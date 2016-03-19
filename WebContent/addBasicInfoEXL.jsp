<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>由Excel导入基本信息</title>
</head>
<body background="images/bottom.png">
  <center>
      <br><br><br><br><br><br>
       <script>  
function check()  
    {  
        var excelfileName = importDriversInfoEXL.importEXLFile.value ;  
        var exceltype = excelfileName.substring(excelfileName.lastIndexOf('.')  +  1).toLowerCase();  
          
        if(excelfileName.length==0)  
        {  
            alert("请选择excel");  
             return false;  
        }  
              
        else if(!(exceltype=="xls"))  
        {  
            alert("格式必须为excel 2003");  
             return false;  
        }  
    }  
      
</script>   
      <form action="<%=request.getContextPath()%>/ReadDriverEXL" method="get" enctype="multipart/form-data" name="importDriversInfoEXL" >
       导入司机基本信息：
      <input name="importEXLFile" type="file" size="30" maxlength="50" onchange="check()"/>
      <br>  
      <br>  
      <input type="submit" class="importButton" value="确定" >  
      </form>
  </center>

</body>
</html>