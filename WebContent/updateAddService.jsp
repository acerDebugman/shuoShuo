<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.io.*,java.util.*,java.sql.SQLException,shouqisystem.user.*,java.sql.*,java.sql.Timestamp,java.util.Date.*" %>
<jsp:useBean id="userinfo" class="shouqisystem.user.UserInfo" />
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
      String complaintTime=new String(request.getParameter("complaintTime").getBytes("iso-8859-1"),"utf-8");
      String complaintPlot=new String(request.getParameter("complaintPlot").getBytes("iso-8859-1"),"utf-8");
      String serviceDisciplineTime=new String(request.getParameter("serviceDisciplineTime").getBytes("iso-8859-1"),"utf-8");
      String serviceDisciplinePlot=new String(request.getParameter("serviceDisciplinePlot").getBytes("iso-8859-1"),"utf-8");
      
      userinfo.addService(name, carNum, complaintTime, complaintPlot, serviceDisciplineTime, serviceDisciplinePlot);
      userinfo.addServiceRemind(name, carNum, complaintTime, complaintPlot, serviceDisciplineTime, serviceDisciplinePlot);
      userinfo.addCaptainServiceRemind(name, carNum, complaintTime, complaintPlot, serviceDisciplineTime, serviceDisciplinePlot);
      userinfo.addManServiceRemind(name, carNum, complaintTime, complaintPlot, serviceDisciplineTime, serviceDisciplinePlot);
   %>
   <script language="javascript">
          alert(" 增加成功！");
   </script>
   
   <a href="http://localhost:8080/ShouQiSystem/service.jsp">返回服务信息主界面</a><br><br>
   <a href="http://localhost:8080/ShouQiSystem/addService.jsp">继续添加服务信息</a>
</body>
</html>