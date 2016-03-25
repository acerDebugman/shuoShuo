<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,shouQiSystem.user.*" %>
<jsp:useBean id="userinfo" scope="request" class="shouQiSystem.user.UserInfo"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改司机基本信息</title>
</head>
<body background="images/bottom.png">
<br><br><br><br><br>
   <%
     
      String[] kys=request.getParameterValues("pkey");
      ResultSet rs=userinfo.queryBasicInfoCard(kys[0]);
      while(rs.next()){
   %>
<center>
       <form action="updateEditBasicInfo.jsp" method="GET">
  <table boder="1">
  <tr>
 <td align="right"><span style="color:white">工作证号：</span></td>
 <td><input type="text" name="employeeCardNum" size="20" value="<%=rs.getString("employeeCardNum")%>"/></td>
 <td align="right"><span style="color:white">姓名：</span></td>
 <td><input type="text" name="name" size="20" value="<%=rs.getString("name")%>"/></td>
 <td align="right"><span style="color:white">姓别：</span></td>
 <td><select name="sex">
          <option value="男" selected="selected">男</option>
          <option value="女">女</option>
          </select>
 </td>
 <td align="right"><span style="color:white">身份证号：</span></td>
 <td><input type="text" name="ID" size="20" value="<%=rs.getString("ID")%>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">出生日期：</span></td>
 <td><input type="text" name="birthDate" size="20" value="<%=rs.getString("birthDate") %>"/></td>
 <td align="right"><span style="color:white">民族：</span></td>
 <td><input type="text" name="nation" size="20" value="<%=rs.getString("nation") %>"/></td>
 <td align="right"><span style="color:white">文化程度：</span></td>
 <td><input type="text" name="education" size="20" value="<%=rs.getString("education") %>"/></td>
 <td align="right"><span style="color:white">政治面貌：</span></td>
 <td><input type="text" name="politicsStatus" size="20" value="<%=rs.getString("politicsStatus") %>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">单位：</span></td>
      <td><select name="workPlace">
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
      </td>
 <td align="right"><span style="color:white">手机：</span></td>
 <td><input type="text" name="phone" size="20" value="<%=rs.getString("phone") %>"/></td>
 <td align="right"><span style="color:white">现住址：</span></td>
 <td><input type="text" name="address" size="20" value="<%=rs.getString("address") %>"/></td>
 <td align="right"><span style="color:white">工种：</span></td>
 <td><input type="text" name="workType" size="20" value="<%=rs.getString("workType") %>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">工人技术等级：</span></td>
 <td><input type="text" name="workerDegreeTech" size="20" value="<%=rs.getString("workerDegreeTech") %>"/></td>
 <td align="right"><span style="color:white">参加工作时间：</span></td>
 <td><input type="text" name="beginWorkDate" size="20" value="<%=rs.getString("beginWorkDate").substring(0, 10) %>"/></td>
 <td align="right"><span style="color:white">进入本单位时间：</span></td>
 <td><input type="text" name="enterWorkPlaceDate" size="20" value="<%=rs.getString("enterWorkPlaceDate").substring(0, 10) %>"/></td>
 <td align="right"><span style="color:white">户口所在地：</span></td>
 <td><input type="text" name="domicilePlace" size="20" value="<%=rs.getString("domicilePlace") %>"/></td>
 </tr>
 <tr>
 <td align="right"><span style="color:white">邮政编码：</span></td>
 <td><input type="text" name="postalcode" size="20" value="<%=rs.getString("postalcode") %>"/></td>
 <td align="right"><span style="color:white">驾驶证档案编号：</span></td>
 <td><input type="text" name="drivingLicenseFileNum" size="20" value="<%=rs.getString("drivingLicenseFileNum") %>"/></td>
 <td align="right"><span style="color:white">车牌号：</span></td>
 <td><input type="text" name="carNum" size="20" value="<%=rs.getString("carNum") %>"/></td>
 <td align="right"><span style="color:white">单双班：</span></td>
      <td><select name="singleDouble">
          <option value="单班" selected="selected">单班</option>
          <option value="双班">双班</option>
          </select>
      </td>
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