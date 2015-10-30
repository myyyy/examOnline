<%@page import="com.augmentum.examonline.until.PropertiesUtil"%>
<%@page import="com.augmentum.examonline.until.PathUtil"%>
<%@ taglib uri="/WEB-INF/block.tld" prefix="block"%> 
<%@page import="com.augmentum.examonline.model.Exam"%>
<%@page import="com.augmentum.examonline.until.StringUtil"%> 
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<%=PropertiesUtil.getStaticUrl()%>/css/exam_create.css" type="text/css" rel="stylesheet"/>
    <link href="<%=PropertiesUtil.getStaticUrl()%>/css/reset.css" type="text/css" rel="stylesheet"/>
    <link href="<%=PropertiesUtil.getStaticUrl()%>/css/common.css" type="text/css" rel="stylesheet"/>
    <title>Show_Exam</title>
  </head>
  <body>
    <% Exam exam = (Exam)request.getAttribute("exam");
    %>
    <form action="<%=PathUtil.getFullPath("exam/save")%>" method="POST" id="addQuestionFrom">
        <block:display name="questionHeadBlock"/>
    <div id="warper">
    <div id="main" class="exam_main">
      <div class="breadcrumb">
        <div class="breadcrumb_link">
          <label class="breadcrumb_link_text">Exam Manager > Create Exam</label>
        </div>  
      </div> 
        <div class="main_box">
          <div id="main_box_exam">
            <div id="exam_name">
              <input name="creator" value="5555" style="display: none;"/>
              <div class="exam_font">Exam Name</div>
              <input type="text" name="name" class="exam_name_input" value="<%=StringUtil.doWithNull(exam.getName()) %>"/>
            </div>
            <div id="description">
              <div class="exam_description_font">Description</div>
              <input type="text" name="description" class="exam_description_input" value="<%=StringUtil.doWithNull(exam.getDescription()) %>"/>
            </div>
            <div id="effective_time">
              <div class="exam_font">EffectiveTime</div>
              <%if(exam.getId() > 0){%>
              <input type="date"  class="effective_time_input" />
              <%} else {%>
              <input type="date" class="effective_time_input" placeholder="select the date" />
              <%} %>
              <input type="time" class="effective_time_input_two">
              <input type="text" class="dateTime" name="effectiveTimeTest" style="display: none;">
            </div>
            <div id="duration">
              <div class="exam_font">Duration</div>
              <input type="text" name="duration" class="duration_input" value="<%=StringUtil.doWithNull(exam.getDuration()) %>"/>
            </div>
            <div id="question_setting">
              <div class="exam_font">QuestionSetting</div>
              <div class="question_setting_input">
                    <div class="setting_font" > Question Quantity</div>
                    <input type="text" name="questionQuantity" class="setting_input" value="<%=StringUtil.doWithNull(exam.getQuestionQuantity()) %>"/>
                    <div class="setting_font"> Question Points</div>
                    <input type="text" name="questionPoints" class="setting_input" value="<%=StringUtil.doWithNull(exam.getQuestionPoints()) %>"/>
                    <div class="setting_font"> Total Socre</div>
                    <input type="text" name="totalScore" class="setting_input" value="<%=StringUtil.doWithNull(exam.getTotalScore()) %>"/>
                    <div class="setting_font"> Pass Criteria</div>
                    <input type="text" name="passCriteria" class="setting_input" value="<%=StringUtil.doWithNull(exam.getPassCriteria()) %>"/>
              </div>
            </div>
          </div>
        </div>
        <div class="handle">
              <input type="button" class="handle_submit_create"></input>
              <input type="button" class="handle_submit_cancel" ></input>
        </div>
    </div>
     
    <div id="footer">
      &copy; Copyright  2014 Augmentun,Inc,All Right Reserved.
    </div>
    </div>
    </form>
    <input id="null_or_not" value="<%=exam.getId() %>" style="display: none;"/>
    <input id="basePath" value="<%=PathUtil.getFullPath("")%>" style="display: none;"/>
    <script type="text/javascript"src="<%=PropertiesUtil.getStaticUrl()%>/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript"src="<%=PropertiesUtil.getStaticUrl()%>/js/exam_create.js"></script>
    <script type="text/javascript"src="<%=PropertiesUtil.getStaticUrl()%>/js/common.js"></script>
    <script type="text/javascript"src="<%=PropertiesUtil.getStaticUrl()%>/js/show_exam.js"></script>
  </body>
</html>