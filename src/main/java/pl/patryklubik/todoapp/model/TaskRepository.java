package pl.patryklubik.todoapp.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Create by Patryk Łubik on 13.04.2021.
 */

@RepositoryRestResource
interface TaskRepository extends JpaRepository<Task, Integer> {
}
