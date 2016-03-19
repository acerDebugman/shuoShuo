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
<a href="http://localhost:8080/ShouQiSystem/technology.jsp">返回技术信息主界面</a><br><br>
<a href="http://localhost:8080/ShouQiSystem/queryTechnology.jsp">返回技术信息查询界面</a><br><br>
<a href="http://localhost:8080/ShouQiSystem/allDrivers.jsp">返回查看所有司机信息界面</a>
<%
 String id=new String(request.getParameter("ID").getBytes("iso-8859-1"),"utf-8");
 int  ID=0;
 if(id!=null&!id.equals("")){
	 ID=Integer.parseInt(id.trim());
 }
 String name=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
 String carNum=new String(request.getParameter("carNum").getBytes("iso-8859-1"),"utf-8");
 String noRuleMaintainTime=new String(request.getParameter("noRuleMaintainTime").getBytes("iso-8859-1"),"utf-8");
 String noRuleMaintainKm=new String(request.getParameter("noRuleMaintainKm").getBytes("iso-8859-1"),"utf-8");
 
 userinfo.editTechnology(ID, name, carNum, noRuleMaintainTime, noRuleMaintainKm);
 userinfo.editTechnologyRemind(ID, name, carNum, noRuleMaintainTime, noRuleMaintainKm);
 userinfo.editCaptainTechnologyRemind(ID, name, carNum, noRuleMaintainTime, noRuleMaintainKm);
 userinfo.editManTechnologyRemind(ID, name, carNum, noRuleMaintainTime, noRuleMaintainKm);
%>
<script language="javascript">
          alert("  修改成功！");
</script>
</body>
</html>