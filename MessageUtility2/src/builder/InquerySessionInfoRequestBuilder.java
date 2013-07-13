package builder;

import java.util.LinkedList;

import enums.PathInqSsInfo;
import msgutils.message.factory.XmlBuilder;
import msgutils.message.model.XmlElementModel;

public class InquerySessionInfoRequestBuilder extends XmlBuilder{

	LinkedList<XmlElementModel> elementList;
	
	public InquerySessionInfoRequestBuilder() {
		newDataTree();
		Builder();
	}
	
	private void Builder(){
		
		try {
			this.addElement("/", "AVP");
			this.addElement("/", "AVP");
			this.addElement("/", "AVP"); 
			this.elementList = this.getElements(PathInqSsInfo.AVP.getPath());
			
			this.elementList.get(2).addAttribute("type", PathInqSsInfo.METHOD_VERSION.getPath());
			XmlElementModel methodVelementModel = XmlElementModel.newInstance();
			methodVelementModel.setName("vals");
			methodVelementModel.addAttribute("value", "1");
			this.elementList.add(methodVelementModel);
			this.elementList.get(2).addChildren(methodVelementModel);

			this.elementList.get(0).addAttribute("type", PathInqSsInfo.SESSION_TYPE.getPath());
			XmlElementModel sessionTypeModel = XmlElementModel.newInstance();
			sessionTypeModel.setName("vals");
			sessionTypeModel.addAttribute("value", "1");
			this.elementList.add(sessionTypeModel);
			this.elementList.get(0).addChildren(sessionTypeModel);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void setResultInfo(String msisdn) {

		this.elementList.get(1).addAttribute("type", PathInqSsInfo.RESULT_INFO.getPath());
		XmlElementModel sessionTypeModel = XmlElementModel.newInstance();
		sessionTypeModel.setName("vals");
		sessionTypeModel.addAttribute("value", msisdn);
		this.elementList.add(sessionTypeModel);
		this.elementList.get(1).addChildren(sessionTypeModel);
	}

}
