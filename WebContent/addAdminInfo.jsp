<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body background="images/bottom.png">
<br>
<hr>
<br><br><br><br><br>
<script type="text/javascript">
   function able(){
	  var s1=document.getElementById('captainNum');
	  s1.style.display='';
   }
   function disable(){
		  var s1=document.getElementById('captainNum');
		  s1.style.display='none';
	   }
</script>
<form action="updateAddAdminInfo.jsp" method="get" name="addTrafficViolationFrom">
<table boder="1" align="center">
   <tr>
      <td align="right"><span style="color:white">用户名：</span></td>
      <td><input type="text" name="userName" size="30" /></td>
   </tr>
   <tr>
      <td align="right"><span style="color:white">密码：</span></td>
      <td><input type="text" name="userPassWord" size="30" /></td>
   </tr>
   <tr>
      <td align="right"><span style="color:white">用户类型：</span></td>
      <td><input type="radio" name="userType" size="30" value="captain" checked="checked" onchange="able()"/> 队长&nbsp;&nbsp;
      <input type="radio" name="userType" size="30" value="sectionChief" onchange="disable()"/> 科长&nbsp;&nbsp;
      <input type="radio" name="userType" size="30" value="manager" onchange="disable()"/>经理
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
   <tr align="right">
      <td colspan="2">
         <input type="submit" name="submit" value="新增">
         <input type="reset" name="reset" value="重置">
   </td>
   </tr>
</table>
<br>

</form>
</body>
</html>