package shouqisystem.user;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;;

/**
 * Servlet implementation class ReadDriverEXL
 */
public class ReadDriverEXL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Driver driver=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadDriverEXL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filePath=new String(request.getParameter("importEXLFile"));
		System.out.println(filePath);
		ArrayList<Driver> list=readXls(filePath);
		PrintWriter out = response.getWriter();
		
		for(int i=0;i<list.size();i++){
			driver=list.get(i);
			boolean judge = false;
			try {
				judge = UserInfo.judgeEXLtoDB(driver);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(judge){
				try {
					UserInfo.EXLtoDB(driver);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				try {
					UserInfo.editEXLtoDB(driver);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		response.setCharacterEncoding("utf-8"); 
		out.print("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
		out.print("<script charset='utf-8' language='javascript'>alert('����˾����Ϣ�ɹ���');window.location.href='http://localhost:8080/ShouQiSystem/driversInfo.jsp';</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public ArrayList<Driver> readXls(String filePath) throws IOException{
		InputStream is=new FileInputStream(filePath);
		HSSFWorkbook hssfWorkbook=new HSSFWorkbook(is);
		Driver driver=null;
		ArrayList<Driver> list=new ArrayList<Driver>();
		
		for(int numSheet=0; numSheet<hssfWorkbook.getNumberOfSheets();numSheet++){
			HSSFSheet hssfSheet=hssfWorkbook.getSheetAt(numSheet);
			if(hssfSheet==null){
				continue;
			}
			
			for(int rowNum=1;rowNum<=hssfSheet.getLastRowNum();rowNum++){
				HSSFRow hssfRow=hssfSheet.getRow(rowNum);
				if(hssfRow!=null){
					driver=new Driver();
					HSSFCell employeeCardNum=hssfRow.getCell(0);	
					HSSFCell name=hssfRow.getCell(1);
					HSSFCell sex=hssfRow.getCell(2);
					HSSFCell ID=hssfRow.getCell(3);
					HSSFCell birthDate=hssfRow.getCell(4);
					HSSFCell nation=hssfRow.getCell(5);
					HSSFCell education=hssfRow.getCell(6);
					HSSFCell politicsStatus=hssfRow.getCell(7);
					HSSFCell workPlace=hssfRow.getCell(8);
					HSSFCell phone=hssfRow.getCell(9);
					HSSFCell address=hssfRow.getCell(10);
					HSSFCell workType=hssfRow.getCell(11);
					HSSFCell workerDegreeTech=hssfRow.getCell(12);
					HSSFCell beginWorkDate=hssfRow.getCell(13);
					HSSFCell enterWorkPlaceDate=hssfRow.getCell(14);
					HSSFCell domicilePlace=hssfRow.getCell(15);
					HSSFCell postalcode=hssfRow.getCell(16);
					HSSFCell drivingLicenseFileNum=hssfRow.getCell(17);
					HSSFCell carNum=hssfRow.getCell(18);
					HSSFCell singleDouble=hssfRow.getCell(19);
					
					driver.setEmployeeCardNum(getValue(employeeCardNum));
					driver.setName(getValue(name));
					driver.setSex(getValue(sex));
					driver.setID(getValue(ID));
					driver.setBirthDate(getValue(birthDate));
					driver.setNation(getValue(nation));
					driver.setEducation(getValue(education));
					driver.setPoliticsStatus(getValue(politicsStatus));
					driver.setWorkPlace(getValue(workPlace));
					driver.setPhone(getValue(phone));
					driver.setAddress(getValue(address));
					driver.setWorkType(getValue(workType));
					driver.setWorkerDegreeTech(getValue(workerDegreeTech));
					driver.setBeginWorkDate(getValue(beginWorkDate));
					driver.setEnterWorkPlaceDate(getValue(enterWorkPlaceDate));
					driver.setDomicilePlace(getValue(domicilePlace));
					driver.setPostalcode(getValue(postalcode));
					driver.setDrivingLicenseFileNum(getValue(drivingLicenseFileNum));
					driver.setCarNum(getValue(carNum));
					driver.setSingleDouble(getValue(singleDouble));
					
					list.add(driver);
				}
				System.out.println("********************************");
			}
			return list;
		}
		return list;
		
	}
	
	private String getValue(HSSFCell hssfCell){
	DecimalFormat df=new DecimalFormat("#");
	switch (hssfCell.getCellType()) {
	case HSSFCell.CELL_TYPE_NUMERIC:
		if(HSSFDateUtil.isCellDateFormatted(hssfCell)){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(sdf.format(HSSFDateUtil.getJavaDate(hssfCell.getNumericCellValue())).toString());
			return sdf.format(HSSFDateUtil.getJavaDate(hssfCell.getNumericCellValue())).toString();
		}
		System.out.println(df.format(hssfCell.getNumericCellValue()).toString());
		return df.format(hssfCell.getNumericCellValue()).toString();

	case HSSFCell.CELL_TYPE_STRING:
		System.out.println(hssfCell.getStringCellValue());
		return hssfCell.getStringCellValue();
	case HSSFCell.CELL_TYPE_FORMULA:
		return hssfCell.getCellFormula();
	case HSSFCell.CELL_TYPE_BLANK:
		return "";
	case HSSFCell.CELL_TYPE_BOOLEAN:
		return hssfCell.getBooleanCellValue() + "";
	case HSSFCell.CELL_TYPE_ERROR:
		return hssfCell.getErrorCellValue() + "";		
    }
	return "";
}

}
