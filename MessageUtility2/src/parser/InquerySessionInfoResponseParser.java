package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import enums.PathInqSsInfo;

import msgutils.message.model.XmlElementModel;

public class InquerySessionInfoResponseParser extends SMFMessageParser{

	private HashMap<String, String> elementModelMap;
	private ArrayList<String> sessionInfoList;
	public InquerySessionInfoResponseParser() {
		super();
	}
	
	public static InquerySessionInfoResponseParser newInstance(String message){
		InquerySessionInfoResponseParser parser = new InquerySessionInfoResponseParser();
		parser.setMessage(message);
		parser.processValue();
		return parser;
	}
	
	public String getSessionType(){
		return this.getValueMap(PathInqSsInfo.SESSION_TYPE.getPath());
	}
	
	public String getMethodVersion(){
		return this.getValueMap(PathInqSsInfo.METHOD_VERSION.getPath());
	}
	
	public String getResultInfo(){
		return this.getValueMap(PathInqSsInfo.RESULT_INFO.getPath());
	}
	
	public String[] getSessionInfo(){
		try{
			String[] sessionInfo = this.sessionInfoList.toArray(new String[this.sessionInfoList.size()]);
			if(sessionInfo != null && sessionInfo.length != 0){
				return sessionInfo;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void processValue(){
		
		this.elementModelMap = new HashMap<String, String>();
		this.sessionInfoList = new ArrayList<String>();
		try{
			LinkedList<XmlElementModel> elementModels = this.getValueElement();
			
			for(XmlElementModel elementModel:elementModels){
				String elementBuffer = elementModel.getParent(getDataTree()).getAttribute("type");
				if("methodVersion".equals(elementBuffer)){
					elementModelMap.put(elementBuffer, elementModel.getAttribute("value"));
				}
				else if("resultInfo".equals(elementBuffer)){
					elementModelMap.put(elementBuffer, elementModel.getAttribute("value"));
				}
				else if("sessionType".equals(elementBuffer)){
					elementModelMap.put(elementBuffer, elementModel.getAttribute("value"));
				}
				else if("sessionInfo".equals(elementBuffer)){
					sessionInfoList.add(elementModel.getAttribute("value"));
				}
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private LinkedList<XmlElementModel> getValueElement(){
		try{
			return this.getElements(PathInqSsInfo.AVP_VALS.getPath(), true);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String getValueMap(String keyMap){
		try {
			return this.elementModelMap.get(keyMap);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
