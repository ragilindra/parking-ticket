package com.project.parking.service;

import com.project.parking.dto.request.NewTypeVehicleRequest;
import com.project.parking.entity.Type;

import java.util.List;

public interface TypeService {
    Type createNew(NewTypeVehicleRequest request);
    Type update(Type type);
    Type findByName(String name);
    List<Type> getAll();
}
