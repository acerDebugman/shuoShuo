package shouQiSystem.shuoshuo.ioc;

public class IocObject {
	
	/**
	 * aop support
	 */
	public String events = "";
	
	/**
	 * object scope
	 */
	public String scope = "singleton";
	
	/**
	 * which class
	 */
	public Class<?> type;
	
	/**
	 * instance object
	 */
	public Object instanceObj;
	
	
	public void setType(Class<?> t){
		this.type = t;
	}

}
