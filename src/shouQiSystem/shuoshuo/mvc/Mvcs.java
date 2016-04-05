package shouQiSystem.shuoshuo.mvc;

import java.util.Map;

import javax.servlet.ServletConfig;

import shouQiSystem.shuoshuo.ioc.Ioc;

public class Mvcs {

	public static Ioc ioc = null;
	
	/**
	 * serlet config 
	 */
	public static ServletConfig servletConfig;

	/**
	 * default web library directory
	 */
	public static String DEF_WEB_LIB_DIR = "WEB-INF/lib";
	
	/**
	 * default web classes directory
	 */
	public static String DEF_WEB_CLASSES_DIR = "WEB-INF/classes";
	
	/**
	 * default web room path 
	 */
	public static String APP_REAL_ROOT_PATH = "";
	
	public static String scanPackagePath = "";
	
	/**
	 * url mapping addr, may be I should use words filter algorithm... XXX DFA algorithm
	 */
	public static Map<String, AtMap> urlMapping;
	
}
