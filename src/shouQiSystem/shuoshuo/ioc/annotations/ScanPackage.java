package shouQiSystem.shuoshuo.ioc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * for shuoshuo:
 * 1. every method in interface is implicitly abstract
 * 2. every method in interface is implicitly public
 * @author root
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ScanPackage {
	/**
	 * the scan path
	 * @return
	 */
	String path();
	
}
