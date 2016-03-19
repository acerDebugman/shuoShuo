<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body background="images/bottom.png">
<center>
   <br><br><br><br><br><br>
      <form action="<%=request.getContextPath()%>/SessionDriverServlet" method="post" name="driversInfoForm">
           请选择车队：
      <select name="workPlace">
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
         <option value="第十一车队">第十一车队</option>
         <option value="第十二车队">第十二车队</option>
      </select>
      <tr>
           <td><input type="hidden" name="URL" value="managerOneCaptainDriversListAll.jsp"></td>
      </tr>
      &nbsp;&nbsp;<input type="submit" name="查询" value="查询">
      </form>
</center>
</body>
</html>