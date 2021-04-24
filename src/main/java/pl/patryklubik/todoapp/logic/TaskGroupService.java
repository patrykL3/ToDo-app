package pl.patryklubik.todoapp.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import org.springframework.web.context.annotation.RequestScope;
import pl.patryklubik.todoapp.model.*;
import pl.patryklubik.todoapp.model.projection.GroupReadModel;
import pl.patryklubik.todoapp.model.projection.GroupWriteModel;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Create by Patryk Łubik on 20.04.2021.
 */
//@Service // domyślnie wstrzykiwane beany są obiektami singleton
//@RequestScope // w obrębie 1 żądania dostajemy unikalny obiekt serwisu
////@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TaskGroupService {

    private TaskGroupRepository repository;
    private TaskRepository taskRepository;

    TaskGroupService(final TaskGroupRepository repository, final TaskRepository taskRepository) {
        this.repository = repository;
        this.taskRepository = taskRepository;
    }

    public GroupReadModel createGroup(final GroupWriteModel source) {
        return createGroup(source, null);
    }

    GroupReadModel createGroup(final GroupWriteModel source, final Project project) {
        TaskGroup result = repository.save(source.toGroup(project));
        return new GroupReadModel(result);
    }


    public List<GroupReadModel> readAll() {
        return repository.findAll().stream()
                .map(GroupReadModel::new)
                .collect(Collectors.toList());
    }

    public void toggleGroup(int groupId) {
        if (taskRepository.existsByDoneIsFalseAndGroup_Id(groupId)) {
            throw new IllegalStateException("Group has undone tasks. Done all the tasks first");
        }
        TaskGroup result = repository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("TaskGroup with given id not found"));
        result.setDone(!result.isDone());
        repository.save(result);
    }


}
