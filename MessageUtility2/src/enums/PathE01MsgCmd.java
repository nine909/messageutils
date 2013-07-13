package enums;

public enum PathE01MsgCmd {

	EXT_MSG("/ext-message")
	;
	
	private String path;
	
	private PathE01MsgCmd(String path) {
		this.path = path;
	}
		
	public String getPath(){
		return this.path;
	}
}
