<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,shouqisystem.user.*" %>
<jsp:useBean id="userinfo" scope="request" class="shouqisystem.user.UserInfo"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>删除司机基本信息信息</title>
</head>
<body background="images/bottom.png">
<a href="http://localhost:8080/ShouQiSystem/basicInfo.jsp">返回司机基本信息主界面</a><br><br>
<a href="http://localhost:8080/ShouQiSystem/queryBasicInfo.jsp">返回司机基本信息查询界面</a>
<%
   String[] kys=request.getParameterValues("pkey");
   String name=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
   String carNum=new String(request.getParameter("carNum").getBytes("iso-8859-1"),"utf-8");

   userinfo.deleteBasicInfo(kys);
   userinfo.deleteDynamicMonitor2(name, carNum);
   userinfo.deleteDynamicMonitorRemind2(name, carNum);
   userinfo.deleteFinance2(name, carNum);
   userinfo.deleteFinanceRemind2(name, carNum);
   userinfo.deleteICcardData2(name, carNum);
   userinfo.deleteICcardDataRemind2(name, carNum);
   userinfo.deleteLabour2(name, carNum);
   userinfo.deleteLabourRemind2(name, carNum);
   userinfo.deleteService2(name, carNum);
   userinfo.deleteServiceRemind2(name, carNum);
   userinfo.deleteTechnology2(name, carNum);
   userinfo.deleteTechnologyRemind2(name, carNum);
   userinfo.deleteTrafficAccident2(name, carNum);
   userinfo.deleteTrafficAccidentRemind2(name, carNum);
   userinfo.deleteTrafficViolation2(name, carNum);
   userinfo.deleteTrafficViolationRemind2(name, carNum);
   userinfo.deleteTrainRecord2(name, carNum);
   userinfo.deleteTrainRecordRemind2(name, carNum);
%>
<script language="javascript">
          alert("删除成功！");
</script>
</body>
</html>