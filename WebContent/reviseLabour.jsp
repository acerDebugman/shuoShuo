<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,shouQiSystem.user.*" %>
<jsp:useBean id="userinfo" scope="request" class="shouQiSystem.user.UserInfo"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改劳动信息</title>
</head>
<body background="images/bottom.png">
<br><br><br><br><br>
   <%
     
      String[] kys=request.getParameterValues("pkey");
      for(int i=0;i<kys.length;i++){
    	  kys[i]=new String(kys[i].getBytes("iso-8859-1"),"utf-8");
      }
      ResultSet rs=userinfo.queryLabourID(Integer.parseInt(kys[0]));
      while(rs.next()){
   %>
<center>
       <form action="updateEditLabour.jsp" method="GET">
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
 <td align="right"><span style="color:white">住院时间：</span></td>
 <td><input type="text" name="inHospitalTime" size="20" value="<%=rs.getString("inHospitalTime").substring(0, 10) %>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">病因：</span></td>
 <td><input type="text" name="diseaseCause" size="20" value="<%=rs.getString("diseaseCause") %>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">一年内医疗二次报销金额：</span></td>
 <td><input type="text" name="yearMedicalTwiceReimburse" size="20" value="<%=rs.getString("yearMedicalTwiceReimburse") %>"/></td>
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