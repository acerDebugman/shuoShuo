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
<form action="updateAddLabour.jsp" method="get" name="addLabourFrom">
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
      <td align="right"><span style="color:white">住院时间：</span></td>
      <td><input type="text" name="inHospitalTime" size="30" onchange="strDateTime()"/>格式为：YYYY-MM-DD</td>
   </tr>
   <tr><span style="color:white">
      <td align="right"><span style="color:white">病因：</span></td>
      <td><input type="text" name="diseaseCause" size="30" /></td>
   </tr>
   <tr>
      <td align="right"><span style="color:white">一年内医疗二次报销金额：</span></td>
      <td><input type="text" name="yearMedicalTwiceReimburse" size="30" />元</td>
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