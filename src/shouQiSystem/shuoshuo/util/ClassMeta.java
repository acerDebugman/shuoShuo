package shouQiSystem.shuoshuo.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class ClassMeta {

    public String type;
    public Map<String, List<String>> paramNames = new HashMap<String, List<String>>();
    public Map<String, Integer> methodLines = new HashMap<String, Integer>();
    
    public String toString() {
    	return JSON.toJSONString(this);  
    }
}
