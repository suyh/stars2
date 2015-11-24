package 大脑.搜索;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.lionsoul.jcseg.core.ADictionary;
import org.lionsoul.jcseg.core.DictionaryFactory;
import org.lionsoul.jcseg.core.ISegment;
import org.lionsoul.jcseg.core.IWord;
import org.lionsoul.jcseg.core.JcsegException;
import org.lionsoul.jcseg.core.JcsegTaskConfig;
import org.lionsoul.jcseg.core.SegmentFactory;

public class 分词 {
	JcsegTaskConfig config;
	ADictionary dic;
	ISegment seg;
	
	public 分词() throws JcsegException{
		config = new JcsegTaskConfig();
		dic = DictionaryFactory .createDefaultDictionary(config);
		seg = SegmentFactory .createJcseg(JcsegTaskConfig.COMPLEX_MODE, new Object[]{config, dic});
	}
	public List<String> 执行(String str) throws JcsegException, IOException{
		
		seg.reset(new StringReader(str)); 
		List<String> 词语集 = new ArrayList<String>();

		IWord word = null;
		while ( (word = seg.next()) != null ) {
			词语集.add(word.getValue());
		}
		
		String[] 中文数字 = {"零","一","二","三","四","五","六","七","八","九","十","百","千"};
		List<String> 无用词语 = new ArrayList<String>();
		for(String 词语:词语集){
			for(String 中文:中文数字){
				if(词语.contains(中文)){
					无用词语.add(词语);
				}
			}
			
		}
		词语集.removeAll(无用词语);
		List<String> 新词语集 = new ArrayList<String>();
	    for(String 词语:词语集){
	      	if(词语.contains("的") && !词语.equals("的") && !词语.equals("目的") && !词语.equals("目的地") && !词语.equals("无的放矢") && !词语.equals("众矢之的")  && !词语.equals("的卢")){
	        	新词语集.add(词语.substring(0, 词语.indexOf("的")));
	        	新词语集.add("的");
	        }else{
	        	新词语集.add(词语); 
	       	}
	    }
		
		新词语集.forEach(n->System.out.print(n+" "));
		return 新词语集;
	}
}
