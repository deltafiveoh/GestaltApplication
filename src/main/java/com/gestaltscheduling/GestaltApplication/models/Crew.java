package com.gestaltscheduling.GestaltApplication.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Crew extends AbstractEntity {

    @NotBlank
    @Size(min = 2, max = 1000, message = "Description must be between 2 and 1000 characters.")
    private String description;

    @ManyToMany(mappedBy = "crewmembers")
    private List<Task> tasks = new ArrayList<>();

    public Crew(String description) {
        this.description = description;
    }

    public Crew() {}

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

}