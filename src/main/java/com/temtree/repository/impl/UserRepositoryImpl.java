/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.repository.impl;

import com.temtree.pojo.User;
import com.temtree.repository.UserRepository;
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
import org.hibernate.HibernateException;
import org.hibernate.query.Query;


/**
 *
 * @author admin
 */
@Repository
@PropertySource("classpath:databases.properties")
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public boolean addUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            session.save(user);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex);
            return false;
        }
    }

    @Override
    public boolean deleteUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<User> getUsers() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public User findById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(User.class, id);
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(User.class, id);
    }

    @Override
    public List<User> getUsers(String username) {
        List<User> results = (List<User>) entityManager.createNativeQuery(
                "SELECT * FROM user\n" +
                "where user.username = ?\n", User.class)
                .setParameter(1, username)
                .getResultList();
        

        return results;
    }

    @Override
    public List<User> getUsersByRole(String role) {
        List<User> results = (List<User>) entityManager.createNativeQuery(
                "SELECT * FROM user\n" +
                "where user_role = ?\n", User.class)
                .setParameter(1, role)
                .getResultList();
        

        return results;
    }

    @Override
    public boolean updateUser(User user) {
        Query query = (Query) entityManager.createNativeQuery(
                "UPDATE user SET user_role = ? where id = ?")
                .setParameter(1, user.getUserRole())
                .setParameter(2, user.getId());

        int result = query.executeUpdate();

        return result > 0;
    }

}
