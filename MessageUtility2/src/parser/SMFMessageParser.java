package parser;

import enums.PathBPM;
import enums.PathE01MsgCmd;
import msgutils.message.factory.XmlParser;

public class SMFMessageParser extends XmlParser{

	private String message;
	
	public SMFMessageParser() {
		super();
	}
	
	public static SMFMessageParser newInstance(){
		SMFMessageParser parser = new SMFMessageParser();
		return parser;
	}
	
	public void setMessageParser(String message){
		this.message = message;
	}
	
	public OsRARParser getOsRARParser(){
		return OsRARParser.newInstance(message);
	}
	
	public OsRAAParser getOsRAAParser(){
		return OsRAAParser.newInstance(message);
	}
	
	public InquerySessionInfoResponseParser getInquerySessionInfoResponseParser(){
		return InquerySessionInfoResponseParser.newInstance(message);
	}

	public BPMRParser getBPMRParser(){
		return BPMRParser.newInstance(message);
	}

	public BPMAParser getBPMAParser(){
		return BPMAParser.newInstance(message);
	}
	
	public E01ProvisionCommandParser getE01ProvisionCommandParser(){
		return E01ProvisionCommandParser.newInstance(message);
	}

	
	/*** for parser BPM message ***/
	protected String getValBPMElement(String attributeName) {
		try{
			return this.getElements(PathBPM.BPM.getPath()).getFirst().getAttribute(attributeName);
		}catch (Exception e) {
			return null;
		}
	}

	protected String getValServNElement(String attributeName){
		try{
			return this.getElements(PathBPM.SERVICE_NAME.getPath()).getFirst().getAttribute(attributeName);
		}catch (Exception e) {
			return null;
		}
	}

	protected String getValResultCodeElement(String attributeName){
		try{
			return this.getElements(PathBPM.RESULT_CODE.getPath()).getFirst().getAttribute(attributeName);
		}catch (Exception e) {
			return null;
		}
	}

	protected String getValE01ProElement(String attributeName){
		try{
			return this.getElements(PathBPM.E01_PROVISION.getPath()).getFirst().getAttribute(attributeName);
		}catch (Exception e) {
		return null;
		}
	}
	
	protected String  getValDataElement(String attributeName){
		try{
			return this.getElements(PathBPM.DATA.getPath()).getFirst().getAttribute(attributeName);
		}catch (Exception e) {
		return null;
		}
	}
	

	/*** for parser ext-message ***/
	
	protected String getAtValE01MsgElement(String attributeName){
		try{
			return getElements(PathE01MsgCmd.EXT_MSG.getPath()).getFirst().getAttribute(attributeName);
		}catch (Exception e) {
		return null;
		}
	}
}
