package com.augmentum.examonline.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.augmentum.examonline.dao.ExamDao;
import com.augmentum.examonline.model.Exam;
import com.augmentum.examonline.model.Pagination;

public class ExamDaoImpl extends SqlSessionDaoSupport implements ExamDao{

    protected static String SQL_ID_UPDATE = ".update";
    private static final String CLASS_NAME = Exam.class.getName();
    @Override
    public void delete(int id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("deleted", true);
        params.put("id", id);
        getSqlSession().selectOne(CLASS_NAME + ".delete", params);
    }

    @Override
    public List<Exam> findList(int pageNoStr, Pagination pagination, String key) {
        pagination.setTotalRecords(this.getPageCount(key));
        if(pagination.getPageNo() > pagination.getTotalPages() && pagination.getTotalPages() != 0) {
            pageNoStr = pagination.getTotalPages();
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("key", key);
        params.put("offset", pagination.getOffset()) ;
        params.put("pageSize", pagination.getPageSize());
        return getSqlSession().selectList(CLASS_NAME + ".findList", params);
    }

    @Override
    public Exam getById(int id) {
        return getSqlSession().selectOne(CLASS_NAME + ".getById", id);
    }

    @Override
    public void update(Exam exam) {
        getSqlSession().update(CLASS_NAME + SQL_ID_UPDATE, exam);
    }

    @Override
    public int getPageCount(String key) {
        return getSqlSession().selectOne(CLASS_NAME + ".getPageCount", key);
    }

}
