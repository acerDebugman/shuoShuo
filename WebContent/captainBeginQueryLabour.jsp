<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,shouqisystem.user.*" %>
<jsp:useBean id="userinfo" scope="request" class="shouqisystem.user.UserInfo"/>
<jsp:useBean id="pages" scope="page" class="shouqisystem.user.Pages"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body background="images/bottom.png">
<center>
   <form action="" method="GET" name="form">
  <table boder="2" cellpadding="5" cellspacing="5">
  <tr>
     <td><b><span style="color:white">姓名</span></b></td>
     <td><b><span style="color:white">车牌号</span></b></td>
     <td><b><span style="color:white">住院时间</span></b></td>
     <td><b><span style="color:white">病因</span></b></td>
     <td><b><span style="color:white">一年内医疗二次报销金额</span></b></td>
  </tr>
  <%

  String name=(String)session.getAttribute("name");
  String carNum=(String)session.getAttribute("carNum");
  ResultSet CountTopicrs=userinfo.queryLabourSum(name, carNum);
  ResultSet rs=userinfo.queryLabour(name, carNum);
  pages.querySql(CountTopicrs,rs,request);
  String footer=pages.PageFooter();
  if(pages.intPageCount>0){
      int i=0;
      while(rs.next())
      {
          i++;
          if(i>((pages.intPage-1)*pages.intPageSize)&&(i<=pages.intPage*pages.intPageSize))
          {  
  %>
  <tr>
 
      <td><span style="color:white"><%=rs.getString("name") %></span></td>
      <td><span style="color:white"><%=rs.getString("carNum") %></span></td>
      <td><span style="color:white"><%=rs.getString("inHospitalTime").substring(0, 10) %></span></td>
      <td><span style="color:white"><%=rs.getString("diseaseCause") %></span></td>
      <td><span style="color:white"><%=rs.getString("yearMedicalTwiceReimburse") %></span></td>
  </tr>
  <%    
          }
      }
  }  
  out.println("<tr><td colspan=2>"+footer+"</td></tr>");
  rs.close();
  pages.close_all();
   %>

   </table><br><br> 
   </form>

   </center>
</body>
</html>