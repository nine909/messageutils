package parser;

import java.util.LinkedList;

import enums.PathOsRAR;
import msgutils.message.conttype.ThaiMsisdnType;
import msgutils.message.model.XmlElementModel;

public class OsRARParser extends SMFMessageParser{
	
	public OsRARParser() {
		super();
	}

	public static OsRARParser newInstance(String message) {
		OsRARParser parser = new OsRARParser();
		parser.setMessage(message);
		return parser;
	}

	public String getAuthApplicationId(){
		return getValue(this.getElements(PathOsRAR.AUTH_APPLICATION_ID.getPath(), false));
	}
	
	public String getDestinationHost(){
		return getValue(this.getElements(PathOsRAR.DESTINATION_HOST.getPath(), false));
	}

	public String getDestinationRealm(){
		return getValue(this.getElements(PathOsRAR.DESTINATION_REALM.getPath(), false));
	}

	public String getOriginHost(){
		return getValue(this.getElements(PathOsRAR.ORIGIN_HOST.getPath(), false));
	}

	public String getOriginRealm(){
		return getValue(this.getElements(PathOsRAR.ORIGIN_REALM.getPath(), false));
	}

	public  String getReAuthRequestType(){
		return getValue(this.getElements(PathOsRAR.RE_AUTH_REQUEST_TYPE.getPath(), false));
	}
	
	public String getSessionId(){
		return getValue(this.getElements(PathOsRAR.SESSION_ID.getPath(), false));
	}

	public String getUserName(){
		return getValue(this.getElements(PathOsRAR.USER_NAME.getPath(), false));
	}
	
	public String getMsisdn(){
		
		String userName = getUserName();
		
		String[] msisdn = new ThaiMsisdnType().filter(userName);
		
		if(msisdn != null){
			return msisdn[0];
		}
		return null;
	}
	
	private String getValue(LinkedList<XmlElementModel> XmlElement){
		try{
			return XmlElement.getFirst().getAttribute("value");
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	protected LinkedList<XmlElementModel> getElements(String path, boolean b){
		try{
		return super.getElements(path, b);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
