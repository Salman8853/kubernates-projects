package com.codeadiction.service;

import com.codeadiction.entity.Passenger;
import com.codeadiction.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public void addPassenger(Passenger passenger) {
        passengerRepository.save(passenger);
    }

    @Override
    public String updatePassenger(Long id, Passenger updatedPassenger) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);
        if (optionalPassenger.isPresent()) {
            Passenger passenger = optionalPassenger.get();
            passenger.setName(updatedPassenger.getName());
            passenger.setTicket(updatedPassenger.getTicket());
            passengerRepository.save(passenger);
            return "Passenger updated successfully";
        } else {
            return "Passenger not found";
        }
    }

    @Override
    public List<Passenger> getAllPassenger() {
        return passengerRepository.findAll();
    }

    @Override
    public Passenger getPassengerById(Long id) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);
        return optionalPassenger.orElse(null);
    }

    @Override
    public String deletePassenger(Long id) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);
        if (optionalPassenger.isPresent()) {
            passengerRepository.deleteById(id);
            return "Passenger deleted successfully";
        } else {
            return "Passenger not found";
        }
    }
}
