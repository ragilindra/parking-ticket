package com.project.parking.dto.request;

import com.project.parking.constant.EType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewParkingTicketRequest {
    private String licencePlate;
    private String adminId;
    private EType nameType;
}
