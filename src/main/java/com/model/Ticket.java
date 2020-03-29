package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "train_id")
    @NotBlank(message = "Train number must be filled in")
    private int trainNumber;

    @Column (name = "passenger_id")
    @NotBlank(message = "Passenger info must be filled in")
    private int passengerId;

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", trainId=" + trainNumber +
                ", passengerId=" + passengerId +
                '}';
    }
}