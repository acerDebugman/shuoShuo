<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.io.*,java.util.*,java.sql.SQLException,shouQiSystem.user.*,java.sql.*,java.sql.Timestamp,java.util.Date.*" %>
<jsp:useBean id="userinfo" class="shouQiSystem.user.UserInfo" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body background="images/bottom.png">
   <%
      String userName=new String(request.getParameter("userName").getBytes("iso-8859-1"),"utf-8");
      String userPassword=new String(request.getParameter("userPassWord").getBytes("iso-8859-1"),"utf-8");
      String userType=new String(request.getParameter("userType").getBytes("iso-8859-1"),"utf-8");
      String captainNum=new String(request.getParameter("captainNum").getBytes("iso-8859-1"),"utf-8");
      if(userType.equals("sectionChief")||userType.equals("manager")){
    	  captainNum="";
      }
      userinfo.addAdminInfo(userName, userPassword, userType, captainNum);
      
   %>
   <script language="javascript">
          alert(" 增加成功！");
   </script>
   
   <a href="http://localhost:8080/ShouQiSystem/adminInfo.jsp">返回管理人员信息界面</a><br><br>
   <a href="http://localhost:8080/ShouQiSystem/addAdminInfo.jsp">继续添加管理人员信息</a>
</body>
</html>