package 大脑.存储;

import java.lang.reflect.Field;
import java.net.UnknownHostException;

import org.bson.Document;

import 大脑.类集._人;
import 大脑.类集._偏低;
import 大脑.类集._偏高;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class 类信息存储 {
	
	public static void main(String[] args) throws UnknownHostException, JsonSyntaxException, ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
//		获取();
		存储();
	}
	
	public static void 存储() throws UnknownHostException{
		Gson gson = new Gson();
		_人 人 = new _人();
		System.out.println(人.类名);
		人.名字 = "姚明";
		人.身高.偏高 = new _偏高();
		
		String str = gson.toJson(人);
		
		MongoClient mongo = new MongoClient();
		MongoDatabase db =mongo.getDatabase("AI");
		MongoCollection<Document> coll = db.getCollection("Classes");
		
		coll.insertOne(Document.parse(str));
	}
	
	/*public static void 获取() throws UnknownHostException, JsonSyntaxException, ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		
		MongoClient mongo = new MongoClient();
		MongoDatabase db =mongo.getDatabase("AI");
		MongoCollection<Document> coll = db.getCollection("Classes");
		
		FindIterable<Document> 所有结果 = coll.find();
		MongoCursor<Document> cursor = 所有结果.iterator();
		
		Gson gson = new Gson();
		
		while(cursor.hasNext()){
			Document doc = cursor.next();
			if(doc.get("名字").toString().equals("苏永怀")){
				Object obj = gson.fromJson(doc.toJson(), Class.forName(doc.getString("类名")));
				
				Field field = Class.forName(doc.getString("类名")).getDeclaredField("名字");
				System.out.println(field.get(obj));
			}
		}
		
	}*/
	
	
}
