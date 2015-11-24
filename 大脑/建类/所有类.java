package 大脑.建类;

import java.net.UnknownHostException;
import java.util.ArrayList;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import com.mongodb.MongoClient;

@Entity
public class 所有类 {

	@Id
	public String 类名;
	
	public ArrayList<String> 对象集 = new ArrayList<String>();
	public ArrayList<String> 属性集 = new ArrayList<String>();
	public ArrayList<String> 方法集 = new ArrayList<String>();
	
	public 所有类 set类名(String 类名){
		this.类名 = 类名;
		return this;
	}
	public String get类名(){
		return 类名;
	}
	
	public 所有类 添加对象(String...对象集){
		for(String 对象:对象集){
			if(!this.对象集.contains(对象) && !"".equals(对象.trim())){
				this.对象集.add(对象);
			}
		}
		return this;
	}
	
	public ArrayList<String> get对象集(){
		return 对象集;
	}
	
	
	public 所有类 添加属性(String...属性集){
		for(String 属性:属性集){
			if(!this.属性集.contains(属性) && !"".equals(属性.trim())){
				this.属性集.add(属性);
			}
		}
		return this;
	}
	
	public ArrayList<String> get属性集(){
		return 属性集;
	}
	
	public 所有类 添加方法(String...方法集){
		for(String 方法:方法集){
			if(!this.方法集.contains(方法) && !"".equals(方法.trim())){
				this.方法集.add(方法);
			}
		}
		return this;
	}
	public ArrayList<String> get方法集(){
		return 方法集;
	}

	public void 存储() throws UnknownHostException{
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		Morphia morphia = new Morphia();
		Datastore ds = morphia.createDatastore(mongoClient, "AI");
		ds.save(this);
	}
	
	public 所有类 清除重复(){
		ArrayList<String> 新对象集 = new ArrayList<String>();
		for(String 对象:对象集){
			if(!新对象集.contains(对象)){
				新对象集.add(对象);
			}
		}
		对象集 = 新对象集;
		
		ArrayList<String> 新属性集 = new ArrayList<String>();
		for(String 属性:属性集){
			if(!新属性集.contains(属性)){
				新属性集.add(属性);
			}
		}
		属性集 = 新属性集;
		
		ArrayList<String> 新方法集 = new ArrayList<String>();
		for(String 方法:方法集){
			if(!新方法集.contains(方法)){
				新方法集.add(方法);
			}
		}
		方法集 = 新方法集;
		
		return this;
	}
}
