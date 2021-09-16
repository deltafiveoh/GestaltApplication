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
    private String rig;

//    @OneToMany
//    @JoinColumn
//    private List<Task> employees = new ArrayList<>();

    public Rig(String rig) {
        this.rig = rig;
    }

    public Rig() {}

    public String getRig() { return rig; }

    public void setRig(String rig) {
        this.rig = rig;
    }

}
