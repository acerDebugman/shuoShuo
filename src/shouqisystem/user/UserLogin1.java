package shouqisystem.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=new String(request.getParameter("userName").getBytes("iso-8859-1"),"utf-8");
        String userPassword=new String(request.getParameter("userPassword").getBytes("iso-8859-1"),"utf-8");
        String userType=new String(request.getParameter("userType").getBytes("iso-8859-1"),"utf-8");
        HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
		session.setAttribute("userPassword", userPassword);
		session.setAttribute("userType", userType);
        response.setContentType("text/html;charset=UTF-8");
        String s1 = response.encodeURL("captainMain.jsp");
        String s2 = response.encodeURL("sectionChiefMain.jsp");
        String s3 = response.encodeURL("managerMain.jsp");
        String[] results={userName,userPassword,userType};
        PrintWriter out = response.getWriter();
       
			
			try {

			String	result = (String)UserInfo.executeQuery(userName, userPassword, userType);
			if(result!=null&&result!=""){
				
			request.setAttribute("results", results);
			}
			RequestDispatcher disp=null;
			if (result.equals("error")){			
				out.print("<script>alert('用户名或密码错误！');window.location.href='http://localhost:8080/ShouQiSystem/login.jsp';</script>");
			}else{
				if(result.equals("captain")){
					 disp=request.getRequestDispatcher(s1);
				}
				else if(result.equals("sectionChief")){
					disp=request.getRequestDispatcher(s2);
				}
				else if(result.equals("manager")){
					disp=request.getRequestDispatcher(s3);
				}
				
			
			 disp.forward(request, response);

			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
