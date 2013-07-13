package validate;

import msgutils.message.factory.XmlValidator;
import msgutils.message.model.XmlDataTree;

public class SMFMessageValidator extends XmlValidator{
		
	public static SMFMessageValidator newInstance(boolean debugMode){
		SMFMessageValidator validator = new SMFMessageValidator();
		validator.setDebugMode(debugMode);
		return validator;
	}
	
	public boolean validateBPMR(XmlDataTree dataTree) throws Exception {
		BPMRValidator validator = new BPMRValidator();
		validator.setDebugMode(isDebugMode());
		 return validator.validate(dataTree);
	}
	
	public boolean validateBPMA(XmlDataTree dataTree) throws Exception {
		BPMAValidator validator = new BPMAValidator();
		validator.setDebugMode(isDebugMode());
		 return validator.validate(dataTree);
	}
	
	public boolean validateE01Response(XmlDataTree dataTree) throws Exception {
		E01ProvisionResponseValidator validator = new E01ProvisionResponseValidator();
		validator.setDebugMode(isDebugMode());
		 return validator.validate(dataTree);
	}
	
	public boolean validateOsRAR(XmlDataTree dataTree) throws Exception {
		OsRARValidator validator = new OsRARValidator();
		validator.setDebugMode(isDebugMode());
		return validator.validate(dataTree);
	}
	
	public boolean validateOsRAA(XmlDataTree dataTree) throws Exception {
		OsRAAValidator validator = new OsRAAValidator();
		validator.setDebugMode(isDebugMode());
		return validator.validate(dataTree);
	}
	
	public boolean validateInquerySessionInfoResponse(XmlDataTree dataTree) throws Exception {
		InquerySessionInfoResponseValidator validator = new InquerySessionInfoResponseValidator();
		validator.setDebugMode(isDebugMode());
		return validator.validate(dataTree);
	}
	
}
