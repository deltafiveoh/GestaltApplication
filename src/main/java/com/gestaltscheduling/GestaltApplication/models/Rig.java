package com.gestaltscheduling.GestaltApplication.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rig extends AbstractEntity {

    @NotBlank(message = "Rig description is required")
    private String rig;

    @ManyToMany(mappedBy = "rig")
    @JoinColumn
    private List<Task> rigs = new ArrayList<>();

    public Rig(String rig) {
        this.rig = rig;
    }

    public Rig() {}

    public String getRig() { return rig; }

    public void setRig(String rig) {
        this.rig = rig;
    }

}
