<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body background="images/bottom.png">
<br><br><br><br><br>
   <form action="<%=request.getContextPath()%>/SessionServrlet" method="get">
       <table boder="1" align="center">
         <tr>
           <td align="right"><span style="color:white">姓名：</span></td>
           <td><input type="text" name="name" size="30" /></td>
         </tr>
         <tr>
           <td align="right"><span style="color:white">车号：</span></td>
           <td><input type="text" name="carNum" size="30" /></td>
         </tr>
         <tr>
           <td><input type="hidden" name="URL" value="beginQueryTrafficViolation.jsp"></td>
         </tr>
         <tr align="right">
           <td colspan="2">
             <input type="submit" name="submit" value="查询">
             <input type="reset" name="reset" value="重置">
           </td>
         </tr>
       </table>
   </form>
</body>
</html>