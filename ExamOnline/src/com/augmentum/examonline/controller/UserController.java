package com.augmentum.examonline.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.augmentum.examonline.AppContext;
import com.augmentum.examonline.Constants;
import com.augmentum.examonline.exception.ParameterException;
import com.augmentum.examonline.exception.ServiceException;
import com.augmentum.examonline.model.User;
import com.augmentum.examonline.service.UserService;
import com.augmentum.examonline.until.StringUtil;

@Controller
@RequestMapping(Constants.APP_URL_USER_PREFIX)
public class UserController extends BaseController{
    private final String LOGIN_PAGE = "login";
    private final String LIST_QUESTION = "question/list";
    private UserService userService;
    private final Logger logger = Logger.getLogger(UserService.class);
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login (@RequestParam(value = "go", defaultValue = "") String go) {
        User user = this.getUser();
        ModelAndView modelAndView = new ModelAndView();
        if(user != null){
            modelAndView.setView(this.getRedirectView(LIST_QUESTION));
        }else{
            modelAndView.addObject("go", go);
            modelAndView.setViewName(LOGIN_PAGE);
        }
        return modelAndView;
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public  ModelAndView nextLogin (
                                    @RequestParam(value = "userName", defaultValue = "")
                                    String wName,
                                    @RequestParam(value = "userPassword", defaultValue = "")
                                    String wPassword,
                                    @RequestParam(value = "queryString", defaultValue = "")
                                    String queryString,
                                    @RequestParam(value = "go", defaultValue = "")
                                    String go
                                    ) {
         ModelAndView modelAndView = new ModelAndView();
         try {
             User user = null;
             user = userService.login(wName, wPassword);
             user.setPassword(null);
             this.addSession("userName", wName);
             this.addSession(Constants.USER, user);
             if (!StringUtil.isEmpty(queryString)) {
                 if (queryString.startsWith("#")) {
                     queryString = queryString.substring(1);
                 }
                 go = go + "?" + queryString;
             }
             RedirectView redirectView = StringUtil.isEmpty(go) ? this.getRedirectView(LIST_QUESTION)
                     :  new RedirectView(AppContext.getContextPath() + "/" + go);
             modelAndView.setView(redirectView);
         } catch (ParameterException parameterException) {
             Map<String, String> errorField = parameterException.getErrorField();
             modelAndView.addObject(Constants.ERR0R_FILED, errorField);
             modelAndView.setViewName(LOGIN_PAGE);
             logger.error(wName+"parameterException");
         } catch (ServiceException serviceException) {
             String messageString = serviceException.getMessage();
             modelAndView.addObject(Constants.TOP_MESSAGE , messageString);
             modelAndView.setViewName(LOGIN_PAGE);
             logger.warn(wName+"name&password are error.");
         }
         return modelAndView;
    }

}
