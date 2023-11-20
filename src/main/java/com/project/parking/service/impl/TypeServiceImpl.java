package com.project.parking.service.impl;

import com.project.parking.dto.request.NewTypeVehicleRequest;
import com.project.parking.entity.Type;
import com.project.parking.repository.TypeRepository;
import com.project.parking.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;
    @Override
    public Type createNew(NewTypeVehicleRequest request) {
        Type type = Type.builder()
                .nameType(request.getTypeName())
                .price(request.getPrice())
                .build();
        return typeRepository.saveAndFlush(type);
    }


    @Override
    public Type update(Type type) {
        return typeRepository.update(type);
    }

    @Override
    public Type findByName(String name) {
        return typeRepository.findByName(name);
    }

    @Override
    public List<Type> getAll() {
        return typeRepository.findAll();
    }
}
