package shouQiSystem.shuoshuo.ioc.loader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import shouQiSystem.shuoshuo.ioc.IocLoader;
import shouQiSystem.shuoshuo.mvc.Mvcs;
import shouQiSystem.shuoshuo.util.ScannerUtil;

public class AnnotationIocLoader extends IocLoader {

	public int a;
	protected long c;
	
	@Override
	public void test(){
		System.out.println("in anno");
	}

	@Override
	public List<String> scanAllClassNames() {
		//1. get all class files
		List<String> classFiles = ScannerUtil.scanAllClassFiles();
		//2. filter package path
		String scanPath = Mvcs.scanPackagePath;
		scanPath = scanPath.replaceAll("\\.", File.separator);
		
		//3. filter
		List<String> pkgClassPaths = new ArrayList<String>();
		for(String path : classFiles){
			//if the class belong to this package
			if(path.contains(scanPath)){
				pkgClassPaths.add(path.substring(1, path.lastIndexOf(".")).replaceAll(File.separator, "."));
			}
		}
		
		//XXX test
		for(String str : pkgClassPaths){
			System.out.println(str);
		}
		
		return pkgClassPaths;
	}

}
