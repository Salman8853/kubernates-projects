package com.codeadiction.controller;

import com.codeadiction.entity.Passenger;
import com.codeadiction.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping
    public ResponseEntity<Void> addPassenger(@RequestBody Passenger passenger) {
        passengerService.addPassenger(passenger);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePassenger(@PathVariable Long id, @RequestBody Passenger updatedPassenger) {
        String result = passengerService.updatePassenger(id, updatedPassenger);
        if (result.equals("Passenger not found")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers() {
        List<Passenger> passengers = passengerService.getAllPassenger();
        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id) {
        Passenger passenger = passengerService.getPassengerById(id);
        if (passenger != null) {
            return new ResponseEntity<>(passenger, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePassenger(@PathVariable Long id) {
        String result = passengerService.deletePassenger(id);
        if (result.equals("Passenger not found")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}
