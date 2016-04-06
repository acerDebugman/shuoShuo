package shouQiSystem.shuoshuo.util;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import shouQiSystem.user.TestJojo;


public class ClassUtil {
	
	/**
     * 获取一个 Type 类型实际对应的Class
     * 
     * @param type
     *            类型
     * @return 与Type类型实际对应的Class
     */
    @SuppressWarnings("rawtypes")
    public static Class<?> getTypeClass(Type type) {
        Class<?> clazz = null;
        if (type instanceof Class<?>) {
            clazz = (Class<?>) type;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            clazz = (Class<?>) pt.getRawType();
        } else if (type instanceof GenericArrayType) {
            GenericArrayType gat = (GenericArrayType) type;
            Class<?> typeClass = getTypeClass(gat.getGenericComponentType());
            return Array.newInstance(typeClass, 0).getClass();
        } else if (type instanceof TypeVariable) {
            TypeVariable tv = (TypeVariable) type;
            Type[] ts = tv.getBounds();
            if (ts != null && ts.length > 0)
                return getTypeClass(ts[0]);
        } else if (type instanceof WildcardType) {
            WildcardType wt = (WildcardType) type;
            Type[] t_low = wt.getLowerBounds();// 取其下界
            if (t_low.length > 0)
                return getTypeClass(t_low[0]);
            Type[] t_up = wt.getUpperBounds(); // 没有下界?取其上界
            return getTypeClass(t_up[0]);// 最起码有Object作为上界
        }
        return clazz;
    }

    public static void printClassInfo(Object o){
    	Class<?> c = o.getClass();
    	
    	System.out.println("class info-----------------------");
    	printModifers(c.getModifiers());
    	System.out.print(c.getName() + "{...}\n");
    	System.out.println("Name: " + c.getName());
    	Class<?> superClass = c.getSuperclass();
    	if(superClass != null)
    		System.out.println("Superclass : " + superClass.getName());
    	
    	System.out.println("Interfaces: ");
    	Class<?>[] interfaces = c.getInterfaces();
    	for(int i = 0; i < interfaces.length; i++){
    		System.out.println("Interfaces: " + interfaces[i].getName());
    	}

    	System.out.println("Fields: ");
//    	Field[] fields = c.getFields();
    	Field[] fields = c.getDeclaredFields();
    	for(int i = 0; i < fields.length; i++){
    		printModifers(fields[i].getModifiers());
    		System.out.println(fields[i].getType().getName() + " " + fields[i].getName() + ";");
    	}
    	
    	System.out.println("Methods: ");
    	Method[] methods = c.getMethods();
    	for(int i = 0; i < methods.length; i++){
//    		methods[i].
    		printModifers(methods[i].getModifiers());
    		System.out.print(methods[i].getReturnType().getName() + " " + methods[i].getName() + "(");
    		Class<?>[] params = methods[i].getParameterTypes();
    		for(int j = 0; j < params.length; j++){
    			System.out.print(params[j].getName());
//    			System.out.print(params[j].getName() + " " + params[j].);
    			if(j < params.length - 1)
    				System.out.print(", ");
    		}
    		System.out.println(");");
    	}
    	
    }
    
    public static void printModifers(int modifiers){
    	//all modifier, class modifier, method modifier
    	if(Modifier.isPrivate(modifiers))
    		System.out.print("private ");
    	else if(Modifier.isPublic(modifiers))
    		System.out.print("public ");
    	else if(Modifier.isProtected(modifiers))
    		System.out.print("protected ");
    	
    	if(Modifier.isFinal(modifiers))
    		System.out.print("final ");
    	if(Modifier.isAbstract(modifiers))
    		System.out.print("abstract ");
    	if(Modifier.isStatic(modifiers))
    		System.out.print("static ");
    	if(Modifier.isVolatile(modifiers))
    		System.out.print("volatile ");
    	if(Modifier.isTransient(modifiers))
    		System.out.print("transient ");
    	if(Modifier.isSynchronized(modifiers))
    		System.out.print("synchronized ");
    	if(Modifier.isNative(modifiers))
    		System.out.print("native ");
    }
    
    public static ClassLoader getClassLoader(){
    	return Thread.currentThread().getContextClassLoader();
    }
    
    /**
     * load class
     * @param pkgClassPath
     * @return
     */
    public static Class<?> getClass(String pkgClassPath){
    	try {
			return Thread.currentThread().getContextClassLoader().loadClass(pkgClassPath);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("@classUtil load class error!");
		}
    }

    public static void main(String[] args) throws IOException {
//    	Class<?> cls = getTypeClass(Enum.class);
//    	System.out.println(cls.getClass().getName());
//    	Class<?> cls2 = getTypeClass(WildcardType.class);
//    	System.out.println(cls2.getClass().getName());
//    	printClassInfo(new AnnotationIocLoader());
//    	printClassInfo(new ShuoShuoIoc(new AnnotationIocLoader()));
//    	printClassInfo(new TestJojo());
    	Class<?> cls = TestJojo.class;
    	System.out.println("abc: " + cls.getName().replace(".", "/"));
    	Map<String, List<String>> params = MethodParamNamesScaner.getParamNames(cls);
    	System.out.println("methods are: " + JSON.toJSONString(params));
    	
    	for(Map.Entry<String, List<String>> entry : params.entrySet()){
    		String key = entry.getKey();
    		List<String> values = entry.getValue();
    		
    		System.out.println("key: " + key.substring(0, key.indexOf(",")));
    		System.out.println("values: " + JSON.toJSONString(values));
    	}
    	
    	Method[] methods = cls.getMethods();
    	for(Method m : methods){
    		Class<?>[] mParamTypes = m.getParameterTypes();
    		for(int j = 0; j < mParamTypes.length; j++){
    			System.out.print(",type: " + mParamTypes[j]);
    		}

    		List<String> pnames = MethodParamNamesScaner.getParamNames(m);
    		if(StringHandler.isEmpty(pnames))
    			continue ;
//    		System.out.println("  method name: " + m.getName()); 
    		System.out.println("  ccc:" + JSON.toJSON(pnames));
    	}
    	
//    	System.out.println("jojo: " + params.get());
    	System.out.println("joe joe zhang");
	}

}
