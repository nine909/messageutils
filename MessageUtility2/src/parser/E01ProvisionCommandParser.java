package parser;

import interfaces.E01ProvRespInterface;

public class E01ProvisionCommandParser extends SMFMessageParser implements E01ProvRespInterface{

	public E01ProvisionCommandParser() {
		super();
	}
	
	public static E01ProvisionCommandParser newInstance(String message){
		E01ProvisionCommandParser parser = new E01ProvisionCommandParser();
		parser.setMessage(message);
		return parser;
	}
	
	public String getE01Command(){
		return getAtValE01MsgElement("command");
	}
	
	public String getE01ObjectType(){
		return getAtValE01MsgElement("objecttype");
	}
	
	public String getE01ResultCode(){
		return getAtValE01MsgElement("resultcode");
	}
	
	public String getE01Description(){
		return getAtValE01MsgElement("description");
	}
	
	@Override
	public String getObjectType() {
		return getAtValE01MsgElement("objecttype");
	}
	
	public String[] getKeywords(){
		try {
			return this.getAtValE01MsgElement("key").split(",");
		} catch (Exception e) {
			return null;
		}
	}
	
	public String getData(){
		return this.getAtValE01MsgElement("data");
	}

}
