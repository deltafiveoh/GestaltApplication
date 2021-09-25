package com.gestaltscheduling.GestaltApplication.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Task extends AbstractEntity{

    @NotBlank
    @NotNull
    @Size(min = 2, max = 2000, message="Task description must be between 2 and 2000 characters")
    private String description;

    @ManyToMany
    private List<Crew> crewList = new ArrayList<>();

    @ManyToMany
    private List<Rig> rig = new ArrayList<>();

    @ManyToMany
    private DatesSelected datesSelected;

    public Task() { }

    public Task(List<Rig> Rigs, List<Crew> crewList, DatesSelected dateStart) {
        super();
        this.rig = Rigs;
        this.crewList = crewList;
        this.datesSelected = dateStart;
    }

    public List<Rig> getRig() {
        return rig;
    }

    public void setRig(List<Rig> rig) {
        this.rig = rig;
    }

    public List<Crew> getCrew() {
        return crewList;
    }

    public void setCrew(List<Crew> crewList) {
        this.crewList = crewList;
    }

    public DatesSelected getDates() {
        return datesSelected;
    }

    public void setDates(DatesSelected datesSelected) { this.datesSelected = datesSelected; }

}
