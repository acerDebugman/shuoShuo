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
<script type="text/javascript">
function setRadio(userType){
	var radio=document.getElementById('userType');
	for(var i=0;i<radio.length;i++){
		if(radio[i].value.equals(userType)){
			radio[i].checked='checked';
		}
	}
}

function setSelected(captainNum){
	var select=document.getElementsByName('captainNum');
	for(var i=0;i<select.length;i++){
		if(select[i].value==userType){
			select[i].selected='selected';
		}
	}
}
function able(){
	  var s1=document.getElementById('captainNum');
	  s1.style.display='';
 }
 function disable(){
		  var s1=document.getElementById('captainNum');
		  s1.style.display='none';
	   }
</script>
</head>
<body background="images/bottom.png">
<br><br><br><br><br>
<center>
  <%
  String userName=new String(request.getParameter("userName").getBytes("iso-8859-1"),"utf-8");
  String userPassword=new String(request.getParameter("userPassword").getBytes("iso-8859-1"),"utf-8");
  String userType=new String(request.getParameter("userType").getBytes("iso-8859-1"),"utf-8");
  ResultSet rs=userinfo.queryAdminInfo(userName, userPassword, userType);
  if(rs.isAfterLast()==rs.isBeforeFirst()){
	  %>
	  <script>alert('用户名、密码或用户类型错误！');window.location.href='http://localhost:8080/ShouQiSystem/queryAdminInfo.jsp';</script>
	  <% 
  }else{
  
    while(rs.next()){
  %>
    <script type="text/javascript">setRadio("<%=rs.getString("userType")%>");
  setSelected("<%=rs.getString("captainNum")%>");
  </script>
   <form action="" method="GET">
  <table boder="1">
  <tr>
 <td align="right"><span style="color:white">用户名：</span></td>
 <td><input type="text" name="userName" size="20" value="<%=rs.getString("userName")%>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">密码：</span></td>
 <td><input type="text" name="userPassword" size="20" value="<%=rs.getString("userPassword") %>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">用户类型：</span></td>
      <td><input type="radio" id="userType" name="userType" size="30" value="captain" checked="checked" onchange="able()"/> 队长&nbsp;&nbsp;
      <input type="radio" id="userType" name="userType" size="30" value="sectionChief" onchange="disable()"/> 科长&nbsp;&nbsp;
      <input type="radio" id="userType" name="userType" size="30" value="manager" onchange="disable()"/>经理
      </td>
 </tr>
 <tr><span style="color:white">
      <td align="right"><span style="color:white">车队：</span></td>
      <td><select name="captainNum" id="captainNum">
          <option value="第一车队" selected="selected">第一车队</option>
          <option value="第二车队">第二车队</option>
          <option value="第三车队">第三车队</option>
          <option value="第四车队">第四车队</option>
          <option value="第五车队">第五车队</option>
          <option value="第六车队">第六车队</option>
          <option value="第七车队">第七车队</option>
          <option value="第八车队">第八车队</option>
          <option value="第九车队">第九车队</option>
          <option value="第十车队">第十车队</option>
          </select>
      </td>
   </tr>
 <tr>
 <td><input type="hidden" name="userID" size="20" value="<%=String.valueOf(rs.getInt("userID")) %>"></td>
 </tr>
  <%  
    }
  }
  rs.close();
  pages.close_all();
   %>
   <tr align="right">
           <td colspan="2">
             <input type="submit" name="revise" value="修改" onclick="form.action='reviseAdminInfo.jsp';form.submit();">
             <input type="submit" name="delete" value="删除" onclick="form.action='deleteAdminInfo.jsp';form.submit();">
           </td>
   </tr>

   </table><br><br> 
   </form>

   </center>
</body>
</html>