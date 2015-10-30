package com.augmentum.examonline.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.augmentum.examonline.dao.QuestionDao;
import com.augmentum.examonline.model.Pagination;
import com.augmentum.examonline.model.Question;
import com.mysql.jdbc.Statement;

public class QuestionDaoImpl<T> implements QuestionDao{
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void update (final Question question) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                String sql = "INSERT INTO  question(question_id, a, b, c, d, correct_answer, question_title, created_time, last_updated_time) VALUES (?, ?, ?, ?, ?, ?, ? ,NOW(), NOW())";
                PreparedStatement stmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, question.getQuestionId());
                stmt.setString(2, question.getA());
                stmt.setString(3, question.getB());
                stmt.setString(4, question.getC());
                stmt.setString(5, question.getD());
                stmt.setString(6, question.getCorrectAnswer());
                stmt.setString(7, question.getTitle());
                return stmt;
            }
        },keyHolder);
        question.setId(keyHolder.getKey().intValue());
    }

    public Question getById(int id) {
        String sql = "SELECT * FROM question WHERE id = " + id;
        RowMapper<Question> rowMapper = new RowMapper<Question>() {
            @Override
            public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rsToQuestion(rs);
            }
        };
        Question question = jdbcTemplate.queryForObject(sql, rowMapper);
        return question;
    }

//    public void updateDeleted(int id, int deleted) {
//        String sql = "UPDATE question SET deleted = "+ deleted +", updated_time = NOW() WHERE id = " + id;
//        jdbcTemplate.update(sql);
//    }

    public void delete (final int id, int pageNo) {
        String sql = "DELETE FROM question WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

    public List<Question> findList(int pageNoStr, Pagination pagination, String key) {
        pagination.setTotalRecords(this.getPageCount(key));
        if(pagination.getPageNo() > pagination.getTotalPages() && pagination.getTotalPages() != 0) {
            pageNoStr = pagination.getTotalPages();
        }
        int pageX = (pagination.getPageNo() - 1) * pagination.getPageSize();
        int pageSize = pagination.getPageSize();
        String sql = "SELECT * FROM question LIMIT " + pageX+"," + pageSize;
        RowMapper<Question> rowMapper = new RowMapper<Question>() {
            @Override
            public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rsToQuestion(rs);
            }
        };
        List<Question> questions = jdbcTemplate.query(sql, rowMapper);
        return questions;
    }

    private Question rsToQuestion(ResultSet rs) throws SQLException {
        Question question = new Question();
        question.setId(rs.getInt(1));
        question.setQuestionId(rs.getString("question_id"));
        question.setA(rs.getString("a"));
        question.setB(rs.getString("b"));
        question.setC(rs.getString("c"));
        question.setD(rs.getString("d"));
        question.setCorrectAnswer(rs.getString("correct_answer"));
        question.setTitle(rs.getString("question_title"));
        question.setCreatedTime(rs.getDate("created_time"));
        question.setLastUpdatedTime(rs.getDate("last_updated_time"));
        return question;
    }

    public List<Question> findByKeyWords(String key) {
        //TODO Sql bug
        String sql = "SELECT * FROM question WHERE question_title LIKE '%" + key + "%'";
        RowMapper<Question> rowMapper = new RowMapper<Question>() {

            @Override
            public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rsToQuestion(rs);
            }
        };
        List<Question> questions = jdbcTemplate.query(sql, rowMapper);
        return questions;
    }
    //TODO 要拿出去
    public  int getPageCount(final String key ) {
        String sql = "SELECT COUNT(*) FROM question where question_title LIKE '%" + key + "%'";
        return jdbcTemplate.queryForInt(sql);
    }

}