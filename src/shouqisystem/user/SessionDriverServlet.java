package shouqisystem.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDriverServlet
 */
public class SessionDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionDriverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String workPlace=new String(request.getParameter("workPlace").getBytes("iso-8859-1"),"utf-8");
		 String s1=new String(request.getParameter("URL").getBytes("iso-8859-1"),"utf-8");
		 HttpSession session = request.getSession();
		 session.setAttribute("workPlace", workPlace);
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
