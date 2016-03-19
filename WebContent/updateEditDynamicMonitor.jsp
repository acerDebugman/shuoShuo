<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,shouqisystem.user.*" %>
<jsp:useBean id="userinfo" scope="request" class="shouqisystem.user.UserInfo"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body background="images/bottom.png">
<a href="http://localhost:8080/ShouQiSystem/dynamicMonitor.jsp">返回动态监控主界面</a><br><br>
<a href="http://localhost:8080/ShouQiSystem/queryDynamicMonitor.jsp">返回动态监控查询界面</a><br><br>
<a href="http://localhost:8080/ShouQiSystem/allDrivers.jsp">返回查看所有司机信息界面</a>
<%
 String id=new String(request.getParameter("ID").getBytes("iso-8859-1"),"utf-8");
 int  ID=0;
 if(id!=null&!id.equals("")){
	 ID=Integer.parseInt(id.trim());
 }
 String name=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
 String carNum=new String(request.getParameter("carNum").getBytes("iso-8859-1"),"utf-8");
 String speedTime=new String(request.getParameter("speedTime").getBytes("iso-8859-1"),"utf-8");
 String speedFourLevelTimes=new String(request.getParameter("speedFourLevelTimes").getBytes("iso-8859-1"),"utf-8");
 String outGoingTime=new String(request.getParameter("outGoingTime").getBytes("iso-8859-1"),"utf-8");
 String destination=new String(request.getParameter("destination").getBytes("iso-8859-1"),"utf-8");
 String fatigueDrivingTime=new String(request.getParameter("fatigueDrivingTime").getBytes("iso-8859-1"),"utf-8");
 String degree=new String(request.getParameter("degree").getBytes("iso-8859-1"),"utf-8");
 String times=new String(request.getParameter("times").getBytes("iso-8859-1"),"utf-8");
 
 userinfo.editDynamicMonitor(ID, name, carNum, speedTime, speedFourLevelTimes, outGoingTime, destination, fatigueDrivingTime, degree, times);
 userinfo.editDynamicMonitorRemind(ID, name, carNum, speedTime, speedFourLevelTimes, outGoingTime, destination, fatigueDrivingTime, degree, times);
 userinfo.editCaptainDynamicMonitorRemind(ID, name, carNum, speedTime, speedFourLevelTimes, outGoingTime, destination, fatigueDrivingTime, degree, times);
 userinfo.editManDynamicMonitorRemind(ID, name, carNum, speedTime, speedFourLevelTimes, outGoingTime, destination, fatigueDrivingTime, degree, times);
%>
<script language="javascript">
          alert("  修改成功！");
</script>
</body>
</html>