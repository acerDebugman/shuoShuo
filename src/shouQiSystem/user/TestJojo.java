package shouQiSystem.user;

import shouQiSystem.shuoshuo.ioc.annotations.At;
import shouQiSystem.shuoshuo.ioc.annotations.IocBean;

@IocBean
@At("/joe")
public class TestJojo {
	
	@At("/abc")
	public String test(int age){
		return "jooj";
	}
	
	@At("/abc")
	public String test(int cge, Double ddd, String age){
		return "jooj";
	}
	
	@At("/abc")
	public String test(int bge, long age){
		return "jooj";
	}

	@At("/cde")
	public int testa(String kk){
		return 0;
	}
	
	
}
