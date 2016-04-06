package shouQiSystem.shuoshuo.mvc.chainConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import shouQiSystem.shuoshuo.util.Catchall;
import shouQiSystem.shuoshuo.util.ClassUtil;
import shouQiSystem.shuoshuo.util.StringHandler;

public class JsonActionChainMakerConfiguration {

	/**
	 * for all configurations
	 */
	Map<String, Map<String, Object>> map = new HashMap<String, Map<String, Object>>();
	
	/**
	 * 
	 * @param jsonPaths
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JsonActionChainMakerConfiguration(String...jsonPaths){
		for(String str : jsonPaths){
			System.out.println(str);
			//here conver the read stream to string manually
			String content = Catchall.readAll(new InputStreamReader(ClassUtil.getClassLoader().getResourceAsStream(str)));
			System.out.println("content : " + content);
			map.putAll((Map)JSON.parse(content));
		}
	}
	
	public Map<String, Map<String, Object>> getAll(){
		return map;
	}
	
	/**
	 * fetch processor list 
	 * @param chainName
	 * @param listName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getProcessList(String chainName, String listName){
		for(Map.Entry<String, Map<String, Object>> entry : map.entrySet()){
			if(entry.getKey().equals(chainName.trim())){
				Map<String, Object> val = entry.getValue();
				return (List<String>)val.get(listName);
			}
		}
		return (List<String>)map.get("default").get("ps");
	}
	
	/**
	 * return fail processor name
	 * @param chainName chain name
	 * @param errorProcessorName fail processor name 
	 * @return
	 */
	public String getErrorProcessor(String chainName, String errorProcessorName){
		for(Map.Entry<String, Map<String, Object>> entry : map.entrySet()){
			if(StringHandler.equals(entry.getKey(), chainName)){
				return (String)entry.getValue().get(errorProcessorName);
			}
		}
		return (String)map.get("default").get("error");
	}
	
	
	public static void main(String[] args) {
		String path = "/root/git/shuoShuo/src/shouQiSystem/shuoshuo/mvc/chainConfig/mvc-chain.js";
		String content;
		try {
			content = Catchall.readAll(new InputStreamReader(new FileInputStream(new File(path))));
			System.out.println("content: " + content);
			Map<?,?> map = (Map<?, ?>) JSON.parse(content);
			System.out.println("default:" + map.get("default"));
			System.out.println("default:" + ((Map)map.get("default")).get("error"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		new JsonActionChainMakerConfiguration(path);
	}
	
}
