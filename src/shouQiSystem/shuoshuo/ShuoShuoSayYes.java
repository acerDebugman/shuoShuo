package shouQiSystem.shuoshuo;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shouQiSystem.shuoshuo.mvc.ActionHandler;
import shouQiSystem.shuoshuo.mvc.Mvcs;

public class ShuoShuoSayYes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ActionHandler actionHandler = null;
	
	public void init(ServletConfig config) throws ServletException {
		_init(config);
	}

	/**
	 * do initial job
	 * @param config
	 */
	private void _init(ServletConfig config) {
		//save servlet config
		Mvcs.servletConfig = config;
		
		//initail actionHandler
		actionHandler = new ActionHandler(config);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("jojo handler servie!");
		resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "error !");
		actionHandler.doHandler(req, resp);
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
		doGet(req, resp);
    }
	
	public void destroy() {
    }

}
