<%-- <%@page import="com.sun.crypto.provider.RSACipher"%> --%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,shouQiSystem.user.*" %>
<jsp:useBean id="userinfo" scope="request" class="shouQiSystem.user.UserInfo"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  -->
<meta http-equiv="refresh" content="3; URL=bottom.jsp; charset=utf-8">
<title>底部页面</title>
</head>
<body background="images/bottom.png">
   <center>
    <form action="" method="GET" name="form" target="main">
    <table boder="2" cellpadding="5" cellspacing="5">
  <tr>
      <%
        String name="";String carNum="";
        int trafficViolationSum=0,trafficAccidentSum=0,dynamicMonitorSum=0,ICcardDataSum=0,trainRecordSum=0,serviceSum=0,technologySum=0,financeSum=0,labourSum=0;
       
        ResultSet trafficViolationSumRs,trafficAccidentSumRs,dynamicMonitorSumRs,ICcardDataSumRs,trainRecordSumRs,serviceSumRs,technologySumRs,financeSumRs,labourSumRs;
        
        String trafficViolationSql="select * from trafficViolationRemind order by ID desc limit 0,1";
        ResultSet trafficViolationRs=userinfo.execute(trafficViolationSql);
        while(trafficViolationRs.next()){
        	name=trafficViolationRs.getString("name");
        	carNum=trafficViolationRs.getString("carNum");
        	trafficViolationSumRs=userinfo.queryTrafficViolationSum(name, carNum);
        	trafficAccidentSumRs=userinfo.queryTrafficAccidentSum(name, carNum);
        	dynamicMonitorSumRs=userinfo.queryDynamicMonitorSum(name, carNum);
        	ICcardDataSumRs=userinfo.queryICcardDataSum(name, carNum);
        	trainRecordSumRs=userinfo.queryTrainRecordSum(name, carNum);
        	serviceSumRs=userinfo.queryServiceSum(name, carNum);
        	technologySumRs=userinfo.queryTechnologySum(name, carNum);
        	financeSumRs=userinfo.queryFinanceSum(name, carNum);
        	labourSumRs=userinfo.queryLabourSum(name, carNum);
        	
            if(trafficViolationSumRs.next()){
            	trafficViolationSum=trafficViolationSumRs.getInt(1);
            }
            if(trafficAccidentSumRs.next()){
            	trafficAccidentSum=trafficAccidentSumRs.getInt(1);
            }
            if(dynamicMonitorSumRs.next()){
            	dynamicMonitorSum=dynamicMonitorSumRs.getInt(1);
            }
            if(ICcardDataSumRs.next()){
            	ICcardDataSum=ICcardDataSumRs.getInt(1);
            }
            if(trainRecordSumRs.next()){
            	trainRecordSum=trainRecordSumRs.getInt(1);
            }
            if(serviceSumRs.next()){
            	serviceSum=serviceSumRs.getInt(1);
            }
            if(technologySumRs.next()){
            	technologySum=technologySumRs.getInt(1);
            }
            if(financeSumRs.next()){
            	financeSum=financeSumRs.getInt(1);
            }
            if(labourSumRs.next()){
            	labourSum=labourSumRs.getInt(1);
            }
            trafficViolationSumRs.close();
            trafficAccidentSumRs.close();
            dynamicMonitorSumRs.close();
            ICcardDataSumRs.close();
            trainRecordSumRs.close();
            serviceSumRs.close();
            technologySumRs.close();
            financeSumRs.close();
            labourSumRs.close();
            userinfo.close_all();
            if(trafficViolationSum+trafficAccidentSum+ICcardDataSum+trainRecordSum+serviceSum+technologySum+financeSum+labourSum>=3){
      %>
          <td><input type="checkbox" name="pkey" size="5" value="<%=userinfo.findEmployeeCardNum(name, carNum) %>"/></td>
          <td><span style="color:red"> <%=trafficViolationRs.getString("name") %></span><span style="color:red">车牌号：</span><span style="color:red"><%=trafficViolationRs.getString("carNum")%></span><span style="color:red">新增一条交通违法记录</span></td>
       </tr>
      <%
            }
            else{
            	%>
            	 <td><input type="checkbox" name="pkey" size="5" value="<%=userinfo.findEmployeeCardNum(name, carNum) %>"/></td>
                 <td><span style="color:white"> <%=trafficViolationRs.getString("name") %></span><span style="color:white">车牌号：</span><span style="color:white"><%=trafficViolationRs.getString("carNum")%></span><span style="color:white">新增一条交通违法记录</span></td>
            </tr>
            	<% 
            }
        }
        trafficViolationRs.close();
        userinfo.close_all();
      %>
      
       <tr>
      <%            
        String trafficAccidentSql="select * from trafficaccidentremind order by ID desc limit 0,1";
        ResultSet trafficAccidentRs=userinfo.execute(trafficAccidentSql);
        while(trafficAccidentRs.next()){
        	name=trafficAccidentRs.getString("name");
        	carNum=trafficAccidentRs.getString("carNum");
        	trafficViolationSumRs=userinfo.queryTrafficViolationSum(name, carNum);
        	trafficAccidentSumRs=userinfo.queryTrafficAccidentSum(name, carNum);
        	dynamicMonitorSumRs=userinfo.queryDynamicMonitorSum(name, carNum);
        	ICcardDataSumRs=userinfo.queryICcardDataSum(name, carNum);
        	trainRecordSumRs=userinfo.queryTrainRecordSum(name, carNum);
        	serviceSumRs=userinfo.queryServiceSum(name, carNum);
        	technologySumRs=userinfo.queryTechnologySum(name, carNum);
        	financeSumRs=userinfo.queryFinanceSum(name, carNum);
        	labourSumRs=userinfo.queryLabourSum(name, carNum);
        	
            if(trafficViolationSumRs.next()){
            	trafficViolationSum=trafficViolationSumRs.getInt(1);
            }
            if(trafficAccidentSumRs.next()){
            	trafficAccidentSum=trafficAccidentSumRs.getInt(1);
            }
            if(dynamicMonitorSumRs.next()){
            	dynamicMonitorSum=dynamicMonitorSumRs.getInt(1);
            }
            if(ICcardDataSumRs.next()){
            	ICcardDataSum=ICcardDataSumRs.getInt(1);
            }
            if(trainRecordSumRs.next()){
            	trainRecordSum=trainRecordSumRs.getInt(1);
            }
            if(serviceSumRs.next()){
            	serviceSum=serviceSumRs.getInt(1);
            }
            if(technologySumRs.next()){
            	technologySum=technologySumRs.getInt(1);
            }
            if(financeSumRs.next()){
            	financeSum=financeSumRs.getInt(1);
            }
            if(labourSumRs.next()){
            	labourSum=labourSumRs.getInt(1);
            }
            trafficViolationSumRs.close();
            trafficAccidentSumRs.close();
            dynamicMonitorSumRs.close();
            ICcardDataSumRs.close();
            trainRecordSumRs.close();
            serviceSumRs.close();
            technologySumRs.close();
            financeSumRs.close();
            labourSumRs.close();
            userinfo.close_all();
            if(trafficViolationSum+trafficAccidentSum+ICcardDataSum+trainRecordSum+serviceSum+technologySum+financeSum+labourSum>=3){
      %>
          <td><input type="checkbox" name="pkey" size="5" value="<%=userinfo.findEmployeeCardNum(name, carNum) %>"/></td>
          <td><span style="color:red"> <%=trafficAccidentRs.getString("name") %></span><span style="color:red">车牌号：</span><span style="color:red"><%=trafficAccidentRs.getString("carNum")%></span><span style="color:red">新增一条交通事故记录</span></td>
       </tr>
      <%
            }
            else{
            	%>
            	 <td><input type="checkbox" name="pkey" size="5" value="<%=userinfo.findEmployeeCardNum(name, carNum) %>"/></td>
                 <td><span style="color:white"> <%=trafficAccidentRs.getString("name") %></span><span style="color:white">车牌号：</span><span style="color:white"><%=trafficAccidentRs.getString("carNum")%></span><span style="color:white">新增一条交通事故记录</span></td>
            </tr>
            	<% 
            }
        }
        trafficAccidentRs.close();
        userinfo.close_all();
      %>
       <tr>
      <%            
        String dynamicMonitorSql="select * from dynamicMonitorRemind order by ID desc limit 0,1";
        ResultSet dynamicMonitorRs=userinfo.execute(dynamicMonitorSql);
        while(dynamicMonitorRs.next()){
        	name=dynamicMonitorRs.getString("name");
        	carNum=dynamicMonitorRs.getString("carNum");
        	trafficViolationSumRs=userinfo.queryTrafficViolationSum(name, carNum);
        	trafficAccidentSumRs=userinfo.queryTrafficAccidentSum(name, carNum);
        	dynamicMonitorSumRs=userinfo.queryDynamicMonitorSum(name, carNum);
        	ICcardDataSumRs=userinfo.queryICcardDataSum(name, carNum);
        	trainRecordSumRs=userinfo.queryTrainRecordSum(name, carNum);
        	serviceSumRs=userinfo.queryServiceSum(name, carNum);
        	technologySumRs=userinfo.queryTechnologySum(name, carNum);
        	financeSumRs=userinfo.queryFinanceSum(name, carNum);
        	labourSumRs=userinfo.queryLabourSum(name, carNum);
        	
            if(trafficViolationSumRs.next()){
            	trafficViolationSum=trafficViolationSumRs.getInt(1);
            }
            if(trafficAccidentSumRs.next()){
            	trafficAccidentSum=trafficAccidentSumRs.getInt(1);
            }
            if(dynamicMonitorSumRs.next()){
            	dynamicMonitorSum=dynamicMonitorSumRs.getInt(1);
            }
            if(ICcardDataSumRs.next()){
            	ICcardDataSum=ICcardDataSumRs.getInt(1);
            }
            if(trainRecordSumRs.next()){
            	trainRecordSum=trainRecordSumRs.getInt(1);
            }
            if(serviceSumRs.next()){
            	serviceSum=serviceSumRs.getInt(1);
            }
            if(technologySumRs.next()){
            	technologySum=technologySumRs.getInt(1);
            }
            if(financeSumRs.next()){
            	financeSum=financeSumRs.getInt(1);
            }
            if(labourSumRs.next()){
            	labourSum=labourSumRs.getInt(1);
            }
            trafficViolationSumRs.close();
            trafficAccidentSumRs.close();
            dynamicMonitorSumRs.close();
            ICcardDataSumRs.close();
            trainRecordSumRs.close();
            serviceSumRs.close();
            technologySumRs.close();
            financeSumRs.close();
            labourSumRs.close();
            userinfo.close_all();
            if(trafficViolationSum+trafficAccidentSum+ICcardDataSum+trainRecordSum+serviceSum+technologySum+financeSum+labourSum>=3){
      %>
          <td><input type="checkbox" name="pkey" size="5" value="<%=userinfo.findEmployeeCardNum(name, carNum) %>"/></td>
          <td><span style="color:red"> <%=dynamicMonitorRs.getString("name") %></span><span style="color:red">车牌号：</span><span style="color:red"><%=dynamicMonitorRs.getString("carNum")%></span><span style="color:red">新增一条动态监控记录</span></td>
       </tr>
      <%
            }
            else{
            	%>
            	 <td><input type="checkbox" name="pkey" size="5" value="<%=userinfo.findEmployeeCardNum(name, carNum) %>"/></td>
                 <td><span style="color:white"> <%=dynamicMonitorRs.getString("name") %></span><span style="color:white">车牌号：</span><span style="color:white"><%=dynamicMonitorRs.getString("carNum")%></span><span style="color:white">新增一条动态监控记录</span></td>
            </tr>
            	<% 
            }
        }
        dynamicMonitorRs.close();
        userinfo.close_all();
      %>
      
       <tr>
      <%            
        String ICcardDataSql="select * from ICcardDataRemind order by ID desc limit 0,1";
        ResultSet ICcardDataRs=userinfo.execute(ICcardDataSql);
        while(ICcardDataRs.next()){
        	name=ICcardDataRs.getString("name");
        	carNum=ICcardDataRs.getString("carNum");
        	trafficViolationSumRs=userinfo.queryTrafficViolationSum(name, carNum);
        	trafficAccidentSumRs=userinfo.queryTrafficAccidentSum(name, carNum);
        	dynamicMonitorSumRs=userinfo.queryDynamicMonitorSum(name, carNum);
        	ICcardDataSumRs=userinfo.queryICcardDataSum(name, carNum);
        	trainRecordSumRs=userinfo.queryTrainRecordSum(name, carNum);
        	serviceSumRs=userinfo.queryServiceSum(name, carNum);
        	technologySumRs=userinfo.queryTechnologySum(name, carNum);
        	financeSumRs=userinfo.queryFinanceSum(name, carNum);
        	labourSumRs=userinfo.queryLabourSum(name, carNum);
        	
            if(trafficViolationSumRs.next()){
            	trafficViolationSum=trafficViolationSumRs.getInt(1);
            }
            if(trafficAccidentSumRs.next()){
            	trafficAccidentSum=trafficAccidentSumRs.getInt(1);
            }
            if(dynamicMonitorSumRs.next()){
            	dynamicMonitorSum=dynamicMonitorSumRs.getInt(1);
            }
            if(ICcardDataSumRs.next()){
            	ICcardDataSum=ICcardDataSumRs.getInt(1);
            }
            if(trainRecordSumRs.next()){
            	trainRecordSum=trainRecordSumRs.getInt(1);
            }
            if(serviceSumRs.next()){
            	serviceSum=serviceSumRs.getInt(1);
            }
            if(technologySumRs.next()){
            	technologySum=technologySumRs.getInt(1);
            }
            if(financeSumRs.next()){
            	financeSum=financeSumRs.getInt(1);
            }
            if(labourSumRs.next()){
            	labourSum=labourSumRs.getInt(1);
            }
            trafficViolationSumRs.close();
            trafficAccidentSumRs.close();
            dynamicMonitorSumRs.close();
            ICcardDataSumRs.close();
            trainRecordSumRs.close();
            serviceSumRs.close();
            technologySumRs.close();
            financeSumRs.close();
            labourSumRs.close();
            userinfo.close_all();
            if(trafficViolationSum+trafficAccidentSum+ICcardDataSum+trainRecordSum+serviceSum+technologySum+financeSum+labourSum>=3){
      %>
          <td><input type="checkbox" name="pkey" size="5" value="<%=userinfo.findEmployeeCardNum(name, carNum) %>"/></td>
          <td><span style="color:red"> <%=ICcardDataRs.getString("name") %></span><span style="color:red">车牌号：</span><span style="color:red"><%=ICcardDataRs.getString("carNum")%></span><span style="color:red">新增一条IC卡数据记录</span></td>
       </tr>
      <%
            }
            else{
            	%>
            	 <td><input type="checkbox" name="pkey" size="5" value="<%=userinfo.findEmployeeCardNum(name, carNum) %>"/></td>
                 <td><span style="color:white"> <%=ICcardDataRs.getString("name") %></span><span style="color:white">车牌号：</span><span style="color:white"><%=ICcardDataRs.getString("carNum")%></span><span style="color:white">新增一条IC卡数据记录</span></td>
            </tr>
            	<% 
            }
        }
        ICcardDataRs.close();
        userinfo.close_all();
      %>
      
      <tr>
      <%            
        String trainRecordSql="select * from trainRecordRemind order by ID desc limit 0,1";
        ResultSet trainRecordRs=userinfo.execute(trainRecordSql);
        while(trainRecordRs.next()){
        	name=trainRecordRs.getString("name");
        	carNum=trainRecordRs.getString("carNum");
        	trafficViolationSumRs=userinfo.queryTrafficViolationSum(name, carNum);
        	trafficAccidentSumRs=userinfo.queryTrafficAccidentSum(name, carNum);
        	dynamicMonitorSumRs=userinfo.queryDynamicMonitorSum(name, carNum);
        	ICcardDataSumRs=userinfo.queryICcardDataSum(name, carNum);
        	trainRecordSumRs=userinfo.queryTrainRecordSum(name, carNum);
        	serviceSumRs=userinfo.queryServiceSum(name, carNum);
        	technologySumRs=userinfo.queryTechnologySum(name, carNum);
        	financeSumRs=userinfo.queryFinanceSum(name, carNum);
        	labourSumRs=userinfo.queryLabourSum(name, carNum);
        	
            if(trafficViolationSumRs.next()){
            	trafficViolationSum=trafficViolationSumRs.getInt(1);
            }
            if(trafficAccidentSumRs.next()){
            	trafficAccidentSum=trafficAccidentSumRs.getInt(1);
            }
            if(dynamicMonitorSumRs.next()){
            	dynamicMonitorSum=dynamicMonitorSumRs.getInt(1);
            }
            if(ICcardDataSumRs.next()){
            	ICcardDataSum=ICcardDataSumRs.getInt(1);
            }
            if(trainRecordSumRs.next()){
            	trainRecordSum=trainRecordSumRs.getInt(1);
            }
            if(serviceSumRs.next()){
            	serviceSum=serviceSumRs.getInt(1);
            }
            if(technologySumRs.next()){
            	technologySum=technologySumRs.getInt(1);
            }
            if(financeSumRs.next()){
            	financeSum=financeSumRs.getInt(1);
            }
            if(labourSumRs.next()){
            	labourSum=labourSumRs.getInt(1);
            }
            trafficViolationSumRs.close();
            trafficAccidentSumRs.close();
            dynamicMonitorSumRs.close();
            ICcardDataSumRs.close();
            trainRecordSumRs.close();
            serviceSumRs.close();
            technologySumRs.close();
            financeSumRs.close();
            labourSumRs.close();
            userinfo.close_all();
            if(trafficViolationSum+trafficAccidentSum+ICcardDataSum+trainRecordSum+serviceSum+technologySum+financeSum+labourSum>=3){
      %>
          <td><input type="checkbox" name="pkey" size="5" value="<%=userinfo.findEmployeeCardNum(name, carNum) %>"/></td>
          <td><span style="color:red"> <%=trainRecordRs.getString("name") %></span><span style="color:red">车牌号：</span><span style="color:red"><%=trainRecordRs.getString("carNum")%></span><span style="color:red">新增一条培训记录</span></td>
       </tr>
      <%
            }
            else{
            	%>
            	 <td><input type="checkbox" name="pkey" size="5" value="<%=userinfo.findEmployeeCardNum(name, carNum) %>"/></td>
                 <td><span style="color:white"> <%=trainRecordRs.getString("name") %></span><span style="color:white">车牌号：</span><span style="color:white"><%=trainRecordRs.getString("carNum")%></span><span style="color:white">新增一条培训记录</span></td>
            </tr>
            	<% 
            }
        }
        trainRecordRs.close();
        userinfo.close_all();
      %>

      <tr>
      <%            
        String serviceSql="select * from serviceRemind order by ID desc limit 0,1";
        ResultSet serviceRs=userinfo.execute(serviceSql);
        while(serviceRs.next()){
        	name=serviceRs.getString("name");
        	carNum=serviceRs.getString("carNum");
        	trafficViolationSumRs=userinfo.queryTrafficViolationSum(name, carNum);
        	trafficAccidentSumRs=userinfo.queryTrafficAccidentSum(name, carNum);
        	dynamicMonitorSumRs=userinfo.queryDynamicMonitorSum(name, carNum);
        	ICcardDataSumRs=userinfo.queryICcardDataSum(name, carNum);
        	trainRecordSumRs=userinfo.queryTrainRecordSum(name, carNum);
        	serviceSumRs=userinfo.queryServiceSum(name, carNum);
        	technologySumRs=userinfo.queryTechnologySum(name, carNum);
        	financeSumRs=userinfo.queryFinanceSum(name, carNum);
        	labourSumRs=userinfo.queryLabourSum(name, carNum);
        	
            if(trafficViolationSumRs.next()){
            	trafficViolationSum=trafficViolationSumRs.getInt(1);
            }
            if(trafficAccidentSumRs.next()){
            	trafficAccidentSum=trafficAccidentSumRs.getInt(1);
            }
            if(dynamicMonitorSumRs.next()){
            	dynamicMonitorSum=dynamicMonitorSumRs.getInt(1);
            }
            if(ICcardDataSumRs.next()){
            	ICcardDataSum=ICcardDataSumRs.getInt(1);
            }
            if(trainRecordSumRs.next()){
            	trainRecordSum=trainRecordSumRs.getInt(1);
            }
            if(serviceSumRs.next()){
            	serviceSum=serviceSumRs.getInt(1);
            }
            if(technologySumRs.next()){
            	technologySum=technologySumRs.getInt(1);
            }
            if(financeSumRs.next()){
            	financeSum=financeSumRs.getInt(1);
            }
            if(labourSumRs.next()){
            	labourSum=labourSumRs.getInt(1);
            }
            trafficViolationSumRs.close();
            trafficAccidentSumRs.close();
            dynamicMonitorSumRs.close();
            ICcardDataSumRs.close();
            trainRecordSumRs.close();
            serviceSumRs.close();
            technologySumRs.close();
            financeSumRs.close();
            labourSumRs.close();
            userinfo.close_all();
            if(trafficViolationSum+trafficAccidentSum+ICcardDataSum+trainRecordSum+serviceSum+technologySum+financeSum+labourSum>=3){
      %>
          <td><input type="checkbox" name="pkey" size="5" value="<%=userinfo.findEmployeeCardNum(name, carNum) %>"/></td>
          <td><span style="color:red"> <%=serviceRs.getString("name") %></span><span style="color:red">车牌号：</span><span style="color:red"><%=serviceRs.getString("carNum")%></span><span style="color:red">新增一条服务记录</span></td>
       </tr>
      <%
            }
            else{
            	%>
            	 <td><input type="checkbox" name="pkey" size="5" value="<%=userinfo.findEmployeeCardNum(name, carNum) %>"/></td>
                 <td><span style="color:white"> <%=serviceRs.getString("name") %></span><span style="color:white">车牌号：</span><span style="color:white"><%=serviceRs.getString("carNum")%></span><span style="color:white">新增一条服务记录</span></td>
            </tr>
            	<% 
            }
        }
        serviceRs.close();
        userinfo.close_all();
      %>
      
       <tr>
      <%            
        String technologySql="select * from technologyRemind order by ID desc limit 0,1";
        ResultSet technologyRs=userinfo.execute(technologySql);
        while(technologyRs.next()){
        	name=technologyRs.getString("name");
        	carNum=technologyRs.getString("carNum");
        	trafficViolationSumRs=userinfo.queryTrafficViolationSum(name, carNum);
        	trafficAccidentSumRs=userinfo.queryTrafficAccidentSum(name, carNum);
        	dynamicMonitorSumRs=userinfo.queryDynamicMonitorSum(name, carNum);
        	ICcardDataSumRs=userinfo.queryICcardDataSum(name, carNum);
        	trainRecordSumRs=userinfo.queryTrainRecordSum(name, carNum);
        	serviceSumRs=userinfo.queryServiceSum(name, carNum);
        	technologySumRs=userinfo.queryTechnologySum(name, carNum);
        	financeSumRs=userinfo.queryFinanceSum(name, carNum);
        	labourSumRs=userinfo.queryLabourSum(name, carNum);
        	
            if(trafficViolationSumRs.next()){
            	trafficViolationSum=trafficViolationSumRs.getInt(1);
            }
            if(trafficAccidentSumRs.next()){
            	trafficAccidentSum=trafficAccidentSumRs.getInt(1);
            }
            if(dynamicMonitorSumRs.next()){
            	dynamicMonitorSum=dynamicMonitorSumRs.getInt(1);
            }
            if(ICcardDataSumRs.next()){
            	ICcardDataSum=ICcardDataSumRs.getInt(1);
            }
            if(trainRecordSumRs.next()){
            	trainRecordSum=trainRecordSumRs.getInt(1);
            }
            if(serviceSumRs.next()){
            	serviceSum=serviceSumRs.getInt(1);
            }
            if(technologySumRs.next()){
            	technologySum=technologySumRs.getInt(1);
            }
            if(financeSumRs.next()){
            	financeSum=financeSumRs.getInt(1);
            }
            if(labourSumRs.next()){
            	labourSum=labourSumRs.getInt(1);
            }
            trafficViolationSumRs.close();
            trafficAccidentSumRs.close();
            dynamicMonitorSumRs.close();
            ICcardDataSumRs.close();
            trainRecordSumRs.close();
            serviceSumRs.close();
            technologySumRs.close();
            financeSumRs.close();
            labourSumRs.close();
            userinfo.close_all();
            if(trafficViolationSum+trafficAccidentSum+ICcardDataSum+trainRecordSum+serviceSum+technologySum+financeSum+labourSum>=3){
      %>
          <td><input type="checkbox" name="pkey" size="5" value="<%=userinfo.findEmployeeCardNum(name, carNum) %>"/></td>
          <td><span style="color:red"> <%=technologyRs.getString("name") %></span><span style="color:red">车牌号：</span><span style="color:red"><%=technologyRs.getString("carNum")%></span><span style="color:red">新增一条技术记录</span></td>
       </tr>
      <%
            }
            else{
            	%>
            	 <td><input type="checkbox" name="pkey" size="5" value="<%=userinfo.findEmployeeCardNum(name, carNum) %>"/></td>
                 <td><span style="color:white"> <%=technologyRs.getString("name") %></span><span style="color:white">车牌号：</span><span style="color:white"><%=technologyRs.getString("carNum")%></span><span style="color:white">新增一条技术记录</span></td>
            </tr>
            	<% 
            }
        }
        technologyRs.close();
        userinfo.close_all();
      %>
      
       <tr>
      <%            
        String financeSql="select * from financeRemind order by ID desc limit 0,1";
        ResultSet financeRs=userinfo.execute(financeSql);
        while(financeRs.next()){
        	name=financeRs.getString("name");
        	carNum=financeRs.getString("carNum");
        	trafficViolationSumRs=userinfo.queryTrafficViolationSum(name, carNum);
        	trafficAccidentSumRs=userinfo.queryTrafficAccidentSum(name, carNum);
        	dynamicMonitorSumRs=userinfo.queryDynamicMonitorSum(name, carNum);
        	ICcardDataSumRs=userinfo.queryICcardDataSum(name, carNum);
        	trainRecordSumRs=userinfo.queryTrainRecordSum(name, carNum);
        	serviceSumRs=userinfo.queryServiceSum(name, carNum);
        	technologySumRs=userinfo.queryTechnologySum(name, carNum);
        	financeSumRs=userinfo.queryFinanceSum(name, carNum);
        	labourSumRs=userinfo.queryLabourSum(name, carNum);
        	
            if(trafficViolationSumRs.next()){
            	trafficViolationSum=trafficViolationSumRs.getInt(1);
            }
            if(trafficAccidentSumRs.next()){
            	trafficAccidentSum=trafficAccidentSumRs.getInt(1);
            }
            if(dynamicMonitorSumRs.next()){
            	dynamicMonitorSum=dynamicMonitorSumRs.getInt(1);
            }
            if(ICcardDataSumRs.next()){
            	ICcardDataSum=ICcardDataSumRs.getInt(1);
            }
            if(trainRecordSumRs.next()){
            	trainRecordSum=trainRecordSumRs.getInt(1);
            }
            if(serviceSumRs.next()){
            	serviceSum=serviceSumRs.getInt(1);
            }
            if(technologySumRs.next()){
            	technologySum=technologySumRs.getInt(1);
            }
            if(financeSumRs.next()){
            	financeSum=financeSumRs.getInt(1);
            }
            if(labourSumRs.next()){
            	labourSum=labourSumRs.getInt(1);
            }
            trafficViolationSumRs.close();
            trafficAccidentSumRs.close();
            dynamicMonitorSumRs.close();
            ICcardDataSumRs.close();
            trainRecordSumRs.close();
            serviceSumRs.close();
            technologySumRs.close();
            financeSumRs.close();
            labourSumRs.close();
            userinfo.close_all();
            if(trafficViolationSum+trafficAccidentSum+ICcardDataSum+trainRecordSum+serviceSum+technologySum+financeSum+labourSum>=3){
      %>
          <td><input type="checkbox" name="pkey" size="5" value="<%=userinfo.findEmployeeCardNum(name, carNum) %>"/></td>
          <td><span style="color:red"> <%=financeRs.getString("name") %></span><span style="color:red">车牌号：</span><span style="color:red"><%=financeRs.getString("carNum")%></span><span style="color:red">新增一条财务记录</span></td>
       </tr>
      <%
            }
            else{
            	%>
            	 <td><input type="checkbox" name="pkey" size="5" value="<%=userinfo.findEmployeeCardNum(name, carNum) %>"/></td>
                 <td><span style="color:white"> <%=financeRs.getString("name") %></span><span style="color:white">车牌号：</span><span style="color:white"><%=financeRs.getString("carNum")%></span><span style="color:white">新增一条财务记录</span></td>
            </tr>
            	<% 
            }
        }
        financeRs.close();
        userinfo.close_all();
      %>
      
      <tr>
      <%            
        String labourSql="select * from labourRemind order by ID desc limit 0,1";
        ResultSet labourRs=userinfo.execute(labourSql);
        while(labourRs.next()){
        	name=labourRs.getString("name");
        	carNum=labourRs.getString("carNum");
        	trafficViolationSumRs=userinfo.queryTrafficViolationSum(name, carNum);
        	trafficAccidentSumRs=userinfo.queryTrafficAccidentSum(name, carNum);
        	dynamicMonitorSumRs=userinfo.queryDynamicMonitorSum(name, carNum);
        	ICcardDataSumRs=userinfo.queryICcardDataSum(name, carNum);
        	trainRecordSumRs=userinfo.queryTrainRecordSum(name, carNum);
        	serviceSumRs=userinfo.queryServiceSum(name, carNum);
        	technologySumRs=userinfo.queryTechnologySum(name, carNum);
        	financeSumRs=userinfo.queryFinanceSum(name, carNum);
        	labourSumRs=userinfo.queryLabourSum(name, carNum);
        	
            if(trafficViolationSumRs.next()){
            	trafficViolationSum=trafficViolationSumRs.getInt(1);
            }
            if(trafficAccidentSumRs.next()){
            	trafficAccidentSum=trafficAccidentSumRs.getInt(1);
            }
            if(dynamicMonitorSumRs.next()){
            	dynamicMonitorSum=dynamicMonitorSumRs.getInt(1);
            }
            if(ICcardDataSumRs.next()){
            	ICcardDataSum=ICcardDataSumRs.getInt(1);
            }
            if(trainRecordSumRs.next()){
            	trainRecordSum=trainRecordSumRs.getInt(1);
            }
            if(serviceSumRs.next()){
            	serviceSum=serviceSumRs.getInt(1);
            }
            if(technologySumRs.next()){
            	technologySum=technologySumRs.getInt(1);
            }
            if(financeSumRs.next()){
            	financeSum=financeSumRs.getInt(1);
            }
            if(labourSumRs.next()){
            	labourSum=labourSumRs.getInt(1);
            }
            trafficViolationSumRs.close();
            trafficAccidentSumRs.close();
            dynamicMonitorSumRs.close();
            ICcardDataSumRs.close();
            trainRecordSumRs.close();
            serviceSumRs.close();
            technologySumRs.close();
            financeSumRs.close();
            labourSumRs.close();
            userinfo.close_all();
            if(trafficViolationSum+trafficAccidentSum+ICcardDataSum+trainRecordSum+serviceSum+technologySum+financeSum+labourSum>=3){
      %>
          <td><input type="checkbox" name="pkey" size="5" value="<%=userinfo.findEmployeeCardNum(name, carNum) %>"/></td>
          <td><span style="color:red"> <%=labourRs.getString("name") %></span><span style="color:red">车牌号：</span><span style="color:red"><%=labourRs.getString("carNum")%></span><span style="color:red">新增一条劳动记录</span></td>
       </tr>
      <%
            }
            else{
            	%>
            	 <td><input type="checkbox" name="pkey" size="5" value="<%=userinfo.findEmployeeCardNum(name, carNum) %>"/></td>
                 <td><span style="color:white"> <%=labourRs.getString("name") %></span><span style="color:white">车牌号：</span><span style="color:white"><%=labourRs.getString("carNum")%></span><span style="color:white">新增一条劳动记录</span></td>
            </tr>
            	<% 
            }
        }
        labourRs.close();
        userinfo.close_all();

      %>
      
      <tr align="right">
           <td colspan="2">
             <input type="submit" name="look" value="查看" onclick="form.action='RemindServlet';form.submit();">
           </td>
      </tr>
   </center>

</body>
</html>