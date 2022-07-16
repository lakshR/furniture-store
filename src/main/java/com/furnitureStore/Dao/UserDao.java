package com.furnitureStore.Dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.furnitureStore.entity.Users;
public interface UserDao extends CrudRepository<Users, BigInteger>{

}