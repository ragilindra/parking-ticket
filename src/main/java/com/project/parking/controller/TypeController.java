package com.project.parking.controller;

import com.project.parking.entity.Type;
import com.project.parking.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
@RequiredArgsConstructor
public class TypeController {
    private final TypeRepository typeRepository;

    @PostMapping
    public Type createNew(Type type){
        return typeRepository.saveAndFlush(type);
    }

    @GetMapping
    public List<Type> getAll(){
        return typeRepository.findAll();
    }

    @PutMapping
    public Type update(Type type){
        return typeRepository.update(type);
    }

}
