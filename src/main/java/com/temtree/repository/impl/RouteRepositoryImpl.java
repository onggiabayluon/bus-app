/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.repository.impl;

import com.temtree.pojo.Route;
import com.temtree.pojo.Route;
import com.temtree.pojo.Location;
import com.temtree.repository.RouteRepository;
import java.util.ArrayList;
import java.util.Iterator;
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
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author admin
 */
@Repository
@PropertySource("classpath:databases.properties")
@Transactional
public class RouteRepositoryImpl implements RouteRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean deleteRoute(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Route> getRoutesName() {

        List<Object[]> results = entityManager.createNativeQuery(
                "SELECT r.id, j1.name as start_location_name, j2.name as end_location_name FROM Route r\n"
                + "join Location j1 on j1.id = r.start_location_id\n"
                + "join Location j2 on j2.id = r.end_location_id").getResultList();
        
        List<Route> routes = new ArrayList<Route>();
        
        for (Object[] item : results) {
            Route route = new Route(item);
            routes.add(route);
        }
        
        return routes;
    }

    @Override
    public boolean addRoute(Route route) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            session.save(route);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Route> getRoutes() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Route> q = b.createQuery(Route.class);
        Root route = q.from(Route.class);
        q.select(route);
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Route> getRoutesByLocationId(int locationId) {
        List<Object[]> results = entityManager.createNativeQuery(
                "SELECT r.id, j1.name as start_location_name, j2.name as end_location_name, r.end_location_id FROM Route r\n" +
                "join Location j1 on j1.id = r.start_location_id\n" +
                "join Location j2 on j2.id = r.end_location_id\n" +
                "where start_location_id = ?").setParameter(1, locationId).getResultList();
        
        List<Route> routes = new ArrayList<Route>();
        
        for (Object[] item : results) {
            Route route = new Route(item);
            routes.add(route);
        }
        
        return routes;
    }

}
