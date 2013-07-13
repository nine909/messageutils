package tester;

import parser.BPMAParser;
import parser.BPMRParser;
import parser.E01ProvisionCommandParser;
import parser.SMFMessageParser;

public class parserTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
			String text = concatArguments(args);
			System.err.println(text);
			
			SMFMessageParser parser = SMFMessageParser.newInstance();
			parser.setMessageParser(text);
			
//			OsRARParser osRARParser = parser.getOsRARParser();
//			System.out.println(osRARParser.getSessionId());
//			System.out.println(osRARParser.getOriginHost());
//			System.out.println(osRARParser.getOriginRealm());
//			System.out.println(osRARParser.getDestinationHost());
//			System.out.println(osRARParser.getDestinationRealm());
//			System.out.println(osRARParser.getAuthApplicationId());
//			System.out.println(osRARParser.getReAuthRequestType());
//			System.out.println(osRARParser.getUserName());
//			System.out.println(osRARParser.getRatingGroup());
//			System.out.println(osRARParser.getMsisdn());
			
//			InquerySessionInfoResponseParser infoResponseParser = parser.getInquerySessionInfoResponseParser();
//			System.out.println(infoResponseParser.getSessionType());
//			System.out.println(infoResponseParser.getResultInfo());
//			System.out.println(infoResponseParser.getMethodVersion());
//			String[] sessionInfo = infoResponseParser.getSessionInfo();
//			if(sessionInfo != null){
//				for(String session: sessionInfo){
//					System.out.println(session);
//				}
//			}
			
//			OsRAAParser osRAAParser = parser.getOsRAAParser();
//			System.out.println(osRAAParser.getOriginHost());
//			System.out.println(osRAAParser.getOriginRealm());
//			System.out.println(osRAAParser.getOriginStateId());
//			System.out.println(osRAAParser.getResultCode());
//			System.out.println(osRAAParser.getSessionId());
//			System.out.println(osRAAParser.getAuthApplicationId());

//			BPMRParser bpmrParser = parser.getBPMRParser();
//			System.out.println(bpmrParser.getSession());
//			System.out.println(bpmrParser.getUserName());
//			System.out.println(bpmrParser.getPassword());
//			System.out.println(bpmrParser.getBPMCommand());
//			System.out.println(bpmrParser.getType());
//			System.out.println(bpmrParser.getServiceName());
//			System.out.println(bpmrParser.getE01Command());
//			System.out.println(bpmrParser.getObjectType());
//			String[] keywords = bpmrParser.getKeywords();
//			int i=0;
//			while(i<keywords.length){
//				System.out.println(keywords[i]);
//				i++;
//			}
//			System.out.println(bpmrParser.getData());
			
//			BPMAParser bpmaParser = parser.getBPMAParser();
//			System.out.println(bpmaParser.getSession());
//			System.out.println(bpmaParser.getUserName());
//			System.out.println(bpmaParser.getBPMCommand());
//			System.out.println(bpmaParser.getType());
//			System.out.println(bpmaParser.getServiceName());
//			System.out.println(bpmaParser.getBPMResultCode());
//			System.out.println(bpmaParser.getE01Command());
//			System.out.println(bpmaParser.getE01ResultCode());
//			System.out.println(bpmaParser.getE01Description());
//			System.out.println(bpmaParser.getObjectType());
//			String[] keywords = bpmaParser.getKeywords();
//			int i=0;
//			while(i<keywords.length){
//				System.out.println(keywords[i]);
//				i++;
//			}
//			System.out.println(bpmaParser.getData());
			
//			E01ProvisionCommandParser commandParser = parser.getE01ProvisionCommandParser();
//			System.out.println(commandParser.getE01Command());
//			System.out.println(commandParser.getObjectType());
//			System.out.println(commandParser.getE01ResultCode());
//			System.out.println(commandParser.getE01Description());
//			int i =0;
//			String[] keywords = commandParser.getKeywords();
//			while(i<keywords.length){
//				System.out.println(keywords[i]);
//				i++;
//			}
//			System.out.println(commandParser.getData());
			
			System.out.println("....Ending!!....");
			
	}
	
	public static String concatArguments(String[] args) {
		StringBuilder message = new StringBuilder();
		for (String arg : args) {
			message.append(arg).append(" ");
		}
		message.deleteCharAt(message.length() - 1);
		return message.toString();
	}
}
