package com.codeadiction.repository;

import com.codeadiction.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
