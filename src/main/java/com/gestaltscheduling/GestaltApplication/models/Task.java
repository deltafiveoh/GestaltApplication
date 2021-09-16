package com.gestaltscheduling.GestaltApplication.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task extends AbstractEntity{

////    @ManyToMany
//    private List<Crew> crewList = new ArrayList<>();
//    public Task() { }
//
////    @ManyToOne
//    private Crew employee;
//
//    public Task(Crew anEmployee, List<Crew> crewList) {
//        super();
//        this.employee = anEmployee;
//        this.crewList = crewList;
//    }
//
//    public Crew getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Crew employer) {
//        this.employee = employer;
//    }
//
//    public List<Crew> getCrew() {
//        return crewList;
//    }
//
//    public void setCrew(List<Crew> crewList) {
//        this.crewList = crewList;
//    }
//


}
