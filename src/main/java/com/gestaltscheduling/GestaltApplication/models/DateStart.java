package com.gestaltscheduling.GestaltApplication.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class DateStart {

    @GeneratedValue
    @Id
    private int id;

    @NotBlank(message = "Please enter a date in mm/dd/year format")
    @DateTimeFormat(pattern = "mm/dd/year")
    private Date dateStart;

    @ManyToMany(mappedBy = "dateStarts")
    private List<Task> dateStarts = new ArrayList<>();

    public int getId() {
        return id;
    }

    public DateStart(Date date) {
        this.dateStart = date;
    }

    public DateStart() {}

    public Date getDateStart() { return dateStart; }

    public void setDateStart(Date start) {
        this.dateStart = start;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateStart that = (DateStart) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
