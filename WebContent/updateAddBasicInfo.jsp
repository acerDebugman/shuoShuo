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
      String employeeCardNum=new String(request.getParameter("employeeCardNum").getBytes("iso-8859-1"),"utf-8");
      String name=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
      String sex=new String(request.getParameter("sex").getBytes("iso-8859-1"),"utf-8");
      String ID=new String(request.getParameter("ID").getBytes("iso-8859-1"),"utf-8");
      String birthDate=new String(request.getParameter("birthDate").getBytes("iso-8859-1"),"utf-8");
      String nation=new String(request.getParameter("nation").getBytes("iso-8859-1"),"utf-8");
      String education=new String(request.getParameter("education").getBytes("iso-8859-1"),"utf-8");
      String politicsStatus=new String(request.getParameter("politicsStatus").getBytes("iso-8859-1"),"utf-8");
      String workPlace=new String(request.getParameter("workPlace").getBytes("iso-8859-1"),"utf-8");
      String phone=new String(request.getParameter("phone").getBytes("iso-8859-1"),"utf-8");
      String address=new String(request.getParameter("address").getBytes("iso-8859-1"),"utf-8");
      String workType=new String(request.getParameter("workType").getBytes("iso-8859-1"),"utf-8");
      String workerDegreeTech=new String(request.getParameter("workerDegreeTech").getBytes("iso-8859-1"),"utf-8");
      String beginWorkDate=new String(request.getParameter("beginWorkDate").getBytes("iso-8859-1"),"utf-8");
      String enterWorkPlaceDate=new String(request.getParameter("enterWorkPlaceDate").getBytes("iso-8859-1"),"utf-8");
      String domicilePlace=new String(request.getParameter("domicilePlace").getBytes("iso-8859-1"),"utf-8");
      String postalcode=new String(request.getParameter("postalcode").getBytes("iso-8859-1"),"utf-8");
      String drivingLicenseFileNum=new String(request.getParameter("drivingLicenseFileNum").getBytes("iso-8859-1"),"utf-8");
      String carNum=new String(request.getParameter("carNum").getBytes("iso-8859-1"),"utf-8");
      String singleDouble=new String(request.getParameter("singleDouble").getBytes("iso-8859-1"),"utf-8");
      
      boolean judgeCard=userinfo.judgeBasicInfoCard(employeeCardNum);
      boolean judgeCarNum=userinfo.judgeBasicInfoCarNum(carNum);
      if(judgeCard&&judgeCarNum){
      userinfo.addBasicInfo(employeeCardNum, name, sex, ID, birthDate, nation, education, politicsStatus, workPlace, phone, address, 
    		  workType, workerDegreeTech, beginWorkDate, enterWorkPlaceDate, domicilePlace, postalcode, drivingLicenseFileNum, carNum, singleDouble);
      %>
         <script language="javascript">
          alert(" 增加成功！");
         </script>
      <% 
      }else{
    	  %>
    	  <script language="javascript">
          alert(" 您插入的工作证号或车牌号数据库中已存在！");
          </script>
    	  <%
      }
   %>
   <a href="http://localhost:8080/ShouQiSystem/basicInfo.jsp">返回基本信息主界面</a><br><br>
   <a href="http://localhost:8080/ShouQiSystem/addBasicInfoMain.jsp">返回添加基本信息主界面</a><br><br>
   <a href="http://localhost:8080/ShouQiSystem/addBasicInfo.jsp">继续添加交通违法信息</a>
</body>
</html>