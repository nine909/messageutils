package enums;

public enum PathInqSsInfo {
	
	AVP("/AVP")
	,AVP_VALS("/AVP/vals")
	
	,SESSION_TYPE("sessionType")
	,RESULT_INFO("resultInfo")
	,METHOD_VERSION("methodVersion")
	,SESSION_INFO("sessionInfo")
	;
	
	protected String path;
	
	PathInqSsInfo(String path){
		this.path = path;
	}
	
	public String getPath(){
		return this.path;
	}
}
