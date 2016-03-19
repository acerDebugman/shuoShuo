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
<a href="http://localhost:8080/ShouQiSystem/adminInfo.jsp">返回管理人员信息主界面</a><br><br>
<a href="http://localhost:8080/ShouQiSystem/queryAdminInfo.jsp">返回管理人员信息查询界面</a><br><br>
<%
 String userID=new String(request.getParameter("userID").getBytes("iso-8859-1"),"utf-8");
 int  ID=0;
 if(userID!=null&!userID.equals("")){
	 ID=Integer.parseInt(userID.trim());
 }
 String userName=new String(request.getParameter("userName").getBytes("iso-8859-1"),"utf-8");
 String userPassword=new String(request.getParameter("userPassword").getBytes("iso-8859-1"),"utf-8");
 String userType=new String(request.getParameter("userType").getBytes("iso-8859-1"),"utf-8");
 String captainNum=new String(request.getParameter("captainNum").getBytes("iso-8859-1"),"utf-8");
 if(userType.equals("sectionChief")||userType.equals("manager")){
	  captainNum="";
 }
 
 userinfo.editAdminInfo(ID, userName, userPassword, userType, captainNum);
%>
<script language="javascript">
          alert("  修改成功！");
</script>
</body>
</html>