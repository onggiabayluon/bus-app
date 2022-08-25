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
    public List<Bustrip> getAvailableBustrips(int startLocationId, int endLocationId, Date departDate) {
        System.err.println(startLocationId);
        System.err.println(endLocationId);

        System.err.println(departDate);

        List<Bustrip> results = (List<Bustrip>) entityManager.createNativeQuery(
                "SELECT bustrip.id, depart_time, end_time, active, route_id, driver_id, bus_id, bustrip.calendar_id\n" +
                ", If(exception_type = 3 and date = ?, bustrip.price*ratio, bustrip.price) as price\n" +
                "FROM bustrip\n" +
                "left join route\n" +
                "on bustrip.route_id = route.id\n" +
                "left join calendar\n" +
                "on bustrip.calendar_id = calendar.id\n" +
                "left join calendar_dates\n" +
                "on calendar_dates.calendar_id = calendar.id \n" +
                "and calendar_dates.date = ? \n" +
                "and NOT (exception_type = 2 and calendar_dates.date = ?)\n" +
                "where start_location_id = ? \n" +
                "and end_location_id = ?     \n" +
                "and ? BETWEEN start_date AND end_date \n" +
                "and DAYOFWEEK(?) IN (monday, tuesday, wednesday, thursday, friday, saturday, sunday)\n" 
                , Bustrip.class)
                .setParameter(1, departDate)
                .setParameter(2, departDate)
                .setParameter(3, departDate)
                .setParameter(4, startLocationId)
                .setParameter(5, endLocationId)
                .setParameter(6, departDate)
                .setParameter(7, departDate)
                .getResultList();

        System.out.println("com.temtree.repository.impl.BustripRepositoryImpl.getAvailableBustrips()");
        System.err.println(results);

        return results;
    }

    @Override
    public Bustrip findById(int id) {
        Bustrip bustrip = (Bustrip) entityManager.createNativeQuery(
                "SELECT * FROM bustrip\n"
                + "where id = ?", Bustrip.class)
                .setParameter(1, id)
                .getSingleResult();
        
        return bustrip;
    }

    @Override
    public boolean updateBustrip(Bustrip bustrip) {
        Query query = (Query) entityManager.createNativeQuery(
                "UPDATE bustrip SET driver_id = ? where id = ?")
                .setParameter(1, bustrip.getDriverId())
                .setParameter(2, bustrip.getId());

        int result = query.executeUpdate();

        return result > 0;
    }

}
