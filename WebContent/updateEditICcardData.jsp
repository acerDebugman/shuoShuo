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
<a href="http://localhost:8080/ShouQiSystem/ICcardData.jsp">返回IC卡信息主界面</a><br><br>
<a href="http://localhost:8080/ShouQiSystem/queryICcardData.jsp">返回IC卡信息查询界面</a><br><br>
<a href="http://localhost:8080/ShouQiSystem/allDrivers.jsp">返回查看所有司机信息界面</a>
<%
 String id=new String(request.getParameter("ID").getBytes("iso-8859-1"),"utf-8");
 int  ID=0;
 if(id!=null&!id.equals("")){
	 ID=Integer.parseInt(id.trim());
 }
 String name=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
 String carNum=new String(request.getParameter("carNum").getBytes("iso-8859-1"),"utf-8");
 String ICdate=new String(request.getParameter("ICdate").getBytes("iso-8859-1"),"utf-8");
 String monthIncomeTopTen=new String(request.getParameter("monthIncomeTopTen").getBytes("iso-8859-1"),"utf-8");
 String monthIncomeBottomTen=new String(request.getParameter("monthIncomeBottomTen").getBytes("iso-8859-1"),"utf-8");
 String monthWorkTimeExceed=new String(request.getParameter("monthWorkTimeExceed").getBytes("iso-8859-1"),"utf-8");
 String monthRunKmExceed=new String(request.getParameter("monthRunKmExceed").getBytes("iso-8859-1"),"utf-8");
 
 userinfo.editICcardData(ID, name, carNum, ICdate, monthIncomeTopTen, monthIncomeBottomTen, monthWorkTimeExceed, monthRunKmExceed);
 userinfo.editICcardDataRemind(ID, name, carNum, ICdate, monthIncomeTopTen, monthIncomeBottomTen, monthWorkTimeExceed, monthRunKmExceed);
 userinfo.editCaptainICcardDataRemind(ID, name, carNum, ICdate, monthIncomeTopTen, monthIncomeBottomTen, monthWorkTimeExceed, monthRunKmExceed);
 userinfo.editManICcardDataRemind(ID, name, carNum, ICdate, monthIncomeTopTen, monthIncomeBottomTen, monthWorkTimeExceed, monthRunKmExceed);
 
%>
<script language="javascript">
          alert("  修改成功！");
</script>
</body>
</html>