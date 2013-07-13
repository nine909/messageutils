package tester;

import enums.PathBPM;
import exception.ValidationFailedException;
import parser.BPMAParser;
import parser.BPMRParser;
import parser.E01ProvisionCommandParser;
import parser.InquerySessionInfoResponseParser;
import parser.OsRAAParser;
import parser.OsRARParser;
import parser.SMFMessageParser;
import validate.E01ProvisionResponseValidator;
import validate.InquerySessionInfoResponseValidator;
import validate.OsRARValidator;
import validate.SMFMessageValidator;

public class ValidateTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String message = concatArguments(args); 
		
		SMFMessageParser parser = SMFMessageParser.newInstance();
		parser.setMessageParser(message);

		SMFMessageValidator smfValidator = SMFMessageValidator.newInstance(true);
		try{
//		BPMRParser bpmrParser = parser.getBPMRParser();
//		System.out.println(smfValidator.validateBPMR(bpmrParser.getDataTree()));
		
//		BPMAParser bpmaParser = parser.getBPMAParser();
//		System.out.println(smfValidator.validateBPMA(bpmaParser.getDataTree()));
		
//		E01ProvisionCommandParser commandParser = parser.getE01ProvisionCommandParser();
//		System.out.println(smfValidator.validateE01Response(commandParser.getDataTree()));
		
//		OsRARParser osRARParser = parser.getOsRARParser();
//		System.out.println(smfValidator.validateOsRAR(osRARParser.getDataTree()));
		
		OsRAAParser osRAAParser = parser.getOsRAAParser();
		System.out.println(smfValidator.validateOsRAA(osRAAParser.getDataTree()));

//		InquerySessionInfoResponseParser infoResponseParser = parser.getInquerySessionInfoResponseParser();
//		System.out.println(smfValidator.validateInquerySessionInfoResponse(infoResponseParser.getDataTree()));
		}
		catch (ValidationFailedException e) {
			for(String[] err:e.getFailureRecord()){
				System.err.println(err[0]+ " " + err[err.length-2]+ " " +err[err.length-1]);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String concatArguments(String[] args){
		StringBuilder builder = new StringBuilder();
		for(String arg:args){
			builder.append(arg).append(" ");
		}
		builder.deleteCharAt(builder.length()-1);
		return builder.toString();
	}

}
