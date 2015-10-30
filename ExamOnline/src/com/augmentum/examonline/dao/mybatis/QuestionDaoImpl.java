package com.augmentum.examonline.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.augmentum.examonline.dao.QuestionDao;
import com.augmentum.examonline.model.Pagination;
import com.augmentum.examonline.model.Question;

public class QuestionDaoImpl extends SqlSessionDaoSupport implements QuestionDao{

    protected static String SQL_ID_UPDATE = ".update";
    private static final String CLASS_NAME = Question.class.getName();
    @Override
    public void delete(int id, int pageNo) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("deleted", true);
        params.put("id", id);
        getSqlSession().selectOne(CLASS_NAME + ".delete", params);
    }

    @Override
    public List<Question> findList(int pageNoStr, Pagination pagination, String key) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("key", key);
        pagination.setTotalRecords(this.getPageCount(key));
        if(pagination.getTotalRecords() == 0){
            pagination.setTotalRecords(this.getPageCount(""));
            params.put("key", "");
        }
        if(pagination.getPageNo() > pagination.getTotalPages() && pagination.getTotalPages() != 0) {
            pageNoStr = pagination.getTotalPages();
        }
        params.put("offset", pagination.getOffset()) ;
        params.put("pageSize", pagination.getPageSize());
        return getSqlSession().selectList(CLASS_NAME + ".findList", params);
    }

    @Override
    public Question getById(int id) {
        return getSqlSession().selectOne(CLASS_NAME + ".getById", id);
    }

    @Override
    public void update(Question question) {
        getSqlSession().update(CLASS_NAME + SQL_ID_UPDATE, question);
    }

    @Override
    public int getPageCount(String key) {
        return getSqlSession().selectOne(CLASS_NAME + ".getPageCount", key);
    }

}
