package com.gestaltscheduling.GestaltApplication.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class DateSelected extends AbstractEntity {

    @NotBlank(message = "Location is required")
    private Date date;

    @OneToMany
    @JoinColumn
    private List<Task> dates = new ArrayList<>();

    public DateSelected(Date date) {
        this.date = date;
    }

    public DateSelected() {}

    public Date getDate() { return date; }

    public void setDate(Date location) {
        this.date = location;
    }

}
