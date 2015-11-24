package 大脑.类集;

import java.util.ArrayList;
import 大脑.行为.行为管理;

public class _人{
	
	public String 类名 = this.getClass().getName();
	public String 名字;
	public String 词性;
	public String 褒贬;
	public int 使用次数;
	public int 程度;
	public ArrayList<String> 可修饰 = new ArrayList<String>();
	public ArrayList<String> 可被修饰 = new ArrayList<String>();
	public ArrayList<String> 同义词 = new ArrayList<String>();
	public ArrayList<String> 反义词 = new ArrayList<String>();
	行为管理 行为 = new 行为管理();

	public _身高 身高 = new _身高();

	public void 吃(Object 谁的, Object 附属, String 值) throws Exception{
		行为.行为(this,谁的,附属,值,"吃");
	}

	public void 喝(Object 谁的, Object 附属, String 值) throws Exception{
		行为.行为(this,谁的,附属,值,"喝");
	}

	public void 走(Object 谁的, Object 附属, String 值) throws Exception{
		行为.行为(this,谁的,附属,值,"走");
	}

}