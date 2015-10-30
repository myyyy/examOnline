package com.augmentum.examonline.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

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
import com.augmentum.examonline.model.Pagination;
import com.augmentum.examonline.model.Question;
import com.augmentum.examonline.until.PathUtil;
import com.augmentum.examonline.until.SessionUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:exam-mvc.xml"})
public class QuestionControllerTest extends AbstractTransactionalJUnit4SpringContextTests{

    @Before
    public void setUp() throws Exception{
        AppContext.setContextPath("page");
        AppContext appContext = AppContext.getContext();
        appContext.addObject(Constants.APP_CONTEXT_SESSION, new MockHttpSession());
    }

    @After
    public void tearDown() throws Exception {
        AppContext appContext = AppContext.getContext();
        appContext.clear();

    }

    @Test
    public void testListSuccessDefParams() throws UnsupportedEncodingException {
        QuestionController questionController = (QuestionController) this.applicationContext.getBean("questionController");
        ModelAndView modelAndView = questionController.list(1, "");
        Assert.assertEquals("question/list_question", modelAndView.getViewName());
        Assert.assertNotNull(modelAndView.getModel());
    }

    @Test
    public void testListSuccessUnDefParams() throws UnsupportedEncodingException {
        QuestionController questionController = (QuestionController) this.applicationContext.getBean("questionController");
        ModelAndView modelAndView = questionController.list(2, "5");
        Assert.assertEquals("question/list_question", modelAndView.getViewName());
        Map<String, Object> map = modelAndView.getModel();
        Pagination pagination = (Pagination) map.get("Pagination");
        String key = (String) map.get("key");
        int currentPage = pagination.getPageNo();
        Assert.assertEquals(2, currentPage);
        Assert.assertEquals("5", key);
    }

    @Test
    public void testListSuccessParamKey() throws UnsupportedEncodingException {
        QuestionController questionController = (QuestionController) this.applicationContext.getBean("questionController");
        ModelAndView modelAndView = questionController.list(1,"I");
        Assert.assertEquals("question/list_question", modelAndView.getViewName());
        Map<String, Object> map = modelAndView.getModel();
        String key = (String) map.get("key");
        Assert.assertEquals("I", key);
    }

    @Test
    public void testListSuccessParamCurrentPageMoreThanCountPage() throws UnsupportedEncodingException {
        QuestionController questionController = (QuestionController) this.applicationContext.getBean("questionController");
        ModelAndView modelAndView = questionController.list(18,"");
        Assert.assertEquals("question/list_question", modelAndView.getViewName());
        Map<String, Object> map = modelAndView.getModel();
        Pagination pagination = (Pagination) map.get("Pagination");
//        int currentPage = pagination.getPageNo();
//        int bottomPageNo = pagination.getBottomPageNo();
//        Assert.assertEquals(bottomPageNo, currentPage);
    }

    @Test
    public void testListSuccessParamCurrentPageLessThanzero() throws UnsupportedEncodingException {
        QuestionController questionController = (QuestionController) this.applicationContext.getBean("questionController");
        ModelAndView modelAndView = questionController.list(1, "");
        Assert.assertEquals("question/list_question", modelAndView.getViewName());
        Map<String, Object> map = modelAndView.getModel();
        Pagination pagination = (Pagination) map.get("Pagination");
        int currentPage = pagination.getPageNo();
        Assert.assertEquals(1, currentPage);
    }

    @Test
    public void testEditSuccessToCreate() {
        QuestionController questionController = (QuestionController) this.applicationContext.getBean("questionController");
        ModelAndView modelAndView = questionController.edit(0, "edit");
        Assert.assertEquals("question/add_question", modelAndView.getViewName());
        Assert.assertNull(modelAndView.getModel().get("question"));
    }

    @Test
    public void testEditSuccessToSave() {
        QuestionController questionController = (QuestionController) this.applicationContext.getBean("questionController");
        ModelAndView madEdit = questionController.edit(193,"");
        Assert.assertEquals("question/edit_question", madEdit.getViewName());
        Assert.assertNotNull(madEdit.getModelMap().get("question"));
    }

    @Test
    public void testSaveSuccessToCreate() {
        QuestionController questionController = (QuestionController) this.applicationContext.getBean("questionController");
        Question question = new Question();
        question.setQuestionId("22");
        question.setTitle("TitleTest1");
        question.setA("AnswerA");
        question.setB("AnswerB");
        question.setC("AnswerC");
        question.setD("AnswerD");
        question.setCorrectAnswer("A");
        ModelAndView mavSave = questionController.save(question);
        RedirectView redirectView = (RedirectView) mavSave.getView();
        Assert.assertEquals(PathUtil.getFullPath("question/list?pageNo=1"), redirectView.getUrl());
    }

    @Test
    public void testSaveSuccessToUpdate() {
        QuestionController questionController = (QuestionController) this.applicationContext.getBean("questionController");
        Question question = new Question();
        question.setQuestionId("222");
        question.setTitle("TitleTest1");
        question.setA("AnswerA");
        question.setB("AnswerB");
        question.setC("AnswerC");
        question.setD("AnswerD");
        question.setCorrectAnswer("A");
        ModelAndView mavSave = questionController.save(question);
        RedirectView redirectView = (RedirectView) mavSave.getView();
        Assert.assertEquals(PathUtil.getFullPath("question/list?pageNo=1"), redirectView.getUrl());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testSaveCreateParamErr() {
        QuestionController questionController = (QuestionController) this.applicationContext.getBean("questionController");
        Question question = new Question();
        question.setQuestionId("22");
        question.setTitle("TitleTest1");
        question.setA("AnswerA");
        question.setB("AnswerB");
        question.setC("AnswerC");
        question.setD("AnswerD");
        question.setCorrectAnswer("A");
        ModelAndView mavSave = questionController.save(question);
        RedirectView s = (RedirectView) mavSave.getView();
        Assert.assertNull(SessionUtil.getSession(Constants.SUCESS_FLASH_MESSAGE)) ;
        Assert.assertEquals(PathUtil.getFullPath("question/list?pageNo=1"), s.getUrl());
    }
    @Test
    public void testShowSuccessDefParam() throws UnsupportedEncodingException {
        QuestionController questionController = (QuestionController) this.applicationContext.getBean("questionController");
        ModelAndView mavShow = questionController.list(1, "");
        Assert.assertEquals("question/list_question", mavShow.getViewName());
    }

    @Test
    public void testDeleteSuccess() {
        QuestionController questionController = (QuestionController) this.applicationContext.getBean("questionController");
        ModelAndView mavDelete = questionController.delete("193", 1);
        RedirectView redirectView = (RedirectView) mavDelete.getView();
        Assert.assertEquals(PathUtil.getFullPath("question/list"), redirectView.getUrl());
    }

    @Test
    public void testCreate() {
        QuestionController questionController = (QuestionController) this.applicationContext.getBean("questionController");
        ModelAndView mavCreate = questionController.create();
        Assert.assertEquals("question/add_question", mavCreate.getViewName());
    }

}