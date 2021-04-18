package pl.patryklubik.todoapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


/**
 * Create by Patryk Łubik on 13.04.2021.
 */

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(name = "desc")
    @NotBlank(message = "Tasks description must not be null")
    private String description;
    private boolean done;
    private LocalDateTime deadline;

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }
}
