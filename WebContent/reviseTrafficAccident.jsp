<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,shouqisystem.user.*" %>
<jsp:useBean id="userinfo" scope="request" class="shouqisystem.user.UserInfo"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改交通事故信息</title>
</head>
<body background="images/bottom.png">
<br><br><br><br><br>
   <%
     
      String[] kys=request.getParameterValues("pkey");
      for(int i=0;i<kys.length;i++){
    	  kys[i]=new String(kys[i].getBytes("iso-8859-1"),"utf-8");
      }
      ResultSet rs=userinfo.queryTrafficAccidentID(Integer.parseInt(kys[0]));
      while(rs.next()){
   %>
<center>
       <form action="updateEditTrafficAccident.jsp" method="GET">
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
 <td align="right"><span style="color:white">事故时间：</span></td>
 <td><input type="text" name="accidentTime" size="20" value="<%=rs.getString("accidentTime") %>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">事故地点：</span></td>
 <td><input type="text" name="accidentLocation" size="20" value="<%=rs.getString("accidentLocation") %>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">事故情节：</span></td>
 <td><input type="text" name="accidentPlot" size="20" value="<%=rs.getString("accidentPlot") %>"/></td>
 </tr>
 <td align="right"><span style="color:white">事故原因：</span></td>
 <td><input type="text" name="accidentReason" size="20" value="<%=rs.getString("accidentReason")%>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">事故损失：</span></td>
 <td><input type="text" name="accidentLoss" size="20" value="<%=rs.getString("accidentLoss") %>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">交强险报销金额：</span></td>
 <td><input type="text" name="strongInsuranceReimburseSum" size="20" value="<%=rs.getString("strongInsuranceReimburseSum") %>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">三者险报销金额：</span></td>
 <td><input type="text" name="threeInsuranceReimburseSum" size="20" value="<%=rs.getString("threeInsuranceReimburseSum") %>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">企业负担金额：</span></td>
 <td><input type="text" name="companyBurdenSum" size="20" value="<%=rs.getString("companyBurdenSum") %>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">司机负担金额：</span></td>
 <td><input type="text" name="dirverBurdenSum" size="20" value="<%=rs.getString("dirverBurdenSum") %>"/></td>
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