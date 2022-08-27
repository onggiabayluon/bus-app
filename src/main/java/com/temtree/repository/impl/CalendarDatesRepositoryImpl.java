/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.repository.impl;

import com.temtree.pojo.CalendarDates;
import com.temtree.repository.CalendarDatesRepository;
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
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.NoResultException;

/**
 *
 * @author admin
 */
@Repository
@PropertySource("classpath:databases.properties")
@Transactional
public class CalendarDatesRepositoryImpl implements CalendarDatesRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean addCalendarDates(CalendarDates calendarDates) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            session.save(calendarDates);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCalendarDates(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CalendarDates> getCalendarDatess() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<CalendarDates> q = b.createQuery(CalendarDates.class);
        Root root = q.from(CalendarDates.class);
        q.select(root);

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public float getCDByBustrip(int bustripId, Date bookedDate) {
        try {

            float calendarDates = (float) entityManager.createNativeQuery(
                    "SELECT calendar_dates.ratio\n"
                    + "FROM bustrip, calendar_dates\n"
                    + "where bustrip.id = ?\n"
                    + "and date = ?\n"
                    + "and bustrip.calendar_id = calendar_dates.calendar_id\n"
                    + "and exception_type = 3")
                    .setParameter(1, bustripId)
                    .setParameter(2, bookedDate)
                    .getSingleResult();
            

            return calendarDates;
        } catch (NoResultException e) {
            return 1;
        }

    }

}
