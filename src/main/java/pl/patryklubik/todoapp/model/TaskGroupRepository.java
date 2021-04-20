package pl.patryklubik.todoapp.model;

import java.util.List;
import java.util.Optional;


/**
 * Create by Patryk Łubik on 20.04.2021.
 */
public interface TaskGroupRepository {

    List<TaskGroup> findAll();

    Optional<TaskGroup> findById(Integer id);

    TaskGroup save(Task entity);

    boolean existsByDoneIsFalseAndProject_Id(Integer projectId);
}
