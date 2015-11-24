//这个包的类暂时无用了,因为记录可以根据每一个方法的调用来进行记录.在 大脑.行为 的包下.
package 大脑.会话;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class 会话场景 {
	
	List<记录> 记录集0= new ArrayList<记录>();
	SimpleDateFormat 时间格式 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public void add(String 词语0,String 讲话者0){
		
		String 时间0 = 时间格式.format(new Date());
		记录 记录0 = new 记录(词语0,讲话者0,时间0);
		记录集0.add(记录0);
	}
	
	public void addEver(String 词语0,String 讲话者0,Date 时间0){
		
		记录 记录0 = new 记录(词语0,讲话者0,时间格式.format(时间0));
		记录集0.add(记录0);
	}
	
	public void addLater(String 词语0,String 讲话者0,Date 时间0){
		
		记录 记录0 = new 记录(词语0,讲话者0,时间格式.format(时间0));
		记录集0.add(记录0);
	}
	
	public void addEverWithout时间(String 词语0,String 讲话者0){
		
		记录 记录0 = new 记录(词语0,讲话者0,"曾经");
		记录集0.add(记录0);
	}
	
	public void addLaterWithout时间(String 词语0,String 讲话者0){
		
		记录 记录0 = new 记录(词语0,讲话者0,"以后");
		记录集0.add(记录0);
	}
	
	public List<记录> get记录sBefore时间(Date 时间0) throws ParseException{
		List<记录> 结果 = new ArrayList<记录>();
		for(记录 记录0:记录集0){
			if(!记录0.get时间().equals("曾经") && !记录0.get时间().equals("以后")){
				if(时间格式.parse(记录0.get时间()).before(时间0)){
					结果.add(记录0);
				}
			}
		}
		return 结果;
	}
	
	public List<记录> get记录sAfter时间(Date 时间0) throws ParseException{
		List<记录> 结果 = new ArrayList<记录>();
		for(记录 记录0:记录集0){
			if(!记录0.get时间().equals("曾经") && !记录0.get时间().equals("以后")){
				if(时间格式.parse(记录0.get时间()).after(时间0)){
					结果.add(记录0);
				}
			}	
		}
		return 结果;
	}
	
	public List<记录> get记录列表_根据词语(String 词语0){
		List<记录> 结果 = new ArrayList<记录>();
		for(记录 记录0:记录集0){
			if(记录0.get词语().equals(词语0)){
				结果.add(记录0);
			}
		}
		return 结果;
	}
	
	public List<记录> get记录列表_根据讲话者(String 讲话者0){
		List<记录> 结果 = new ArrayList<记录>();
		for(记录 记录0:记录集0){
			if(记录0.get讲话者().equals(讲话者0)){
				结果.add(记录0);
			}
		}
		return 结果;
	}
	
	public List<记录> get_根据词语和讲话者(String 词语0,String 讲话者0){
		List<记录> 结果 = new ArrayList<记录>();
		for(记录 记录0:记录集0){
			if(记录0.get词语().equals(词语0) && 记录0.get讲话者().equals(讲话者0)){
				结果.add(记录0);
			}
		}
		return 结果;
	}
	
	public boolean 是否已存在(String 词语){
		if(get记录列表_根据词语(词语).isEmpty()){
			return false;
		}
		return true;
	}
}
