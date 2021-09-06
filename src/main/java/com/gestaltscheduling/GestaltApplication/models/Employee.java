package com.gestaltscheduling.GestaltApplication.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee extends AbstractEntity {

    @NotBlank(message = "Location is required")
    private String location;

    @OneToMany
    @JoinColumn
    private List<Job> employees = new ArrayList<>();

    public Employee(String location) {
        this.location = location;
    }

    public Employee() {}

    public String getLocation() { return location; }

    public void setLocation(String location) {
        this.location = location;
    }

}
