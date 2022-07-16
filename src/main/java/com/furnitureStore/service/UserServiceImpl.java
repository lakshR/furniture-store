package com.furnitureStore.service;

import com.furnitureStore.Dao.UserDao;
import com.furnitureStore.entity.Users;
import com.furnitureStore.exceptions.RecordAlreadyPresentException;
import com.furnitureStore.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override	public ResponseEntity<?> createUser(Users newUser) {
        // TODO Auto-generated method stub
        Optional<Users> findUserById = userDao.findById(newUser.getUid());
        try {
            if (!findUserById.isPresent()) {
                userDao.save(newUser);
                return new ResponseEntity<Users>(newUser, HttpStatus.OK);
            } else
                throw new RecordAlreadyPresentException(
                        "User with Id: " + newUser.getUsername() + " already exists!!");
        } catch (RecordAlreadyPresentException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Users updateUser(Users updateUser) {
        // TODO Auto-generated method stub
        Optional<Users> findUserById = userDao.findById(updateUser.getUid());
        if (findUserById.isPresent()) {
            userDao.save(updateUser);
        } else
            throw new RecordNotFoundException(
                    "User with Id: " + updateUser.getUid() + " not exists!!");
        return updateUser;
    }

    @Override
    public String deleteUser(BigInteger Uid) {
        // TODO Auto-generated method stub
        Optional<Users> findBookingById = userDao.findById(Uid);
        if (findBookingById.isPresent()) {
            userDao.deleteById(Uid);
            return "User Deleted!!";
        } else
            throw new RecordNotFoundException("User not found for the entered UserID");
    }

    @Override
    public Iterable<Users> displayAllUser() {
        // TODO Auto-generated method stub
        return userDao.findAll();
    }

    @Override
    public ResponseEntity<?> userLogin(BigInteger userId) {

        Optional<Users> findById = userDao.findById(userId);
        try{
            if(findById.isPresent()){
                Users findUser = findById.get();
                return new ResponseEntity<Users>(findUser,HttpStatus.OK);
            }else
                throw new RecordNotFoundException("No record found with ID " + userId);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
