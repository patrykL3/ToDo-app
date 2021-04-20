package pl.patryklubik.todoapp.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryklubik.todoapp.model.Task;
import pl.patryklubik.todoapp.model.TaskGroupRepository;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Create by Patryk Łubik on 20.04.2021.
 */
@Service
public class TempService {

    @Autowired
    List<String> temp(TaskGroupRepository repository) {
        // N+1 selectow
        return repository.findAll().stream().
                flatMap(taskGroup -> taskGroup.getTasks().stream())
                .map(Task::getDescription)
                .collect(Collectors.toList());

    }

}
