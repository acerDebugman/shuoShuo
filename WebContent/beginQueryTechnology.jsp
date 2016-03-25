<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,shouQiSystem.user.*" %>
<jsp:useBean id="userinfo" scope="request" class="shouQiSystem.user.UserInfo"/>
<jsp:useBean id="pages" scope="page" class="shouQiSystem.user.Pages"/>
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
     <td><b><span style="color:white">选择</span></b></td>
     <td><b><span style="color:white">姓名</span></b></td>
     <td><b><span style="color:white">车牌号</span></b></td>
     <td><b><span style="color:white">未按规定保养日期</span></b></td>
     <td><b><span style="color:white">未按规定保养公里数</span></b></td>
  </tr>
  <%

  String name=(String)session.getAttribute("name");
  String carNum=(String)session.getAttribute("carNum");
  ResultSet CountTopicrs=userinfo.queryTechnologySum(name, carNum);
  ResultSet rs=userinfo.queryTechnology(name, carNum);
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
 
      <td><input type="checkbox" name="pkey" size="5" value="<%=String.valueOf(rs.getInt("ID")) %>"/></td>
      <td><span style="color:white"><%=rs.getString("name") %></span></td>
      <td><span style="color:white"><%=rs.getString("carNum") %></span></td>
      <td><span style="color:white"><%=rs.getString("noRuleMaintainTime").substring(0, 10) %></span></td>
      <td><span style="color:white"><%=rs.getString("noRuleMaintainKm") %></span></td>
  </tr>
  <%    
          }
      }
  }  
  out.println("<tr><td colspan=2>"+footer+"</td></tr>");
  rs.close();
  pages.close_all();
   %>
   <tr align="right">
           <td colspan="2">
             <input type="submit" name="revise" value="修改" onclick="form.action='reviseTechnology.jsp';form.submit();">
             <input type="submit" name="delete" value="删除" onclick="form.action='deleteTechnology.jsp';form.submit();">
           </td>
   </tr>

   </table><br><br> 
   </form>

   </center>
</body>
</html>