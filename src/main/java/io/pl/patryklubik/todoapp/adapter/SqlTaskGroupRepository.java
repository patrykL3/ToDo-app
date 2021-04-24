package io.pl.patryklubik.todoapp.adapter;

import io.pl.patryklubik.todoapp.model.TaskGroup;
import io.pl.patryklubik.todoapp.model.TaskGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Create by Patryk Łubik on 20.04.2021.
 */
interface SqlTaskGroupRepository extends TaskGroupRepository, JpaRepository<TaskGroup, Integer> {

    @Override
//    @Query("from TaskGroup g join fetch g.tasks")  // zaczynajac od from pomijamy domyslne select *
    @Query("select distinct g from TaskGroup g join fetch g.tasks") // distinct- unikalne wyniki
        // HQL Query Language,
        // domyślnie inner join
    List<TaskGroup> findAll();


    @Override
    boolean existsByDoneIsFalseAndProject_Id(Integer projectId);


}
