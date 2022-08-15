/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.repository.impl;

import com.temtree.pojo.Ticket;
import com.temtree.pojo.Route;
import com.temtree.repository.TicketRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
                "and depart_date = ?", Ticket.class)
                .setParameter(1, startLocationId)
                .setParameter(2, endLocationId)
                .setParameter(3, departDate)
                .getResultList();
        
        System.out.println("com.temtree.repository.impl.TicketRepositoryImpl.getTicketTickets()");
        System.err.println(results);
        
        
        return results;
    }
    
}
