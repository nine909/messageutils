package utils;

import java.util.ArrayList;

import msgutils.enums.KEY_REQUIREMENT;
import msgutils.message.conttype.CommaSeparatorType;
import msgutils.message.model.AttributeCheckingModel;
import msgutils.message.model.ElementCheckingModel;
import msgutils.message.model.XmlDataTree;
import validate.SMFMessageValidator;

public class KeywordValidator extends SMFMessageValidator{

	private String elementPath;
	
	public KeywordValidator(){
		super();
	}
	
	public KeywordValidator(String elementPath) {
		this.elementPath = elementPath;
	}
	
	private boolean ValidateKeys(XmlDataTree dataTree) throws Exception{
		boolean result = false;
			
			 this.addRule(ElementCheckingModel.check(elementPath, KEY_REQUIREMENT.MANDATORY));
			 this.addRule(AttributeCheckingModel.check(elementPath, "key", KEY_REQUIREMENT.MANDATORY, new CommaSeparatorType()));
				 
			result = this.validate(dataTree);
			
			return result;
	}
	
	private boolean ValidateFiveKeys(XmlDataTree dataTree) throws Exception{
		boolean result = false;
			
			this.addRule(ElementCheckingModel.check(elementPath, KEY_REQUIREMENT.MANDATORY));
			this.addRule(AttributeCheckingModel.check(elementPath, "key0", KEY_REQUIREMENT.MANDATORY, null));
			this.addRule(AttributeCheckingModel.check(elementPath, "key1", KEY_REQUIREMENT.MANDATORY, null));
			this.addRule(AttributeCheckingModel.check(elementPath, "key2", KEY_REQUIREMENT.MANDATORY, null));
			this.addRule(AttributeCheckingModel.check(elementPath, "key3", KEY_REQUIREMENT.MANDATORY, null));
			this.addRule(AttributeCheckingModel.check(elementPath, "key4", KEY_REQUIREMENT.MANDATORY, null));
			
			result = this.validate(dataTree);
			
			return result;
	}
	
	private boolean ValidateNineKeys(XmlDataTree dataTree)throws Exception{
		boolean result = false;
			
			this.addRule(ElementCheckingModel.check(elementPath, KEY_REQUIREMENT.MANDATORY));
			this.addRule(AttributeCheckingModel.check(elementPath, "key0", KEY_REQUIREMENT.MANDATORY, null));
			this.addRule(AttributeCheckingModel.check(elementPath, "key1", KEY_REQUIREMENT.MANDATORY, null));
			this.addRule(AttributeCheckingModel.check(elementPath, "key2", KEY_REQUIREMENT.MANDATORY, null));
			this.addRule(AttributeCheckingModel.check(elementPath, "key3", KEY_REQUIREMENT.MANDATORY, null));
			this.addRule(AttributeCheckingModel.check(elementPath, "key4", KEY_REQUIREMENT.MANDATORY, null));
			this.addRule(AttributeCheckingModel.check(elementPath, "key5", KEY_REQUIREMENT.MANDATORY, null));
			this.addRule(AttributeCheckingModel.check(elementPath, "key6", KEY_REQUIREMENT.MANDATORY, null));
			this.addRule(AttributeCheckingModel.check(elementPath, "key7", KEY_REQUIREMENT.MANDATORY, null));
			this.addRule(AttributeCheckingModel.check(elementPath, "key8", KEY_REQUIREMENT.MANDATORY, null));
			this.addRule(AttributeCheckingModel.check(elementPath, "key9", KEY_REQUIREMENT.MANDATORY, null));
			
			result = this.validate(dataTree);
			
			return result;
	}

	public ArrayList<String[]> getValidate(XmlDataTree dataTree){
		boolean result = false;
		try{
			ArrayList<String[]> errList = new ArrayList<String[]>();
			KeywordValidator keys = new KeywordValidator(this.elementPath);
			keys.setDebugMode(isDebugMode());
			result = keys.ValidateKeys(dataTree);
			if(!result){
				errList = keys.errorRecord;
				KeywordValidator keysNine = new KeywordValidator(this.elementPath);
				keysNine.setDebugMode(isDebugMode());
				result = keysNine.ValidateNineKeys(dataTree);
				if(!result){
					errList = keysNine.errorRecord;
					KeywordValidator keysFive = new KeywordValidator(this.elementPath);
					keysFive.setDebugMode(isDebugMode());
					result = keysFive.ValidateFiveKeys(dataTree);
					if(!result){
						errList = keysFive.errorRecord;
						return errList;
					}
				}
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	
}
