package com.gestaltscheduling.GestaltApplication.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rig extends AbstractEntity {

    @NotBlank(message = "Rig description is required")
    private String description;

    @ManyToMany(mappedBy = "rig")
//    @JoinColumn
    private List<Task> tasks = new ArrayList<>();

    public Rig(String rig) {
        this.description = rig;
    }

    public Rig() {}

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

}
