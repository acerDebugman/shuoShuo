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
      String postponePayDate=new String(request.getParameter("postponePayDate").getBytes("iso-8859-1"),"utf-8");
      String postponeDays=new String(request.getParameter("postponeDays").getBytes("iso-8859-1"),"utf-8");
      String overdueFine=new String(request.getParameter("overdueFine").getBytes("iso-8859-1"),"utf-8");
      
      userinfo.addFinance(name, carNum, postponePayDate, postponeDays, overdueFine);
      userinfo.addFinanceRemind(name, carNum, postponePayDate, postponeDays, overdueFine);
      
   %>
   <script language="javascript">
          alert(" 增加成功！");
   </script>
   
   <a href="http://localhost:8080/ShouQiSystem/finance.jsp">返回财务信息主界面</a><br><br>
   <a href="http://localhost:8080/ShouQiSystem/addFinance.jsp">继续添加财务信息</a>
</body>
</html>