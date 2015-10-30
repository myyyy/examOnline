<%@page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.augmentum.examonline.Constants"%>
<%@page import="com.augmentum.examonline.model.Pagination"%>
<%@page import="com.augmentum.examonline.model.Question"%>
<!DOCTYPE html>
<%@page import="com.augmentum.examonline.until.PropertiesUtil"%>
<%@page import="com.augmentum.examonline.until.PathUtil"%>
<%@ taglib uri="/WEB-INF/block.tld" prefix="block"%> 

<%@page import="com.augmentum.examonline.model.Exam"%><html>
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
        </div>  
      </div> 
      <div class="main_box">
      </div>
    </div>
    <div id="footer">
      &copy; Copyright  2014 Augmentun,Inc,All Right Reserved.
    </div>
    </div>
  </body>
</html>