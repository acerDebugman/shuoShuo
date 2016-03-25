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
      String name=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
      String carNum=new String(request.getParameter("carNum").getBytes("iso-8859-1"),"utf-8");
      String speedTime=new String(request.getParameter("speedTime").getBytes("iso-8859-1"),"utf-8");
      String speedFourLevelTimes=new String(request.getParameter("speedFourLevelTimes").getBytes("iso-8859-1"),"utf-8");
      String outGoingTime=new String(request.getParameter("outGoingTime").getBytes("iso-8859-1"),"utf-8");
      String destination=new String(request.getParameter("destination").getBytes("iso-8859-1"),"utf-8");
      String fatigueDrivingTime=new String(request.getParameter("fatigueDrivingTime").getBytes("iso-8859-1"),"utf-8");
      String degree=new String(request.getParameter("degree").getBytes("iso-8859-1"),"utf-8");
      String times=new String(request.getParameter("times").getBytes("iso-8859-1"),"utf-8");
      
      userinfo.addDynamicMonitor(name, carNum, speedTime, speedFourLevelTimes, outGoingTime, destination, fatigueDrivingTime, degree, times);
      userinfo.addDynamicMonitorRemind(name, carNum, speedTime, speedFourLevelTimes, outGoingTime, destination, fatigueDrivingTime, degree, times);
      
   %>
   <script language="javascript">
          alert(" 增加成功！");
   </script>
   
   <a href="http://localhost:8080/ShouQiSystem/dynamicMonitor.jsp">返回动态监控主界面</a><br><br>
   <a href="http://localhost:8080/ShouQiSystem/addDynamicMonitor.jsp">继续添加动态监控信息</a>
</body>
</html>