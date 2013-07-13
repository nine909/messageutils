package enums;

public enum PathOsRAA {
	ORIGIN_HOST("/Origin-Host")
	,ORIGIN_REALM("/Origin-Realm")
	,ORIGIN_STATE_ID("/Origin-State-Id")
	,RESULT_CODE("/Result-Code")
	,SESSION_ID("/Session-Id")
	;
	
	protected String path;
	
	private PathOsRAA(String path) {
		this.path = path;
	}
	
	public String getPath(){
		return this.path;
	}
}
