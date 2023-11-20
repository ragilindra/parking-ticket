package com.project.parking.entity;

import com.project.parking.constant.EType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "t_parking_ticket")
public class ParkingTicket {
    @Id
    private String id;

    @Column(name = "licence_plate", unique = true)
    private String licencePlate;

    @ManyToOne
    @JoinColumn(name = "id_admin")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "id_type")
    private Type type;

    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Boolean paid;
    private Long price;
}
