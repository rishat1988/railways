package com.dao.impl;


import com.dao.TrainDao;
import com.model.Station;
import com.model.Train;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class TrainDaoImpl implements TrainDao {

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void add(Train train) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(train);
    }
    @Override
    public void delete(Train train) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(train);
    }
    @Override
    public void update(Train train) {
        Session session = sessionFactory.getCurrentSession();
        session.update(train);
    }
    @Override
    public Train getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Train.class, id);
    }

    @Override
    public Train getByNumber(Integer number) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Train.class, number);
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<Train> allTrains() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Train> criteriaQuery = criteriaBuilder.createQuery(Train.class);
        Root<Train> root = criteriaQuery.from(Train.class);
        criteriaQuery.select(root);
        Query query = session.createQuery(criteriaQuery);
        return  query.getResultList();
    }
}