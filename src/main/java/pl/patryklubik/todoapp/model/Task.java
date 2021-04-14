package pl.patryklubik.todoapp.model;

import javax.persistence.*;
//import javax.validation.constraints.NotBlank;


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
//    @NotBlank(message = "Tasks description must not be null")
    private String description;
    private boolean done;

    public Task() {
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

    void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    void setDone(boolean done) {
        this.done = done;
    }
}
