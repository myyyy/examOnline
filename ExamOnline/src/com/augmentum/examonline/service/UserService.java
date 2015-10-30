package com.augmentum.examonline.service;

import com.augmentum.examonline.exception.ParameterException;
import com.augmentum.examonline.exception.ServiceException;
import com.augmentum.examonline.model.User;

public interface UserService {
    public User login (String wName, String wPassword) throws ParameterException, ServiceException;
}
