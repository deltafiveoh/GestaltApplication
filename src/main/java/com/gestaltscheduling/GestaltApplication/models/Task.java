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

    @ManyToOne
    private Rig rig;

    @ManyToMany
    private DateStart start;

    @ManyToMany
    private DateEnd end;

    public Task() { }

    public Task(Rig aRig, List<Crew> crewList) {
        super();
        this.rig = aRig;
        this.crewList = crewList;
    }

    public Rig getRig() {
        return rig;
    }

    public void setRig(Rig rig) {
        this.rig = rig;
    }

    public List<Crew> getCrew() {
        return crewList;
    }

    public void setCrew(List<Crew> crewList) {
        this.crewList = crewList;
    }

}
