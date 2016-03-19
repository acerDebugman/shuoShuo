<%@page import="com.sun.crypto.provider.RSACipher"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,shouqisystem.user.*" %>
<jsp:useBean id="userinfo" scope="request" class="shouqisystem.user.UserInfo"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>队长个人信息</title>
</head>
<body  background="images/bottom.png">
<br><br><br><br><br>
<center>
<%
   String userName=(String)session.getAttribute("userName");
   String userPassword=(String)session.getAttribute("userPassword");
   int userID=(int)userinfo.queryUserID(userName, userPassword);
%>

 <form action="" method="GET">
  <table boder="1">
  <tr>
 <td align="right"><span style="color:white">用户名：</span></td>
 <td><input type="text" name="userName" size="20" value="<%=userName%>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">密码：</span></td>
 <td><input type="text" name="userPassword" size="20" value="<%=userPassword %>"/></td>
 </tr>
 <tr>
 <td><input type="hidden" name="userID" size="20" value="<%=userID %>"></td>
 </tr>
 <tr align="right">
           <td colspan="2">
             <input type="submit" name="revise" value="修改" onclick="form.action='captainRevisePersonInfo.jsp';form.submit();">          
           </td>
   </tr>

   </table><br><br> 
   </form>

   </center>
</body>
</html>