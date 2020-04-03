package com.dao.impl;

import com.dao.TicketDao;
import com.model.Station;
import com.model.Ticket;
import com.model.Train;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketDaoImpl implements TicketDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addTicket(Ticket ticket) {
        Session session = sessionFactory.getCurrentSession();
            session.persist(ticket);
        }

    @Override
    @SuppressWarnings("unchecked")
    public List<Ticket> getAllTickets() {
        Session session = sessionFactory.getCurrentSession();
       return session.createQuery("from Ticket t , Ticket.class").list();
    }

    @Override
    public Ticket getTicketById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Ticket.class, id);
    }

    @Override
    public List<Ticket> getTicketForTrip(Train t, Station departure, Station arrival) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Ticket t WHERE t.departure.id =:departureId AND t.arrival.id =:arrivalId AND t.train.id=:trainId");
        query.setParameter("trainId", t.getId());
        query.setParameter("departureId", departure.getId());
        query.setParameter("arrivalId", arrival.getId());
        return query.getResultList();
    }

    @Override
    public List<Ticket> getTicketsOnTrain(Train train) {
       List <Ticket> ticketsOnTrain = new ArrayList<>();
       for (Ticket t : getAllTickets()){
           if (t.getTrain().getId() == train.getId()) {
               ticketsOnTrain.add(t);
           }
       }
       return ticketsOnTrain;
    }
}
