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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "receipt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receipt.findAll", query = "SELECT r FROM Receipt r"),
    @NamedQuery(name = "Receipt.findById", query = "SELECT r FROM Receipt r WHERE r.id = :id"),
    @NamedQuery(name = "Receipt.findByActive", query = "SELECT r FROM Receipt r WHERE r.active = :active"),
    @NamedQuery(name = "Receipt.findByCreatedDate", query = "SELECT r FROM Receipt r WHERE r.createdDate = :createdDate"),
    @NamedQuery(name = "Receipt.findByAmount", query = "SELECT r FROM Receipt r WHERE r.amount = :amount"),
    @NamedQuery(name = "Receipt.findByPaymentMethod", query = "SELECT r FROM Receipt r WHERE r.paymentMethod = :paymentMethod")})
public class Receipt implements Serializable {
    public static final String MOMO = "MOMO";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "amount")
    private Long amount;
    @Size(max = 255)
    @Column(name = "payment_method")
    private String paymentMethod;
    @Size(max = 255)
    @Column(name = "momo_request_id")
    private String momoRequestId;
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ticket ticketId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public Receipt() {
        this.createdDate = new Date();
        this.active = true;
    }

    public Receipt(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Ticket getTicketId() {
        return ticketId;
    }

    public void setTicketId(Ticket ticketId) {
        this.ticketId = ticketId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof Receipt)) {
            return false;
        }
        Receipt other = (Receipt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.temtree.pojo.Receipt[ id=" + id + " ]";
    }

    /**
     * @return the momoRequestId
     */
    public String getMomoRequestId() {
        return momoRequestId;
    }

    /**
     * @param momoRequestId the momoRequestId to set
     */
    public void setMomoRequestId(String momoRequestId) {
        this.momoRequestId = momoRequestId;
    }
    
}
