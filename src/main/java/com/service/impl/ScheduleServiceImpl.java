package com.service.impl;

import com.dao.ScheduleDao;
import com.dto.ScheduleDto;
import com.model.Schedule;
import com.service.ScheduleService;
import com.service.StationService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;

    @Autowired
    private StationService stationService;

    @Override
    @Transactional
    public void add(Schedule schedule) {
scheduleDao.add(schedule);
    }

    @Override
    @Transactional
    public void delete(Schedule schedule) {
        scheduleDao.delete(schedule);

    }

    @Override
    @Transactional
    public void update(Schedule schedule) {
scheduleDao.update(schedule);
    }

    @Override
    @Transactional
    public Schedule getById(int id) {
      return scheduleDao.getById(id);
    }

    @Override
    @Transactional
    public ScheduleDto getData(int id) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setId(id);
        scheduleDto.setStationName(stationService.getById(scheduleDao.getStationId(id)).getName());
        scheduleDto.getTrainNumber(scheduleDao.getTrainNumber(id));
        LocalDateTime arrivalTime = scheduleDao.getArrivalTime(id);
        scheduleDto.setArrivalTime(arrivalTime);
        LocalDateTime departureTime = scheduleDao.getDepartureTime(id);
        scheduleDto.setDepartureTime(departureTime);
        scheduleDto.setArrivalTimeFormat(arrivalTime.format(dateTimeFormatter));
        scheduleDto.setArrivalTimeFormat(departureTime.format(dateTimeFormatter));
        return scheduleDto;
    }

    @Override
    @Transactional
    public List<Schedule> allSchedules() {
     return  scheduleDao.allSchedules();
    }
}
