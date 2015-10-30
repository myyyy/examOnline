package com.augmentum.examonline.dao;

import java.util.List;

import com.augmentum.examonline.model.Pagination;
import com.augmentum.examonline.model.Question;

public interface QuestionDao {
    public void update (final Question question);
    public Question getById(int id);
    public void delete (int id, int pageNo);
    public List<Question> findList(int pageNoStr, Pagination pagination, String key);
    public int getPageCount(String key );
}
