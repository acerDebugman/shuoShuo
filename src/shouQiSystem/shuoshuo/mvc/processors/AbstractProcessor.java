package shouQiSystem.shuoshuo.mvc.processors;

import shouQiSystem.shuoshuo.mvc.Processor;

public class AbstractProcessor implements Processor {

	private Processor next;
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void process() {
		
		
		doNext();
	}

	public void doNext(){
		if(next != null)
			next.process();
	}
	
	/**
	 * get next
	 * @return
	 */
	public Processor getNext(){
		return next;
	}

	@Override
	public void setNext(Processor p) {
		next = p;
	}

	
	
	
	
}
