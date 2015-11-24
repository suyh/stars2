package 大脑.建类;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import javax.tools.JavaFileManager.Location;

public class 更新类 {
	
	private  StringBuilder 读取类(String 类名) throws Exception{
		
		String filePath = "C:/Users/suyhuai/workspace/星辰2/src/大脑/类集/_" + 类名 + ".java";
		File file = new File(filePath);
		BufferedReader reader = null;
		StringBuilder 类 = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(file));
			String 行 = null;
			
			while ((行 = reader.readLine()) != null) {
				类.append(行).append("\n");
			}
			reader.close();
			类.deleteCharAt(类.length()-2);
			return 类;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}
	
	public 更新类 添加属性(String 类名,String...属性集) throws Exception{
		StringBuilder 类 = 读取类(类名);
		String 代码 = 构建属性(类名,属性集);
		类.append(代码).append("}\n");
		编译(类名,类.toString());
		return this;
	}
	
	public 更新类 添加方法(String 类名,String...方法集) throws Exception{
		StringBuilder 类 = 读取类(类名);
		String 代码 = 构建方法(方法集);
		类.append(代码).append("}\n");
		编译(类名,类.toString());
		return this;	
	}
	
	private String 构建属性(String 类名,String...属性集){
		
		StringBuilder 代码 = new StringBuilder();
		
		for(String 属性名:属性集){
			if(!属性名.trim().equals("")){
				代码.append("	public _").append(属性名).append(" ").append(属性名).append(" = new _").append(属性名).append("();\n\n");
			}	
		}
		return 代码.toString();
	}
	
	private String 构建方法(String...方法集){
		StringBuilder 代码 = new StringBuilder();
		for(String 方法名:方法集){
			if(!方法名.trim().equals("")){
				代码.append("	public void ").append(方法名).append("(Object 谁的, Object 附属, String 值) throws Exception{\n		行为.行为(this,谁的,附属,值,\"").append(方法名).append("\");\n	}\n\n");
			}	
		}
		return 代码.toString();
	}
	
	private void 编译(String 类名,String 类) throws Exception{
		
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
	}
	
	
}
