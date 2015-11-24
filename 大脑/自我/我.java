package 大脑.自我;

import java.util.ArrayList;

public class 我 {
	
	public ArrayList<String> 名词 = new ArrayList<String>();
	public ArrayList<String> 动词 = new ArrayList<String>();
	public ArrayList<String> 形容词 = new ArrayList<String>();
	public ArrayList<String> 语气助词 = new ArrayList<String>();
	public ArrayList<String> 代词 = new ArrayList<String>();
	
	public boolean 是名词(String 词语){
		if(名词.contains(词语)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean 是动词(String 词语){
		if(动词.contains(词语)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean 是形容词(String 词语){
		if(形容词.contains(词语)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean 是语气助词(String 词语){
		if(语气助词.contains(词语)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean 是代词(String 词语){
		if(代词.contains(词语)){
			return true;
		}else{
			return false;
		}
	}
	
	
	public String 词性(String 词语){
		if(名词.contains(词语) && !动词.contains(词语) && !形容词.contains(词语) && !语气助词.contains(词语) && !代词.contains(词语)){
			return "名词";
		}else if(!名词.contains(词语) && 动词.contains(词语) && !形容词.contains(词语) && !语气助词.contains(词语) && !代词.contains(词语)){
			return "动词";
		}else if(!名词.contains(词语) && !动词.contains(词语) && 形容词.contains(词语) && !语气助词.contains(词语) && !代词.contains(词语)){
			return "形容词";
		}else if(!名词.contains(词语) && !动词.contains(词语) && !形容词.contains(词语) && 语气助词.contains(词语) && !代词.contains(词语)){
			return "语气助词";
		}else if(!名词.contains(词语) && !动词.contains(词语) && !形容词.contains(词语) && !语气助词.contains(词语) && 代词.contains(词语)){
			return "语气助词";
		}else{
			return "不确定";
		}
	}

}
