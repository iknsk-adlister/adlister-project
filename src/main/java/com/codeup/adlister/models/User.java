package com.codeup.adlister.models;

import com.codeup.adlister.util.Password;
 // this is your constructor for a user and is being called when you create a new user
public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private long positiveRating;
    private long negativeRating;

    public User() {}
    //constructor for a user
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        setPassword(password);
        this.positiveRating = 0;
        this.negativeRating = 0;
    }

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.positiveRating = 0;
        this.negativeRating = 0;
    }

    public long getPositiveRating() {
        return positiveRating;
    }

    public void setPositiveRating(long positiveRating) {
        this.positiveRating = positiveRating;
    }

    public long getNegativeRating() {
        return negativeRating;
    }

    public void setNegativeRating(long negativeRating) {
        this.negativeRating = negativeRating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Password.hash(password);
    }
}
