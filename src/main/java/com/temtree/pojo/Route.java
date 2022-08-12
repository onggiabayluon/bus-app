/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r"),
    @NamedQuery(name = "Route.findById", query = "SELECT r FROM Route r WHERE r.id = :id")})
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Set<Bustrip> bustripSet;
    @JoinColumn(name = "start_location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Location startLocationId;
    @JoinColumn(name = "end_location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Location endLocationId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private Set<Ticket> ticketSet;
    
    @Transient
    private String startLocationName;
    @Transient
    private String endLocationName;


    public Route() {
    }
    
    public Route(String id) {
        this.id = Integer.parseInt(id);
    }
    
    
    public Route(Object[] obj) {
        this.id = Integer.parseInt(String.valueOf(obj[0]));
        this.startLocationName = String.valueOf(obj[1]);
        this.endLocationName = String.valueOf(obj[2]);
    }

    public Route(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Set<Bustrip> getBustripSet() {
        return bustripSet;
    }

    public void setBustripSet(Set<Bustrip> bustripSet) {
        this.bustripSet = bustripSet;
    }

    public Location getStartLocationId() {
        return startLocationId;
    }

    public void setStartLocationId(Location startLocationId) {
        this.startLocationId = startLocationId;
    }

    public Location getEndLocationId() {
        return endLocationId;
    }

    public void setEndLocationId(Location endLocationId) {
        this.endLocationId = endLocationId;
    }

    @XmlTransient
    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
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
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.temtree.pojo.Route[ id=" + id + " ]";
    }

    /**
     * @return the startLocationName
     */
    public String getStartLocationName() {
        return startLocationName;
    }

    /**
     * @param startLocationName the startLocationName to set
     */
    public void setStartLocationName(String startLocationName) {
        this.startLocationName = startLocationName;
    }

    /**
     * @return the endLocationName
     */
    public String getEndLocationName() {
        return endLocationName;
    }

    /**
     * @param endLocationName the endLocationName to set
     */
    public void setEndLocationName(String endLocationName) {
        this.endLocationName = endLocationName;
    }
    
}
