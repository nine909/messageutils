package validate;

import msgutils.enums.KEY_REQUIREMENT;
import msgutils.message.conttype.CommaSeparatorType;
import msgutils.message.model.AttributeCheckingModel;
import msgutils.message.model.ElementCheckingModel;
import msgutils.message.model.XmlDataTree;
import enums.PathE01MsgCmd;
import exception.ValidationFailedException;

public class E01ProvisionResponseValidator extends SMFMessageValidator{
	
	public E01ProvisionResponseValidator() {
		this.addRule(ElementCheckingModel.check(PathE01MsgCmd.EXT_MSG.getPath(), KEY_REQUIREMENT.MANDATORY));
		this.addRule(AttributeCheckingModel.check(PathE01MsgCmd.EXT_MSG.getPath(), "command", KEY_REQUIREMENT.FLAT_MANDATORY, null));
		this.addRule(AttributeCheckingModel.check(PathE01MsgCmd.EXT_MSG.getPath(), "objecttype", KEY_REQUIREMENT.FLAT_MANDATORY, null));
		this.addRule(AttributeCheckingModel.check(PathE01MsgCmd.EXT_MSG.getPath(), "resultcode", KEY_REQUIREMENT.FLAT_MANDATORY, null));
		this.addRule(AttributeCheckingModel.check(PathE01MsgCmd.EXT_MSG.getPath(), "description", KEY_REQUIREMENT.FLAT_MANDATORY, null));
		this.addRule(AttributeCheckingModel.check(PathE01MsgCmd.EXT_MSG.getPath(), "key", KEY_REQUIREMENT.FLAT_MANDATORY, new CommaSeparatorType()));
		this.addRule(AttributeCheckingModel.check(PathE01MsgCmd.EXT_MSG.getPath(), "data", KEY_REQUIREMENT.FLAT_MANDATORY, null));
		
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
