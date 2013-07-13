package validate;

import msgutils.enums.KEY_REQUIREMENT;
import msgutils.message.model.AttributeCheckingModel;
import msgutils.message.model.ElementCheckingModel;
import msgutils.message.model.XmlDataTree;
import enums.PathOsRAA;
import exception.ValidationFailedException;

public class OsRAAValidator extends SMFMessageValidator{

	public OsRAAValidator() {
		this.addRule(ElementCheckingModel.check(PathOsRAA.ORIGIN_HOST.getPath(), KEY_REQUIREMENT.MANDATORY));
		this.addRule(AttributeCheckingModel.check(PathOsRAA.ORIGIN_HOST.getPath(), "value", KEY_REQUIREMENT.CHAIN_MANDATORY, null));

		this.addRule(ElementCheckingModel.check(PathOsRAA.ORIGIN_REALM.getPath(), KEY_REQUIREMENT.MANDATORY));
		this.addRule(AttributeCheckingModel.check(PathOsRAA.ORIGIN_REALM.getPath(), "value", KEY_REQUIREMENT.CHAIN_MANDATORY, null));

		this.addRule(ElementCheckingModel.check(PathOsRAA.ORIGIN_STATE_ID.getPath(), KEY_REQUIREMENT.MANDATORY));
		this.addRule(AttributeCheckingModel.check(PathOsRAA.ORIGIN_STATE_ID.getPath(), "value", KEY_REQUIREMENT.CHAIN_MANDATORY, null));

		this.addRule(ElementCheckingModel.check(PathOsRAA.RESULT_CODE.getPath(), KEY_REQUIREMENT.MANDATORY));
		this.addRule(AttributeCheckingModel.check(PathOsRAA.RESULT_CODE.getPath(), "value", KEY_REQUIREMENT.CHAIN_MANDATORY, null));

		this.addRule(ElementCheckingModel.check(PathOsRAA.SESSION_ID.getPath(), KEY_REQUIREMENT.MANDATORY));
		this.addRule(AttributeCheckingModel.check(PathOsRAA.SESSION_ID.getPath(), "value", KEY_REQUIREMENT.CHAIN_MANDATORY, null));
	}
	
	@Override
	public boolean validate(XmlDataTree dataTree) throws Exception {
		boolean result = false;
			result = super.validate(dataTree);
			if(!result){
				throw new ValidationFailedException(errorRecord);
			}
		return result;
	}
}
