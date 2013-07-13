package builder;

import enums.PathOsRAA;
import msgutils.message.factory.XmlBuilder;
import msgutils.message.model.XmlDataTree;

public class OsRAABuilder extends XmlBuilder{
	
	private boolean flagData;
	
	public OsRAABuilder() {
		super();
		newDataTree();
		this.flagData = false;
	}
	
	public OsRAABuilder(XmlDataTree dataTree) {
		this.setDataTree(new XmlDataTree(dataTree.toString()));
		this.flagData = true;
	}
	
	public void setSessionId(String sessionId){
		if(flagData){
			this.setAttributeValue(PathOsRAA.SESSION_ID.getPath(), "value", sessionId);
		}else{
			if(this.addElement("/", "Session-Id"))
				this.newAttribute(PathOsRAA.SESSION_ID.getPath(), "value", sessionId);
		}
	}
	
	public void setOriginHost(String originHost){
		if(flagData){
			this.setAttributeValue(PathOsRAA.ORIGIN_HOST.getPath(), "value", originHost);
		}else{
			if(this.addElement("/", "Origin-Host"))
				this.newAttribute(PathOsRAA.ORIGIN_HOST.getPath(), "value", originHost);
		}
	}
	
	public void setOriginRealm(String originRealm){
		if(flagData){
			this.setAttributeValue(PathOsRAA.ORIGIN_REALM.getPath(), "value", originRealm);
		}else{
			if(this.addElement("/", "Origin-Realm"))
				this.newAttribute(PathOsRAA.ORIGIN_REALM.getPath(), "value", originRealm);
		}
	}
	
	public void setResultCode(String resultCode){
		if(flagData){
			this.setAttributeValue(PathOsRAA.RESULT_CODE.getPath(), "value", resultCode);
		}else{
			if(this.addElement("/", "Result-Code"))
				this.newAttribute(PathOsRAA.RESULT_CODE.getPath(), "value", resultCode);
		}
	}

	public void setOriginStateId(String originStateId) {
		if(flagData){
			this.setAttributeValue(PathOsRAA.ORIGIN_STATE_ID.getPath(), "value", originStateId);
		}else{
			if(this.addElement("/", "Origin-State-Id"))
				this.newAttribute(PathOsRAA.ORIGIN_STATE_ID.getPath(), "value", originStateId);
		}
	}
}
