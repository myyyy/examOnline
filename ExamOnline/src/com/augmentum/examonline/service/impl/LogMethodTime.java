package com.augmentum.examonline.service.impl;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

import com.augmentum.examonline.AppContext;
import com.augmentum.examonline.service.UserService;

public class LogMethodTime implements MethodInterceptor{
    private final Logger logger = Logger.getLogger(UserService.class);
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object returnValue = invocation.proceed();
        String methodName = invocation.getMethod().getName();
        long endTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(AppContext.getContext().getUserName());
        sb.append(":");
        sb.append(invocation.getMethod().getDeclaringClass().getSimpleName());
        sb.append(":");
        sb.append(methodName);
        sb.append(":");
        sb.append(endTime - startTime);
        logger.info(sb.toString());
        return returnValue;
    }
}
