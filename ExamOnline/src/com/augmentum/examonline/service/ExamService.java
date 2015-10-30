package com.augmentum.examonline.service;

import java.util.List;

import com.augmentum.examonline.model.Exam;
import com.augmentum.examonline.model.Pagination;

public interface ExamService {
    public List<Exam> findlist(int pageNoStr, Pagination pagination, String key);

    public Exam getById(int id);

    public void update(Exam exam);

    public void delete(int id);

}
