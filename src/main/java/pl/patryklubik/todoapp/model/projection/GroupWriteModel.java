package pl.patryklubik.todoapp.model.projection;

import pl.patryklubik.todoapp.model.Project;
import pl.patryklubik.todoapp.model.TaskGroup;

import java.util.Set;
import java.util.stream.Collectors;


/**
 * Create by Patryk Łubik on 21.04.2021.
 */
public class GroupWriteModel {

    private String description;
    private Set<GroupTaskWriteModel> tasks;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<GroupTaskWriteModel> getTasks() {
        return tasks;
    }

    public void setTasks(Set<GroupTaskWriteModel> tasks) {
        this.tasks = tasks;
    }

    public TaskGroup toGroup(final Project project) {
        var result = new TaskGroup();
        result.setDescription(description);
        result.setTasks(
                tasks.stream()
                        .map(source -> source.toTask(result))
                        .collect(Collectors.toSet())
        );
        result.setProject(project);
        return result;
    }
}
