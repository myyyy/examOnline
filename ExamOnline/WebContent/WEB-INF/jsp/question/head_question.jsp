<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@page import="com.augmentum.examonline.until.PathUtil"%>
<%@page import="com.augmentum.examonline.Constants"%>
    
<%@page import="com.augmentum.examonline.until.PropertiesUtil"%><div id="header">
      <div class="header_absolute">
        <div class="log_img">
        </div>
        <div class="log_text">
            <label>Online Exam Web System</label>
        </div>
            <%
            String flas_message = (String)session.getAttribute(Constants.SUCESS_FLASH_MESSAGE);
            flas_message = flas_message == null ? "" : flas_message;
            String isDisplayFlashMessage = "";
            if (flas_message.equals("")) {
                isDisplayFlashMessage = "style='display:none';";
            }
            %>
            <div id="flas_message" <%=isDisplayFlashMessage %>>
            <%
            out.write(flas_message);
            session.removeAttribute(Constants.SUCESS_FLASH_MESSAGE);
            if (! flas_message.equals("")) {
            %>
                <script type="text/javascript">
                    setTimeout (function () {
                        document.getElementById("flas_message").style.display = "none";}, 3000
                    );
                </script>
            <%
            }
            %>
            </div>
            <div class="header_right">
              <div class="header_right_box">
                <label class="log_user_label">中文</label>
              </div>
              <div class="header_right_box">
                <label class="log_user_label">Logout</label>
              </div>
            </div>
            <div class="log_user">
              <div class="user_avator">
              </div>
              <label class="log_user_label"><%=session.getAttribute("userName") %></label>
            </div>
        </div>  
    </div>
    <div id="bar">
      <div class="bar_absolute">
        <ul>
          <li class="bar_management">
              <a class="head_href_text" href="<%=PathUtil.getFullPath("question/list?pageNo=1")%>">Question Management</a>
          </li>
          <li class="bar_management_next">
               <a class="head_href_text_next" href="<%=PathUtil.getFullPath("exam/list?pageNo=1")%>">Exam Management</a>
          </li>
        </ul>
      </div>
    </div>