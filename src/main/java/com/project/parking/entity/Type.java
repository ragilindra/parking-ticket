package com.project.parking.entity;

import com.project.parking.constant.EType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "m_type")
public class Type {
    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    @Column(name = "name_type")
    private EType nameType;
    @Column(name = "price")
    private Long price;
}
