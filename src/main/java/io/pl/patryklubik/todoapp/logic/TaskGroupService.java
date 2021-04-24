package io.pl.patryklubik.todoapp.logic;

import io.pl.patryklubik.todoapp.model.Project;
import io.pl.patryklubik.todoapp.model.TaskGroup;
import io.pl.patryklubik.todoapp.model.TaskGroupRepository;
import io.pl.patryklubik.todoapp.model.TaskRepository;
import io.pl.patryklubik.todoapp.model.projection.GroupReadModel;
import io.pl.patryklubik.todoapp.model.projection.GroupWriteModel;
import io.pl.patryklubik.todoapp.model.*;

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
