/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.repository.impl;

import com.temtree.repository.StatsRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author admin
 */
@Repository
@PropertySource("classpath:databases.properties")
@Transactional
public class StatsRepositoryImpl implements StatsRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @PersistenceContext
    private EntityManager entityManager;
    

    @Override
    public List<Object[]> revenueStats(Date fromDate, Date toDate) {
        List<Object[]> results = entityManager.createNativeQuery(
                "SELECT sum(amount), bustrip_id, receipt.created_date FROM receipt, ticket\n" +
                "where receipt.created_date BETWEEN ? AND ? \n" +
                "and receipt.ticket_id = ticket.id\n" +
                "group by bustrip_id")
                .setParameter(1, fromDate)
                .setParameter(2, toDate)
                .getResultList();
        

        return results;
    }

    @Override
    public Object[] todayRevenue(Date fromDate, Date toDate) {
        try {
            Object[] results = (Object[]) entityManager.createNativeQuery(
                "SELECT sum(amount), bustrip_id, receipt.created_date FROM receipt, ticket\n" +
                "where CAST(receipt.created_date AS DATE) BETWEEN CAST(? AS DATE) AND CAST(? AS DATE) \n" +
                "and receipt.ticket_id = ticket.id\n" +
                "group by amount")
                .setParameter(1, fromDate)
                .setParameter(2, toDate)
                .getSingleResult();
            
            
            return results;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Object[]> revenueStatsByMonth(Date fromDate, Date toDate) {
        try {
            List<Object[]> results = entityManager.createNativeQuery(
                "SELECT sum(amount), MONTHNAME(receipt.created_date) FROM receipt, ticket\n" +
                "where MONTH(receipt.created_date) BETWEEN MONTH(?) AND MONTH(?)\n" +
                "and receipt.ticket_id = ticket.id\n" +
                "group by amount, MONTHNAME(receipt.created_date)")
                .setParameter(1, fromDate)
                .setParameter(2, toDate)
                .getResultList();
        

        return results;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

    @Override
    public List<Object[]> revenueStatsByRoute(Date fromDate, Date toDate) {
        try {
            List<Object[]> results = entityManager.createNativeQuery(
                "SELECT j1.name as start_location_name, j2.name as end_location_name, sum(rc.amount) FROM receipt rc, ticket t, bustrip b, route r\n" +
                "join Location j1 on j1.id = r.start_location_id\n" +
                "join Location j2 on j2.id = r.end_location_id\n" +
                "where CAST(rc.created_date AS DATE) BETWEEN CAST(? AS DATE) AND CAST(? AS DATE)\n" +
                "and rc.ticket_id = t.id\n" +
                "and t.bustrip_id = b.id\n" +
                "and b.route_id = r.id\n" +
                "group by r.id")
                .setParameter(1, fromDate)
                .setParameter(2, toDate)
                .getResultList();
        

        return results;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object[] totalRevenue() {
        try {
            Object[] results = (Object[]) entityManager.createNativeQuery(
                "SELECT sum(amount), id FROM receipt")
                .getSingleResult();
            
            
            return results;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    

}
