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
      String accidentTime=new String(request.getParameter("accidentTime").getBytes("iso-8859-1"),"utf-8");
      String accidentLocation=new String(request.getParameter("accidentLocation").getBytes("iso-8859-1"),"utf-8");
      String accidentPlot=new String(request.getParameter("accidentPlot").getBytes("iso-8859-1"),"utf-8");
      String accidentReason=new String(request.getParameter("accidentReason").getBytes("iso-8859-1"),"utf-8");
      String accidentLoss=new String(request.getParameter("accidentLoss").getBytes("iso-8859-1"),"utf-8");
      String strongInsuranceReimburseSum=new String(request.getParameter("strongInsuranceReimburseSum").getBytes("iso-8859-1"),"utf-8");
      String threeInsuranceReimburseSum=new String(request.getParameter("threeInsuranceReimburseSum").getBytes("iso-8859-1"),"utf-8");
      String companyBurdenSum=new String(request.getParameter("companyBurdenSum").getBytes("iso-8859-1"),"utf-8");
      String dirverBurdenSum=new String(request.getParameter("dirverBurdenSum").getBytes("iso-8859-1"),"utf-8");
      
      userinfo.addTrafficAccident(name, carNum, accidentTime, accidentLocation, accidentPlot, accidentReason, accidentLoss, strongInsuranceReimburseSum, threeInsuranceReimburseSum, companyBurdenSum, dirverBurdenSum);
      userinfo.addTrafficAccidentRemind(name, carNum, accidentTime, accidentLocation, accidentPlot, accidentReason, accidentLoss, strongInsuranceReimburseSum, threeInsuranceReimburseSum, companyBurdenSum, dirverBurdenSum);
      userinfo.addCaptainTrafficAccidentRemind(name, carNum, accidentTime, accidentLocation, accidentPlot, accidentReason, accidentLoss, strongInsuranceReimburseSum, threeInsuranceReimburseSum, companyBurdenSum, dirverBurdenSum);
      userinfo.addManTrafficAccidentRemind(name, carNum, accidentTime, accidentLocation, accidentPlot, accidentReason, accidentLoss, strongInsuranceReimburseSum, threeInsuranceReimburseSum, companyBurdenSum, dirverBurdenSum);
   %>
   <script language="javascript">
          alert(" 增加成功！");
   </script>
   
   <a href="http://localhost:8080/ShouQiSystem/trafficAccident.jsp">返回交通事故主界面</a><br><br>
   <a href="http://localhost:8080/ShouQiSystem/addTrafficAccident.jsp">继续添加交通事故信息</a>
</body>
</html>