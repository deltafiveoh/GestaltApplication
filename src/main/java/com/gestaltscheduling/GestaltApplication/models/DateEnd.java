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
public class DateEnd {

    @GeneratedValue
    @Id
    private int id;

    @NotBlank(message = "Please enter a date in mm/dd/year format")
    @DateTimeFormat(pattern = "mm/dd/year")
    private Date dateEnd;

    @ManyToMany(mappedBy = "dateEnds")
    private List<Task> dateEnds = new ArrayList<>();

    public int getId() {
        return id;
    }

    public DateEnd(Date date) {
        this.dateEnd = date;
    }

    public DateEnd() {}

    public Date getDateEnd() { return dateEnd; }

    public void setDateEnd(Date end) {
        this.dateEnd = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateEnd that = (DateEnd) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
