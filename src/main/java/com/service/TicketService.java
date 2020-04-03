package com.service;

import com.model.Station;
import com.model.Ticket;
import com.model.Train;
import com.model.User;
import java.util.List;
import java.util.Map;

public interface TicketService {

    void addTicket(Ticket ticket);

    List<Ticket> getAllTickets();

    Ticket getTicketById(int id);

    List<Ticket> getTicketForTrip(Train train, Station departure, Station  arrival);

    String checkPurchaseConditions(Train train, Station departure, Station  arrival, User user);

    public int getNumOfTicketsOnSale(Train t, Station departure, Station arrival);

    List<Ticket> getTicketsOnTrain(Train train);

    String buyTicket(Map<String, String> params);

}
