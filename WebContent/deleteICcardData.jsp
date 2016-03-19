<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,shouqisystem.user.*" %>
<jsp:useBean id="userinfo" scope="request" class="shouqisystem.user.UserInfo"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>删除IC卡信息</title>
</head>
<body background="images/bottom.png">
<a href="http://localhost:8080/ShouQiSystem/ICcardData.jsp">返回IC卡信息主界面</a><br><br>
<a href="http://localhost:8080/ShouQiSystem/queryICcardData.jsp">返回IC卡信息查询界面</a><br><br>
<a href="http://localhost:8080/ShouQiSystem/allDrivers.jsp">返回查看所有司机信息界面</a>
<%
   String[] kys=request.getParameterValues("pkey");
   int[] IDs=new int[kys.length];
   for(int i=0;i<kys.length;i++){
	   kys[i]=new String(kys[i].getBytes("iso-8859-1"),"utf-8");
	   System.out.println(kys[i]);
	   System.out.println(Integer.parseInt(String.valueOf(kys[i])));
	   IDs[i]=Integer.parseInt(String.valueOf(kys[i]));
	   
   }
   userinfo.deleteICcardData(IDs);
   userinfo.deleteICcardDataRemind(IDs);
   userinfo.deleteCaptainICcardDataRemind(IDs);
   userinfo.deleteManICcardDataRemind(IDs);
%>
<script language="javascript">
          alert("删除成功！");
</script>
</body>
</html>