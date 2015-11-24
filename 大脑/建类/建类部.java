package 大脑.建类;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IdentityHashMap;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import javax.tools.JavaFileManager.Location;

import 大脑.行为.行为管理;

public class 建类部 {
	
	public StringBuilder 类 = new StringBuilder();
	public String 类名;
	
	public 建类部 构建类头(String 类名){
		this.类名 = 类名;
		类.append("package 大脑.类集;\n\n")
				.append("import java.util.ArrayList;\nimport 大脑.行为.行为管理;\n\n")
				.append("public class _")
				.append(类名)
				.append("{\n\n");
		return this;
	}
	
	public 建类部 构建信息(){
			类.append("	public String 类名 = this.getClass().getName();\n	public String 名字;\n	public String 词性;\n	public String 褒贬;\n	public int 使用次数;\n	public int 程度;\n	public ArrayList<String> 可修饰 = new ArrayList<String>();\n	public ArrayList<String> 可被修饰 = new ArrayList<String>();\n	public ArrayList<String> 同义词 = new ArrayList<String>();\n	public ArrayList<String> 反义词 = new ArrayList<String>();\n	行为管理 行为 = new 行为管理();\n\n");
		return this;
		
	}
	
	public 建类部 构建属性(String...属性集){
		
		for(String 属性名:属性集){
			if(!属性名.trim().equals("")){
				类.append("	public _").append(属性名).append(" ").append(属性名).append(" = new _").append(属性名).append("();\n\n");
			}	
		}
		return this;
	}
	
	public 建类部 构建方法(String...方法集){
		for(String 方法名:方法集){
			if(!方法名.trim().equals("")){
				类.append("	public void ").append(方法名).append("(Object 谁的, Object 附属, String 值) throws Exception{\n		行为.行为(this,谁的,附属,值,\"").append(方法名).append("\");\n	}\n\n");
			}	
		}
		return this;
	}
	
	public 建类部 构建类尾并编译() throws IOException{
		类.append("}");
		
		FileOutputStream file = new FileOutputStream("C:/Users/suyhuai/workspace/星辰2/src/大脑/类集/_" + 类名 + ".java");
		OutputStreamWriter writer = new OutputStreamWriter(file, "UTF-8");
		writer.append(类);
		writer.close();
		file.close();
		
		JavaCompiler 编译器 = ToolProvider.getSystemJavaCompiler();
		DiagnosticCollector<JavaFileObject> 诊断收集器 = new DiagnosticCollector<JavaFileObject>();
		StandardJavaFileManager java文件标准管理器 = 编译器.getStandardFileManager(诊断收集器, null, null);
		Location 输出位置 = StandardLocation.CLASS_OUTPUT;
		java文件标准管理器.setLocation(输出位置, Arrays.asList(new File[] { new File("C:/Users/suyhuai/workspace/星辰2/bin/") }));
		Iterable<? extends JavaFileObject> java文件集 = java文件标准管理器.getJavaFileObjectsFromFiles(Arrays.asList(new File("C:/Users/suyhuai/workspace/星辰2/src/大脑/类集/_" + 类名 + ".java")));
		编译器.getTask(null , java文件标准管理器, 诊断收集器, null , null , java文件集).call();
		
		return this;
	}
	
}
