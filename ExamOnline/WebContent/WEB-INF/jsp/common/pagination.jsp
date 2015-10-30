<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.augmentum.examonline.until.PathUtil"%>
<%@page import="com.augmentum.examonline.model.Pagination"%>
<%@page import="com.augmentum.examonline.until.PropertiesUtil"%>
<%@page import="com.augmentum.examonline.model.Question"%>
<%@page import="java.util.List"%><html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
  </head>
  <body>
  <% 
  if(PathUtil.getFullPath("")=="/ExamOnline/page/"){
      
  }
  Pagination pagination = (Pagination)request.getAttribute("Pagination"); 
  String key = (String)request.getAttribute("key");
  List<Question> question =(List<Question>)request.getAttribute("Questions");
  %>
    <div class="main_box_right_page">
   
    <%if(question != null) {%>
      <a href="<%=PathUtil.getFullPath("question/list?pageNo=")%><%=pagination.getPreviousPageNo()%>&key=<%=key %>"><div id="prePage"></div></a>
      <div id="pageNumb"></div>
      <a href="<%=PathUtil.getFullPath("question/list?pageNo=")%><%=pagination.getNextPageNo() %>&key=<%=key %>"><div id="nextPage"></div></a>
      <select id="selectPageNo" style="text-align:center">
        <option >5</option>
        <option >10</option>
        <option >20</option>
      </select> 
      <label>Per page:</label> 
      <input type="text" id="WritePageNo"/> 
      <%} else {%>
      <a href="<%=PathUtil.getFullPath("exam/list?pageNo=")%><%=pagination.getPreviousPageNo()%>&key=<%=key %>"><div id="prePage"></div></a>
      <div id="pageNumb"></div>
      <a href="<%=PathUtil.getFullPath("exam/list?pageNo=")%><%=pagination.getNextPageNo() %>&key=<%=key %>"><div id="nextPage"></div></a>
      <select id="selectPageNo" style="text-align:center">
        <option >5</option>
        <option >10</option>
        <option >20</option>
      </select> 
      <label>Per page:</label> 
      <input type="text" id="WritePageNo"/> 
      <% }%>
      <input type="button" class="jump"/>
    </div>
  </body>
</html>