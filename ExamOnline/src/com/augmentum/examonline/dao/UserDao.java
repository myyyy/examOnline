package com.augmentum.examonline.dao;

import com.augmentum.examonline.model.User;

public interface UserDao {
    public User getUserByName(String userName);
}
