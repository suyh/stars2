package 大脑.类集;

import java.util.ArrayList;
import 大脑.行为.行为管理;

public class _身高 {
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
	
	public _偏高 偏高 = new _偏高();
	public _偏低 偏低 = new _偏低();
}
