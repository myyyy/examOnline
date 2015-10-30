<%@page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.augmentum.examonline.Constants"%>
<%@page import="com.augmentum.examonline.model.Pagination"%>
<%@page import="com.augmentum.examonline.model.Question"%>
<!DOCTYPE html>
<%@page import="com.augmentum.examonline.until.PropertiesUtil"%>
<%@page import="com.augmentum.examonline.until.PathUtil"%>
<%@ taglib uri="/WEB-INF/block.tld" prefix="block"%> 

<%@page import="com.augmentum.examonline.model.Exam"%>
<%@page import="com.augmentum.examonline.until.StringUtil"%><html>
  <head>
    <%Pagination pagination = (Pagination)request.getAttribute("Pagination");
    String key = (String)request.getAttribute("key");
    int TotalPages = pagination.getTotalPages();
    int PageNo = pagination.getPageNo();
    %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<%=PropertiesUtil.getStaticUrl()%>/css/exam_show.css" type="text/css" rel="stylesheet"/>
    <link href="<%=PropertiesUtil.getStaticUrl()%>/css/reset.css" type="text/css" rel="stylesheet"/>
    <link href="<%=PropertiesUtil.getStaticUrl()%>/css/common.css" type="text/css" rel="stylesheet"/>
    <title>Show_Exam</title>
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
              <input type="text" id="searchInput" class="search_input" placeholder="Please input the key world"></input>
          <div class="search_input_img"></div>
          </div>
          <div id="select_date">
            <input type="date"  class="date_input" />
            <div id="select_centre">-</div>
            <div id="select_time"><input type="text"/></div>
            <div id="selsct_right"><input type="button" value="Date"/></div>
          </div>
            <div class="main_box_left">
              <div class="main_box_left_list">
              <a href="">Exam List</a>
              </div>
              <div class="main_box_left_create">
              <a href="<%=PathUtil.getFullPath("exam/create")%>" />Create Exam</a>
              </div>
            </div>
          <div class="main_box_right">
            <div class="exam_header">
                <ul class="exam_ul">
                  <li class="exam_order">
                  </li>
                  <li class="exam_id">
                    ID<div class="id_incrense"></div>
                  </li>
                  <li class="exam_name">
                    name
                  </li>
                  <li class="exam_time">
                    Effective Time
                  </li>
                  <li class="exam_mins">
                    Duration(Mins)
                  </li>
                   <li class="exam_creator">
                    Creator
                  </li>
                  <li class="exam_edit">
                    Edit
                  </li>
                  <li class="exam_delete">
                    <input type="checkbox" class="selectAll" id="selectAll"/>
                  </li>
                </ul>
              </div>
              <%
              int i = 0;
              List<Exam> exams = (List<Exam>)request.getAttribute("Exam");
              for (Exam exam : exams) {
                  i++;
              %>
            <div class="exam_content">
              <ul>
                <li class="exam_order">
                  <%=i %>
                </li>
                <li class="exam_id">
                  <%=exam.getId() %>
                </li>
                <li class="exam_name">
                  <%=exam.getName() %>
                </li>
                <li class="exam_time">
                  <%=StringUtil.dateToString(exam.getEffectiveTime())%>
                </li>
                <li class="exam_mins">
                  <%=exam.getDuration()%>
                </li>
                <li class="exam_creator">
                  <%=exam.getCreator()%>
                </li>
                <li class="exam_edit">
                  <input class="examId" value="" style="display: none;">
                  <a href="<%=PathUtil.getFullPath("exam/edit")%>?id=<%=exam.getId() %>"><img src="<%=PropertiesUtil.getStaticUrl()%>/images/web/ICN_Edit_15x15.png" id="edit"></a>
                </li>
                <li class="exam_delete" >
                  <input type="checkbox" value="<%=exam.getId() %>" name="check" class="delete_img"/>
                </li>
              </ul> 
            </div>
             <%
              }
              %>
            <block:display name="pagination"/>
          </div>
        </div>
        <input class="suer_button" type="button" value="deleted"/>
    </div>
    <div id="footer">
      &copy; Copyright  2014 Augmentun,Inc,All Right Reserved.
    </div>
    </div>
    <input id="totalPages" value="<%=pagination.getTotalPages()%>" style="display: none;"/>
    <input id="pageNo" value="<%=pagination.getPageNo()%>" style="display: none;"/>
    <input id="basePath" value="<%=PathUtil.getFullPath("")%>" style="display: none;"/>
    <script type="text/javascript"src="<%=PropertiesUtil.getStaticUrl()%>/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript"src="<%=PropertiesUtil.getStaticUrl()%>/js/common.js"></script>
    <script type="text/javascript"src="<%=PropertiesUtil.getStaticUrl()%>/js/show_exam.js"></script>
  </body>
</html>