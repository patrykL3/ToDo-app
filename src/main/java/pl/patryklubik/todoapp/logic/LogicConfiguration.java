package pl.patryklubik.todoapp.logic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.patryklubik.todoapp.TaskConfigurationProperties;
import pl.patryklubik.todoapp.model.ProjectRepository;
import pl.patryklubik.todoapp.model.TaskGroupRepository;
import pl.patryklubik.todoapp.model.TaskRepository;


/**
 * Create by Patryk Łubik on 22.04.2021.
 */

@Configuration
class LogicConfiguration {
    @Bean
    ProjectService projectService(
            final ProjectRepository repository,
            final TaskGroupRepository taskGroupRepository,
            final TaskConfigurationProperties config
    ) {
        return new ProjectService(repository, taskGroupRepository, config);
    }

    @Bean
    TaskGroupService taskGroupService(
            final TaskGroupRepository taskGroupRepository,
            final TaskRepository taskRepository
    ) {
        return new TaskGroupService(taskGroupRepository, taskRepository);
    }
}
