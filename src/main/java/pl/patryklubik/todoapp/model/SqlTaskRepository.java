package pl.patryklubik.todoapp.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Create by Patryk Łubik on 13.04.2021.
 */

@Repository
public interface SqlTaskRepository extends TaskRepository, JpaRepository<Task, Integer> {
}
