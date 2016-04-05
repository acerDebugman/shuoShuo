package shouQiSystem.shuoshuo.mvc.processors;

import shouQiSystem.shuoshuo.mvc.Processor;

public class AbstractProcessor implements Processor {

	private Processor next;
	
	@Override
	public void process() {
		
	}

	/**
	 * get next
	 * @return
	 */
	public Processor getNext(){
		return next;
	}
	
}
