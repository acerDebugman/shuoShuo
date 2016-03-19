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
function strDateTime(){
	 var strDate=addTrafficViolationFrom.violationTime.value;
	 var   strSeparator = "-";   //日期分隔符 
     var   strDateArray; 
     var   intYear; 
     var   intMonth; 
     var   intDay; 
     var   boolLeapYear; 
     //var strDate=form1.a.value   //表单中的日期值
     strDateArray = strDate.split(strSeparator); 
      
     if(strDateArray.length!=3)    {   alert('提示: 日期格式错误! \r\n 请依【YYYY-MM-DD】格式输入！'); return   false;   }
      
     intYear = parseInt(strDateArray[0],10); 
     intMonth = parseInt(strDateArray[1],10); 
     intDay   =   parseInt(strDateArray[2],10); 
      
     if(isNaN(intYear)||isNaN(intMonth)||isNaN(intDay))   { alert('提示: 日期格式错误! \r\n 请依【YYYY-MM-DD】格式输入！'); return   false; }
      
     if(intMonth>12||intMonth<1) {   alert('提示: 日期格式错误! \r\n 请依【YYYY-MM-DD】格式输入！'); return   false;   } 
      
     if((intMonth==1||intMonth==3||intMonth==5||intMonth==7||intMonth==8||intMonth==10||intMonth==12)&&(intDay>31||intDay<1))   {   alert('提示: 日期格式错误! \r\n 请依【YYYY-MM-DD】格式输入！'); return   false;   } 
      
     if((intMonth==4||intMonth==6||intMonth==9||intMonth==11)&&(intDay>30||intDay<1))   {   alert('提示: 日期格式错误! \r\n 请依【YYYY-MM-DD】格式输入！'); return   false;   }
      
     if(intMonth==2){ 
           if(intDay<1)   {   alert('提示: 日期格式错误! \r\n 请依【YYYY-MM-DD】格式输入！'); return   false;   }
            
           boolLeapYear   =   false;  
         if((intYear%4==0 && intYear %100!=0)||(intYear %400==0))
 {
 boolLeapYear=true;
 }
            
           if(boolLeapYear){ 
                 if(intDay>29) {   alert('提示: 日期格式错误! \r\n 请依【YYYY-MM-DD】格式输入！'); return   false;   }
           } 
           else{ 
                 if(intDay>28) {   alert('提示: 日期格式错误! \r\n 请依【YYYY-MM-DD】格式输入！'); return   false;   }
           } 
     } 
      
     return   true; 
	}
</script>
<form action="updateAddBasicInfo.jsp" method="get" name="addBasicInfoFrom">
<table boder="1" align="center">
   <tr>
      <td align="right"><span style="color:white">工作证号：</span></td>
      <td><input type="text" name="employeeCardNum" size="30" /></td>
      <td align="right"><span style="color:white">姓名：</span></td>
      <td><input type="text" name="name" size="30" /></td>
      <td align="right"><span style="color:white">姓别：</span></td>
      <td><select name="sex">
          <option value="男" selected="selected">男</option>
          <option value="女">女</option>
          </select>
      </td>
      <td align="right"><span style="color:white">身份证号：</span></td>
      <td><input type="text" name="ID" size="30" /></td>
   </tr>
   <tr>
      <td align="right"><span style="color:white">出生日期：</span></td>
      <td><input type="text" name="birthDate" size="30"  onchange="strDateTime()"/></td>
      <td align="right"><span style="color:white">民族：</span></td>
      <td><input type="text" name="nation" size="30" /></td>
      <td align="right"><span style="color:white">文化程度：</span></td>
      <td><input type="text" name="education" size="30" /></td>
      <td align="right"><span style="color:white">政治面貌：</span></td>
      <td><input type="text" name="politicsStatus" size="30" /></td>
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
      <td><input type="text" name="phone" size="30" "/></td>
      <td align="right"><span style="color:white">现住址：</span></td>
      <td><input type="text" name="address" size="30" "/></td>
      <td align="right"><span style="color:white">工种：</span></td>
      <td><input type="text" name="workType" size="30" "/></td>
   </tr>
   <tr>
      <td align="right"><span style="color:white">工人技术等级：</span></td>
      <td><input type="text" name="workerDegreeTech" size="30" /></td>
      <td align="right"><span style="color:white">参加工作时间：</span></td>
      <td><input type="text" name="beginWorkDate" size="30" /></td>
      <td align="right"><span style="color:white">进入本单位时间：</span></td>
      <td><input type="text" name="enterWorkPlaceDate" size="30" /></td>
      <td align="right"><span style="color:white">户口所在地：</span></td>
      <td><input type="text" name="domicilePlace" size="30" /></td>
   </tr>
   <tr>
      <td align="right"><span style="color:white">邮政编码：</span></td>
      <td><input type="text" name="postalcode" size="30" /></td>
      <td align="right"><span style="color:white">驾驶证档案编号：</span></td>
      <td><input type="text" name="drivingLicenseFileNum" size="30" /></td>
      <td align="right"><span style="color:white">车牌号：</span></td>
      <td><input type="text" name="carNum" size="30" /></td>
      <td align="right"><span style="color:white">单双班：</span></td>
      <td><select name="singleDouble">
          <option value="单班" selected="selected">单班</option>
          <option value="双班">双班</option>
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