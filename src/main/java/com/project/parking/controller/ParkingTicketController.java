package com.project.parking.controller;

import com.project.parking.dto.request.NewParkingTicketRequest;
import com.project.parking.dto.response.NewParkingTicketResponse;
import com.project.parking.dto.response.ParkingTicketNoPaidResponse;
import com.project.parking.entity.ParkingTicket;
import com.project.parking.repository.ParkingTicketRepository;
import com.project.parking.service.ParkingTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/parking-tickets")
public class ParkingTicketController {
    private final ParkingTicketService parkingTicketService;

    @PostMapping
    public Object createNew(@RequestBody NewParkingTicketRequest request){
        return parkingTicketService.createNew(request);
    }

    @GetMapping("/no-paid")
    public List<ParkingTicketNoPaidResponse> getAllNoPaid(){
        return parkingTicketService.getAll(false);
    }
}
