package com.project.parking.service.impl;

import com.project.parking.dto.request.NewParkingTicketRequest;
import com.project.parking.dto.response.NewParkingTicketResponse;
import com.project.parking.dto.response.ParkingTicketNoPaidResponse;
import com.project.parking.entity.Admin;
import com.project.parking.entity.ParkingTicket;
import com.project.parking.entity.Type;
import com.project.parking.repository.ParkingTicketRepository;
import com.project.parking.service.AdminService;
import com.project.parking.service.ParkingTicketService;
import com.project.parking.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParkingTicketServiceImpl implements ParkingTicketService {
    private final ParkingTicketRepository parkingTicketRepository;
    private final AdminService adminService;
    private final TypeService typeService;

    @Override
    public NewParkingTicketResponse createNew(NewParkingTicketRequest request) {
        Admin admin = adminService.findById(request.getAdminId());
        Type type = typeService.findByName(request.getNameType().name());
        ParkingTicket parkingTicket = ParkingTicket.builder()
                .licencePlate(request.getLicencePlate())
                .admin(admin)
                .type(type)
                .entryTime(LocalDateTime.now())
                .paid(Boolean.FALSE)
                .build();

        parkingTicketRepository.saveAndFlush(parkingTicket);
        ParkingTicket response = parkingTicketRepository.getByLicencePlate(parkingTicket.getLicencePlate());
        return NewParkingTicketResponse.builder()
                .parkingId(response.getId())
                .adminName(admin.getName())
                .type(type.getNameType().name())
                .pricePerHour(type.getPrice())
                .entryTime(response.getEntryTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
    }

    @Override
    public List<ParkingTicketNoPaidResponse> getAll(Boolean paid) {
        List<ParkingTicket> allPaidOrNoPaid = parkingTicketRepository.findAllPaidOrNoPaid(paid);

        return allPaidOrNoPaid.stream().map(parkingTicket -> {
            long duration = Duration.between(parkingTicket.getEntryTime(), LocalDateTime.now()).toHours();
//            Long price = 0;
//            if (duration > 1) {
//                price = parkingTicket.getPrice();
//            }
            return ParkingTicketNoPaidResponse.builder()
                    .parkingId(parkingTicket.getId())
                    .adminName(parkingTicket.getAdmin().getName())
                    .type(parkingTicket.getType().getNameType().name())
                    .entryTime(parkingTicket.getEntryTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .pricePerHour(parkingTicket.getType().getPrice())
                    .duration(duration)
                    .paidStatus(parkingTicket.getPaid())
//                    .totalPrice(price)
                    .build();
        }).collect(Collectors.toList());
    }
}
