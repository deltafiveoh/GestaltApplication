package com.gestaltscheduling.GestaltApplication.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task extends AbstractEntity{

    @ManyToMany
    private List<Crew> crewList = new ArrayList<>();
    public Task() {
    }

    @ManyToOne
    private Employee employee;

    public Task(Employee anEmployee, List<Crew> crewList) {
        super();
        this.employee = anEmployee;
        this.crewList = crewList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employer) {
        this.employee = employer;
    }

    public List<Crew> getCrew() {
        return crewList;
    }

    public void setCrew(List<Crew> crewList) {
        this.crewList = crewList;
    }



}
