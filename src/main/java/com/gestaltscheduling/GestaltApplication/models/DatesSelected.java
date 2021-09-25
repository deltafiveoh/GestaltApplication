package com.gestaltscheduling.GestaltApplication.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class DatesSelected {

    @GeneratedValue
    @Id
    private int id;

    @NotBlank(message = "Please enter a date in mm/dd/year format")
    @DateTimeFormat(pattern = "mm/dd/year")
    private Date dateStart;

    @NotBlank(message = "Please enter a date in mm/dd/year format")
    @DateTimeFormat(pattern = "mm/dd/year")
    private Date dateEnd;

    @ManyToMany(mappedBy = "datesSelected")
    @JoinColumn
    private List<Task> dates = new ArrayList<>();

    public int getId() {
        return id;
    }

    public DatesSelected(Date dateStart, Date dateEnd) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public DatesSelected() {}

    public Date getDateStart() { return dateStart; }

    public void setDateStart(Date start) {
        this.dateStart = start;
    }

    public Date getDateEnd() { return dateEnd; }

    public void setDateEnd(Date end) {
        this.dateEnd = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatesSelected that = (DatesSelected) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
