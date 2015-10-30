package com.augmentum.examonline.service.impl;
import org.apache.log4j.Logger;

import com.augmentum.examonline.dao.UserDao;
import com.augmentum.examonline.exception.ParameterException;
import com.augmentum.examonline.exception.ServiceException;
import com.augmentum.examonline.model.User;
import com.augmentum.examonline.service.UserService;
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    private final Logger logger = Logger.getLogger(UserServiceImpl.class);
    public void setUserDao (UserDao userDao) {
        this.userDao = userDao;
    }

    public User login (String wName, String wPassword) throws ParameterException, ServiceException {
        User user = null;
        ParameterException parameterException = new ParameterException();

        if (wName == null || wName.equals("")) {
            parameterException.addErrorField("wName", "User Name  is required.");
        }

        if (wPassword == null || wPassword.equals("")) {
            parameterException.addErrorField("wPassword", "User password  is required.");
        }
        if (parameterException.isErrorField()) {
            throw parameterException;
        }

        user = userDao.getUserByName(wName);

        if (user == null) {
            throw new ServiceException(1000, "User or password are error !");
        }

        if (!wPassword.equals(user.getPassword())) {
            throw new ServiceException(1000, "User or password are error !");
        }
        logger.info(wName+"info, Login");
        return user;
    }
}
