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
 * Servlet implementation class ManagerRemindServlet
 */
public class ManagerRemindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerRemindServlet() {
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
		String s1="captainDriverListRemind.jsp";
		try {
			userInfo.deleteManTrafficViolationRemind2(name, carNum);
			userInfo.deleteManTrafficAccidentRemind2(name, carNum);
			userInfo.deleteManDynamicMonitorRemind2(name, carNum);
			userInfo.deleteManICcardDataRemind2(name, carNum);
			userInfo.deleteManTrainRecordRemind2(name, carNum);
			userInfo.deleteManServiceRemind2(name, carNum);
			userInfo.deleteManTechnologyRemind2(name, carNum);
			userInfo.deleteManFinanceRemind2(name, carNum);
			userInfo.deleteManLabourRemind2(name, carNum);
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
