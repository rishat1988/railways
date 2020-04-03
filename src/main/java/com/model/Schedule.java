package com.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "train_number")
    @NotNull(message = "Numbers train must be filled in")
    private Integer trainNumber;

    @Column(name = "station_id")
    @NotNull(message = "station must be filled in")
    private Integer stationId;

    @Column(name = "arrival_time")
    @DateTimeFormat(pattern = "yyyy-dd-MM  HH:mm")
    @NotNull(message = "Arrival time  must be filled in")
    private Date arrivalTime;


    @Column(name = "departure_time")
    @DateTimeFormat(pattern = "yyyy-dd-MM  HH:mm")
    @NotNull(message = "Departure time  must be filled in")
    private Date departureTime;

    @Transient
    private String stationName;

    public Schedule() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(Integer trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", trainId=" + trainNumber +
                ", stationId=" + stationId +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", stationName='" + stationName + '\'' +
                '}';
    }
}