<%@page language="java" contentType="text/html; charset=utf-8"pageEncoding="utf-8"%>
<%@page import="com.augmentum.examonline.Constants"%>
<%@page import="com.augmentum.examonline.Constants" %>
<!DOCTYPE html>

<%@page import="com.augmentum.examonline.until.PathUtil"%>
<%@page import="com.augmentum.examonline.until.PropertiesUtil"%><html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title> login</title>
  </head>
  <link href="<%=PropertiesUtil.getStaticUrl()%>/css/login.css" type="text/css" rel="stylesheet"/>
 <body>
    <%
      String topMessage = (String)request.getAttribute(Constants.TOP_MESSAGE);
          String visibility = "hidden";
      if(topMessage != null && !topMessage.equals("")){
          visibility = "visible";
      }
      if(topMessage == null){
          topMessage = "";
      }
     %>
 <form action="<%=PathUtil.getFullPath("user/login")%>" method="POST" id="loginForm">
    <div class="wapper"  >
      <div class="login_form_left">
        <div class="login_form_left_log">
          <img src="<%=PropertiesUtil.getStaticUrl()%>/images/login/LOGO_Web_Login_90x180.png" />
        </div>
        <div class="login_form_left_text">
          <label style="color: #2E4358;">
            Online Exam Web System
          </label>
        </div>
      </div>
      <div class="login_form_right">
        <div class="login_welcome">
          <label style="color: #2E4358;">Welcome to login! </label>
        </div>
      <div class="login_input">
        <div class="top_info" id="error_info" >
          <span >
            <%=topMessage%>
          </span>
        </div>
      <div class="login_entry">
        <div class="login_entry_input">
          <div class="login_entry_input_wrong" id="error_info_image" >
          </div>
          <div class="login_entry_input_wrong_second" id="error_info_image_second" >
          </div>
          <div class="login_entry_input_avatar">
            <label><img  class="avatar" src="<%=PropertiesUtil.getStaticUrl()%>/images/login/ICN_Usename_20x20.png" /></label>
          </div>
          <div>
            <input type="hidden" name="go" value="<%=request.getAttribute("go") == null ? "" : request.getAttribute("go") %>"/>
            <input type="hidden" name="queryString" id="queryString"/>
            <input class="input" type="text" name="userName" id="userName" placeholder="UserName"/><br/>
          </div>
        </div>
          <div class="login_entry_input">
            <div class="login_entry_input_avatar">
              <label><img class="avatar" src="<%=PropertiesUtil.getStaticUrl()%>/images/login/ICN_Password_20x15.png" /></label>
            </div>
            <div>
              <input class="input" type="password" name="userPassword" id="userPassword" placeholder="UserPassword" /><br/>
            </div>
          </div>
        <div class="login_entry_input"class="login_entry_input">
          <input class="input_submit" type="button" value="login"/> 
        </div>
      </div>
      <div class="under_info">
          <div class="cookie">
            <div>
              <input id="under_info_box" type="checkbox" value="0"/>
              <label class="Remember_label">Remember me</label>
            </div>
          </div>
          <div class="forgot_password">
            <div>
                <label class="label">Forgot Password? </label>
            </div>
          </div>
      </div>
      </div>
      </div>
        <div class="login_footer">
          &copy; Copyright  2014 Augmentun,Inc,All Right Reserved.
        </div>
    </div>
    </form>
    <script type="text/javascript"src="<%=PropertiesUtil.getStaticUrl()%>/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="<%=PropertiesUtil.getStaticUrl()%>/js/log.js"></script>
  </body>
</html>