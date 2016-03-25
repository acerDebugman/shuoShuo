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
      String unjoinTrainTime=new String(request.getParameter("unjoinTrainTime").getBytes("iso-8859-1"),"utf-8");
      
      userinfo.addTrainRecord(name, carNum, unjoinTrainTime);
      userinfo.addTrainRecordRemind(name, carNum, unjoinTrainTime);
      
   %>
   <script language="javascript">
          alert(" 增加成功！");
   </script>
   
   <a href="http://localhost:8080/ShouQiSystem/trainRecord.jsp">返回培训记录主界面</a><br><br>
   <a href="http://localhost:8080/ShouQiSystem/addTrainRecord.jsp">继续添加培训记录信息</a>
</body>
</html>