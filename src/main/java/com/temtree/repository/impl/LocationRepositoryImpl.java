/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.repository.impl;

import com.temtree.pojo.Location;
import com.temtree.repository.LocationRepository;
import java.util.List;
import java.util.Map;
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
public class LocationRepositoryImpl implements LocationRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public boolean addLocation(Location location) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            session.save(location);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteLocation(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Location> getLocations() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Location> q = b.createQuery(Location.class);
        Root root = q.from(Location.class);
        q.select(root);
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }
    
}
