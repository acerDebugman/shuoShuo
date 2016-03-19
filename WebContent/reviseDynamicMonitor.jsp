<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,shouqisystem.user.*" %>
<jsp:useBean id="userinfo" scope="request" class="shouqisystem.user.UserInfo"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改动态监控信息</title>
</head>
<body background="images/bottom.png">
<br><br><br><br><br>
   <%
     
      String[] kys=request.getParameterValues("pkey");
      for(int i=0;i<kys.length;i++){
    	  kys[i]=new String(kys[i].getBytes("iso-8859-1"),"utf-8");
      }
      ResultSet rs=userinfo.queryDynamicMonitorID(Integer.parseInt(kys[0]));
      while(rs.next()){
   %>
<center>
       <form action="updateEditDynamicMonitor.jsp" method="GET">
  <table boder="1">
  <tr>
 <td align="right"><span style="color:white">姓名：</span></td>
 <td><input type="text" name="name" size="20" value="<%=rs.getString("name")%>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">车牌号：</span></td>
 <td><input type="text" name="carNum" size="20" value="<%=rs.getString("carNum") %>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">超速日期：</span></td>
 <td><input type="text" name="speedTime" size="20" value="<%=rs.getString("speedTime") %>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">超速4级次数：</span></td>
 <td><input type="text" name="speedFourLevelTimes" size="20" value="<%=rs.getString("speedFourLevelTimes") %>"/>次</td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">出外埠日期：</span></td>
 <td><input type="text" name="outGoingTime" size="20" value="<%=rs.getString("outGoingTime") %>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">去向：</span></td>
 <td><input type="text" name="destination" size="20" value="<%=rs.getString("destination") %>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">疲劳驾驶日期：</span></td>
 <td><input type="text" name="fatigueDrivingTime" size="20" value="<%=rs.getString("fatigueDrivingTime") %>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">级别：</span></td>
 <td><input type="text" name="degree" size="20" value="<%=rs.getString("degree") %>"/>次</td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">次数：</span></td>
 <td><input type="text" name="times" size="20" value="<%=rs.getString("times") %>"/>次</td>
 </tr>
 <tr>
 <td><input type="hidden" name="ID" size="20" value="<%=String.valueOf(rs.getInt("ID")) %>"></td>
 </tr>
 
   <%
      }
      rs.close();
      userinfo.close_all();
   %>
   <tr align="right">
           <td colspan="2">
              <input type="submit" name="submit" value="修改">
              <input type="reset" name="reset" value="重置">        
           </td>
        </tr>
   </table>
   </center>
   <br><br> 
</body>
</html>