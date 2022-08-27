/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "calendar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendar.findAll", query = "SELECT c FROM Calendar c"),
    @NamedQuery(name = "Calendar.findById", query = "SELECT c FROM Calendar c WHERE c.id = :id"),
    @NamedQuery(name = "Calendar.findByAlias", query = "SELECT c FROM Calendar c WHERE c.alias = :alias"),
    @NamedQuery(name = "Calendar.findByMonday", query = "SELECT c FROM Calendar c WHERE c.monday = :monday"),
    @NamedQuery(name = "Calendar.findByTuesday", query = "SELECT c FROM Calendar c WHERE c.tuesday = :tuesday"),
    @NamedQuery(name = "Calendar.findByWednesday", query = "SELECT c FROM Calendar c WHERE c.wednesday = :wednesday"),
    @NamedQuery(name = "Calendar.findByThursday", query = "SELECT c FROM Calendar c WHERE c.thursday = :thursday"),
    @NamedQuery(name = "Calendar.findByFriday", query = "SELECT c FROM Calendar c WHERE c.friday = :friday"),
    @NamedQuery(name = "Calendar.findBySaturday", query = "SELECT c FROM Calendar c WHERE c.saturday = :saturday"),
    @NamedQuery(name = "Calendar.findBySunday", query = "SELECT c FROM Calendar c WHERE c.sunday = :sunday"),
    @NamedQuery(name = "Calendar.findByStartDate", query = "SELECT c FROM Calendar c WHERE c.startDate = :startDate"),
    @NamedQuery(name = "Calendar.findByEndDate", query = "SELECT c FROM Calendar c WHERE c.endDate = :endDate")})
public class Calendar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "alias")
    private String alias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monday")
    private int monday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tuesday")
    private int tuesday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "wednesday")
    private int wednesday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thursday")
    private int thursday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "friday")
    private int friday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saturday")
    private int saturday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sunday")
    private int sunday;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calendarId")
    private Set<CalendarDates> calendarDatesSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calendarId")
    private Set<Bustrip> bustripSet;

    public Calendar() {
    }

    public Calendar(Integer id) {
        this.id = id;
    }
    
    // Important Note: help stupid fuk request.body which needed my help to parse from string to int
    public Calendar(String id) {
        this.id = Integer.parseInt(id);
    }

    public Calendar(Integer id, int monday, int tuesday, int wednesday, int thursday, int friday, int saturday, int sunday) {
        this.id = id;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getMonday() {
        return monday;
    }

    public void setMonday(int monday) {
        this.monday = monday;
    }

    public int getTuesday() {
        return tuesday;
    }

    public void setTuesday(int tuesday) {
        this.tuesday = tuesday;
    }

    public int getWednesday() {
        return wednesday;
    }

    public void setWednesday(int wednesday) {
        this.wednesday = wednesday;
    }

    public int getThursday() {
        return thursday;
    }

    public void setThursday(int thursday) {
        this.thursday = thursday;
    }

    public int getFriday() {
        return friday;
    }

    public void setFriday(int friday) {
        this.friday = friday;
    }

    public int getSaturday() {
        return saturday;
    }

    public void setSaturday(int saturday) {
        this.saturday = saturday;
    }

    public int getSunday() {
        return sunday;
    }

    public void setSunday(int sunday) {
        this.sunday = sunday;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @XmlTransient
    public Set<CalendarDates> getCalendarDatesSet() {
        return calendarDatesSet;
    }

    public void setCalendarDatesSet(Set<CalendarDates> calendarDatesSet) {
        this.calendarDatesSet = calendarDatesSet;
    }

    @XmlTransient
    public Set<Bustrip> getBustripSet() {
        return bustripSet;
    }

    public void setBustripSet(Set<Bustrip> bustripSet) {
        this.bustripSet = bustripSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calendar)) {
            return false;
        }
        Calendar other = (Calendar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.temtree.pojo.Calendar[ id=" + id + " ]";
    }
    
}
