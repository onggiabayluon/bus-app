/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.repository.impl;

import com.temtree.pojo.Receipt;
import com.temtree.repository.ReceiptRepository;
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
public class ReceiptRepositoryImpl implements ReceiptRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public boolean addReceipt(Receipt receipt) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            session.save(receipt);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex);
            return false;
        }
    }

    @Override
    public boolean deleteReceipt(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Receipt> getReceipts() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Receipt> q = b.createQuery(Receipt.class);
        Root root = q.from(Receipt.class);
        q.select(root);
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public Receipt findById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(Receipt.class, id);
    }

    @Override
    public Receipt getReceiptById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(Receipt.class, id);
    }

    @Override
    public List<Receipt> getReceipts(String receiptname) {
        List<Receipt> results = (List<Receipt>) entityManager.createNativeQuery(
                "SELECT * FROM receipt\n" +
                "where receipt.receiptname = ?\n", Receipt.class)
                .setParameter(1, receiptname)
                .getResultList();
        

        return results;
    }

    
}
