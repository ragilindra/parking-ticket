package com.project.parking.repository;

import com.project.parking.entity.ParkingTicket;
import io.swagger.v3.oas.annotations.links.Link;

import java.util.List;

public interface ParkingTicketRepository {
    void saveAndFlush(ParkingTicket parkingTicket);
    ParkingTicket getByLicencePlate(String licencePlate);
    ParkingTicket update(ParkingTicket parkingTicket);
    List<ParkingTicket> findAllPaidOrNoPaid(Boolean paid);
}
