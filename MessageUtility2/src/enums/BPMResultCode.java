package enums;

public enum BPMResultCode {
	
	SUCESS("2000", "Success")
	,ERROR("5013", "Error")
	;
	
	private String resultCode;
	private String description;
	
	private BPMResultCode(String resultCode, String description) {
		this.resultCode = resultCode;
		this.description = description;
	}
	
	public String getResultCode(){
		return this.resultCode;
	}
	
	public String getDescription(){
		return this.description;
	}
}
