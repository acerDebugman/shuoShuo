<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登录界面</title>
</head>
<body>
   <br><br><br><br><br><br>
   <br><br><br>
   <center><h1>首汽三分公司安全管理系统</h1></center>
   <br><br><br>
   <center>
   <form action="<%=request.getContextPath()%>/UserLogin1" method="get">
      <table border="0">
        <tr>
          <td>
            <table border="1" cellspacing="0" cellpadding="0" bgcolor="#dddddd" width="360" height="200">
              <tr height="130">
                <td align="center">
                  <br>
                                 用户名：<input type="text" name="userName" size="20">
                  <br>
                                 密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="userPassword" size="20">
                  <br>
                  <br>
                  <input type="radio" name="userType" value="captain" checked>
                                 队长&nbsp;&nbsp;
                  <input type="radio" name="userType" value="sectionChief">
                                 科长&nbsp;&nbsp;
                  <input type="radio" name="userType" value="manager">
                                 经理
                  <br>     
                  <br>           
                  <input type="submit" value="登陆" size="12">&nbsp;&nbsp;&nbsp;
                  <input type="reset" value="重置" value="清除" size="12">
                  <br>
                  <br>
                </td>
               </tr>
               <tr height="30">
                  <td bgcolor="#95BDFF">&nbsp;&nbsp;</td>
               </tr>
             </table>
           </td>
         </tr>
       </table>
   </form>
   </center>
   
                                 
</body>
</html>