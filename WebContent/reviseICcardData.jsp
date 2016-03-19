<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,shouqisystem.user.*" %>
<jsp:useBean id="userinfo" scope="request" class="shouqisystem.user.UserInfo"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改IC卡信息</title>
</head>
<body background="images/bottom.png">
<script type="text/javascript">
$(document).ready(function(){
	 selectCheckPayStats("v_txn_type","${v_txn_type}");
	});
   function topIncome(monthIncomeTopTen){
	   var sel=document.getElementById('monthIncomeTopTen');
	   for(var i=0;i<sel.options.length;i++){
		   if(sel.options[i].value==monthIncomeTopTen){
			   sel.options[i].selected=true;
			   break;
		   }
			   
	   }
   }
   function bottomIncome(monthIncomeBottomTen){
	   var sel=document.getElementById('monthIncomeBottomTen');
	   for(var i=0;i<sel.options.length;i++){
		   if(sel.options[i].value==monthIncomeTopTen){
			   sel.options[i].selected=true;
			   break;
		   }
			   
	   }
   }
   function workTimeExceed(monthWorkTimeExceed){
	   var sel=document.getElementById('monthWorkTimeExceed');
	   for(var i=0;i<sel.options.length;i++){
		   if(sel.options[i].value==monthIncomeTopTen){
			   sel.options[i].selected=true;
			   break;
		   }
			   
	   }
   }
   function runKmExceed(monthRunKmExceed){
	   var sel=document.getElementById('monthRunKmExceed');
	   for(var i=0;i<sel.options.length;i++){
		   if(sel.options[i].value==monthIncomeTopTen){
			   sel.options[i].selected=true;
			   break;
		   }
			   
	   }
   }
</script>
<br><br><br><br><br>
   <%
     
      String[] kys=request.getParameterValues("pkey");
      for(int i=0;i<kys.length;i++){
    	  kys[i]=new String(kys[i].getBytes("iso-8859-1"),"utf-8");
      }
      ResultSet rs=userinfo.queryICcardDataID(Integer.parseInt(kys[0]));
      while(rs.next()){
   %>
<center>
       <form action="updateEditICcardData.jsp" method="GET">
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
 <td align="right"><span style="color:white">月份：</span></td>
 <td><input type="text" name="ICdate" size="20" value="<%=rs.getString("ICdate") %>"/></td>
 </tr>
 <tr><span style="color:white">
      <td align="right"><span style="color:white">月收入进入前十：</span></td>
      <td><select name="monthIncomeTopTen" id="monthIncomeTopTen" onchange="topIncome(<%=rs.getString("monthIncomeTopTen") %>)">
          <option value="是">&nbsp;&nbsp;是&nbsp;&nbsp;</option>
          <option value="否">&nbsp;&nbsp;否&nbsp;&nbsp;</option>
          </select>
      </td>
   </tr>
 <tr><span style="color:white">
      <td align="right"><span style="color:white">月收入进入后十：</span></td>
      <td><select name="monthIncomeBottomTen" id="monthIncomeBottomTen" onchange="bottomIncome(<%=rs.getString("monthIncomeBottomTen") %>)">
          <option value="是">&nbsp;&nbsp;是&nbsp;&nbsp;</option>
          <option value="否">&nbsp;&nbsp;否&nbsp;&nbsp;</option>
          </select>
      </td>
   </tr>
 <tr><span style="color:white">
      <td align="right"><span style="color:white">月工作时间超过360小时：</span></td>
      <td><select name="monthWorkTimeExceed" id="monthWorkTimeExceed" onchange="workTimeExceed(<%=rs.getString("monthWorkTimeExceed") %>)">
          <option value="是">&nbsp;&nbsp;是&nbsp;&nbsp;</option>
          <option value="否">&nbsp;&nbsp;否&nbsp;&nbsp;</option>
          </select>
      </td>
   </tr>
 <tr><span style="color:white">
      <td align="right"><span style="color:white">月行驶公里超过10000公里：</span></td>
      <td><select name="monthRunKmExceed" id="monthRunKmExceed" onchange="runKmExceed(<%=rs.getString("monthRunKmExceed") %>)">
          <option value="是">&nbsp;&nbsp;是&nbsp;&nbsp;</option>
          <option value="否">&nbsp;&nbsp;否&nbsp;&nbsp;</option>
          </select>
      </td>
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