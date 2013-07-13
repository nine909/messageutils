package exception;

import java.util.ArrayList;

public class ValidationFailedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6952330005890087693L;

	ArrayList<String[]> failureRecord;
	
	public ValidationFailedException() {
		super();
	}
	
	public ValidationFailedException(String message){
		super(message);
	}
	
	public ValidationFailedException(ArrayList<String[]> failureRecord) {
		this.failureRecord = failureRecord;
	}
	
	public ArrayList<String[]> getFailureRecord(){
		return this.failureRecord;
	}

}
