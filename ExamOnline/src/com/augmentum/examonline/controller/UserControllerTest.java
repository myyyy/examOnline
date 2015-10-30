package com.augmentum.examonline.controller;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.augmentum.examonline.AppContext;
import com.augmentum.examonline.Constants;
import com.augmentum.examonline.until.PathUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:exam-mvc.xml"})
public class UserControllerTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Before
    public void setUp() throws Exception{
        AppContext.setContextPath("/page");
        AppContext appContext = AppContext.getContext();
        appContext.addObject(Constants.APP_CONTEXT_SESSION, new MockHttpSession());
    }

    @After
    public void tearDown() throws Exception {
        AppContext appContext = AppContext.getContext();
        appContext.clear();

    }

    @Test
    public void testSaveLogin() {
        UserController userController = (UserController) this.applicationContext.getBean("userController");
        ModelAndView modelAndView = userController.nextLogin("Ian.Su", "123", "", "");
        RedirectView redirectView = (RedirectView) modelAndView.getView();
        Assert.assertEquals(PathUtil.getFullPath("question/list"), redirectView.getUrl());
    }
}