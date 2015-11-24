package 大脑.建类;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class 类操作 {
	
	@SuppressWarnings("unchecked")
	public void 修改属性值(Object 对象,String 属性名, String key, String value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Field field = 对象.getClass().getDeclaredField(属性名);
		HashMap<String,ArrayList<String>> 属性 = (HashMap<String, ArrayList<String>>) field.get(对象);
		if(属性.containsKey(key)){
			属性.get(key).add(value);
		}else{
			ArrayList<String> 清单 = new ArrayList<String>();
			清单.add(value);
			属性.put(key, 清单);
		}
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, ArrayList<String>> 获取属性值(Object 对象,String 属性名) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Field field = 对象.getClass().getDeclaredField(属性名);
		HashMap<String,ArrayList<String>> 属性 = (HashMap<String, ArrayList<String>>) field.get(对象);
		return 属性;
	}
	
	public void 添加属性 (){
		//需要先检测所添加的属性的类是否存在
	}
	
	public void 添加方法 (){
		//需要先检测所添加的属性的类是否存在
	}
}
