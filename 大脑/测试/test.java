package 大脑.测试;

import java.io.IOException;
import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import 垃圾堆.类更新部;
import 大脑.建类.所有类;
import 大脑.建类.建类部;
import 大脑.建类.更新类;
import 大脑.类集._人;


public class test {
	
	/*static MongoClient mongoClient;
	static Morphia morphia;
	static Datastore ds;
	
	public static void 初始化() throws Exception{
		mongoClient = new MongoClient("localhost", 27007);
		morphia = new Morphia();
		ds = morphia.createDatastore(mongoClient, "AI");
	}*/

	public static void main(String[] args) throws Exception {
		test0();
	}

	public static void test0() throws Exception{
//		初始化();
		
//		建类部 建类部0 = new 建类部();
//		建类部0.构建类头("人").构建信息().构建属性("身高").构建方法("吃","喝","走").构建类尾并编译();
//		
//		所有类 各类信息0 = ds.find(所有类.class).filter("_id","大脑.类集.人").get();
//		
//		各类信息0.set类名("大脑.类集.人").添加对象("").添加属性("力量","国籍").添加方法("睡觉").存储();
//		各类信息0.清除重复().存储();
//		人 人0 = new 人();
//		人0.存储();
//		
		更新类 更新类0 = new 更新类();
		更新类0.添加属性("人", "国籍","性别","户籍","肤色").添加方法("人","踢","撞");
	}
	
	public static void test2() throws Exception{
		
	}
	
}
