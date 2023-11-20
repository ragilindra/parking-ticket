package com.project.parking.repository;

import com.project.parking.entity.ParkingTicket;

public interface ParkingTicketRepository {
    ParkingTicket saveAndFlush(ParkingTicket parkingTicket);
    ParkingTicket getByName(String name);
}
