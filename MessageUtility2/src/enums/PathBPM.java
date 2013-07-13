package enums;

public enum PathBPM {

	BPM("/BPM")
	,SERVICE_NAME("/BPM/Service-Name")
	,E01_PROVISION("/BPM/E01-Provision")
	,RESULT_CODE("/BPM/Result-Code")
	,DATA("/BPM/E01-Provision/data")
	;
	
	private String path;

	private PathBPM(String path) {
		this .path = path;
	}
	
	public String getPath(){
		return this.path;
	}
}
