package com.gestaltscheduling.GestaltApplication.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Task extends AbstractEntity{

    @NotBlank
    @NotNull
    @Size(min = 2, max = 2000, message="Task description must be between 2 and 4000 characters")
    private String description;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date dateStart;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date dateEnd;

    @ManyToMany
    private List<Crew> crewList = new ArrayList<>();

    @ManyToMany
    private List<Rig> rig = new ArrayList<>();

    public Task() { }

    public Task(List<Rig> rigs, List<Crew> crewList, List<Date> dateStart, List<Date> dateEnd) {
        super();
        this.rig = rigs;
        this.crewList = crewList;
        this.dateStart = (Date) dateStart;
        this.dateEnd = (Date) dateEnd;
    }

    public List<Rig> getRigs() {
        return rig;
    }

    public void setRigs(List<Rig> rig) {
        this.rig = rig;
    }

    public List<Crew> getCrew() {
        return crewList;
    }

    public void setCrew(List<Crew> crewList) {
        this.crewList = crewList;
    }

    public String getDescription() { return description; }

    public String setDescription(String description) { return this.description = description; }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int setDateToIntegerOfYear(Date dateEntered) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateEntered);
        int intDate = calendar.get(Calendar.DAY_OF_YEAR);
        return intDate;
    }

    public int setDateToIntegerOfMonth(Date dateEntered) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateEntered);
        int intDate = calendar.get(Calendar.DAY_OF_MONTH);
        return intDate;
    }

    public int setDateToIntegerMonth(Date dateEntered) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateEntered);
        int intDate = calendar.get(Calendar.MONTH);
        return intDate;
    }

}
