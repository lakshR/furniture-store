package com.furnitureStore.service;

import com.furnitureStore.entity.Furniture;

import org.springframework.http.ResponseEntity;

public interface FurnitureService {

    public ResponseEntity<?> createFurniture(Furniture newFurniture);

    public Furniture updateFurniture(Furniture newFurniture);

    public String deleteFurniture(Long furnitureId);

    public Iterable<Furniture> displayAllFurniture();

//	public ResponseEntity<?> findFurnitureById(Furniture furnitureId);


}
