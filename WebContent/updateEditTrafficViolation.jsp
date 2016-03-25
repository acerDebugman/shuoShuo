<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,shouQiSystem.user.*" %>
<jsp:useBean id="userinfo" scope="request" class="shouQiSystem.user.UserInfo"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body background="images/bottom.png">
<a href="http://localhost:8080/ShouQiSystem/trafficViolation.jsp">返回交通违法主界面</a><br><br>
<a href="http://localhost:8080/ShouQiSystem/queryTrafficViolation.jsp">返回交通违法查询界面</a><br><br>
<a href="http://localhost:8080/ShouQiSystem/allDrivers.jsp">返回查看所有司机信息界面</a>
<%
 String id=new String(request.getParameter("ID").getBytes("iso-8859-1"),"utf-8");
 int  ID=0;
 if(id!=null&!id.equals("")){
	 ID=Integer.parseInt(id.trim());
 }
 String name=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
 String carNum=new String(request.getParameter("carNum").getBytes("iso-8859-1"),"utf-8");
 String violationTime=new String(request.getParameter("violationTime").getBytes("iso-8859-1"),"utf-8");
 String violationLocation=new String(request.getParameter("violationLocation").getBytes("iso-8859-1"),"utf-8");
 String violationPlot=new String(request.getParameter("violationPlot").getBytes("iso-8859-1"),"utf-8");
 
 userinfo.editTrafficViolation(ID, name, carNum, violationTime, violationLocation, violationPlot);
 userinfo.editTrafficViolationRemind(ID, name, carNum, violationTime, violationLocation, violationPlot);
%>
<script language="javascript">
          alert("  修改成功！");
</script>
</body>
</html>