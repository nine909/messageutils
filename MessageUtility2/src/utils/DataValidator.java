package utils;

import java.util.ArrayList;

import msgutils.enums.KEY_REQUIREMENT;
import msgutils.message.model.AttributeCheckingModel;
import msgutils.message.model.ElementCheckingModel;
import msgutils.message.model.XmlDataTree;
import validate.SMFMessageValidator;

public class DataValidator extends SMFMessageValidator{

	private String elementPath;
	
	public DataValidator() {
		super();
	}
	
	public DataValidator(String elementPath) {
		this.elementPath = elementPath;
	}
	
	private boolean valDAttribute(XmlDataTree dataTree) throws Exception{
		boolean result = false;
		
		this.addRule(ElementCheckingModel.check(elementPath, KEY_REQUIREMENT.MANDATORY));
		this.addRule(AttributeCheckingModel.check(elementPath, "data", KEY_REQUIREMENT.CHAIN_MANDATORY, null));
		
		result = this.validate(dataTree);
		return result;
	}
	
	private boolean valDElement(XmlDataTree dataTree) throws Exception{
		boolean result = false;
		
		this.addRule(ElementCheckingModel.check(elementPath, KEY_REQUIREMENT.MANDATORY));
		this.addRule(AttributeCheckingModel.check(elementPath, "value", KEY_REQUIREMENT.CHAIN_MANDATORY, null));
		
		result = this.validate(dataTree);

		return result;
	}
	
	public ArrayList<String[]> getValidate(String elementParentPath,XmlDataTree dataTree){
		boolean result = false;
		try{
			DataValidator validator = new DataValidator(elementParentPath+"/data");
			result = validator.valDElement(dataTree);
			if(!result){
				ArrayList<String[]> errRecord = validator.errorRecord;
				DataValidator validator2 = new DataValidator(elementParentPath);
				result = validator2.valDAttribute(dataTree);
				if(!result){
					errRecord = validator2.errorRecord;
					return 
							errRecord;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
