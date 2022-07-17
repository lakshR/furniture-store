package com.furnitureStore.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.furnitureStore.exceptions.RecordAlreadyPresentException;
import com.furnitureStore.exceptions.RecordNotFoundException;
import com.furnitureStore.entity.Furniture;
import com.furnitureStore.service.FurnitureService;

import java.math.BigInteger;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/furniture")
public class FurnitureController {
    @Autowired
    FurnitureService furnitureService;

    @PostMapping("/createfurniture")
    @ExceptionHandler(RecordAlreadyPresentException.class)
    public void addFurniture(@RequestBody Furniture newFurniture) {
        furnitureService.createFurniture(newFurniture);
    }
    @GetMapping("/readAllFurniture")
    public Iterable<Furniture> readAllfurniture() {
        return  furnitureService.displayAllFurniture();
    }
    @DeleteMapping("/deleteFurniture/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public void deleteFurnitureByID(@PathVariable("id") Long furnitureId) {

        furnitureService.deleteFurniture(furnitureId);
    }
    @PutMapping("/updateFurniture")
    @ExceptionHandler(RecordNotFoundException.class)
    public void updateFurniture(@RequestBody Furniture updateFurniture) {

        furnitureService.updateFurniture(updateFurniture);
    }

}
