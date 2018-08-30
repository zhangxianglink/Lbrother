package exception;

public class BoyException extends RuntimeException{

	private Integer status;
	

	public BoyException(ExceptionEnums enums) {
		super(enums.getMsg());
		this.status = enums.getCode();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	
	
}
