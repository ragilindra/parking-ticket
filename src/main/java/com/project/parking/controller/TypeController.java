package com.project.parking.controller;

import com.project.parking.dto.request.NewTypeVehicleRequest;
import com.project.parking.entity.Type;
import com.project.parking.repository.TypeRepository;
import com.project.parking.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
@RequiredArgsConstructor
public class TypeController {
    private final TypeService typeService;

    @PostMapping
    public Type createNew(NewTypeVehicleRequest request){
        return typeService.createNew(request);
    }

    @GetMapping
    public List<Type> getAll(){
        return typeService.getAll();
    }

    @PutMapping
    public Type update(Type type){
        return typeService.update(type);
    }

}
