package io.pl.patryklubik.todoapp.logic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.pl.patryklubik.todoapp.TaskConfigurationProperties;
import io.pl.patryklubik.todoapp.model.ProjectRepository;
import io.pl.patryklubik.todoapp.model.TaskGroupRepository;
import io.pl.patryklubik.todoapp.model.TaskRepository;


/**
 * Create by Patryk Łubik on 22.04.2021.
 */

@Configuration
class LogicConfiguration {
    @Bean
    ProjectService projectService(
            final ProjectRepository repository,
            final TaskGroupRepository taskGroupRepository,
            final TaskGroupService taskGroupService,
            final TaskConfigurationProperties config
    ) {
        return new ProjectService(repository, taskGroupRepository, taskGroupService, config);
    }

    @Bean
    TaskGroupService taskGroupService(
            final TaskGroupRepository taskGroupRepository,
            final TaskRepository taskRepository
    ) {
        return new TaskGroupService(taskGroupRepository, taskRepository);
    }
}
