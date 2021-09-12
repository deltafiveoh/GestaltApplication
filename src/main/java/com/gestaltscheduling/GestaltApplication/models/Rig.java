package com.gestaltscheduling.GestaltApplication.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rig extends AbstractEntity {

    @NotBlank(message = "Location is required")
    private String location;

    @OneToMany
    @JoinColumn
    private List<Task> employees = new ArrayList<>();

    public Rig(String location) {
        this.location = location;
    }

    public Rig() {}

    public String getLocation() { return location; }

    public void setLocation(String location) {
        this.location = location;
    }

}
