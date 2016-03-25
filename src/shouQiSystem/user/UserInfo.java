package shouQiSystem.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserInfo {
	 private static Connection conn=null;
	    private static PreparedStatement pstmt=null;
	    private static Statement stmt=null;
	    static ResultSet rs=null;
	    String error=null;
	    
	    private static final String driverName="com.mysql.jdbc.Driver";
//	    private static final String urls="jdbc:mysql://localhost:3306/shouqisystem?user=root"+"&password=shi1528shuo&useUnicode=true&characterEncoding=GB2312";
	    private static final String urls="jdbc:mysql://123.57.251.91:3306/shouqisystem?user=cuteShuoShuo"+"&password=joeLoveShuo&useUnicode=true&characterEncoding=GB2312";
	    
	    static {
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection(urls);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} 
	    }
	    
	    public static String executeQuery(String name,String password,String type) throws Exception{
	    	pstmt=null;
	    	String queryStr="SELECT * FROM user WHERE userName=?"+" AND userPassword=? AND userType=?";
	    	try{
//	    		Class.forName(driverName);
//	    		//Class.forName("com.mysql.jdbc.Driver"); 
//	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(queryStr);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, password);
	    		pstmt.setString(3, type);
	    		rs=pstmt.executeQuery();
	    		if(rs.next()){
	    			return rs.getString("userType");
	    		}
	    		else{
	    			String s="error";
	    			return s;
	    		}
	    	}
	    	catch (Exception e){
	    		throw e;
	    	}
	    }
	    
	    public static boolean judgeEXLtoDB(Driver driver) throws Exception{
	    	String sql="SELECT * FROM driversinfo WHERE employeeCardNum=?";
	    	try{
	    		////Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1,driver.getEmployeeCardNum());
	    		rs=pstmt.executeQuery();
	    		if(rs.next()){
	    			return false;
	    		}else{
	    			return true;
	    		}
	    	}catch(Exception e){
	    		throw e;
	    	}
	    }
	    
	    
	    public static void EXLtoDB(Driver driver)throws SQLException{
	    	pstmt=null;
	    	String sql="insert into driversinfo(employeeCardNum,name,sex,ID,birthDate,nation,education,politicsStatus,workPlace,phone,address,workType,"
	    			+ "workerDegreeTech,beginWorkDate,enterWorkPlaceDate,domicilePlace,postalcode,drivingLicenseFileNum,carNum,singleDouble)"
	    			+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1,driver.getEmployeeCardNum());
	    		pstmt.setString(2,driver.getName());
	    		pstmt.setString(3, driver.getSex());
	    		pstmt.setString(4,driver.getID());
	    		pstmt.setString(5, driver.getBirthDate());
	    		pstmt.setString(6, driver.getNation());
	    		pstmt.setString(7, driver.getEducation());
	    		pstmt.setString(8, driver.getPoliticsStatus());
	    		pstmt.setString(9, driver.getWorkPlace());
	    		pstmt.setString(10, driver.getPhone());
	    		pstmt.setString(11, driver.getAddress());
	    		pstmt.setString(12, driver.getWorkType());
	    		pstmt.setString(13, driver.getWorkerDegreeTech());
	    		pstmt.setString(14, driver.getBeginWorkDate());
	    		pstmt.setString(15, driver.getEnterWorkPlaceDate());
	    		pstmt.setString(16, driver.getDomicilePlace());
	    		pstmt.setString(17, driver.getPostalcode());
	    		pstmt.setString(18, driver.getDrivingLicenseFileNum());
	    		pstmt.setString(19, driver.getCarNum());
	    		pstmt.setString(20, driver.getSingleDouble());
	    		pstmt.executeUpdate();
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}finally {
	    		if (rs != null) {
	    			 try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		}
	    		if (pstmt != null) {
	    			try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		}
	    		if (conn != null) {
//	    			try {
						//conn.close();
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
	    		}
	    	}
	    }
	    
	    public static void editEXLtoDB(Driver driver)throws SQLException{
	    	pstmt=null;
	    	String sql="update driversinfo set name=?,sex=?,ID=?,birthDate=?,nation=?,education=?,politicsStatus=?,workPlace=?,phone=?,address=?,workType=?,workerDegreeTech=?,beginWorkDate=?,enterWorkPlaceDate=?,"
	    			+ "domicilePlace=?,postalcode=?,drivingLicenseFileNum=?,carNum=?,singleDouble=? where employeeCardNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1,driver.getName());
	    		pstmt.setString(2, driver.getSex());
	    		pstmt.setString(3,driver.getID());
	    		pstmt.setString(4, driver.getBirthDate());
	    		pstmt.setString(5, driver.getNation());
	    		pstmt.setString(6, driver.getEducation());
	    		pstmt.setString(7, driver.getPoliticsStatus());
	    		pstmt.setString(8, driver.getWorkPlace());
	    		pstmt.setString(9, driver.getPhone());
	    		pstmt.setString(10, driver.getAddress());
	    		pstmt.setString(11, driver.getWorkType());
	    		pstmt.setString(12, driver.getWorkerDegreeTech());
	    		pstmt.setString(13, driver.getBeginWorkDate());
	    		pstmt.setString(14, driver.getEnterWorkPlaceDate());
	    		pstmt.setString(15, driver.getDomicilePlace());
	    		pstmt.setString(16, driver.getPostalcode());
	    		pstmt.setString(17, driver.getDrivingLicenseFileNum());
	    		pstmt.setString(18, driver.getCarNum());
	    		pstmt.setString(19, driver.getSingleDouble());
	    		pstmt.setString(20,driver.getEmployeeCardNum());
	    		pstmt.executeUpdate();
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}finally {
	    		if (rs != null) {
	    			 try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		}
	    		if (pstmt != null) {
	    			try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		}
	    		if (conn != null) {
//	    			try {
//						//conn.close();
//					} catch (SQLException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//					}
	    		}
	    	}
	    }
	    
	    public void addBasicInfo(String employeeCardNum,String name,String sex,String ID,String birthDate,
	    		String nation,String education,String politicsStatus,String workPlace,String phone,String address,
	    		String workType,String workerDegreeTech,String beginWorkDate,String enterWorkPlaceDate,
	    		String domicilePlace,String postalcode,String drivingLicenseFileNum,String carNum,String singleDouble)throws Exception{
	    	pstmt=null;
	    	String sql="insert into driversinfo(employeeCardNum,name,sex,ID,birthDate,nation,education,politicsStatus,workPlace,phone,address,workType,"
	    			+ "workerDegreeTech,beginWorkDate,enterWorkPlaceDate,domicilePlace,postalcode,drivingLicenseFileNum,carNum,singleDouble)"
	    			+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1,employeeCardNum);
	    		pstmt.setString(2,name);
	    		pstmt.setString(3,sex);
	    		pstmt.setString(4,ID);
	    		pstmt.setString(5,birthDate);
	    		pstmt.setString(6,nation);
	    		pstmt.setString(7,education);
	    		pstmt.setString(8,politicsStatus);
	    		pstmt.setString(9,workPlace);
	    		pstmt.setString(10,phone);
	    		pstmt.setString(11,address);
	    		pstmt.setString(12,workType);
	    		pstmt.setString(13,workerDegreeTech);
	    		pstmt.setString(14,beginWorkDate);
	    		pstmt.setString(15,enterWorkPlaceDate);
	    		pstmt.setString(16,domicilePlace);
	    		pstmt.setString(17,postalcode);
	    		pstmt.setString(18,drivingLicenseFileNum);
	    		pstmt.setString(19,carNum);
	    		pstmt.setString(20,singleDouble);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public static boolean judgeBasicInfoCard(String employeeCardNum) throws Exception{
	    	String sql="SELECT * FROM driversinfo WHERE employeeCardNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1,employeeCardNum);
	    		rs=pstmt.executeQuery();
	    		if(rs.next()){
	    			return false;
	    		}else{
	    			return true;
	    		}
	    	}catch(Exception e){
	    		throw e;
	    	}
	    }
	    
	    public static boolean judgeBasicInfoCarNum(String carNum) throws Exception{
	    	String sql="SELECT * FROM driversinfo WHERE employeeCardNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1,carNum);
	    		rs=pstmt.executeQuery();
	    		if(rs.next()){
	    			return false;
	    		}else{
	    			return true;
	    		}
	    	}catch(Exception e){
	    		throw e;
	    	}
	    }
	    
	    public ResultSet queryBasicInfo(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from driversinfo where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryBasicInfoSum(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select count(*) from driversinfo where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryBasicInfoCard(String employeeCardNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from driversinfo where employeeCardNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, employeeCardNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public void editBasicInfo(String employeeCardNum,String name,String sex,String ID,String birthDate,
	    		String nation,String education,String politicsStatus,String workPlace,String phone,String address,
	    		String workType,String workerDegreeTech,String beginWorkDate,String enterWorkPlaceDate,
	    		String domicilePlace,String postalcode,String drivingLicenseFileNum,String carNum,String singleDouble)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update driversinfo set name=?,sex=?,ID=?,birthDate=?,nation=?,education=?,politicsStatus=?,workPlace=?,phone=?,address=?,workType=?,workerDegreeTech=?,beginWorkDate=?,enterWorkPlaceDate=?,"
	    			+ "domicilePlace=?,postalcode=?,drivingLicenseFileNum=?,carNum=?,singleDouble=? where employeeCardNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
	    		pstmt.setString(1,name);
	    		pstmt.setString(2,sex);
	    		pstmt.setString(3,ID);
	    		pstmt.setString(4,birthDate);
	    		pstmt.setString(5,nation);
	    		pstmt.setString(6,education);
	    		pstmt.setString(7,politicsStatus);
	    		pstmt.setString(8,workPlace);
	    		pstmt.setString(9,phone);
	    		pstmt.setString(10,address);
	    		pstmt.setString(11,workType);
	    		pstmt.setString(12,workerDegreeTech);
	    		pstmt.setString(13,beginWorkDate);
	    		pstmt.setString(14,enterWorkPlaceDate);
	    		pstmt.setString(15,domicilePlace);
	    		pstmt.setString(16,postalcode);
	    		pstmt.setString(17,drivingLicenseFileNum);
	    		pstmt.setString(18,carNum);
	    		pstmt.setString(19,singleDouble);
	    		pstmt.setString(20,employeeCardNum);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteBasicInfo(String[] IDs)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from driversinfo where employeeCardNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		for(int i=0;i<IDs.length;i++){
	    			pstmt.setString(1, IDs[i]);
	    			pstmt.execute();
	    		}
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public ResultSet queryCaptain(String workPlace)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from driversinfo where workPlace=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, workPlace);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryCaptainSum(String workPlace)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select count(*) from driversinfo where workPlace=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, workPlace);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet execute(String sql)throws Exception{
	    	rs=null;
	    	try{
	    		Class.forName(driverName);
	    		//conn=DriverManager.getConnection(urls);
	    		stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	    		rs=stmt.executeQuery(sql);
	    	}catch(SQLException e){
	    		throw e;
	    	}
	    	return rs;
	    }
	    
	    public void addTrafficViolation(String name,String carNum,String violationTime,String violationLocation,String violationPlot)throws Exception{
	    	pstmt=null;
	    	String sql="insert into trafficViolation(name,carNum,violationTime,violationLocation,violationPlot)values(?,?,?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, violationTime);
	    		pstmt.setString(4, violationLocation);
	    		pstmt.setString(5, violationPlot);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void addTrafficViolationRemind(String name,String carNum,String violationTime,String violationLocation,String violationPlot)throws Exception{
	    	pstmt=null;
	    	String sql="insert into trafficViolationRemind(name,carNum,violationTime,violationLocation,violationPlot)values(?,?,?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, violationTime);
	    		pstmt.setString(4, violationLocation);
	    		pstmt.setString(5, violationPlot);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public ResultSet queryTrafficViolation(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from trafficViolation where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryTrafficViolationRemind(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from trafficViolationRemind where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryTrafficViolationSum(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select count(*) from trafficViolation where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryTrafficViolationID(int ID)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from trafficViolation where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setInt(1, ID);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public void editTrafficViolation(int ID,String name,String carNum,String violationTime,String violationLocation,String violationPlot)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update trafficViolation set name=?,carNum=?,violationTime=?,violationLocation=?,violationPlot=? where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, violationTime);
	    		pstmt.setString(4, violationLocation);
	    		pstmt.setString(5, violationPlot);
	    		pstmt.setInt(6, ID);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void editTrafficViolationRemind(int ID,String name,String carNum,String violationTime,String violationLocation,String violationPlot)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update trafficViolationRemind set name=?,carNum=?,violationTime=?,violationLocation=?,violationPlot=? where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, violationTime);
	    		pstmt.setString(4, violationLocation);
	    		pstmt.setString(5, violationPlot);
	    		pstmt.setInt(6, ID);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteTrafficViolation(int[] IDs)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from trafficViolation where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		for(int i=0;i<IDs.length;i++){
	    			pstmt.setInt(1, IDs[i]);
	    			pstmt.execute();
	    		}
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteTrafficViolationRemind(int[] IDs)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from trafficViolationRemind where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		for(int i=0;i<IDs.length;i++){
	    			pstmt.setInt(1, IDs[i]);
	    			pstmt.execute();
	    		}
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteTrafficViolation2(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from trafficViolation where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
	    			pstmt.setString(1, name);
	    			pstmt.setString(2, carNum);
	    			pstmt.execute();	    		
	    		    pstmt.close();
	    		    //conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteTrafficViolationRemind2(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from trafficViolationRemind where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
	    			pstmt.setString(1, name);
	    			pstmt.setString(2, carNum);
	    			pstmt.execute();	    		
	    		    pstmt.close();
	    		    //conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void addTrafficAccident(String name,String carNum,String accidentTime,String accidentLocation,String accidentPlot,String accidentReason,String accidentLoss,String strongInsuranceReimburseSum,String threeInsuranceReimburseSum,String companyBurdenSum,String dirverBurdenSum)throws Exception{
	    	pstmt=null;
	    	String sql="insert into trafficAccident(name,carNum,accidentTime,accidentLocation,accidentPlot,accidentReason,accidentLoss,strongInsuranceReimburseSum,threeInsuranceReimburseSum,companyBurdenSum,dirverBurdenSum)values(?,?,?,?,?,?,?,?,?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, accidentTime);
	    		pstmt.setString(4, accidentLocation);
	    		pstmt.setString(5, accidentPlot);
	    		pstmt.setString(6, accidentReason);
	    		pstmt.setString(7, accidentLoss);
	    		pstmt.setString(8, strongInsuranceReimburseSum);
	    		pstmt.setString(9, threeInsuranceReimburseSum);
	    		pstmt.setString(10, companyBurdenSum);
	    		pstmt.setString(11, dirverBurdenSum);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void addTrafficAccidentRemind(String name,String carNum,String accidentTime,String accidentLocation,String accidentPlot,String accidentReason,String accidentLoss,String strongInsuranceReimburseSum,String threeInsuranceReimburseSum,String companyBurdenSum,String dirverBurdenSum)throws Exception{
	    	pstmt=null;
	    	String sql="insert into trafficAccidentRemind(name,carNum,accidentTime,accidentLocation,accidentPlot,accidentReason,accidentLoss,strongInsuranceReimburseSum,threeInsuranceReimburseSum,companyBurdenSum,dirverBurdenSum)values(?,?,?,?,?,?,?,?,?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, accidentTime);
	    		pstmt.setString(4, accidentLocation);
	    		pstmt.setString(5, accidentPlot);
	    		pstmt.setString(6, accidentReason);
	    		pstmt.setString(7, accidentLoss);
	    		pstmt.setString(8, strongInsuranceReimburseSum);
	    		pstmt.setString(9, threeInsuranceReimburseSum);
	    		pstmt.setString(10, companyBurdenSum);
	    		pstmt.setString(11, dirverBurdenSum);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public ResultSet queryTrafficAccident(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from trafficAccident where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryTrafficAccidentRemind(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from trafficAccidentRemind where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryTrafficAccidentSum(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select count(*) from trafficAccident where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryTrafficAccidentID(int ID)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from trafficAccident where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setInt(1, ID);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public void editTrafficAccident(int ID,String name,String carNum,String accidentTime,String accidentLocation,String accidentPlot,String accidentReason,String accidentLoss,String strongInsuranceReimburseSum,String threeInsuranceReimburseSum,String companyBurdenSum,String dirverBurdenSum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update trafficAccident set name=?,carNum=?,accidentTime=?,accidentLocation=?,accidentPlot=?,accidentReason=?,accidentLoss=?,strongInsuranceReimburseSum=?,threeInsuranceReimburseSum=?,companyBurdenSum=?,dirverBurdenSum=? where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, accidentTime);
	    		pstmt.setString(4, accidentLocation);
	    		pstmt.setString(5, accidentPlot);
	    		pstmt.setString(6, accidentReason);
	    		pstmt.setString(7, accidentLoss);
	    		pstmt.setString(8, strongInsuranceReimburseSum);
	    		pstmt.setString(9, threeInsuranceReimburseSum);
	    		pstmt.setString(10, companyBurdenSum);
	    		pstmt.setString(11, dirverBurdenSum);
	    		pstmt.setInt(12, ID);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void editTrafficAccidentRemind(int ID,String name,String carNum,String accidentTime,String accidentLocation,String accidentPlot,String accidentReason,String accidentLoss,String strongInsuranceReimburseSum,String threeInsuranceReimburseSum,String companyBurdenSum,String dirverBurdenSum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update trafficAccidentRemind set name=?,carNum=?,accidentTime=?,accidentLocation=?,accidentPlot=?,accidentReason=?,accidentLoss=?,strongInsuranceReimburseSum=?,threeInsuranceReimburseSum=?,companyBurdenSum=?,dirverBurdenSum=? where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, accidentTime);
	    		pstmt.setString(4, accidentLocation);
	    		pstmt.setString(5, accidentPlot);
	    		pstmt.setString(6, accidentReason);
	    		pstmt.setString(7, accidentLoss);
	    		pstmt.setString(8, strongInsuranceReimburseSum);
	    		pstmt.setString(9, threeInsuranceReimburseSum);
	    		pstmt.setString(10, companyBurdenSum);
	    		pstmt.setString(11, dirverBurdenSum);
	    		pstmt.setInt(12, ID);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteTrafficAccident(int[] IDs)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from trafficAccident where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		for(int i=0;i<IDs.length;i++){
	    			pstmt.setInt(1, IDs[i]);
	    			pstmt.execute();
	    		}
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteTrafficAccidentRemind(int[] IDs)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from trafficAccidentRemind where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		for(int i=0;i<IDs.length;i++){
	    			pstmt.setInt(1, IDs[i]);
	    			pstmt.execute();
	    		}
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteTrafficAccident2(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from trafficAccident where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
	    			pstmt.setString(1, name);
	    			pstmt.setString(2, carNum);
	    			pstmt.execute();	    		
	    		    pstmt.close();
	    		    //conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteTrafficAccidentRemind2(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from trafficAccidentRemind where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
	    			pstmt.setString(1, name);
	    			pstmt.setString(2, carNum);
	    			pstmt.execute();	    		
	    		    pstmt.close();
	    		    //conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void addDynamicMonitor(String name,String carNum,String speedTime,String speedFourLevelTimes,String outGoingTime,String destination,String fatigueDrivingTime,String degree,String times)throws Exception{
	    	pstmt=null;
	    	String sql="insert into dynamicMonitor(name,carNum,speedTime,speedFourLevelTimes,outGoingTime,destination,fatigueDrivingTime,degree,times)values(?,?,?,?,?,?,?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, speedTime);
	    		pstmt.setString(4, speedFourLevelTimes);
	    		pstmt.setString(5, outGoingTime);
	    		pstmt.setString(6, destination);
	    		pstmt.setString(7, fatigueDrivingTime);
	    		pstmt.setString(8, degree);
	    		pstmt.setString(9, times);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void addDynamicMonitorRemind(String name,String carNum,String speedTime,String speedFourLevelTimes,String outGoingTime,String destination,String fatigueDrivingTime,String degree,String times)throws Exception{
	    	pstmt=null;
	    	String sql="insert into dynamicMonitorRemind(name,carNum,speedTime,speedFourLevelTimes,outGoingTime,destination,fatigueDrivingTime,degree,times)values(?,?,?,?,?,?,?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, speedTime);
	    		pstmt.setString(4, speedFourLevelTimes);
	    		pstmt.setString(5, outGoingTime);
	    		pstmt.setString(6, destination);
	    		pstmt.setString(7, fatigueDrivingTime);
	    		pstmt.setString(8, degree);
	    		pstmt.setString(9, times);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public ResultSet queryDynamicMonitor(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from dynamicMonitor where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryDynamicMonitorRemind(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from dynamicMonitorRemind where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryDynamicMonitorSum(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select count(*) from dynamicMonitor where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryDynamicMonitorID(int ID)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from dynamicMonitor where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setInt(1, ID);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public void editDynamicMonitor(int ID,String name,String carNum,String speedTime,String speedFourLevelTimes,String outGoingTime,String destination,String fatigueDrivingTime,String degree,String times)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update dynamicMonitor set name=?,carNum=?,speedTime=?,speedFourLevelTimes=?,outGoingTime=?,destination=?,fatigueDrivingTime=?,degree=?,times=? where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, speedTime);
	    		pstmt.setString(4, speedFourLevelTimes);
	    		pstmt.setString(5, outGoingTime);
	    		pstmt.setString(6, destination);
	    		pstmt.setString(7, fatigueDrivingTime);
	    		pstmt.setString(8, degree);
	    		pstmt.setString(9, times);
	    		pstmt.setInt(10, ID);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void editDynamicMonitorRemind(int ID,String name,String carNum,String speedTime,String speedFourLevelTimes,String outGoingTime,String destination,String fatigueDrivingTime,String degree,String times)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update dynamicMonitorRemind set name=?,carNum=?,speedTime=?,speedFourLevelTimes=?,outGoingTime=?,destination=?,fatigueDrivingTime=?,degree=?,times=? where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, speedTime);
	    		pstmt.setString(4, speedFourLevelTimes);
	    		pstmt.setString(5, outGoingTime);
	    		pstmt.setString(6, destination);
	    		pstmt.setString(7, fatigueDrivingTime);
	    		pstmt.setString(8, degree);
	    		pstmt.setString(9, times);
	    		pstmt.setInt(10, ID);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteDynamicMonitor(int[] IDs)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from dynamicMonitor where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		for(int i=0;i<IDs.length;i++){
	    			pstmt.setInt(1, IDs[i]);
	    			pstmt.execute();
	    		}
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteDynamicMonitorRemind(int[] IDs)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from dynamicMonitorRemind where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		for(int i=0;i<IDs.length;i++){
	    			pstmt.setInt(1, IDs[i]);
	    			pstmt.execute();
	    		}
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteDynamicMonitor2(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from dynamicMonitor where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
	    			pstmt.setString(1, name);
	    			pstmt.setString(2, carNum);
	    			pstmt.execute();	    		
	    		    pstmt.close();
	    		    //conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteDynamicMonitorRemind2(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from dynamicMonitorRemind where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
	    			pstmt.setString(1, name);
	    			pstmt.setString(2, carNum);
	    			pstmt.execute();	    		
	    		    pstmt.close();
	    		    //conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void addICcardData(String name,String carNum,String ICdate,String monthIncomeTopTen,String monthIncomeBottomTen,String monthWorkTimeExceed,String monthRunKmExceed)throws Exception{
	    	pstmt=null;
	    	String sql="insert into ICcardData(name,carNum,ICdate,monthIncomeTopTen,monthIncomeBottomTen,monthWorkTimeExceed,monthRunKmExceed)values(?,?,?,?,?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, ICdate);
	    		pstmt.setString(4, monthIncomeTopTen);
	    		pstmt.setString(5, monthIncomeBottomTen);
	    		pstmt.setString(6, monthWorkTimeExceed);
	    		pstmt.setString(7, monthRunKmExceed);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void addICcardDataRemind(String name,String carNum,String ICdate,String monthIncomeTopTen,String monthIncomeBottomTen,String monthWorkTimeExceed,String monthRunKmExceed)throws Exception{
	    	pstmt=null;
	    	String sql="insert into ICcardDataRemind(name,carNum,ICdate,monthIncomeTopTen,monthIncomeBottomTen,monthWorkTimeExceed,monthRunKmExceed)values(?,?,?,?,?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, ICdate);
	    		pstmt.setString(4, monthIncomeTopTen);
	    		pstmt.setString(5, monthIncomeBottomTen);
	    		pstmt.setString(6, monthWorkTimeExceed);
	    		pstmt.setString(7, monthRunKmExceed);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public ResultSet queryICcardData(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from ICcardData where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryICcardDataRemind(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from ICcardDataRemind where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryICcardDataSum(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select count(*) from ICcardData where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryICcardDataID(int ID)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from ICcardData where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setInt(1, ID);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public void editICcardData(int ID,String name,String carNum,String ICdate,String monthIncomeTopTen,String monthIncomeBottomTen,String monthWorkTimeExceed,String monthRunKmExceed)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update ICcardData set name=?,carNum=?,ICdate=?,monthIncomeTopTen=?,monthIncomeBottomTen=?,monthWorkTimeExceed=?,monthRunKmExceed=? where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, ICdate);
	    		pstmt.setString(4, monthIncomeTopTen);
	    		pstmt.setString(5, monthIncomeBottomTen);
	    		pstmt.setString(6, monthWorkTimeExceed);
	    		pstmt.setString(7, monthRunKmExceed);
	    		pstmt.setInt(8, ID);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void editICcardDataRemind(int ID,String name,String carNum,String ICdate,String monthIncomeTopTen,String monthIncomeBottomTen,String monthWorkTimeExceed,String monthRunKmExceed)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update ICcardDataRemind set name=?,carNum=?,ICdate=?,monthIncomeTopTen=?,monthIncomeBottomTen=?,monthWorkTimeExceed=?,monthRunKmExceed=? where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, ICdate);
	    		pstmt.setString(4, monthIncomeTopTen);
	    		pstmt.setString(5, monthIncomeBottomTen);
	    		pstmt.setString(6, monthWorkTimeExceed);
	    		pstmt.setString(7, monthRunKmExceed);
	    		pstmt.setInt(8, ID);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteICcardData(int[] IDs)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from ICcardData where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		for(int i=0;i<IDs.length;i++){
	    			pstmt.setInt(1, IDs[i]);
	    			pstmt.execute();
	    		}
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteICcardDataRemind(int[] IDs)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from ICcardDataRemind where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		for(int i=0;i<IDs.length;i++){
	    			pstmt.setInt(1, IDs[i]);
	    			pstmt.execute();
	    		}
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteICcardData2(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from ICcardData where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
	    			pstmt.setString(1, name);
	    			pstmt.setString(2, carNum);
	    			pstmt.execute();	    		
	    		    pstmt.close();
	    		    //conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteICcardDataRemind2(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from ICcardDataRemind where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
	    			pstmt.setString(1, name);
	    			pstmt.setString(2, carNum);
	    			pstmt.execute();	    		
	    		    pstmt.close();
	    		    //conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void addTrainRecord(String name,String carNum,String unjoinTrainTime)throws Exception{
	    	pstmt=null;
	    	String sql="insert into trainRecord(name,carNum,unjoinTrainTime)values(?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, unjoinTrainTime);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void addTrainRecordRemind(String name,String carNum,String unjoinTrainTime)throws Exception{
	    	pstmt=null;
	    	String sql="insert into trainRecordRemind(name,carNum,unjoinTrainTime)values(?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, unjoinTrainTime);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public ResultSet queryTrainRecord(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from trainRecord where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryTrainRecordRemind(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from trainRecordRemind where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryTrainRecordSum(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select count(*) from trainRecord where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryTrainRecordID(int ID)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from trainRecord where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setInt(1, ID);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public void editTrainRecord(int ID,String name,String carNum,String unjoinTrainTime)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update trainRecord set name=?,carNum=?,unjoinTrainTime=? where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, unjoinTrainTime);
	    		pstmt.setInt(4, ID);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void editTrainRecordRemind(int ID,String name,String carNum,String unjoinTrainTime)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update trainRecordRemind set name=?,carNum=?,unjoinTrainTime=? where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, unjoinTrainTime);
	    		pstmt.setInt(4, ID);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteTrainRecord(int[] IDs)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from trainRecord where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		for(int i=0;i<IDs.length;i++){
	    			pstmt.setInt(1, IDs[i]);
	    			pstmt.execute();
	    		}
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteTrainRecordRemind(int[] IDs)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from trainRecordRemind where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		for(int i=0;i<IDs.length;i++){
	    			pstmt.setInt(1, IDs[i]);
	    			pstmt.execute();
	    		}
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteTrainRecord2(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from trainRecord where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
	    			pstmt.setString(1, name);
	    			pstmt.setString(2, carNum);
	    			pstmt.execute();	    		
	    		    pstmt.close();
	    		    //conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteTrainRecordRemind2(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from trainRecordRemind where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
	    			pstmt.setString(1, name);
	    			pstmt.setString(2, carNum);
	    			pstmt.execute();	    		
	    		    pstmt.close();
	    		    //conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void addService(String name,String carNum,String complaintTime,String complaintPlot,String serviceDisciplineTime,String serviceDisciplinePlot)throws Exception{
	    	pstmt=null;
	    	String sql="insert into service(name,carNum,complaintTime,complaintPlot,serviceDisciplineTime,serviceDisciplinePlot)values(?,?,?,?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, complaintTime);
	    		pstmt.setString(4, complaintPlot);
	    		pstmt.setString(5, serviceDisciplineTime);
	    		pstmt.setString(6, serviceDisciplinePlot);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void addServiceRemind(String name,String carNum,String complaintTime,String complaintPlot,String serviceDisciplineTime,String serviceDisciplinePlot)throws Exception{
	    	pstmt=null;
	    	String sql="insert into serviceRemind(name,carNum,complaintTime,complaintPlot,serviceDisciplineTime,serviceDisciplinePlot)values(?,?,?,?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, complaintTime);
	    		pstmt.setString(4, complaintPlot);
	    		pstmt.setString(5, serviceDisciplineTime);
	    		pstmt.setString(6, serviceDisciplinePlot);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public ResultSet queryService(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from service where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryServiceRemind(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from serviceRemind where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryServiceSum(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select count(*) from service where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryServiceID(int ID)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from service where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setInt(1, ID);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public void editService(int ID,String name,String carNum,String complaintTime,String complaintPlot,String serviceDisciplineTime,String serviceDisciplinePlot)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update service set name=?,carNum=?,complaintTime=?,complaintPlot=?,serviceDisciplineTime=?,serviceDisciplinePlot=? where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, complaintTime);
	    		pstmt.setString(4, complaintPlot);
	    		pstmt.setString(5, serviceDisciplineTime);
	    		pstmt.setString(6, serviceDisciplinePlot);
	    		pstmt.setInt(7, ID);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void editServiceRemind(int ID,String name,String carNum,String complaintTime,String complaintPlot,String serviceDisciplineTime,String serviceDisciplinePlot)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update serviceRemind set name=?,carNum=?,complaintTime=?,complaintPlot=?,serviceDisciplineTime=?,serviceDisciplinePlot=? where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, complaintTime);
	    		pstmt.setString(4, complaintPlot);
	    		pstmt.setString(5, serviceDisciplineTime);
	    		pstmt.setString(6, serviceDisciplinePlot);
	    		pstmt.setInt(7, ID);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteService(int[] IDs)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from service where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		for(int i=0;i<IDs.length;i++){
	    			pstmt.setInt(1, IDs[i]);
	    			pstmt.execute();
	    		}
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteServiceRemind(int[] IDs)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from serviceRemind where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		for(int i=0;i<IDs.length;i++){
	    			pstmt.setInt(1, IDs[i]);
	    			pstmt.execute();
	    		}
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteService2(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from service where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
	    			pstmt.setString(1, name);
	    			pstmt.setString(2, carNum);
	    			pstmt.execute();	    		
	    		    pstmt.close();
	    		    //conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteServiceRemind2(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from serviceRemind where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
	    			pstmt.setString(1, name);
	    			pstmt.setString(2, carNum);
	    			pstmt.execute();	    		
	    		    pstmt.close();
	    		    //conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void addTechnology(String name,String carNum,String noRuleMaintainTime,String noRuleMaintainKm)throws Exception{
	    	pstmt=null;
	    	String sql="insert into technology(name,carNum,noRuleMaintainTime,noRuleMaintainKm)values(?,?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, noRuleMaintainTime);
	    		pstmt.setString(4, noRuleMaintainKm);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void addTechnologyRemind(String name,String carNum,String noRuleMaintainTime,String noRuleMaintainKm)throws Exception{
	    	pstmt=null;
	    	String sql="insert into technologyRemind(name,carNum,noRuleMaintainTime,noRuleMaintainKm)values(?,?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, noRuleMaintainTime);
	    		pstmt.setString(4, noRuleMaintainKm);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public ResultSet queryTechnology(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from technology where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryTechnologyRemind(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from technologyRemind where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryTechnologySum(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select count(*) from technology where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryTechnologyID(int ID)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from technology where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setInt(1, ID);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public void editTechnology(int ID,String name,String carNum,String noRuleMaintainTime,String noRuleMaintainKm)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update technology set name=?,carNum=?,noRuleMaintainTime=?,noRuleMaintainKm=? where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, noRuleMaintainTime);
	    		pstmt.setString(4, noRuleMaintainKm);
	    		pstmt.setInt(5, ID);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void editTechnologyRemind(int ID,String name,String carNum,String noRuleMaintainTime,String noRuleMaintainKm)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update technologyRemind set name=?,carNum=?,noRuleMaintainTime=?,noRuleMaintainKm=? where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, noRuleMaintainTime);
	    		pstmt.setString(4, noRuleMaintainKm);
	    		pstmt.setInt(5, ID);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteTechnology(int[] IDs)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from technology where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		for(int i=0;i<IDs.length;i++){
	    			pstmt.setInt(1, IDs[i]);
	    			pstmt.execute();
	    		}
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteTechnologyRemind(int[] IDs)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from technologyRemind where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		for(int i=0;i<IDs.length;i++){
	    			pstmt.setInt(1, IDs[i]);
	    			pstmt.execute();
	    		}
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteTechnology2(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from technology where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
	    			pstmt.setString(1, name);
	    			pstmt.setString(2, carNum);
	    			pstmt.execute();	    		
	    		    pstmt.close();
	    		    //conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteTechnologyRemind2(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from technologyRemind where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
	    			pstmt.setString(1, name);
	    			pstmt.setString(2, carNum);
	    			pstmt.execute();	    		
	    		    pstmt.close();
	    		    //conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void addFinance(String name,String carNum,String postponePayDate,String postponeDays,String overdueFine)throws Exception{
	    	pstmt=null;
	    	String sql="insert into finance(name,carNum,postponePayDate,postponeDays,overdueFine)values(?,?,?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, postponePayDate);
	    		pstmt.setString(4, postponeDays);
	    		pstmt.setString(5, overdueFine);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void addFinanceRemind(String name,String carNum,String postponePayDate,String postponeDays,String overdueFine)throws Exception{
	    	pstmt=null;
	    	String sql="insert into financeRemind(name,carNum,postponePayDate,postponeDays,overdueFine)values(?,?,?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, postponePayDate);
	    		pstmt.setString(4, postponeDays);
	    		pstmt.setString(5, overdueFine);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public ResultSet queryFinance(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from finance where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryFinanceRemind(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from financeRemind where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryFinanceSum(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select count(*) from finance where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryFinanceID(int ID)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from finance where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setInt(1, ID);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public void editFinance(int ID,String name,String carNum,String postponePayDate,String postponeDays,String overdueFine)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update finance set name=?,carNum=?,postponePayDate=?,postponeDays=?,overdueFine=? where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, postponePayDate);
	    		pstmt.setString(4, postponeDays);
	    		pstmt.setString(5, overdueFine);
	    		pstmt.setInt(6, ID);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void editFinanceRemind(int ID,String name,String carNum,String postponePayDate,String postponeDays,String overdueFine)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update financeRemind set name=?,carNum=?,postponePayDate=?,postponeDays=?,overdueFine=? where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, postponePayDate);
	    		pstmt.setString(4, postponeDays);
	    		pstmt.setString(5, overdueFine);
	    		pstmt.setInt(6, ID);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteFinance(int[] IDs)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from finance where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		for(int i=0;i<IDs.length;i++){
	    			pstmt.setInt(1, IDs[i]);
	    			pstmt.execute();
	    		}
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteFinanceRemind(int[] IDs)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from financeRemind where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		for(int i=0;i<IDs.length;i++){
	    			pstmt.setInt(1, IDs[i]);
	    			pstmt.execute();
	    		}
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteFinance2(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from finance where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
    			pstmt.setString(1, name);
    			pstmt.setString(2, carNum);
    			pstmt.execute();	    		
    		    pstmt.close();
    		    //conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteFinanceRemind2(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from financeRemind where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
	    			pstmt.setString(1, name);
	    			pstmt.setString(2, carNum);
	    			pstmt.execute();	    		
	    		    pstmt.close();
	    		    //conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void addLabour(String name,String carNum,String inHospitalTime,String diseaseCause,String yearMedicalTwiceReimburse)throws Exception{
	    	pstmt=null;
	    	String sql="insert into labour(name,carNum,inHospitalTime,diseaseCause,yearMedicalTwiceReimburse)values(?,?,?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, inHospitalTime);
	    		pstmt.setString(4, diseaseCause);
	    		pstmt.setString(5, yearMedicalTwiceReimburse);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void addLabourRemind(String name,String carNum,String inHospitalTime,String diseaseCause,String yearMedicalTwiceReimburse)throws Exception{
	    	pstmt=null;
	    	String sql="insert into labourRemind(name,carNum,inHospitalTime,diseaseCause,yearMedicalTwiceReimburse)values(?,?,?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, inHospitalTime);
	    		pstmt.setString(4, diseaseCause);
	    		pstmt.setString(5, yearMedicalTwiceReimburse);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public ResultSet queryLabour(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from labour where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryLabourRemind(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from labourRemind where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryLabourSum(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select count(*) from labour where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public ResultSet queryLabourID(int ID)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from labour where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setInt(1, ID);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public void editLabour(int ID,String name,String carNum,String inHospitalTime,String diseaseCause,String yearMedicalTwiceReimburse)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update labour set name=?,carNum=?,inHospitalTime=?,diseaseCause=?,yearMedicalTwiceReimburse=? where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, inHospitalTime);
	    		pstmt.setString(4, diseaseCause);
	    		pstmt.setString(5, yearMedicalTwiceReimburse);
	    		pstmt.setInt(6, ID);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void editLabourRemind(int ID,String name,String carNum,String inHospitalTime,String diseaseCause,String yearMedicalTwiceReimburse)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update labourRemind set name=?,carNum=?,inHospitalTime=?,diseaseCause=?,yearMedicalTwiceReimburse=? where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		pstmt.setString(3, inHospitalTime);
	    		pstmt.setString(4, diseaseCause);
	    		pstmt.setString(5, yearMedicalTwiceReimburse);
	    		pstmt.setInt(6, ID);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteLabour(int[] IDs)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from labour where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		for(int i=0;i<IDs.length;i++){
	    			pstmt.setInt(1, IDs[i]);
	    			pstmt.execute();
	    		}
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteLabourRemind(int[] IDs)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from labourRemind where ID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		for(int i=0;i<IDs.length;i++){
	    			pstmt.setInt(1, IDs[i]);
	    			pstmt.execute();
	    		}
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteLabour2(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from labour where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
	    			pstmt.setString(1, name);
	    			pstmt.setString(2, carNum);
	    			pstmt.execute();	    		
	    		    pstmt.close();
	    		    //conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteLabourRemind2(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from labourRemind where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
	    			pstmt.setString(1, name);
	    			pstmt.setString(2, carNum);
	    			pstmt.execute();	    		
	    		    pstmt.close();
	    		    //conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public String findEmployeeCardNum(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String employeeCardNum="";
	    	String sql="select * from driversInfo where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	while(rs.next()){
	    		employeeCardNum=rs.getString("employeeCardNum");
    		}
	    	pstmt.close();
    		//conn.close();
	    	return employeeCardNum;
	    }
	    
	    public void addAdminInfo(String userName,String userPassword,String userType,String captainNum)throws Exception{
	    	pstmt=null;
	    	String sql="insert into user(userName,userPassword,userType,captainNum)values(?,?,?,?)";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, userName);
	    		pstmt.setString(2, userPassword);
	    		pstmt.setString(3, userType);
	    		pstmt.setString(4, captainNum);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public ResultSet queryAdminInfo(String userName,String userPassword,String userType)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="select * from user where userName=?"+"and userPassword=?"+"and userType=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, userName);
	    		pstmt.setString(2, userPassword);
	    		pstmt.setString(3, userType);
	    		rs=pstmt.executeQuery();
	    		
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return rs;
	    }
	    
	    public void editAdminInfo(int ID,String userName,String userPassword,String userType,String captainNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="update user set userName=?,userPassword=?,userType=?,captainNum=? where userID=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, userName);
	    		pstmt.setString(2, userPassword);
	    		pstmt.setString(3, userType);
	    		pstmt.setString(4, captainNum);
	    		pstmt.setInt(5, ID);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		//conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public void deleteAdminInfo(String userName,String userPassword)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String sql="delete from user where userName=?"+"and userPassword=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);	    		
	    			pstmt.setString(1, userName);
	    			pstmt.setString(2, userPassword);
	    			pstmt.execute();	    		
	    		    pstmt.close();
	    		    //conn.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    }
	    
	    public String queryCaptainNum(String userName,String userPassword)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String captainNum="";
	    	String sql="select * from user where userName=?"+"and userPassword=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, userName);
	    		pstmt.setString(2, userPassword);
	    		rs=pstmt.executeQuery();
	    		while(rs.next()){
	    		captainNum=rs.getString("captainNum");
	    		}
	    		pstmt.close();
    		    //conn.close();
    		    rs.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return captainNum;
	    }
	    
	    public String queryWorkplace(String name,String carNum)throws Exception{
	    	ResultSet rs=null;
	    	pstmt=null;
	    	String workPlace="";
	    	String sql="select * from driversinfo where name=?"+"and carNum=?";
	    	try{
	    		//Class.forName("com.mysql.jdbc.Driver"); 
	    		//conn=DriverManager.getConnection(urls);
	    		pstmt=conn.prepareStatement(sql);
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, carNum);
	    		rs=pstmt.executeQuery();
	    		while(rs.next()){
	    			workPlace=rs.getString("workPlace");
	    		}
	    		pstmt.close();
    		    //conn.close();
    		    rs.close();
	    	}catch(SQLException ex){
	    		throw ex;
	    	}
	    	return workPlace;
	    }
	    
	    public void close_all() throws Exception{
	    	if(pstmt!=null){
	    		try{
	    			pstmt.close();
	    		}catch(SQLException el){
	    			throw new Exception("close stmt Exception");
	    		}
	    	}
	    	if(conn!=null){
//	    		try{
//	    			//conn.close();
//	    		}catch(SQLException e){
//	    			throw new Exception("close stmt Exception");
//	    		}
	    	}
	    }
	    
	    
}
