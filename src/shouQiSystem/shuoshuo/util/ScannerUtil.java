package shouQiSystem.shuoshuo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import shouQiSystem.shuoshuo.mvc.Mvcs;

public class ScannerUtil {
	
	
	/**
	 * scan all .class files
	 * @return
	 */
	public static List<String> scanAllClassFiles(){
		//pattern 
		Pattern p = Pattern.compile(".class");
		Pattern excludeClassFile = Pattern.compile("package-info.class");
		
		List<String> rsList = new ArrayList<String>();
		//get all files
		List<String> allFiles = scanAllFiles();
		//filter all .class files and not include package-info.class file
		for(String file : allFiles){
			if(p.matcher(file).find() && !excludeClassFile.matcher(file).matches())
				rsList.add(file);
		}
		//XXX test code
//		for(String file : rsList){
//			System.out.println("*******" + file);
//		}
		
		return rsList;
	}
	
	/***
	 * scan all files
	 * @return
	 */
	public static List<String> scanAllFiles(){
		String rootPath = Mvcs.servletConfig.getServletContext().getRealPath("/");
		//save to Mvcs
		Mvcs.APP_REAL_ROOT_PATH = rootPath;
		String classesDirPath = rootPath + Mvcs.DEF_WEB_CLASSES_DIR;
		String libDirPath =  rootPath + Mvcs.DEF_WEB_LIB_DIR;
		
		List<String> rsList = new ArrayList<String>();
		List<String> allClassesDirFiles = new ArrayList<String>();
		List<String> allJarDirFiles = new ArrayList<String>();
		//collect all files under /WEB-INF/classes 
		collectFiles(classesDirPath, allClassesDirFiles);
		for(String path : allClassesDirFiles){
			if(path.length() > classesDirPath.length())
				rsList.add(path.substring(classesDirPath.length()));
		}

		//collect all files under /WEB-INF/lib
		collectFiles(libDirPath, allJarDirFiles);
		//expand jar files, all files contained by .jar file has no need to be substring() 
		expandLibFiles(allJarDirFiles, rsList);
		
		for(String path : allJarDirFiles){
			if(path.length() > libDirPath.length())
				rsList.add(path.substring(libDirPath.length()));
		}

		return rsList;
	}
	
	/**
	 * extract all .jar files
	 * @param rsList
	 */
	public static void expandLibFiles(List<String> jarFilesList, List<String> rsList){
		List<String> subJarList = new ArrayList<String>();
		for(String jarFile : jarFilesList)
			if(jarFile.endsWith(".jar"))
				expandJarFile(jarFile, subJarList);
		//merge all list files
		rsList.addAll(subJarList);
	}
	
	/**
	 * expand jar file and put all inside files into list 
	 * @param jarFile
	 * @param rsList
	 */
	@SuppressWarnings("resource")
	public static void expandJarFile(String jarFile, List<String> rsList){
		try {
			File f = new File(jarFile);
			ZipInputStream zis = new ZipInputStream(new FileInputStream(f));
			ZipEntry entry;
			while(null != (entry = zis.getNextEntry())){
				//all entry name in jar has no web_root prefix
				rsList.add(entry.getName());
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("expand jar files error!");
		}
	}
	
	/***
	 * get all files under specified directory
	 * @param path 
	 * 			directory path
	 * @param list
	 * 			list containing all file name
	 */
	public static void collectFiles(String path, List<String> list){
		File f = new File(path);
		if(f != null && f.exists()){
			if(f.isDirectory()){
				for(File subf : f.listFiles())
					collectFiles(subf.getAbsolutePath(), list);
			}
			else 
				list.add(f.getAbsolutePath());
		}
	}
}
