package shouQiSystem.shuoshuo.ioc.loader;

import java.util.ArrayList;
import java.util.List;

import shouQiSystem.shuoshuo.ioc.IocLoader;

public class ComboLoader extends IocLoader {

	List<IocLoader> loaderList = new ArrayList<IocLoader>();
	
	public ComboLoader(IocLoader ...loaders){
		for(IocLoader ld : loaders){
			loaderList.add(ld);
		}
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> scanAllClassNames() {
		return null;
	}
	
	
	
	
	
}
