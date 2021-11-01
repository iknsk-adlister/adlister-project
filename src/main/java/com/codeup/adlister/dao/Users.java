package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    User findById(long id);

    void update(User user);
    Boolean check(User user);
    User findByEmail(String email);
    Boolean emailDuplicates(User user);
    Boolean emailInputIsValid(String email);
    void updatePassword(String password, long id);

}
