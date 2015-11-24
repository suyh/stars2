package 大脑.会话;

public class 记录 {
	
	private String 词语;
	private String 讲话者;
	private String 时间;
	
	public String get词语() {
		return 词语;
	}

	public void set词语(String 词语) {
		this.词语 = 词语;
	}

	public String get讲话者() {
		return 讲话者;
	}

	public void set讲话者(String 讲话者) {
		this.讲话者 = 讲话者;
	}
	
	public String get时间() {
		return 时间;
	}

	public void set时间(String 时间) {
		this.时间 = 时间;
	}
	
	public 记录(String 词语,String 讲话者,String 时间){
		this.词语 = 词语;
		this.讲话者 = 讲话者;
		this.时间 = 时间;
	}
}
