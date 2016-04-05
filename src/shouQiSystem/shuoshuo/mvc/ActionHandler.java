package shouQiSystem.shuoshuo.mvc;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionHandler {
	
	
	public ActionHandler(ServletConfig config){
		//loading data
		ShuoShuoLoading loader = new ShuoShuoLoading(config);
		loader.loading(config);//loading resources
	}

	
	public boolean doHandler(HttpServletRequest req, HttpServletResponse resp){
		
		return false;
	}
}
