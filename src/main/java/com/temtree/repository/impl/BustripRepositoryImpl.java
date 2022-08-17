/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.repository.impl;

import com.temtree.pojo.Bustrip;
import com.temtree.repository.BustripRepository;

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
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;


/**
 *
 * @author admin
 */
@Repository
@PropertySource("classpath:databases.properties")
@Transactional
public class BustripRepositoryImpl implements BustripRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    private BustripRepository bustripRepository;
    
    @Override
    public boolean addBustrip(Bustrip bustrip) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            session.save(bustrip);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteBustrip(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Bustrip> getBustrips() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Bustrip> q = b.createQuery(Bustrip.class);
        Root bustrip = q.from(Bustrip.class);
        q.select(bustrip);
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Bustrip> getTicketBustrips(int startLocationId, int endLocationId, Date departDate) {
        List<Bustrip> results = (List<Bustrip>) entityManager.createNativeQuery(
                "SELECT bustrip.* FROM bustrip, route, ticket\n" +
                "where bustrip.route_id = route.id\n" +
                "and bustrip.id = ticket.bustrip_id\n" +
                "and start_location_id = ?\n" +
                "and end_location_id = ?\n" +
                "and depart_date = ?", Bustrip.class)
                .setParameter(1, startLocationId)
                .setParameter(2, endLocationId)
                .setParameter(3, departDate)
                .getResultList();
        
        System.out.println("com.temtree.repository.impl.BustripRepositoryImpl.getTicketBustrips()");
        System.err.println(results);
        
        
        return results;
    }

    @Override
    public Bustrip findById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(Bustrip.class, id);
    }

}