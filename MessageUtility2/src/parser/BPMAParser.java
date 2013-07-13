package parser;

import interfaces.BPMAInterface;

import java.awt.List;

public class BPMAParser extends SMFMessageParser implements BPMAInterface{

	public static BPMAParser newInstance(String message){
		BPMAParser parser = new BPMAParser();
		parser.setMessage(message);
		return parser;
	}
	
	@Override
	public String getSession() {
		return this.getValBPMElement("session");
	}

	@Override
	public String getUserName() {
		return this.getValBPMElement("username");
	}

	@Override
	public String getBPMCommand() {
		return this.getValBPMElement("command");
	}

	@Override
	public String getType() {
		return this.getValBPMElement("type");
	}

	@Override
	public String getServiceName() {
		return this.getValServNElement("value");
	}

	@Override
	public String getBPMResultCode() {
		return this.getValResultCodeElement("value");
	}

	@Override
	public String getE01Command() {
		return this.getValE01ProElement("command");
	}

	@Override
	public String getE01ResultCode() {
		return this.getValE01ProElement("resultcode");
	}

	@Override
	public String getE01Description() {
		return this.getValE01ProElement("description");
	}

	@Override
	public String getObjectType() {
		return this.getValE01ProElement("objecttype");
	}

	@Override
	public String[] getKeywords() {

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

	@Override
	public String getData() {
		String data = this.getValDataElement("value");
		if( data != null){
			return data;
		}else{
			return this.getValE01ProElement("data");
		}
	}
	
}
