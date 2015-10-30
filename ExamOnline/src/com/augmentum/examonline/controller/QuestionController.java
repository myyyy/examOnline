package com.augmentum.examonline.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.augmentum.examonline.Constants;
import com.augmentum.examonline.model.Common;
import com.augmentum.examonline.model.Pagination;
import com.augmentum.examonline.model.Question;
import com.augmentum.examonline.service.QuestionService;
@Controller
@RequestMapping(Constants.APP_URL_QUESTION_PREFIX)
public class QuestionController extends BaseController {

    private final String LIST_QUESTION = "question/list";
    private QuestionService questionService;
    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create (){
        ModelAndView modelAndView = new ModelAndView();
        Question question = new Question();
        modelAndView.addObject("question", question);
        modelAndView.setViewName("question/add_question");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit (
                              @RequestParam(value = "id", defaultValue = "")
                              int id,
                              @RequestParam(value = "status", defaultValue = "")
                              String status){
        Question question = questionService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("question", question);
        if(status.equals("edit")){
            modelAndView.setViewName("question/add_question");
        } else {
            modelAndView.setViewName("question/edit_question");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save (Question question) {
        ModelAndView modelAndView = new ModelAndView();
        questionService.update(question);
        this.addSession(Constants.SUCESS_FLASH_MESSAGE, "edit sucess");
        modelAndView.setView(this.getRedirectView(LIST_QUESTION+"?pageNo=1"));
        return modelAndView;
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list (
                              @RequestParam(value = "pageNo", defaultValue = "1")
                              int pageNoStr,
                              @RequestParam(value = "key", defaultValue = "")
                              String key
                              ) throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView();
        List<Question> questions = null;
        Pagination pagination = new Pagination();
        pagination.setPageNo(pageNoStr);
        Common common = new Common();
        common.setKeyWord(key);
        questions = questionService.findList(pageNoStr, pagination,key);
        modelAndView.addObject("Pagination", pagination);
        modelAndView.addObject("Questions", questions);
        modelAndView.addObject("key", common.getKeyWord());
        modelAndView.setViewName("question/list_question");
        return modelAndView;
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete (
                                @RequestParam(value = "id", defaultValue = "")
                                String id,
                                @RequestParam(value = "pageNo", defaultValue = "1")
                                int pageNo
                                ) {
        ModelAndView modelAndView = new ModelAndView();
        String[]dealId = id.split(",");
        for(int i=0; i<dealId.length; i++) {
            Pagination pagination = new Pagination();
            pagination.setPageNo(pageNo);
            questionService.delete(Integer.parseInt(dealId[i]),pageNo);
        }
        modelAndView.addObject("pageNo", pageNo);
        modelAndView.setView(this.getRedirectView(LIST_QUESTION));
        return modelAndView;
    }
}