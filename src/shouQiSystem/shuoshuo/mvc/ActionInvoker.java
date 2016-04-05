package shouQiSystem.shuoshuo.mvc;

import java.util.HashMap;
import java.util.Map;

/**
 * every  
 * @author root
 *
 */
public class ActionInvoker {
	/**
	 * key: GET/POST/DELETE, value: ActionChain
	 */
	Map<String, ActionChain> httpMethodChainMap = new HashMap<String, ActionChain>(); 
	
	
	public boolean invoke(ActionContext ac, AtMap atMap){
		
		return true;
	}
}
