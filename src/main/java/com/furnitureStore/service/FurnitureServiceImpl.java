package com.furnitureStore.service;
import com.furnitureStore.exceptions.*;
import com.furnitureStore.Dao.FurnitureDao;
import com.furnitureStore.entity.Furniture;
import com.furnitureStore.entity.Users;
import com.furnitureStore.exceptions.RecordAlreadyPresentException;
import com.furnitureStore.exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.Optional;
import java.util.logging.Logger;

public class FurnitureServiceImpl implements FurnitureService{
    @Autowired
    FurnitureDao furnitureDao;
    Logger logger = Logger.getLogger(String.valueOf(FurnitureServiceImpl.class));

    @Override
    public ResponseEntity<?> createFurniture(Furniture newFurniture) {
        Optional<Furniture> findFunitureById = furnitureDao.findById(newFurniture.getFurnitureId());
        try {
            if (!findFunitureById .isPresent()) {
                furnitureDao.save(newFurniture);
                return new ResponseEntity<Furniture>(newFurniture,HttpStatus.OK);
            } else
                throw new RecordAlreadyPresentException(" Furniture with number: " + newFurniture.getFurnitureId() + " already present");
        }
        catch(RecordAlreadyPresentException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Furniture updateFurniture(Furniture updateFurniture) {
        // TODO Auto-generated method stub
        Optional<Furniture> findFurnitureById = furnitureDao.findById(updateFurniture.getFurnitureId());
        if (findFurnitureById.isPresent()) {
            furnitureDao.save(updateFurniture);
        } else
            throw new RecordNotFoundException(
                    "User with Id: " + updateFurniture.getFurnitureId() + " not exists!!");
        return updateFurniture;
    }



    @Override
    public String deleteFurniture(Long furnitureId) {
        // TODO Auto-generated method stub
        Optional<Furniture> findFurnitureById = furnitureDao.findById(furnitureId);
        if (findFurnitureById.isPresent()) {
            furnitureDao.deleteById(furnitureId);
            return "findFurniture Deleted!!";
        } else
            throw new RecordNotFoundException("Furniture not found for the entered findFurnitureById");
    }

    @Override
    public Iterable<Furniture> displayAllFurniture() {
        // TODO Auto-generated method stub
        return furnitureDao.findAll();
    }

//    @Override
//    public ResponseEntity<?> findFurnitureById(Furniture furnitureId) {
//        return null;
//    }
}
