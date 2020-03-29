package com.service;


import com.dto.ScheduleDto;
import com.model.Schedule;

import java.util.List;


public interface ScheduleService {


    void add(Schedule schedule);

    void delete(Schedule schedule);

    void update(Schedule schedule);

    Schedule getById(int id);

    ScheduleDto getData(int id);

    List<Schedule> allSchedules();


}