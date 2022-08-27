/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.repository.impl;

import com.temtree.pojo.Ticket;
import com.temtree.repository.TicketRepository;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;

/**
 *
 * @author admin
 */
@Repository
@PropertySource("classpath:databases.properties")
@Transactional
public class TicketRepositoryImpl implements TicketRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public boolean addTicket(Ticket ticket) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            session.save(ticket);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteTicket(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Ticket> getTickets() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Ticket> q = b.createQuery(Ticket.class);
        Root ticket = q.from(Ticket.class);
        q.select(ticket);
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Ticket> getTicketBustrips(int startLocationId, int endLocationId, Date departDate) {
        List<Ticket> results = (List<Ticket>) entityManager.createNativeQuery(
                "SELECT ticket.* FROM bustrip, route, ticket\n" +
                "where bustrip.route_id = route.id\n" +
                "and bustrip.id = ticket.bustrip_id\n" +
                "and start_location_id = ?\n" +
                "and end_location_id = ?\n" +
                "and booked_date = ?", Ticket.class)
                .setParameter(1, startLocationId)
                .setParameter(2, endLocationId)
                .setParameter(3, departDate)
                .getResultList();
        
        return results;
    }

    @Override
    public Ticket getTicketByUserId(int id) {
        Ticket ticket = (Ticket) entityManager.createNativeQuery(
                "select * from ticket\n" +
                "where user_id = ?\n" +
                "and payment_status = false\n" +
                "order by created_date desc\n" +
                "LIMIT 1", Ticket.class)
                .setParameter(1, id)
                .getSingleResult();
        
        
        return ticket;
    }

    @Override
    public boolean checkBookedSeat(int id, Date bookedDate, int bustripId) {
        Query query = (Query) entityManager.createNativeQuery(
                "SELECT count(*) FROM busdb.ticket\n" +
                "where seat_id = ?\n" +
                "and bustrip_id = ?\n" +
                "and booked_date = ?\n" +
                "and active = 1")
                .setParameter(1, id)
                .setParameter(2, bustripId)
                .setParameter(3, bookedDate);

        BigInteger isBooked = (BigInteger) query.getSingleResult();

        return isBooked.intValue() > 0;
    }

    @Override
    public int getTotalBookedSeatByDateAndBusTrip(Date date, int bustripId) {
        BigInteger totalSeat = (BigInteger) entityManager.createNativeQuery(
                "SELECT count(*) FROM busdb.ticket\n" +
                "where booked_date = ?\n" +
                "and bustrip_id = ?\n" +
                "and active = 1")
                .setParameter(1, date)
                .setParameter(2, bustripId)
                .getSingleResult();

        return totalSeat.intValue();
    }

    @Override
    public List<Ticket> getTicketsByUserId(int userId) {
        List<Ticket> results = (List<Ticket>) entityManager.createNativeQuery(
                "SELECT ticket.* FROM ticket\n" +
                "where user_id = ?", Ticket.class)
                .setParameter(1, userId)
                .getResultList();
        
        return results;
    }

    @Override
    public Ticket getTicketById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(Ticket.class, id);
    }

    @Override
    public boolean updateTicket(Ticket ticket) {
        Query query = (Query) entityManager.createNativeQuery(
                "UPDATE ticket SET payment_status = ? where id = ?")
                .setParameter(1, ticket.getPaymentStatus())
                .setParameter(2, ticket.getId());

        int result = query.executeUpdate();

        return result > 0;
    }

    @Override
    public Ticket addTicket2(Ticket ticket) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            session.save(ticket);
            return ticket;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Ticket> getTicketsWithFilter(boolean paymentStatus, Date fromDate, Date toDate) {
        List<Ticket> results = (List<Ticket>) entityManager.createNativeQuery(
                "SELECT ticket.* FROM ticket\n" +
                "where payment_status = ?\n" +
                "and CAST(created_date AS DATE) BETWEEN CAST(? AS DATE) AND CAST(? AS DATE)", Ticket.class)
                .setParameter(1, paymentStatus)
                .setParameter(2, fromDate)
                .setParameter(3, toDate)
                .getResultList();
        
        return results;
    }

}
