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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "bustrip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bustrip.findAll", query = "SELECT b FROM Bustrip b"),
    @NamedQuery(name = "Bustrip.findById", query = "SELECT b FROM Bustrip b WHERE b.id = :id"),
    @NamedQuery(name = "Bustrip.findByDepartTime", query = "SELECT b FROM Bustrip b WHERE b.departTime = :departTime"),
    @NamedQuery(name = "Bustrip.findByActive", query = "SELECT b FROM Bustrip b WHERE b.active = :active"),
    @NamedQuery(name = "Bustrip.findByDriverId", query = "SELECT b FROM Bustrip b WHERE b.driverId = :driverId")})
public class Bustrip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "depart_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departTime;
    @Column(name = "active")
    private Boolean active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "driver_id")
    private int driverId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bustripId")
    private Set<Bus> busSet;
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Route routeId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bustripId")
    private Set<Ticket> ticketSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bustripId")
    private Set<Comment> commentSet;

    public Bustrip() {
    }

    public Bustrip(Integer id) {
        this.id = id;
    }

    public Bustrip(Integer id, int driverId) {
        this.id = id;
        this.driverId = driverId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Date departTime) {
        this.departTime = departTime;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @XmlTransient
    public Set<Bus> getBusSet() {
        return busSet;
    }

    public void setBusSet(Set<Bus> busSet) {
        this.busSet = busSet;
    }

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }

    @XmlTransient
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
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
        if (!(object instanceof Bustrip)) {
            return false;
        }
        Bustrip other = (Bustrip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.temtree.pojo.Bustrip[ id=" + id + " ]";
    }
    
}
