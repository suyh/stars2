package 大脑.词集;

import java.util.ArrayList;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(value="词集",noClassnameStored=true)
public class 词语 {
	@Id
	public String ID;
	public String 词性;
	public String 褒贬;
	public int 使用次数;
	public int 程度;
	public ArrayList<String> 可修饰 = new ArrayList<String>();
	public ArrayList<String> 可被修饰 = new ArrayList<String>();
	public ArrayList<String> 同义词 = new ArrayList<String>();
	public ArrayList<String> 反义词 = new ArrayList<String>();
	
}
