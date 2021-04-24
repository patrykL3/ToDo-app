package io.pl.patryklubik.todoapp.logic;

import io.pl.patryklubik.todoapp.model.Project;
import io.pl.patryklubik.todoapp.model.ProjectRepository;
import io.pl.patryklubik.todoapp.model.TaskGroupRepository;
import io.pl.patryklubik.todoapp.model.projection.GroupReadModel;
import io.pl.patryklubik.todoapp.model.projection.GroupTaskWriteModel;
import io.pl.patryklubik.todoapp.model.projection.GroupWriteModel;
import io.pl.patryklubik.todoapp.model.projection.ProjectWriteModel;
import io.pl.patryklubik.todoapp.TaskConfigurationProperties;
import io.pl.patryklubik.todoapp.model.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Create by Patryk Łubik on 21.04.2021.
 */

//@Service
public class ProjectService {
    private ProjectRepository repository;
    private TaskGroupRepository taskGroupRepository;
    private TaskGroupService taskGroupService;
    private TaskConfigurationProperties config;

    public ProjectService(final ProjectRepository repository, final TaskGroupRepository taskGroupRepository, final TaskGroupService taskGroupService, final TaskConfigurationProperties config) {
        this.repository = repository;
        this.taskGroupRepository = taskGroupRepository;
        this.taskGroupService = taskGroupService;
        this.config = config;
    }

    public List<Project> readAll() {
        return repository.findAll();
    }

    public Project save(final ProjectWriteModel toSave) {
        return repository.save(toSave.toProject());
    }

    public GroupReadModel createGroup(LocalDateTime deadline, int projectId) {
        if (!config.getTemplate().isAllowMultipleTasks() && taskGroupRepository.existsByDoneIsFalseAndProject_Id(projectId)) {
            throw new IllegalStateException("Only one undone group from project is allowed");
        }
        return repository.findById(projectId)
                .map(project -> {
                    var targetGroup = new GroupWriteModel();
                    targetGroup.setDescription(project.getDescription());
                    targetGroup.setTasks(
                            project.getSteps().stream()
                                    .map(projectStep -> {
                                                var task = new GroupTaskWriteModel();
                                                task.setDescription(projectStep.getDescription());
                                                task.setDeadline(deadline.plusDays(projectStep.getDaysToDeadline()));
                                                return task;
                                            }
                                    ).collect(Collectors.toList())
                    );
                    return taskGroupService.createGroup(targetGroup, project);
                }).orElseThrow(() -> new IllegalArgumentException("Project with given id not found"));
    }
}

