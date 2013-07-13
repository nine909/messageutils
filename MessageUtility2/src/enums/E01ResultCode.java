package enums;

public enum E01ResultCode {
	SUCCESS("0", "SUCCESS")
	;
	
	private String resultCode;
	private String description;
	
	private E01ResultCode(String resultCode, String description) {
		this.resultCode = resultCode;
		this.description = description;
	}
	
	public String getResultCode(){
		return this.resultCode;
	}
	
	public String getMessage(){
		return this.description;
	}
}
