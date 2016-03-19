package shouqisystem.user;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RemindServlet
 */
public class RemindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name="";String carNum="";
		String[] kys=request.getParameterValues("pkey");
		String employeeCardNum=kys[0];
		HttpSession session = request.getSession();
		session.setAttribute("employeeCardNum", employeeCardNum);
		UserInfo userInfo = new UserInfo();
		try {
			ResultSet rs=userInfo.queryBasicInfoCard(employeeCardNum);
			while(rs.next()){
			name=rs.getString("name");
			carNum=rs.getString("carNum");
			}
			rs.close();
			userInfo.close_all();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		String s1="driverListRemind.jsp";
		try {
			userInfo.deleteTrafficViolationRemind2(name, carNum);
			userInfo.deleteTrafficAccidentRemind2(name, carNum);
			userInfo.deleteDynamicMonitorRemind2(name, carNum);
			userInfo.deleteICcardDataRemind2(name, carNum);
			userInfo.deleteTrainRecordRemind2(name, carNum);
			userInfo.deleteServiceRemind2(name, carNum);
			userInfo.deleteTechnologyRemind2(name, carNum);
			userInfo.deleteFinanceRemind2(name, carNum);
			userInfo.deleteLabourRemind2(name, carNum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=UTF-8");
	     String s = response.encodeURL(s1);
	     RequestDispatcher disp=null;
	     disp=request.getRequestDispatcher(s);
	     disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
