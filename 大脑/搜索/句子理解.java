package 大脑.搜索;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import 大脑.建类.所有类;

public class 句子理解 {
	
	MongoClient mongoClient; 
	Morphia morphia;
	Datastore ds;
//	字典查询 查询1;
	所有类 各类信息1;
	
	public 句子理解() throws UnknownHostException{
		mongoClient = new MongoClient("localhost", 27017);
		morphia = new Morphia();
		ds = morphia.createDatastore(mongoClient, "AI");
		各类信息1 = ds.find(所有类.class).filter("_id","大脑.类集.人").get();
//		查询1 = new 字典查询();
	}
	
	public List<Object> 理解(String 句子) throws Exception{
		
		//去除各种标点.符号,字母和数字
		句子 = 句子.replaceAll("[\\pP‘’“”]", "");
		句子 = 句子.replaceAll("[\\pN[0-9]]", "");
		句子 = 句子.replaceAll("[\\pS!@#$%^&*()_+={}?><]", "");
		句子 = 句子.replaceAll("[\\pZ ]", "");
		System.out.println(句子);
		
        List<String> 断句= new ArrayList<String>();
        
        for(int 起始=0;起始<句子.length();起始++){
        	
            for(int 截止=起始+1;截止<=句子.length();截止++){

            	断句.add(句子.substring(起始, 截止));
            	System.out.print(句子.substring(起始, 截止)+",");

            }
            System.out.println("");
        }
        
        List<String> 词语集 = new ArrayList<String>();
        
        for(String 句子成分:断句){
        	Object 对象 = ds.find(所有类.class).filter("_id","大脑.类集.人").get();
//        			各类信息 各类信息1 = ds.find(各类信息.class).filter("_id","大脑.类集.人").get();
        }
        
        System.out.println("");
        List<String> 含_的_词语 = new ArrayList<String>();
        for(String 词语:词语集){
        	if(词语.contains("的") && !词语.equals("的") && !词语.equals("目的") && !词语.equals("目的地") && !词语.equals("无的放矢") && !词语.equals("众矢之的") ){
        		含_的_词语.add(词语);
        	}
        }
        
        词语集.removeAll(含_的_词语);
        
        List<String> 无用词语 = new ArrayList<String>();
        for(int i=0;i<词语集.size();i++){
        	List<String> 词语副本 = new ArrayList<String>(词语集);
        	词语副本.remove(词语集.get(i));
        	
        	for(String 词语:词语副本){
        		if(词语.contains(词语集.get(i))){
        			无用词语.add(词语集.get(i));
        		}
        	}
        }
        
        词语集.removeAll(无用词语);
        //===============================
        StringBuilder 合成结果 = new StringBuilder();
        List<String> 多余词语 = new ArrayList<String>();
        StringBuilder 临时句子 = new StringBuilder(句子);
        for(int i=0;i<词语集.size();i++){
        	合成结果.append(词语集.get(i));
        	if(!临时句子.toString().contains(合成结果.toString())){
        		多余词语.add(词语集.get(i));
        		临时句子.insert(合成结果.length()-词语集.get(i).length(),词语集.get(i));
        		System.out.print(合成结果.toString()+" | ");
        		System.out.print(临时句子.toString()+" | ");
        	}
        }
        词语集.removeAll(多余词语);
//        String 合成字符串 = 合成结果.toString();
//        
//        System.out.print(合成字符串);
//        while(!合成字符串.equals(句子)){
//        	
//        	List<char[]> 原字符集 = Arrays.asList(句子.toCharArray());
//            List<char[]> 新字符集 = Arrays.asList(合成字符串.toCharArray());
//            
//            StringBuilder 多余词语 = new StringBuilder();
//            for(int i=0;i<原字符集.size();i++){
//            	if(新字符集.get(i) != (原字符集.get(i))){
//            		多余词语.append(新字符集.get(i));
//            		新字符集.remove(i);
//            	}
//            }
//        }
        
        //===============================
        System.out.print("\n 运行结果是: ");
        
        词语集.forEach(n ->System.out.print(n+"  "));

        
        List<Object> things = new ArrayList<Object>();

       

//        for(String 句子成分:断句){
//        	if(各类信息1.对象集.contains(句子成分)){
//        		
//        	}
//        	
//        }
//        
//        for(String 句子成分:断句){
//        	if(各类信息1.属性集.contains(句子成分)){
//        		
//        	}
//        	
//        }
//        
//        for(String 句子成分:断句){
//        	if(各类信息1.方法集.contains(句子成分)){
//        		
//        	}
//        	
//        }

       

        return things;

    }
	
}
