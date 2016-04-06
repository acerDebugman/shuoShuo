package shouQiSystem.shuoshuo.mvc.impl;

import java.util.Iterator;
import java.util.List;

import shouQiSystem.shuoshuo.mvc.ActionChain;
import shouQiSystem.shuoshuo.mvc.Processor;

public class ShuoShuoActionChain implements ActionChain {
	
	private String chainName;
	
	/**
	 * the head of action chain
	 */
	private Processor head = null;
	
	private Processor errorProcessor = null;
	
	public ShuoShuoActionChain(String chainName, List<Processor> processors, Processor failProcessor) {
		Iterator<Processor> it = processors.iterator();
		if(it.hasNext())
			head = it.next();
		Processor pt = head;
		while(it.hasNext()){
			Processor p = it.next();
			pt.setNext(p);
			pt = p;
		}
		
		this.errorProcessor = failProcessor;
		this.chainName = chainName; 
	}
	
	@Override
	public void doChain() {
		try{
			head.process();
		}catch(Exception e){
			System.out.println("error happen!!!!!");
			errorProcessor.process();
		}
	}

	@Override
	public String getChainName() {
		return chainName;
	}

}
