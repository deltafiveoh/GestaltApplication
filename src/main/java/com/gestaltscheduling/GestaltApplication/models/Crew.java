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
    @Size(min = 2, max = 1000, message = "Role must be between 2 and 1000 characters.")
    private String occupation;

    @ManyToMany(mappedBy = "crewmembers")
    private List<Task> tasks = new ArrayList<>();

    public Crew(String description) {
        this.occupation = description;
    }

    public Crew() {}

    public String getOccupation() { return occupation; }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public List<Task> getTasks() {
        return tasks;
    }

}