<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>经理主界面</title>
</head>
<frameset rows="*" cols="180,*">
    <frame src="managerLeft.jsp" name="left" scrolling="no"/>
    <frameset rows="180,480,*" cols="*">
         <frame src="top.jsp" name="captainLeft" scrolling="no"/>
         <frame src="managerMiddle.jsp" name="managerMain" />
         <frame src="managerBottom.jsp" name="managerBottom" scrolling="yes"/>
    </frameset>
</frameset>
</html>