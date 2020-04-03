package com.dao;

import com.model.Station;
import com.model.Ticket;
import com.model.Train;

import java.util.List;

public interface  TicketDao {

    void addTicket (Ticket ticket);

    List<Ticket> getAllTickets ();

    Ticket getTicketById (int id);

    List <Ticket> getTicketForTrip (Train t, Station departure, Station arrival);

    List <Ticket> getTicketsOnTrain (Train train);

}
