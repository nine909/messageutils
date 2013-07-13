package validate;

import java.util.ArrayList;

import msgutils.message.model.XmlDataTree;
import parser.InquerySessionInfoResponseParser;
import exception.ValidationFailedException;

public class InquerySessionInfoResponseValidator extends SMFMessageValidator{

	ArrayList<String[]> errList;
	
	private InquerySessionInfoResponseParser parser;
	public InquerySessionInfoResponseValidator() {
		super();
	}
	
	private boolean validateMethodVersion(){

		try{
			String valueType = parser.getMethodVersion();
			if("".equals(valueType)){
				String[] err = new String[4];
				err[0] = "INVALID_VALUE";
				err[1] = "1";
				err[2] = "/AVP@@methodVersion";
				err[3] = "value";
				errList.add( err );
				return false;
			}else if (valueType == null) {
				String[] err = new String[3];
				err[0] = "MISSING_ELEMENT";
				err[1] = "1";
				err[2] = "/AVP@methodVersion"; 
				errList.add(err);
				return false;
			}else {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean validateSessionType(){

		try{
			String valueType = parser.getSessionType();
			if("".equals(valueType)){
				String[] err = new String[4];
				err[0] = "INVALID_VALUE";
				err[1] = "1";
				err[2] = "/AVP@sessionType";
				err[3] = "value";
				errList.add( err );
				return false;
			}else if (valueType == null) {
				String[] err = new String[3];
				err[0] = "MISSING_ELEMENT";
				err[1] = "1";
				err[2] = "/AVP@sessionType"; 
				errList.add(err);
				return false;
			}else {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean validateResultInfo(){

		try{
			String valueType = parser.getResultInfo();
			if("".equals(valueType)){
				String[] err = new String[4];
				err[0] = "INVALID_VALUE";
				err[1] = "1";
				err[2] = "/AV@resultInfo";
				err[3] = "value";
				errList.add( err );
				return false;
			}else if (valueType == null) {
				String[] err = new String[3];
				err[0] = "MISSING_ELEMENT";
				err[1] = "1";
				err[2] = "/AVP@resultInfo"; 
				errList.add(err);
				return false;
			}else {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean validateSessionInfo(){

		try{
			String[] valueType = parser.getSessionInfo();
			if (valueType == null) {
				String[] err = new String[4];
				err[0] = "MISSING_ELEMENT";
				err[1] = "1";
				err[2] = "/AVP@sessionInfo"; 
				errList.add(err);
				return false;
			}else if("".equals(valueType[0])){
				String[] err = new String[3];
				err[0] = "INVALID_VALUE";
				err[1] = "1";
				err[2] = "/AVP@sessionInfo";
				err[3] = "value";
				errList.add( err );
				return false;
			}else {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean validate(XmlDataTree dataTree) throws Exception {

		boolean result = false ,result1 ,result2 ,result3 ,result4;
			parser = InquerySessionInfoResponseParser.newInstance(dataTree.toString());
			errList = new ArrayList<String[]>();
			
			result1 = validateMethodVersion();
			if(!debugMode && !result1){
				throw new ValidationFailedException(errList);
			}
			result2 = validateResultInfo();
			if(!debugMode && !result2){
				throw new ValidationFailedException(errList);
			}
			result3 = validateSessionType();
			if(!debugMode && !result3){
				throw new ValidationFailedException(errList);
			}
			result4 = validateSessionInfo();
			
			result = result1 && result2 && result3 && result4;
			
			if(!result){
				throw new ValidationFailedException(errList);
			}
		return result;
	}
	
}
