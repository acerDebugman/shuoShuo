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
      String ICdate=new String(request.getParameter("ICdate").getBytes("iso-8859-1"),"utf-8");
      String monthIncomeTopTen=new String(request.getParameter("monthIncomeTopTen").getBytes("iso-8859-1"),"utf-8");
      String monthIncomeBottomTen=new String(request.getParameter("monthIncomeBottomTen").getBytes("iso-8859-1"),"utf-8");
      String monthWorkTimeExceed=new String(request.getParameter("monthWorkTimeExceed").getBytes("iso-8859-1"),"utf-8");
      String monthRunKmExceed=new String(request.getParameter("monthRunKmExceed").getBytes("iso-8859-1"),"utf-8");
      
      userinfo.addICcardData(name, carNum, ICdate, monthIncomeTopTen, monthIncomeBottomTen, monthWorkTimeExceed, monthRunKmExceed);
      userinfo.addICcardDataRemind(name, carNum, ICdate, monthIncomeTopTen, monthIncomeBottomTen, monthWorkTimeExceed, monthRunKmExceed);
      
   %>
   <script language="javascript">
          alert(" 增加成功！");
   </script>
   
   <a href="http://localhost:8080/ShouQiSystem/ICcardData.jsp">返回IC卡数据主界面</a><br><br>
   <a href="http://localhost:8080/ShouQiSystem/addICcardData.jsp">继续添加IC卡数据信息</a>
</body>
</html>