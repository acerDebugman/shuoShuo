package shouQiSystem.shuoshuo.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringHandler {
	
	/**
	 * tell if the object is empty
	 * @param obj
	 * @return 
	 */
	public static boolean isEmpty(Object obj){
		if(null == obj)
			return true;
		
		if(obj instanceof String)
			return ((String)obj).trim().equals("");
		if(obj instanceof Map)
			return ((Map<?, ?>)obj).isEmpty();
		if(obj instanceof List)
			return ((List<?>)obj).isEmpty();
		if(obj instanceof Set)
			return ((Set<?>)obj).isEmpty();
		
		return false;
	}

	public static boolean isNotEmpty(Object obj){
		return !isEmpty(obj);
	}
	
	/**
	 * tell if the String is empty
	 * @param cs
	 * @return
	 */
	public static boolean isBlank(CharSequence cs){
		if(cs == null)
			return true;
		
		int len = cs.length();
		for(int i = 0; i < len; i++){
			if(!Character.isWhitespace(cs.charAt(i)))
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("empty? : " + isEmpty("   "));
		System.out.println("empty? :|" + "   ".trim() + "|");
		System.out.println("empty? : " + isBlank("   "));
	}
	
}
