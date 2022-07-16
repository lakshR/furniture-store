//package com.furnitureStore.service;
//
//import com.furnitureStore.Dao.FurnitureDao;
//import com.furnitureStore.entity.Furniture;
//import com.furnitureStore.exceptions.RecordAlreadyPresentException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Optional;
//import java.util.logging.Logger;
//
//public class FurnitureServiceImpl implements FurnitureService{
//    @Autowired
//    FurnitureDao furnitureDao;
//    Logger logger = Logger.getLogger(String.valueOf(FurnitureServiceImpl.class));
//
//    @Override
//    public ResponseEntity<?> createFurniture(Furniture newFurniture) {
//        Optional<Furniture> findFunitureById = FurnitureDao.findById(newFurniture.getFurnitureId());
//        try {
//            if (!findFunitureById .isPresent()) {
//                FurnitureDao.save(newFurniture);
//                return new ResponseEntity<Furniture>(newFurniture,HttpStatus.OK);
//            } else
//                throw new RecordAlreadyPresentException(" Furniture with number: " + newFurniture.getFurnitureId() + " already present");
//        }
//        catch(RecordAlreadyPresentException e)
//        {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @Override
//    public Furniture updateFurniture(Furniture newFurniture) {
//        return null;
//    }
//
//    @Override
//    public String deleteFurniture(Furniture furnitureId) {
//        return null;
//    }
//
//    @Override
//    public Iterable<Furniture> displayAllFurniture() {
//        // TODO Auto-generated method stub
//        return FurnitureDao.findAll();
//    }
//
//    @Override
//    public ResponseEntity<?> findFurnitureById(Furniture furnitureId) {
//        return null;
//    }
//}
