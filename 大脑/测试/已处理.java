package 大脑.测试;

import java.util.ArrayList;
import java.util.List;

public class 已处理 {

	 public List<Object> 获取句子对象集(String sentence){

	       

	        List<String> subStrs= new ArrayList<String>();

	       

	        for(int star=0;star<sentence.length();star++){

	            for(int end=star+1;end<=sentence.length();end++){

	                subStrs.add(sentence.substring(star, end));

	            }

	        }

	       

	        List<Object> things= new ArrayList<Object>();

	       

	        for(String str:subStrs){

//	          Object o = ds.find("_id",str);

	            //利用java-mongodb-driver 查询 "_id":str 这条记录的className属性值，然后根据这个值，实例化这个对象

	           

//	          things.add(object);

	        }

	       

	        return things;

	    }

	   

	 

	    public List<String> 获取句子方法(String sentence){

	        //这个sentence可能需要把在 “获取句子对象集” 方法中确定的对象 排除.

	        List<String> subStrs= new ArrayList<String>();

	       

	        for(int star=0;star<sentence.length();star++){

	            for(int end=star+1;end<=sentence.length();end++){

	                subStrs.add(sentence.substring(star, end));

	            }

	        }

	       

	        List<String> actions= new ArrayList<String>();

	       

	        /**

	        * 两种思路：1.遍历每一个句子对象集中的对象，获取他们的所有方法，看是否有方法名与句子中排除对象名之后剩下的字符串相同。若有，则调用.

	        *       2. 对剩余字符串进行完全遍历拆分，并对每一个拆分的子字符串对对象进行反射调用，若不报错，则调用.调用时传入参数。

	        *      ps：在对排出了对象名和方法名之后的剩余字符串，进行有用信息提取，排除掉无用字符串. 其实无用字符串有用，可以根据这些字符串判断心情等.  设计脏话排除算法，无用信息排除算法.

	        *		重点:1. 遵循无用字符串最少原则
	        *			2.重写文件时,读取文件,在文件后面加上方法和属性即可.
	        */

	       

	       

	        for(String str:subStrs){

	            //Object o = ds.find("_id",str);

	           

	            //利用java-mongodb-driver 查询 "_id":str 这条记录的className属性值，然后根据这个值，实例化这个对象

	            //things.add(object);

	        }

	       

	        return actions;

	    }

	   

	    //添加到类集中的各类中

	    public void how (Object whose, Object what, String...newValue){

	        //这是每一个类中方法的模板：

	        //方法拥有者为 who，所以连起来就是： who 把 whose what 改为 newValue -by- how。 如果what 为空，则需要根据一个newValue去数据库中寻找对应类并实例化，从而获得what。例如：

	        //我把他打瞎了。可以根据 瞎这个属性，找到数据库中属于 眼睛 这个类，所以可以获得眼睛这个对象。

	       

	    }
	
	
}
