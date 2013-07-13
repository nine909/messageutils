package parser;

import java.util.LinkedList;

import enums.PathOsRAA;

import msgutils.message.model.XmlElementModel;
import msgutils.message.factory.XmlParser;;

public class OsRAAParser extends XmlParser{
	public OsRAAParser() {
		super();
	}
	
	public static OsRAAParser newInstance(String message){
		OsRAAParser parser = new OsRAAParser();
		parser.setMessage(message);
		return parser;
	}
	
	public String getOriginHost(){
		return getValue(this.getElements(PathOsRAA.ORIGIN_HOST.getPath(), false));
	}
	
	public String getOriginRealm(){
		return getValue(this.getElements(PathOsRAA.ORIGIN_REALM.getPath(), false));
	}
	
	public String getOriginStateId(){
		return getValue(this.getElements(PathOsRAA.ORIGIN_STATE_ID.getPath(), false));
	}
	
	public String getResultCode(){
		return getValue(this.getElements(PathOsRAA.RESULT_CODE.getPath(), false));
	}

	public String getSessionId(){
		return getValue(this.getElements(PathOsRAA.SESSION_ID.getPath(), false));
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
	protected LinkedList<XmlElementModel> getElements(String path, boolean isMultiple){
		try{
			return super.getElements(path, isMultiple);
		}catch (Exception e) {
			return null;
		}
	}
}
