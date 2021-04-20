package pl.patryklubik.todoapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


/**
 * Create by Patryk Łubik on 13.04.2021.
 */

@Entity
@Table(name = "task_groups")
public class TaskGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(name = "desc")
    @NotBlank(message = "Task group's description must not be empty")
    private String description;
    private boolean done;

//    @OneToMany(fetch = FetchType.LAZY) // lazy- domyślna opcja,
//     nie dociąga całości dopóki nie ma takiej potrzeby
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group") // usunięcie (lub inne operacje)
    // grupy usuwa automatycznie wszystkie jej taski
    private Set<Task> tasks; // lista z hibernate nie zachowuje kolejności tak jak zbiór set

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;



    public TaskGroup() {
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


    public Set<Task> getTasks() {
        return tasks;
    }

    void setTasks(final Set<Task> tasks) {
        this.tasks = tasks;
    }

    Project getProject() {
        return project;
    }

    void setProject(Project project) {
        this.project = project;
    }
}
