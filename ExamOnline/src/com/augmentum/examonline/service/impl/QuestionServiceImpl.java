package com.augmentum.examonline.service.impl;
import java.util.List;

import com.augmentum.examonline.dao.QuestionDao;
import com.augmentum.examonline.model.Pagination;
import com.augmentum.examonline.model.Question;
import com.augmentum.examonline.service.QuestionService;
public class QuestionServiceImpl implements QuestionService{

    private QuestionDao questionDao;

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public void update(Question question) {
        questionDao.update(question);
    }

    public List<Question> findList(int pageNoStr, Pagination pagination, String key) {
        return questionDao.findList(pageNoStr, pagination, key);
    }


    public void delete(int id, int pageNo) {
        questionDao.delete(id, pageNo);
    }

    public  int getPageCount(String key) {
        return questionDao.getPageCount(key);
    }

    public Question getById(int id) {
        return questionDao.getById(id);
    }

}
