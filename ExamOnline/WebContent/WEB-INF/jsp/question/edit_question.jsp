<%@page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@page import="com.augmentum.examonline.model.User"%>
<%@page import="com.augmentum.examonline.Constants"%>
<!DOCTYPE html>
<%@page import="com.augmentum.examonline.until.PathUtil"%>
<%@page import="com.augmentum.examonline.until.PropertiesUtil"%>
<%@page import="com.augmentum.examonline.until.StringUtil"%>
<%@page import="com.augmentum.examonline.model.Question"%>
<%@ taglib uri="/WEB-INF/block.tld" prefix="block"%> 
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit_question</title>
  </head>
    <link href="<%=PropertiesUtil.getStaticUrl()%>/css/edit_question.css" type="text/css" rel="stylesheet"/>
    <link href="<%=PropertiesUtil.getStaticUrl()%>/css/reset.css" type="text/css" rel="stylesheet"/>
    <link href="<%=PropertiesUtil.getStaticUrl()%>/css/common.css" type="text/css" rel="stylesheet"/>
  <body>
    <% Question question = (Question)request.getAttribute("question");%>
    <form action="<%=PathUtil.getFullPath("question/save")%>" method="POST" id="addQuestionFrom">
      <block:display name="questionHeadBlock"/>
      <div id="warper">
      <div id="main" class="exam_main">
        <div class="breadcrumb">
          <div class="breadcrumb_link">
            <label class="breadcrumb_link_text">
            <a href="<%=PathUtil.getFullPath("question/list")%>">Question Management</a>
            &ensp; &gt;&ensp;
            <a href="<%=PathUtil.getFullPath("question/list")%>">Question List &ensp; &gt;</a>
            <%=question.getId()%>
            </label>
          </div>
        </div>
        <div class="main_box">
          <div class="create_box">
            <div class="question_id" >
              <div class="create_text" >Question ID:</div>
            <%if (question.getId() > 0) {%>
            <input readonly class="question_id_input" type="text" name="questionId" id="question_id" value="<%=StringUtil.doWithNull(question.getId()) %>"></input>
            <%} else { %>
            <input readonly class="question_id_input" type="text" name="questionId" id="question_id" ></input>
            <%} %>
            </div>
            <div class="question_titel">
              <div class="create_text">Question &ensp;:</div>
              <input id="titel_hidden" readonly value="<%=StringUtil.doWithNull(question.getTitle())%>"/>
            </div>
            <div class="question_answer">
              <div class="create_text">Answer &ensp; :</div>
              <div class="question_answer_box">
                <div class="answer_left" >
                  <label>A</label>
                  <label>B</label>
                  <label>C</label>
                  <label>D</label>
                </div>
                  <input readonly class="question_answer_input" name="a" type="text" value="<%=StringUtil.doWithNull(question.getA()) %>"></input>
                  <input readonly class="question_answer_input" name="b" type="text" value="<%=StringUtil.doWithNull(question.getB()) %>"></input>
                  <input readonly class="question_answer_input" name="c" type="text" value="<%=StringUtil.doWithNull(question.getC()) %>"></input>
                  <input readonly class="question_answer_input" name="d" type="text" value="<%=StringUtil.doWithNull(question.getD()) %>"></input>
              </div>
            </div>
            </div>
            <div class="handle">
              <a href="<%=PathUtil.getFullPath("question/edit")%>?id=<%=question.getId() %>&status=edit">
              <input type="button" class="handle_submit_create"/>
              </a>
              <a href="<%=PathUtil.getFullPath("question/delete")%>?id=<%=question.getId() %>">
              <input type="button" class="handle_submit_cancel" value="Delete"/>
              </a>
            </div>
        </div>
      </div>
      <div id="footer">
         Copyright &copy; 2014  Augmentum,&ensp;Inc,&ensp;All Right Reserved.
      </div>
      </div>
    </form>
    <input id="basePath" value="<%=PathUtil.getFullPath("")%>" style="display: none;"/>
    <script type="text/javascript"src="<%=PropertiesUtil.getStaticUrl()%>/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript"src="<%=PropertiesUtil.getStaticUrl()%>/js/edit_question.js"></script>
  </body>
</html>