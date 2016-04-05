package shouQiSystem.shuoshuo.ioc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import shouQiSystem.shuoshuo.ioc.annotations.IocBean;
import shouQiSystem.shuoshuo.ioc.annotations.IocScope;
import shouQiSystem.shuoshuo.ioc.annotations.ScanPackage;
import shouQiSystem.shuoshuo.mvc.Mvcs;
import shouQiSystem.shuoshuo.util.ClassUtil;
import shouQiSystem.shuoshuo.util.StringHandler;

public abstract class IocLoader {

	public static List<Class<?>> list = new ArrayList<Class<?>>();

	public IocLoader(){
		init();
	}

	private void init() {
		//get scan package path
		Mvcs.scanPackagePath = analyseScanPath();
		if(StringHandler.isEmpty(Mvcs.scanPackagePath))
			throw new RuntimeException("No scan path has been set! you need to setup ScanPackage annotation");
		
		//put all class into the list
		List<String> allClassNames = scanAllClassNames();
		if(StringHandler.isEmpty(allClassNames)) //some loader may have no return value 
			return ;
		
		for(String pkgPath : allClassNames){
			list.add(ClassUtil.getClass(pkgPath));
		}
	}

	/***
	 * get scan path from ScanPackage annotation
	 * @return
	 */
	private String analyseScanPath() {
		//1. get main module from init params
		String mainModule = Mvcs.servletConfig.getInitParameter("mainModule");
		Class<?> cl = ClassUtil.getClass(mainModule);
		if(cl.isAnnotationPresent(ScanPackage.class)){
			ScanPackage ann = cl.getAnnotation(ScanPackage.class);
			//get annotation path value
			return ann.path();
		}
		//default return null
		return null;
	}

	/**
	 * get all class name
	 * @return
	 */
	public abstract List<String> scanAllClassNames(); 

	public abstract void test();

	/**
	 * set the ioc container
	 * @param ioc
	 */
	public void analyseAnnotations(AbsIoc ioc){
		//0. makeup a cache first
		Map<String, IocObject> cacheMap = new HashMap<String, IocObject>();
		IocObject iocObj = null;
		for(Class<?> cl : list){
			iocObj = new IocObject();
			iocObj.setType(cl);
			//1.tell if there is an IocBean 
			if(!cl.isAnnotationPresent(IocBean.class))
				continue ;
			//2.if have the class name
			IocBean bean = cl.getAnnotation(IocBean.class);
			if(StringHandler.isEmpty(bean))
				continue ;
			String className = bean.name();
			if(StringHandler.isEmpty(className))
				className = cl.getSimpleName(); //if no name has been set, then use simple name
			
			//3. scope properties, here only use default properties
			if(cl.isAnnotationPresent(IocScope.class)){
				IocScope scope = cl.getAnnotation(IocScope.class);
				String val = scope.value();
				//default is singleton
				if(StringHandler.isEmpty(val)) 
					val = "singleton"; 
				
				iocObj.scope = val.trim();
			}
			
			//4. initial a instance
			try {
				if(iocObj.scope.equals("singleton"))
					iocObj.instanceObj = cl.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} 
			//XXX later change to logger
			System.out.println("success load class: " + cl.getName());
			cacheMap.put(className, iocObj); 
		}
		
		//finally replace the map
		ioc.iocMap = cacheMap;
	}
	
	public static void main(String[] args) {
//		IocLoader ld = new AnnotationIocLoader();
		
		System.out.println(System.getProperty("user.dir")); 
	}
	
}