package utils;

import msgutils.message.conttype.ThaiMsisdnType;
import msgutils.message.interfaces.ContentType;

public class UserNameFormat implements ContentType{
	
	private boolean validateUserName(String userName){
			if((userName.indexOf("msisdn") == 0) && (userName.indexOf("@ais.co.th") == 17 || userName.indexOf(".ais.co.th") == 17)){
				if(new ThaiMsisdnType().checkFormat(userName.substring(6, 17))){
					return true;
				}
			}
		return false;
	}

	@Override
	public boolean checkFormat(String userName) {
		return validateUserName(userName);
	}

	@Override
	public String[] filter(String value) {
		// TODO Auto-generated method stub
		return null;
	}
}
