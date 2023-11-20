package com.project.parking.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewParkingTicketResponse {
    private String parkingId;
    private String adminName;
    private String type;
    private Long pricePerHour;
    private String entryTime;
}
