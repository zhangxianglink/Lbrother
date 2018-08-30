package exception;

public enum ExceptionEnums {
	
	UNKNOW_ERROR(-1,"未知错误"),
	SUCCESS(0,"成功"),
	TOOLONG(101,"你不适合当飞行员,太高了"),
	LONG(102,"正常男子的身高,但还不是很合适"),
	SHORT(103,"身高合适了,但是,你近视吗?");
	
	
	private Integer code;
	
	private String msg;
	
	private ExceptionEnums(Integer code, String message) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}
