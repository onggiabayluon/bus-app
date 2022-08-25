/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.repository.impl;

import com.temtree.pojo.Seat;
import com.temtree.repository.SeatRepository;
import java.math.BigInteger;
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
public class SeatRepositoryImpl implements SeatRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean addSeat(Seat seat) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            session.save(seat);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteSeat(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Seat> getSeat() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Seat> q = b.createQuery(Seat.class);
        Root root = q.from(Seat.class);
        q.select(root);

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Seat> getSeats() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Seat> q = b.createQuery(Seat.class);
        Root root = q.from(Seat.class);
        q.select(root);

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public Seat findById(int id) {
        Seat seat = (Seat) entityManager.createNativeQuery(
                "SELECT * FROM seat\n"
                + "where id = ?", Seat.class)
                .setParameter(1, id)
                .getSingleResult();

        return seat;
    }

    @Override
    public boolean checkBooked(int id) {
        Query query = (Query) entityManager.createNativeQuery(
                "SELECT count(*) FROM seat\n"
                + "where seat.id = ? and is_booked = true")
                .setParameter(1, id);

        BigInteger isBooked = (BigInteger) query.getSingleResult();

        return isBooked.intValue() > 0;
    }

    @Override
    public boolean updateIsBooked(int id) {
        Query query = (Query) entityManager.createNativeQuery(
                "UPDATE seat SET is_booked = true where id = ?")
                .setParameter(1, id);

        int isBooked = query.executeUpdate();

        return isBooked > 0;
    }

    @Override
    public int getTotalSeatByBus(int busId) {
        BigInteger totalSeat = (BigInteger) entityManager.createNativeQuery(
                "SELECT count(*) FROM seat\n" +
                "where bus_id = ?\n" +
                "and active = 1")
                .setParameter(1, busId)
                .getSingleResult();

        return totalSeat.intValue();
    }
}
