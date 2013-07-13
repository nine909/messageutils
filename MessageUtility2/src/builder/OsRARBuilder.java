package builder;

import msgutils.message.factory.XmlBuilder;
import msgutils.message.model.XmlDataTree;
import msgutils.message.model.XmlElementModel;
import parser.OsRARParser;
import enums.PathOsRAR;

public class OsRARBuilder extends XmlBuilder{

	public OsRARBuilder(XmlDataTree dataTree){
		this.setDataTree(new XmlDataTree(dataTree.toString()));
		 Builder();
	}
	
	public void setSessionId(String sessionId){
		this.setValue(PathOsRAR.SESSION_ID.getPath(), sessionId);
	}
	
	public void setOriginHost(String originHost){
		this.setValue(PathOsRAR.ORIGIN_HOST.getPath(), originHost);
	}
	
	public void setOriginRealm(String originRealm){
		this.setValue(PathOsRAR.ORIGIN_REALM.getPath(), originRealm);
	}
	
	public void setDestinationHost(String destinationHost){
		this.setValue(PathOsRAR.DESTINATION_HOST.getPath(), destinationHost);
	}
	
	public void setDestinationRealm(String destinationRealm){
		this.setValue(PathOsRAR.DESTINATION_REALM.getPath(), destinationRealm);
	}
	
	private void Builder(){
		this.setValue(PathOsRAR.RE_AUTH_REQUEST_TYPE.getPath(), "0");
		
		this.addElement("/", "Subscription-Id");
		XmlElementModel idType = XmlElementModel.newInstance();
		idType.setName("Subscription-Id-Type");
		idType.addAttribute("value", "0");
		
		XmlElementModel idData = XmlElementModel.newInstance();
		idData.setName("Subscription-Id-Data");
		
		OsRARParser parser = OsRARParser.newInstance(dataTree.toString());
		idData.addAttribute("value", parser.getMsisdn());
		
		this.addElement("/Subscription-Id", idType);
		this.addElement("/Subscription-Id", idData);
		
	}

	private void setValue(String elementPath ,String value){
		try {
			this.getElements(elementPath).getFirst().setAttribute("value", value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
