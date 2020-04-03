package com.service.impl;


import com.dao.StationDao;
import com.dao.TicketDao;
import com.dao.TrainDao;
import com.dao.UserDao;
import com.model.Station;
import com.model.Ticket;
import com.model.Train;
import com.model.User;


import com.service.StationService;
import com.service.TicketService;
import com.service.TrainService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static jdk.nashorn.tools.Shell.SUCCESS;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    TrainDao trainDao;

    @Autowired
    TicketDao ticketDao;

    @Autowired
    UserDao userDao;

    @Autowired
    StationDao stationDao;

    @Autowired
    private StationService stationService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private UserService userService;

    @Override
    public void addTicket(Ticket ticket) {
    ticketDao.addTicket(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
      return ticketDao.getAllTickets();
    }

    @Override
    public Ticket getTicketById(int id) {
        return ticketDao.getTicketById(id);
    }

    @Override
    public List<Ticket> getTicketForTrip(Train train, Station departure, Station arrival) {
        return  ticketDao.getTicketForTrip(train, departure, arrival);
    }

    @Override
    public String checkPurchaseConditions
            (Train train, Station departure, Station arrival, User user) {
        if (getNumOfTicketsOnSale(train , departure , arrival) <=0 ) {
            return "ticket was finished";
        }
        if (train.getSchedules().get(0).getDepartureTime().getTime() - new Date().getTime() < 600000){
            return "too late"; ////////////////////////////////////
        }

            for (Ticket ticket : ticketService.getTicketsOnTrain(train)){
                if (ticket.getUser().equals(user) && ticket.getTrain().equals(train)){
    return "yet you buy this ticket";
                }
            }
        return "Our congratulations";
    }

    @Override
    public int getNumOfTicketsOnSale(Train t, Station departure, Station arrival) {
       Integer result=  t.getCapacityTrain();
       result =



    }

    @Override
    public List<Ticket> getTicketsOnTrain(Train train) {
        return ticketDao.getTicketsOnTrain(train);
    }

    @Override
    public String buyTicket(Map<String, String> params) {
        Station departure = stationService.getStationByName(params.get("departureStation"));
               Station arrival = stationService.getStationByName(params.get("arrivalStation"));
        Train train = trainService.getById(Integer.parseInteger(params.get("trainId")));
        User user = userService.findByUsername(authentication.getName());
        String conditions = checkPurchaseConditions(train,departure,arrival, user);
        if(conditions.equals(SUCCESS)){
            Ticket ticket = new Ticket();
            ticket.setTrain(train);
            ticket.setDeparture(departure);
            ticket.setArrival(arrival);
            ticket.setPassenger(passengerService.findByUsername(authentication.getName()));
            saveTicket(ticket);
        }
        return conditions;
    }
    }
}
