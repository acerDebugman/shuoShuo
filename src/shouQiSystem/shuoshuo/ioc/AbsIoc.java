package shouQiSystem.shuoshuo.ioc;

import java.util.HashMap;
import java.util.Map;

import shouQiSystem.shuoshuo.ioc.annotations.IocBean;

public class AbsIoc implements Ioc {

	/**
	 * here allow other subclass to modify the container, is this ok ?
	 * but we don't use concurrentHashMap, this seems not good XXX
	 */
	protected Map<String, IocObject> iocMap = new HashMap<String, IocObject>();
	
	protected Class<?> annClass = IocBean.class;
	
	public AbsIoc(IocLoader iocLoader){
		initIocContainer(iocLoader);
	}
	
	@Override
	public Object get(String name) {
		//XXX 
		return null;
	}

	@Override
	public Object get(Class<?> type, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void initIocContainer(IocLoader iocLoader){
		iocLoader.analyseAnnotations(this);
	}

	@Override
	public Map<String, IocObject> getCacheMap() {
		return iocMap;
	}
	
}
