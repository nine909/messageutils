/**
 * 
 */
package enums;

/**
 * @author ubuntu
 *
 */
public enum E01Command {

	ADD("add")
	,DELETE("delete")
	,SEARCH("search")
	,REPLACE("replace")
	;
	
	private String command;
	
	private E01Command(String command) {
		this.command = command;
	}
	
	public String getCommand(){
		return this.command;
	}
	
}
