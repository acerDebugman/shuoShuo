package shouQiSystem.shuoshuo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import shouQiSystem.shuoshuo.mvc.Mvcs;

/**
 * this class for all miscellaneous operation
 * @author root
 *
 */
public class Catchall {

	/**
	 * read all data and turn them to String 
	 * @param reader
	 * @return
	 */
	public static String readAll(Reader reader){
		if(!(reader instanceof BufferedReader))
			reader = new BufferedReader(reader);

		StringBuilder sb = new StringBuilder();
		char[] data = new char[64];
		int len = -1;
		try {
			while(-1 != (len = reader.read(data))){
				sb.append(data, 0, len);
			}

			return sb.toString();
		} catch (IOException e) {
			throw new RuntimeException("read all data error!!"); 
		}finally{
			try {
				if(reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//---disks properties
	public static String getUserDirPath(){
		String path = System.getProperty("user.dir");
		System.out.println(path);
		return path;
	}
	
	public static String getJavaClassPath(){
		String path = System.getProperty("java.class.path");
		System.out.println(path);
		return path;
	}
	
	public static String getServletPath(){
		String path = Mvcs.servletConfig.getServletContext().getRealPath("/");
		System.out.println(path);
		return path;
	}
	
	public static String getClassLoaderPath(){
//		String path = Thread.currentThread().getContextClassLoader().getResource("/").toString();
		System.out.println(Catchall.class.getClassLoader().getResource("/"));
		String path = Catchall.class.getClassLoader().getResource("/").toString();
		System.out.println(path);
		return path;
	}
	
	public static String getSystemResource(){
		String path = ClassLoader.getSystemResource("/").toString();
		System.out.println(path);
		return path;
	}
	
	public static void main(String[] args) {
		getUserDirPath();
		getJavaClassPath();
//		getServletPath();
//		getClassLoaderPath();
		getSystemResource();
	}
	
}
