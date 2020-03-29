package com.dao;

import com.model.Schedule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ScheduleDao {

    void add(Schedule schedule);

    void delete(Schedule schedule);

    void update(Schedule schedule);

    Schedule getById(int id);

    List<Schedule> allSchedules();

    int getStationId(int id);

    int getTrainNumber(int id);

    LocalDateTime getArrivalTime(int id);

    LocalDateTime getDepartureTime(int id);

    List<Integer> getAllTrainsNumbers();

    List<String> getAllStations();


}