package io.pl.patryklubik.todoapp.model.projection;

import io.pl.patryklubik.todoapp.model.Task;


/**
 * Create by Patryk Łubik on 21.04.2021.
 */
public class GroupTaskReadModel {

    private String description;
    private boolean done;

    GroupTaskReadModel(Task source) {

        description = source.getDescription();
        done = source.isDone();
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
}
