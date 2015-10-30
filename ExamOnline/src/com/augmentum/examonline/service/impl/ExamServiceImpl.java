package com.augmentum.examonline.service.impl;

import java.util.List;

import com.augmentum.examonline.dao.ExamDao;
import com.augmentum.examonline.model.Exam;
import com.augmentum.examonline.model.Pagination;
import com.augmentum.examonline.service.ExamService;

public class ExamServiceImpl implements ExamService{
    private ExamDao examDao;
    public ExamDao getExamDao() {
        return examDao;
    }
    public void setExamDao(ExamDao examDao) {
        this.examDao = examDao;
    }
    public List<Exam> findlist(int pageNoStr, Pagination pagination, String key) {
        return examDao.findList(pageNoStr, pagination, key);
    }
    @Override
    public Exam getById(int id) {
        return examDao.getById(id);
    }
    @Override
    public void update(Exam exam) {
        examDao.update(exam);
    }
    @Override
    public void delete(int id) {
        examDao.delete(id);
    }
}
