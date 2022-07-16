package com.furnitureStore.controller;

import java.math.BigInteger;

import com.furnitureStore.entity.Users;
import com.furnitureStore.exceptions.RecordAlreadyPresentException;
import com.furnitureStore.exceptions.RecordNotFoundException;
import com.furnitureStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createUser") //--> signup
    @ExceptionHandler(RecordAlreadyPresentException.class)
    public void addUser(@RequestBody Users newUser) {

        userService.createUser(newUser);
    }
    @GetMapping("/readAllUsers")
    public Iterable<Users> readAllUsers() {

        return userService.displayAllUser();
    }

    @DeleteMapping("/deleteUser/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public void deleteUserByID(@PathVariable("id") BigInteger Uid) {

        userService.deleteUser(Uid);
    }

    @PutMapping("/updateUser")
    @ExceptionHandler(RecordNotFoundException.class)
    public void updateUser(@RequestBody Users updateUser) {

        userService.updateUser(updateUser);
    }

    @GetMapping("/userLogin/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> userLogin(@PathVariable("id") BigInteger userId){

        return userService.userLogin(userId);
    }
}