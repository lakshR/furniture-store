package com.furnitureStore.service;


import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.furnitureStore.entity.Users;

public interface UserService {

    public ResponseEntity<?> createUser(Users newUser);

    public Users updateUser(Users newUser);

    public String deleteUser(BigInteger uid);

    public Iterable<Users> displayAllUser();

//	public ResponseEntity<?> findUserById(BigInteger userId);


    //login details
    ResponseEntity<?> userLogin(BigInteger uid);
}