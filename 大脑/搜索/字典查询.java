package 大脑.搜索;

import java.io.BufferedReader;
import java.io.IOException;  
import java.io.InputStreamReader;
import java.net.URLDecoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;  
import org.apache.http.client.ClientProtocolException;  
import org.apache.http.client.HttpClient;  
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.impl.client.HttpClientBuilder;  
  
public class 字典查询 {  
    private HttpClient 调用端;  
    private HttpResponse 响应内容 = null;  
    private String 传输方式, 访问连接;  
    
    public 字典查询(String 传输方式, String 访问连接){  
        this.传输方式 = 传输方式;  
        this.访问连接 = 访问连接;  
    }  
    
    public 字典查询(){
    	
    }  
    
    public String  执行() throws ClientProtocolException, IOException{  
    	HttpEntity 返回结果;
        调用端 = HttpClientBuilder.create().build();  
        StringBuilder 字符串构建=new StringBuilder();
        switch(传输方式){  
        case "GET":  
            响应内容 = 调用端.execute(new HttpGet(访问连接));  
            break;  
        case "POST":  
            响应内容 = 调用端.execute(new HttpPost(访问连接));  
        }  
        返回结果 = 响应内容.getEntity();
        
        String 处理结果 = null;
        if (返回结果!=null) {
            try {
            	BufferedReader 缓存阅读器 = new BufferedReader
                (new InputStreamReader(返回结果.getContent(), "UTF-8"), 8*1024);
                String 行=null;
                while ((行=缓存阅读器.readLine())!=null) {
                	字符串构建.append(行+"/n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        处理结果 = URLDecoder.decode(字符串构建.toString(), "UTF-8");
		return 处理结果;
    }  
    
    public String 转换(String 待转字符串){  
        StringBuilder 结果字符串 = new StringBuilder();  
        int 第N个位置 = -1;  
        int 初始位置 = 0;  
          
        while((第N个位置=待转字符串.indexOf("\\u", 初始位置)) != -1){  
        	结果字符串.append(待转字符串.substring(初始位置, 第N个位置));  
            if(第N个位置+5 < 待转字符串.length()){  
            	初始位置 = 第N个位置+6;  
            	结果字符串.append((char)Integer.parseInt(待转字符串.substring(第N个位置+2, 第N个位置+6), 16));  
            }  
        }  
        结果字符串.append(待转字符串.substring(初始位置, 待转字符串.length()-2));
        return 结果字符串.toString();  
    } 

    public String 查询(String 词语) throws Exception{
    	this.传输方式 = "GET";  
    	this.访问连接 = "http://openapi.baidu.com/public/2.0/translate/dict/simple?client_id=rWtNEad5jNsxVMO3H1tY5vQL&q="+词语+"&from=zh&to=zh";
		String 结果 = 执行();
		return 转换(结果);
    }
    
} 