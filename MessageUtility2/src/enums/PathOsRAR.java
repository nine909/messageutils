package enums;

public enum PathOsRAR {
	AUTH_APPLICATION_ID("/Auth-Application-Id")
	,DESTINATION_HOST("/Destination-Host")
	,DESTINATION_REALM("/Destination-Realm")
	,ORIGIN_HOST("/Origin-Host")
	,ORIGIN_REALM("/Origin-Realm")
	,RE_AUTH_REQUEST_TYPE("/Re-Auth-Request-Type")
	,SESSION_ID("/Session-Id")
	,USER_NAME("/User-Name")
	;
	
	protected String path;
	
	private PathOsRAR(String path) {
		this.path = path;
	}
	
	public String getPath(){
		return this.path;
	}
}
