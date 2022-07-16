//package com.furnitureStore.controller;
//
//import com.furnitureStore.entity.Furniture;
//
//import com.furnitureStore.exceptions.RecordAlreadyPresentException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.web.bind.annotation.*;
//import com.furnitureStore.service.FurnitureService;
//
//@ComponentScan(basePackages = "com")
//@RestController
//@RequestMapping("/furniture")
//@CrossOrigin(origins = "http://localhost:3000")
//
//public class FurnitureController {
//    @Autowired(required = true)
//    FurnitureService furnitureService;
//
//    @PostMapping("/createfurniture")
//    @ExceptionHandler(RecordAlreadyPresentException.class)
//    public void addFurniture(@RequestBody Furniture newFurniture) {
//        furnitureService.createFurniture(newFurniture);
//    }
//}
