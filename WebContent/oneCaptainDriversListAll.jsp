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
          <td><b><span style="color:white">选择</span></b></td>
          <td><b><span style="color:white">工作证号</span></b></td>
          <td><b><span style="color:white">姓名</span></b></td>
          <td><b><span style="color:white">车牌号</span></b></td>      
        </tr>
    <%
      String workPlace=(String)session.getAttribute("workPlace");
      //System.out.println(workPlace);
      String sql="";
      String CountQuery="";
      ResultSet CountTopicrs=userinfo.queryCaptainSum(workPlace);
      ResultSet rs=userinfo.queryCaptain(workPlace);
      pages.querySql(CountTopicrs, rs, request);
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
                    <td><input type="checkbox" name="pkey" size="5" value="<%=String.valueOf(rs.getString("employeeCardNum")) %>"/></td>
                    <td><span style="color:white"><%=rs.getString("employeeCardNum") %></span></td>
                    <td><span style="color:white"><%=rs.getString("name") %></span></td>
                    <td><span style="color:white"><%=rs.getString("carNum") %></span></td>          
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
             <input type="submit" name="look" value="查看" onclick="form.action='driverList.jsp';form.submit();">
           </td>
   </tr>
   </table><br><br> 
   </form>
   </center>
</body>
</html>