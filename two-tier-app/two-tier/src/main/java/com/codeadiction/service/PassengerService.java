package com.codeadiction.service;

import com.codeadiction.entity.Passenger;

import java.util.List;

public interface PassengerService {

    void addPassenger(Passenger passenger);
    String updatePassenger(Long id,Passenger updatedPassenger);
    List<Passenger> getAllPassenger();

    Passenger getPassengerById(Long id);

    String deletePassenger(Long id);
}
