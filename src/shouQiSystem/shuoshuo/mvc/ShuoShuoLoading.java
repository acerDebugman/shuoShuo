package shouQiSystem.shuoshuo.mvc;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;

import shouQiSystem.shuoshuo.ioc.Ioc;
import shouQiSystem.shuoshuo.ioc.IocObject;
import shouQiSystem.shuoshuo.ioc.annotations.At;
import shouQiSystem.shuoshuo.ioc.impl.ShuoShuoIoc;
import shouQiSystem.shuoshuo.ioc.loader.AnnotationIocLoader;
import shouQiSystem.shuoshuo.ioc.loader.ComboLoader;
import shouQiSystem.shuoshuo.ioc.loader.JsonLoader;
import shouQiSystem.shuoshuo.mvc.chainConfig.ActionChainMakerImpl;
import shouQiSystem.shuoshuo.util.MethodParamNamesScaner;
import shouQiSystem.shuoshuo.util.StringHandler;

public class ShuoShuoLoading {

	ServletConfig config;
	
	public ShuoShuoLoading(ServletConfig config){
		this.config = config;
	}
	
	public void loading(ServletConfig config){
		//0. main module analyze
		//default action chain
		
		//1. ioc object
		Ioc ioc = new ShuoShuoIoc(new ComboLoader(new AnnotationIocLoader(), new JsonLoader()));
		Mvcs.ioc = ioc;
		

		
		
//		evalUrlLoading(ioc);
		//2. url mapping
		Map<String, AtMap> urlMapping = new HashMap<String, AtMap>();
		AtMap atMap = null; 
		Map<String, IocObject> iocCacheMap = ioc.getCacheMap();
		for(Map.Entry<String, IocObject> entry : iocCacheMap.entrySet()){
			String key = entry.getKey();
			IocObject iocObj = entry.getValue();

			//3. class level url
			String classLevelUrl = "";
			String methodLevelUrl = "";
			//4. if there At anno for the class
			if(iocObj.type.isAnnotationPresent(At.class)){
				At at = iocObj.type.getAnnotation(At.class);
				if(at != null){
					classLevelUrl = at.value();
					//4.1 tell if classLevelUrl is empty 
					if(StringHandler.isNotEmpty(classLevelUrl))
						classLevelUrl = tidyUrlAddr(classLevelUrl);
				}
			}
			//5. iterate the methods
			Method[] methods = iocObj.type.getMethods();
			for(Method m : methods){
				if(m.isAnnotationPresent(At.class)){
					//5.1 analyse At annotation
					At at = m.getAnnotation(At.class);
					if(at != null){
						methodLevelUrl = tidyUrlAddr(at.value());
						if(StringHandler.isNotEmpty(methodLevelUrl)){
							//5.1.1 form a atMap
							atMap = new AtMap();
							atMap.iocName = StringHandler.lowerFirst(key);
							atMap.type = iocObj.type;
							atMap.method = m;
							atMap.url = classLevelUrl + methodLevelUrl;
							//5.1.2 get the method arguments
							Class<?>[] paramsTypes = m.getParameterTypes();
							List<String> paramsNames = MethodParamNamesScaner.getParamNames(m);
							Map<String, Class<?>> pairArgs = new HashMap<String, Class<?>>();
							for(int i = 0; i < paramsNames.size(); i++){
								pairArgs.put(paramsNames.get(i), paramsTypes[i]);
							}
							//5.1.3 put the AtMap into the urlMapping container 
							urlMapping.put(atMap.url, atMap);
						}
					}
					//XXX 5.2 analyze other annotation
					
				}
				
			}
		}
		
		//XXX test code, output urlmap addr
		
		
		
		//3.action chain processors initialization
		initialActionChain();
		
		
		//4. dao layer datasource loading
		
	}
	
	private void initialActionChain() {
		//1.read all chain from configuration file
		String path = "shouQiSystem/shuoshuo/mvc/chainConfig/mvc-chain.js";
		ActionChainMaker chainMaker = new ActionChainMakerImpl(path);
		List<ActionChain> actionChains = chainMaker.make();
		
		//2.initial action chain
		
		
		//3.put them into Mvcs
		
	}

	private void evalUrlLoading(Ioc ioc) {
		
	}

	/**
	 * tidy the url addr
	 * @param levelUrl
	 * @return
	 */
	private String tidyUrlAddr(String levelUrl) {
		//1. add '/' if there is no '/' prefix
		if(levelUrl.charAt(0) != '/'){
			levelUrl = "/" + levelUrl;
		}
		//2. if '/' is the ending char, then subtract it  
		if(levelUrl.endsWith("/")){
			levelUrl = levelUrl.substring(0, levelUrl.length());
		}
		
		return levelUrl;
	}

	public static void main(String[] args) {
//		Testa a = new Testa(new JsonLoader());
	}
}
