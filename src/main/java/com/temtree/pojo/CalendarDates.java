/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "calendar_dates")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalendarDates.findAll", query = "SELECT c FROM CalendarDates c"),
    @NamedQuery(name = "CalendarDates.findById", query = "SELECT c FROM CalendarDates c WHERE c.id = :id"),
    @NamedQuery(name = "CalendarDates.findByDate", query = "SELECT c FROM CalendarDates c WHERE c.date = :date"),
    @NamedQuery(name = "CalendarDates.findByExceptionType", query = "SELECT c FROM CalendarDates c WHERE c.exceptionType = :exceptionType")})
public class CalendarDates implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exception_type")
    private int exceptionType;
    @JoinColumn(name = "calendar_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Calendar calendarId;

    public CalendarDates() {
    }

    public CalendarDates(Integer id) {
        this.id = id;
    }

    public CalendarDates(Integer id, Date date, int exceptionType) {
        this.id = id;
        this.date = date;
        this.exceptionType = exceptionType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(int exceptionType) {
        this.exceptionType = exceptionType;
    }

    public Calendar getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(Calendar calendarId) {
        this.calendarId = calendarId;
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
        if (!(object instanceof CalendarDates)) {
            return false;
        }
        CalendarDates other = (CalendarDates) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.temtree.pojo.busdb2.CalendarDates[ id=" + id + " ]";
    }
    
}
