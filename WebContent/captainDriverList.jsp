<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,shouQiSystem.user.*" %>
<jsp:useBean id="userinfo" scope="request" class="shouQiSystem.user.UserInfo"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body background="images/bottom.png">
<br>
   <%
     
      String[] kys=request.getParameterValues("pkey");
      ResultSet rs=userinfo.queryBasicInfoCard(kys[0]);
      while(rs.next()){
   %>
       <center>
   <form action="" method="GET" name="form">
  <table boder="2" cellpadding="5" cellspacing="5" width="1500" height="200">
  <tr>
     <td><b><span style="color:white">工作证号</span></b></td>
     <td><b><span style="color:white">姓名</span></b></td>
     <td><b><span style="color:white">性别</span></b></td>
     <td><b><span style="color:white">身份证号</span></b></td>
     <td><b><span style="color:white">出生日期</span></b></td>
     <td><b><span style="color:white">民族</span></b></td>
     <td><b><span style="color:white">文化程度</span></b></td>
     <td><b><span style="color:white">政治面貌</span></b></td>
  </tr>
  <tr>
      <td><span style="color:white"><%=rs.getString("employeeCardNum") %></span></td>
      <td><span style="color:white"><%=rs.getString("name") %></span></td>
      <td><span style="color:white"><%=rs.getString("sex") %></span></td>
      <td><span style="color:white"><%=rs.getString("ID") %></span></td>
      <td><span style="color:white"><%=rs.getString("birthDate").substring(0, 10) %></span></td>
      <td><span style="color:white"><%=rs.getString("nation") %></span></td>
      <td><span style="color:white"><%=rs.getString("education") %></span></td>
      <td><span style="color:white"><%=rs.getString("politicsStatus") %></span></td>      
  </tr>
  <tr>
     <td><b><span style="color:white">单位</span></b></td>
     <td><b><span style="color:white">手机</span></b></td>
     <td><b><span style="color:white">现住址</span></b></td>
     <td><b><span style="color:white">工种</span></b></td>
     <td><b><span style="color:white">工人技术等级</span></b></td>
     <td><b><span style="color:white">参加工作时间</span></b></td>
     <td><b><span style="color:white">进入本单位时间</span></b></td>
     <td><b><span style="color:white">户口所在地</span></b></td>
  </tr>
   <tr>
      <td><span style="color:white"><%=rs.getString("workPlace") %></span></td>
      <td><span style="color:white"><%=rs.getString("phone") %></span></td>
      <td><span style="color:white"><%=rs.getString("address") %></span></td>
      <td><span style="color:white"><%=rs.getString("workType") %></span></td>
      <td><span style="color:white"><%=rs.getString("workerDegreeTech") %></span></td>
      <td><span style="color:white"><%=rs.getString("beginWorkDate").substring(0, 10) %></span></td>
      <td><span style="color:white"><%=rs.getString("enterWorkPlaceDate").substring(0, 10) %></span></td>
      <td><span style="color:white"><%=rs.getString("domicilePlace") %></span></td>    
  </tr>
  <tr>
     <td><b><span style="color:white">邮政编码</span></b></td>
     <td><b><span style="color:white">驾驶证档案编号</span></b></td>
     <td><b><span style="color:white">车牌号</span></b></td>
     <td><b><span style="color:white">单双班</span></b></td>
  </tr>
  <tr>
      <td><span style="color:white"><%=rs.getString("postalcode") %></span></td>
      <td><span style="color:white"><%=rs.getString("drivingLicenseFileNum") %></span></td>     
      <td><span style="color:white"><%=rs.getString("carNum") %></span></td>
      <td><span style="color:white"><%=rs.getString("singleDouble") %></span></td>
  </tr>    
   <tr>
     <td><input type="hidden" name="name" value=<%=rs.getString("name") %>></td>
     <td><input type="hidden" name="carNum" value=<%=rs.getString("carNum") %>></td>
   </tr>
   <tr align="right">
           <td colspan="2">
             <input type="submit" name="trafficViolation" value="交通违法" onclick="form.action='CaptainTrafficViolationServlet';form.submit();">
           </td>
           <td colspan="2">
             <input type="submit" name="trafficAccident" value="交通事故" onclick="form.action='CaptainTrafficAccidentServlet';form.submit();">
           </td>
           <td colspan="2">
             <input type="submit" name="dynamicMonitor" value="动态监控" onclick="form.action='CaptainDynamicMonitorServlet';form.submit();">
           </td>
   </tr><br>
   <tr align="right">
           <td colspan="2">
             <input type="submit" name="ICcardData" value="IC卡数据" onclick="form.action='CaptainICcardDataServlet';form.submit();">
           </td>
           <td colspan="2">
             <input type="submit" name="trainRecord" value="培训记录" onclick="form.action='CaptainTrainRecordServlet';form.submit();">
           </td>
           <td colspan="2">
             <input type="submit" name="service" value="服务" onclick="form.action='CaptainServiceServlet';form.submit();">
           </td>
   </tr>
   <tr align="right">
           <td colspan="2">
             <input type="submit" name="technology" value="技术" onclick="form.action='CaptainTechnologyServlet';form.submit();">
           </td>
           <td colspan="2">
             <input type="submit" name="finance" value="财务" onclick="form.action='CaptainFinanceServlet';form.submit();">
           </td>
           <td colspan="2">
             <input type="submit" name="labour" value="劳动" onclick="form.action='CaptainLabourServlet';form.submit();">
           </td>
   </tr>
   </table><br><br>
   </form>
   </center>
   <%
      }
   rs.close();
   userinfo.close_all();
   %>
</body>
</html>