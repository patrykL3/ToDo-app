package pl.patryklubik.todoapp.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.patryklubik.todoapp.model.Project;
import pl.patryklubik.todoapp.model.ProjectRepository;

import java.util.List;


/**
 * Create by Patryk Łubik on 20.04.2021.
 */
@Repository
interface SqlProjectRepository extends ProjectRepository, JpaRepository<Project, Integer> {
    @Override
    @Query("select distinct p from Project p join fetch p.steps")
    List<Project> findAll();
}
