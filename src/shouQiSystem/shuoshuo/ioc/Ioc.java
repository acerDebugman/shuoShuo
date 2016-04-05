package shouQiSystem.shuoshuo.ioc;

import java.util.Map;

public interface Ioc {

	public Object get(String name);
	
	public Object get(Class<?> type, String name);
	
	public Map<String, IocObject> getCacheMap();
	
}
