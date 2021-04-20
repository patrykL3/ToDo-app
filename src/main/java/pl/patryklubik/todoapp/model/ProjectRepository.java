package pl.patryklubik.todoapp.model;

import java.util.List;
import java.util.Optional;


/**
 * Create by Patryk Łubik on 20.04.2021.
 */
public interface ProjectRepository {
    List<Project> findAll();

    Optional<Project> findById(Integer id);

    Project save(Project entity);
}
