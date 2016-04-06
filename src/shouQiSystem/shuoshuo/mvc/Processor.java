package shouQiSystem.shuoshuo.mvc;

public interface Processor {
	
	public void init();
	
	public void process();
	
	public Processor getNext();
	
	public void setNext(Processor p);
}
