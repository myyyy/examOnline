package com.augmentum.examonline.service;

import java.util.List;

import com.augmentum.examonline.dao.QuestionDao;
import com.augmentum.examonline.model.Pagination;
import com.augmentum.examonline.model.Question;

public interface QuestionService {
    public void setQuestionDao(QuestionDao questionDao);
    public void update(Question question);
    public void delete(int id,int pageNo);
    public int getPageCount(String key);
    public Question getById(int id);
    public List<Question> findList(int pageNoStr, Pagination pagination, String key);
}
