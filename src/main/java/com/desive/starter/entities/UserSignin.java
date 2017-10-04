package com.desive.starter.entities;

/*
 Created by Jack DeSive on 10/3/2017 at 3:50 AM
*/
public class UserSignin {

    String username;
    String password;

    public UserSignin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserSignin() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
