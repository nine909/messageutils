package parser;

import interfaces.BPMRInterface;

import java.awt.List;

public class BPMRParser extends SMFMessageParser implements BPMRInterface{

	public static BPMRParser newInstance(String message) {
		BPMRParser parser = new BPMRParser();
		parser.setMessage(message);
		return parser;
	}

	public String getSession(){
		return this.getValBPMElement("session");
	}

	public String getUserName(){
		return this.getValBPMElement("username");
	}

	public String getPassword(){
		return this.getValBPMElement("password");
	}

	public String getBPMCommand(){
		return this.getValBPMElement("command");
	}

	public String getType(){
		return this.getValBPMElement("type");
	}

	public String getServiceName(){
		return this.getValServNElement("value");
	}

	public String getE01Command(){
		return this.getValE01ProElement("command");
	}

	public String getObjectType(){
		return this.getValE01ProElement("objecttype");
	}

	public String[] getKeywords(){

			String Orkey = this.getValE01ProElement("key");
			if (Orkey != null) {
				return Orkey.split(",");
				
			} else if (this.getValE01ProElement("key9") != null) {
				List keys = new List();
				int i = 0;
				while (i < 10) {
					keys.add(this.getValE01ProElement("key" + i));
					i++;
				}
				String[] keywords = keys.getItems();
				return keywords;
				
			} else {
				List keys = new List();
				int i = 0;
				while (i < 5) {
					keys.add(this.getValE01ProElement("key" + i));
					i++;
				}
				String[] keywords = keys.getItems();
				return keywords;
			}
	}
	
	public String getData(){
		String data = this.getValDataElement("value");
		if( data != null){
			return data;
		}else{
			return this.getValE01ProElement("data");
		}
	}

}