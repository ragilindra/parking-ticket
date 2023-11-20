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
public class NewTypeRequest {
    private EType nameType;
    private Long price;
}
