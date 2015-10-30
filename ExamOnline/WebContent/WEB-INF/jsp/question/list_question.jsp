<%@page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.augmentum.examonline.Constants"%>
<%@page import="com.augmentum.examonline.model.Pagination"%>
<%@page import="com.augmentum.examonline.model.Question"%>
<%@page import="com.augmentum.examonline.until.PropertiesUtil"%>
<%@page import="com.augmentum.examonline.until.PathUtil"%>
<%@ taglib uri="/WEB-INF/block.tld" prefix="block"%> 
<!DOCTYPE html>

<%@page import="com.augmentum.examonline.model.Common"%><html>
  <head>
    <%Pagination pagination = (Pagination)request.getAttribute("Pagination");
    String keyWord = (String)request.getAttribute("key");
    int TotalPages = pagination.getTotalPages();
    int PageNo = pagination.getPageNo();
    %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<%=PropertiesUtil.getStaticUrl()%>/css/question_list.css" type="text/css" rel="stylesheet"/>
    <link href="<%=PropertiesUtil.getStaticUrl()%>/css/reset.css" type="text/css" rel="stylesheet"/>
    <link href="<%=PropertiesUtil.getStaticUrl()%>/css/common.css" type="text/css" rel="stylesheet"/>
    <title>List_QuestionList</title>
  </head>
  <body>
    <div id="delete_yes" class="shade" ></div>
    <div id="delete_no" class="pop_box" >
      <label class="pop_box_label"> Are you sure delete the select question?</label>
      <input class="pop_box_yes" value="YES" type="button" />
      <input value="NO" class="pop_box_no" type="button" />
    </div>
        <block:display name="questionHeadBlock"/>
    <div id="warper">
    <div id="main" class="exam_main">
      <div class="breadcrumb">
        <div class="breadcrumb_link">
          <label class="breadcrumb_link_text"></label>
        </div>
      </div>
        <div class="main_box">
          <div class="main_box_search">
              <input type="text" id="searchInput" class="search_input"  ></input>
          <div class="search_input_img"></div>
          </div>
            <div class="main_box_left">
              <div class="main_box_left_list">
              <a href="">Question List</a>
              </div>
              <div class="main_box_left_create">
              <a href="<%=PathUtil.getFullPath("question/create?")%>" />Create Question</a>
              </div>
            </div>
          <div class="main_box_right">
            <div class="question_header">
                <ul class="question_ul">
                  <li class="question_order">
                  </li>
                  <li class="question_id">
                    ID<div class="id_incrense"></div>
                  </li>
                  <li class="question_description">
                    Description
                  </li>
                  <li class="question_edit">
                    Edit
                  </li>
                  <li class="question_delete">
                  <!-- <div class="selectSpan"></div> -->
                    <input type="checkbox" name="selectAll" id="selectAll" class="selectAll" />
                  </li>
                </ul>
              </div>
              <%
              int i = 0;
              List<Question> questions = (List<Question>)request.getAttribute("Questions");
              for (Question question : questions) {
                  i++;
              %>
            <div class="question_content">
              <ul>
                <li class="question_order">
                  <%=i %>
                </li>
                <li class="question_id">
                  <%=question.getQuestionId() %>
                </li>
                <li class="question_description">
                  <label title="<%=question.getTitle() %>"><%=question.getTitle() %></label>
                </li>
                <li class="question_edit">
                  <input class="questionId" value="<%=question.getId()%>" style="display: none;">
                  <a href="<%=PathUtil.getFullPath("question/edit")%>?id=<%=question.getId() %>"><img src="<%=PropertiesUtil.getStaticUrl()%>/images/web/ICN_Edit_15x15.png" id="edit"></a>
                </li>
                <li class="question_delete" >
                  <!-- <div type="button" class="selectSpanNe"></div> -->
                  <input type="checkbox" value="<%=question.getId() %>" name="check" class="delete_img"/>
                </li>
              </ul> 
            </div>
              <%
              }
              %>
            <block:display name="pagination"/>
          </div>
        </div>
        <input class="suer_button" type="button" value="delete"/>
    </div>
    <div id="footer">
      &copy; Copyright  2014 Augmentun, Inc, All  Right Reserved.
    </div>
    </div>
    <input id="keyWords"value="<%=keyWord %>" style="display: none;"/>
    <input id="basePath" value="<%=PathUtil.getFullPath("")%>" style="display: none;"/>
    <input id="totalPages" value="<%=pagination.getTotalPages()%>" style="display: none;"/>
    <input id="pageNo" value="<%=pagination.getPageNo()%>" style="display: none;"/>
    <script type="text/javascript"src="<%=PropertiesUtil.getStaticUrl()%>/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript"src="<%=PropertiesUtil.getStaticUrl()%>/js/list_question.js"></script>
    <script type="text/javascript"src="<%=PropertiesUtil.getStaticUrl()%>/js/common.js"></script>
  </body>
</html>