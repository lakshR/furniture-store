package com.furnitureStore.entity;




import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity
public class Users {
    @Id
    private BigInteger uid;
    private String username;
    private String password;
    private String role;

    public Users() {
    }

    public Users(BigInteger uid, String username, String password, String role) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public BigInteger getUid() {
        return uid;
    }

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}