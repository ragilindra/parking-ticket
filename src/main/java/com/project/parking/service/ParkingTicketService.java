package com.project.parking.service;

import com.project.parking.dto.request.NewParkingTicketRequest;
import com.project.parking.dto.response.NewParkingTicketResponse;
import com.project.parking.dto.response.ParkingTicketNoPaidResponse;
import com.project.parking.entity.ParkingTicket;

import java.util.List;

public interface ParkingTicketService {
    NewParkingTicketResponse createNew(NewParkingTicketRequest request);
    List<ParkingTicketNoPaidResponse> getAll(Boolean paid);
}
