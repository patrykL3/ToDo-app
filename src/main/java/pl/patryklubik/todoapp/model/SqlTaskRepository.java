package pl.patryklubik.todoapp.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Create by Patryk Łubik on 13.04.2021.
 */

@Repository
public interface SqlTaskRepository extends TaskRepository, JpaRepository<Task, Integer> {

    @Override
    @Query(nativeQuery = true, value = "select count(*) > 0 from tasks where id=:id")
        // where id=?1 pobiera pierwszy param. z metody poniżej
    boolean existsById(@Param("id")Integer id);
}
