package shouQiSystem.shuoshuo.mvc.chainConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import shouQiSystem.shuoshuo.mvc.ActionChain;
import shouQiSystem.shuoshuo.mvc.ActionChainMaker;
import shouQiSystem.shuoshuo.mvc.Processor;
import shouQiSystem.shuoshuo.mvc.impl.ShuoShuoActionChain;
import shouQiSystem.shuoshuo.util.ClassUtil;
import shouQiSystem.shuoshuo.util.StringHandler;

/**
 * the implementation fo aciton chain 
 * @author root
 *
 */
public class ActionChainMakerImpl implements ActionChainMaker{

	/***
	 * response for load json file
	 */
	JsonActionChainMakerConfiguration cnf = null;
	
	public ActionChainMakerImpl(String...paths){
		cnf = new JsonActionChainMakerConfiguration(paths);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActionChain> make() {
		List<ActionChain> rsList = new ArrayList<ActionChain>();
		Map<String, Map<String, Object>> map = cnf.getAll();
		for(Map.Entry<String, Map<String, Object>> entry : map.entrySet()){
			String chainName = entry.getKey();
			List<String> processorNames = (List<String>)entry.getValue().get("ps");
			List<Processor> processorList = getProcessorList(processorNames);
			Processor failProcessor = getProcessor(entry.getValue().get("error").toString());
			rsList.add(new ShuoShuoActionChain(chainName, processorList, failProcessor));
		}
		return rsList;
	}

	private Processor getProcessor(String fullQuafiedName) {
		try {
			return (Processor) ClassUtil.getClass(fullQuafiedName).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<Processor> getProcessorList(List<String> processorNames) {
		List<Processor> rsList =  new ArrayList<Processor>();
		for(String fullQuafiedName : processorNames){
			Processor p = getProcessor(fullQuafiedName);
			if(!StringHandler.isEmpty(p))
				rsList.add(p);
		}
		return rsList;
	}
}
