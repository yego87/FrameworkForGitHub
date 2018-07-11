package com.epam.data;

import com.epam.utils.TestProperties;

/**
 * Need for successful login in account,
 * take user data from properties file
 */
public class UserData {

    private String username;
    private String password;

    /**
     * Constructor
     */
    public UserData() {

    }


    public String getUsername() {
        username = TestProperties.getTestProperty("username");

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        password = TestProperties.getTestProperty("password");

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
