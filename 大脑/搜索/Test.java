package 大脑.搜索;

import org.json.JSONArray;
import org.json.JSONObject;

public class Test {

	public static void main(String[] args) throws Exception {
//		String method = "GET";  
//		String url = "http://openapi.baidu.com/public/2.0/translate/dict/simple?client_id=rWtNEad5jNsxVMO3H1tY5vQL&q=人有旦夕祸福&from=zh&to=zh";
//		String url = "http://brisk.eu.org/api/hycd.php?word=程序";
//		字典查询 查询1 = new 字典查询(method, url);  
		
//		System.out.println(查询1.转换(查询1.执行()));
		
//		字典查询 查询1 = new 字典查询();
//		String 结果 = 查询1.查询("人有旦夕祸福");
//		System.out.println(结果);
//		JSONObject json = new JSONObject(结果);
//		JSONObject object2 = object1.getJSONObject("data");
//		System.out.println(object2.toString());
//		System.out.println(json.isNull("data"));
		
		
//		JSONArray array = new JSONArray();
////		array.getJSONObject(str.);
//        JSONObject object = JSONObject.toJSONObject(array.get(0));
//        System.out.println(object.get("UserID"));
		
		
		
		
		
		
		
		
		
//		句子理解 理解 = new 句子理解();
////		理解.理解("光阴!@#$%^&*()_似+={}?><,箭一转眼我们已经9毕。，“”’“\"'业两年多了.");
		String str = "我的名字叫苏永怀";
//		理解.理解(str);
		
		分词 分词1 = new 分词();
		分词1.执行(str);
		
	}

}
