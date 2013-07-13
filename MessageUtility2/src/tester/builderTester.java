package tester;

import enums.BPMResultCode;
import parser.BPMRParser;
import parser.SMFMessageParser;
import builder.BPMBuilder;

public class builderTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String text = concat(args);
			System.err.println(text);

			SMFMessageParser parser = SMFMessageParser.newInstance();
			parser.setMessageParser(text);

			try{
//			BPMRParser bpmrParser = parser.getBPMRParser();
//			BPMRBuilder builder = new BPMRBuilder(bpmrParser.getDataTree());
//			System.out.println(builder.toString());
			
			BPMRParser bpmrParser = parser.getBPMRParser();
			BPMBuilder builder = new BPMBuilder();
			builder.buildBPMA(bpmrParser.getDataTree(), BPMResultCode.SUCESS.getResultCode(), "0", "Success", "AAAAA");
			System.out.println(builder.toString());
			
			
//			BPMRParser bpmrParser = parser.getBPMRParser();
//			E01ProvisionCommandBuilder commandBuilder = new E01ProvisionCommandBuilder(bpmrParser.getDataTree());
			
//			E01ProvisionCommandParser commandParser = parser.getE01ProvisionCommandParser();
//			E01ProvisionCommandBuilder commandBuilder = new E01ProvisionCommandBuilder(bpmrParser.getDataTree());
			
//			commandBuilder.setE01SearchCommand();
//			System.out.println(commandBuilder.toString());

//			OsRARParser osRARParser = parser.getOsRARParser();
//			OsRARBuilder builder = new OsRARBuilder(osRARParser.getDataTree());
//			builder.setDestinationHost("desHost");
//			builder.setDestinationRealm("desRealm");
//			builder.setSessionId("sess");
//			builder.setOriginHost("OriHost");
//			builder.setOriginRealm("OriRealm");
//			System.out.println(builder.toString());
			
//			OsRARParser osRARParser = parser.getOsRARParser();
//			OsRAAParser osRARParser = parser.getOsRAAParser();
//			
//			OsRAABuilder builder = new OsRAABuilder();
//			builder.setSessionId(osRARParser.getSessionId());
//			builder.setOriginHost(osRARParser.getOriginHost());
//			builder.setOriginRealm(osRARParser.getOriginRealm());
//			builder.setOriginStateId("1");
//			builder.setResultCode("5012");
//			builder.setAuthApplicationId("4");
//			System.out.println(builder.toString());
			
//			OsRARParser osRARParser = parser.getOsRARParser();
//			InquerySessionInfoRequestBuilder builder = new InquerySessionInfoRequestBuilder();
//			builder.setResultInfo(osRARParser.getMsisdn());
//			System.out.println(builder.toString());
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

	public static String concat(String[] args) {
		StringBuilder builder = new StringBuilder();
		for (String arg : args) {
			builder.append(arg).append(" ");
		}
		return builder.toString().trim();
	}

}
