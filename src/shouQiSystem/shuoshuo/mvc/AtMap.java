package shouQiSystem.shuoshuo.mvc;

import java.lang.reflect.Method;
import java.util.Map;

public class AtMap {
	
	/**
	 * maping url
	 */
	public String url;
	
	/**
	 * class type
	 */
	public Class<?> type;
	
	/**
	 * mapping method
	 */
	public Method method;
	
	/**
	 * method arguments, 
	 * key: parameter name, value: parameter type
	 */
	public Map<String, Class<?>> args; 
	
	/**
	 * the name in ioc container, default is getClass().getSimpleName(); 
	 * use the name to find the object in ioc container, and then pass to method.invoke()
	 */
	public String iocName;

	/**
	 * http method, GET/POST/DELETE...,put the thing into actionInvoker
	 */
//	public String httpMethod;
}
