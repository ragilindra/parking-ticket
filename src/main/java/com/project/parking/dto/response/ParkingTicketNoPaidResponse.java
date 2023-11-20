package com.project.parking.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingTicketNoPaidResponse {
    private String parkingId;
    private String adminName;
    private String type;
    private Long pricePerHour;
    private String entryTime;
    private Long duration;
    private Long totalPrice;
    private Boolean paidStatus;
}
