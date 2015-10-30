package com.augmentum.examonline.dao;

import java.util.List;

import com.augmentum.examonline.model.Exam;
import com.augmentum.examonline.model.Pagination;

public interface ExamDao {

    void delete(int id);

    public List<Exam> findList(int pageNoStr, Pagination pagination, String key);

    public Exam getById(int id);

    public void update(Exam exam);

    public int getPageCount(String key);

}
