package validate;

import utils.UserNameFormat;
import enums.PathOsRAR;
import exception.ValidationFailedException;
import msgutils.enums.KEY_REQUIREMENT;
import msgutils.message.model.AttributeCheckingModel;
import msgutils.message.model.ElementCheckingModel;
import msgutils.message.model.XmlDataTree;

public class OsRARValidator extends SMFMessageValidator{

	public OsRARValidator() {
		
		this.addRule(ElementCheckingModel.check(PathOsRAR.AUTH_APPLICATION_ID.getPath(), KEY_REQUIREMENT.MANDATORY));
		this.addRule(AttributeCheckingModel.check(PathOsRAR.AUTH_APPLICATION_ID.getPath(), "value", KEY_REQUIREMENT.CHAIN_MANDATORY, null));
		
		this.addRule(ElementCheckingModel.check(PathOsRAR.DESTINATION_HOST.getPath(), KEY_REQUIREMENT.MANDATORY));
		this.addRule(AttributeCheckingModel.check(PathOsRAR.DESTINATION_HOST.getPath(), "value", KEY_REQUIREMENT.CHAIN_MANDATORY, null));

		this.addRule(ElementCheckingModel.check(PathOsRAR.DESTINATION_REALM.getPath(), KEY_REQUIREMENT.MANDATORY));
		this.addRule(AttributeCheckingModel.check(PathOsRAR.DESTINATION_REALM.getPath(), "value", KEY_REQUIREMENT.CHAIN_MANDATORY, null));

		this.addRule(ElementCheckingModel.check(PathOsRAR.ORIGIN_HOST.getPath(), KEY_REQUIREMENT.MANDATORY));
		this.addRule(AttributeCheckingModel.check(PathOsRAR.ORIGIN_HOST.getPath(), "value", KEY_REQUIREMENT.CHAIN_MANDATORY, null));

		this.addRule(ElementCheckingModel.check(PathOsRAR.ORIGIN_REALM.getPath(), KEY_REQUIREMENT.MANDATORY));
		this.addRule(AttributeCheckingModel.check(PathOsRAR.ORIGIN_REALM.getPath(), "value", KEY_REQUIREMENT.CHAIN_MANDATORY, null));

		this.addRule(ElementCheckingModel.check(PathOsRAR.RE_AUTH_REQUEST_TYPE.getPath(), KEY_REQUIREMENT.MANDATORY));
		this.addRule(AttributeCheckingModel.check(PathOsRAR.RE_AUTH_REQUEST_TYPE.getPath(), "value", KEY_REQUIREMENT.CHAIN_MANDATORY, null));

		this.addRule(ElementCheckingModel.check(PathOsRAR.SESSION_ID.getPath(), KEY_REQUIREMENT.MANDATORY));
		this.addRule(AttributeCheckingModel.check(PathOsRAR.SESSION_ID.getPath(), "value", KEY_REQUIREMENT.CHAIN_MANDATORY, null));

		this.addRule(ElementCheckingModel.check(PathOsRAR.USER_NAME.getPath(), KEY_REQUIREMENT.MANDATORY));
		this.addRule(AttributeCheckingModel.check(PathOsRAR.USER_NAME.getPath(), "value", KEY_REQUIREMENT.CHAIN_MANDATORY, new UserNameFormat()));
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
