package 大脑.类集;

import java.lang.reflect.Field;
import java.util.IdentityHashMap;

public class Test {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field f = _人.class.getDeclaredField("身高");
		_人 人0 = new _人();
		
		IdentityHashMap<String,String> 身高 = (IdentityHashMap<String, String>) f.get(人0);
		身高.put(new String("范围"), "中等");
//		f.set(人0, 身高);
		
		IdentityHashMap<String,String> 身高2 = (IdentityHashMap<String, String>) f.get(人0);
		身高2.put(new String("cm"), "167");
		System.out.println(f.get(人0).toString());
	}

}
