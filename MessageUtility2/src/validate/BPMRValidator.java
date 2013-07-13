package validate;

import java.util.ArrayList;

import msgutils.enums.KEY_REQUIREMENT;
import msgutils.message.model.AttributeCheckingModel;
import msgutils.message.model.ElementCheckingModel;
import msgutils.message.model.XmlDataTree;
import utils.DataValidator;
import utils.KeywordValidator;
import enums.PathBPM;
import exception.ValidationFailedException;

public class BPMRValidator extends SMFMessageValidator{

	public BPMRValidator() {
		this.addRule(ElementCheckingModel.check(PathBPM.BPM.getPath(), KEY_REQUIREMENT.MANDATORY));
		this.addRule(AttributeCheckingModel.check(PathBPM.BPM.getPath(), "session", KEY_REQUIREMENT.FLAT_MANDATORY, null));
		this.addRule(AttributeCheckingModel.check(PathBPM.BPM.getPath(), "username", KEY_REQUIREMENT.FLAT_MANDATORY, null));
		this.addRule(AttributeCheckingModel.check(PathBPM.BPM.getPath(), "password", KEY_REQUIREMENT.FLAT_MANDATORY, null));
		this.addRule(AttributeCheckingModel.check(PathBPM.BPM.getPath(), "command", KEY_REQUIREMENT.FLAT_MANDATORY, null));
		this.addRule(AttributeCheckingModel.check(PathBPM.BPM.getPath(), "type", KEY_REQUIREMENT.FLAT_MANDATORY, null));

		this.addRule(ElementCheckingModel.check(PathBPM.SERVICE_NAME.getPath(), KEY_REQUIREMENT.MANDATORY));
		this.addRule(AttributeCheckingModel.check(PathBPM.SERVICE_NAME.getPath(), "value", KEY_REQUIREMENT.CHAIN_MANDATORY, null));
		
		this.addRule(ElementCheckingModel.check(PathBPM.E01_PROVISION.getPath(), KEY_REQUIREMENT.MANDATORY));
		this.addRule(AttributeCheckingModel.check(PathBPM.E01_PROVISION.getPath(), "command", KEY_REQUIREMENT.FLAT_MANDATORY, null));
		this.addRule(AttributeCheckingModel.check(PathBPM.E01_PROVISION.getPath(), "objecttype", KEY_REQUIREMENT.FLAT_MANDATORY, null));

	}
	
	@Override
	public boolean validate(XmlDataTree dataTree) throws Exception {
		boolean result = false;
			result = super.validate(dataTree);
			
			KeywordValidator validateKeys = new KeywordValidator(PathBPM.E01_PROVISION.getPath());
			validateKeys.setDebugMode(isDebugMode());
			ArrayList<String[]> errKeysRecord = validateKeys.getValidate(dataTree);
			
			DataValidator dataValidator = new DataValidator();
			dataValidator.setDebugMode(isDebugMode());
			ArrayList<String[]> errDataRecord = dataValidator.getValidate(PathBPM.E01_PROVISION.getPath(), dataTree);
			if(!result || errKeysRecord != null || errDataRecord != null){
				result = false;
				if(errKeysRecord != null)
					errorRecord.addAll(errKeysRecord);
				if(errDataRecord != null)
					errorRecord.addAll(errDataRecord);
				throw new ValidationFailedException(errorRecord);
			}
		return result;
	}

	
}
