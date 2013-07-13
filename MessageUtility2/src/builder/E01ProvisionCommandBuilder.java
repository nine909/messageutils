package builder;

import java.util.LinkedList;

import msgutils.message.factory.XmlBuilder;
import msgutils.message.model.XmlDataTree;
import msgutils.message.model.XmlElementModel;
import enums.E01Command;
import enums.PathBPM;
import enums.PathE01MsgCmd;
import exception.E01Exception;

public class E01ProvisionCommandBuilder extends XmlBuilder {

	public E01ProvisionCommandBuilder(XmlDataTree dataTree) throws Exception {
		this.setDataTree(new XmlDataTree(dataTree.toString()));
		this.Builder();
	}

	public void setE01AddCommand(){
		processE01(E01Command.ADD.getCommand());
	}
	
	public void setE01DeleteCommand(){
		processE01(E01Command.DELETE.getCommand());
	}

	public void setE01SearchCommand(){
		processE01(E01Command.SEARCH.getCommand());
	}

	public void setE01ReplaceCommand(){
		processE01(E01Command.REPLACE.getCommand());
	}
	
	private void processE01(String command){
		try{
		LinkedList<XmlElementModel> elementModels = this.getElements(PathE01MsgCmd.EXT_MSG.getPath());
		if(command.equals(E01Command.DELETE.getCommand()) || command.equals(E01Command.SEARCH.getCommand())){
			elementModels.getFirst().removeAttribute("data");
		}
		elementModels.getFirst().setAttribute("command", command);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void Builder() throws Exception {
		LinkedList<XmlElementModel> elementModels;
		
		if ((elementModels = this.getElements(PathBPM.BPM.getPath())) != null){

			LinkedList<XmlElementModel> e01ElementModel = this.getElements(PathBPM.E01_PROVISION.getPath()); 
			String e01Command = e01ElementModel.getFirst().getAttribute("command");
			
			if(e01ElementModel.getFirst().getAttribute("key") == null){
				if(e01Command.equals("add")  || e01Command.equals("replace")){
					LinkedList<XmlElementModel> dataModel = this.getElements(PathBPM.DATA.getPath());
					String DataValue = dataModel.getFirst().getAttribute("value");
					this.newAttribute(PathBPM.E01_PROVISION.getPath(), "data", DataValue);
					this.removeElement(PathBPM.DATA.getPath());			
				}
			}			
			this.removeElement(PathBPM.SERVICE_NAME.getPath());

			this.removeKeywords(e01ElementModel);
			
			this.setRoot(elementModels.getFirst());
			this.setElementName("/E01-Provision", "ext-message");
		}else if((elementModels = this.getElements(PathE01MsgCmd.EXT_MSG.getPath())) != null){
			elementModels.getFirst().removeAttribute("resultcode");
			elementModels.getFirst().removeAttribute("description");
		}
		else throw new E01Exception("input dataTree from BPMRParser or E01ProvisionCommand");	
		
	}
	
	private void removeKeywords(LinkedList<XmlElementModel> elementModels){
		
			if(elementModels.getFirst().getAttribute("key") == null){
				String keys = getKeywords(elementModels);
				elementModels.getFirst().addAttribute("key", keys);
				if(elementModels.getFirst().getAttribute("key9") != null){
					int i = 0;
					while(i<10){
						elementModels.getFirst().removeAttribute("key"+i);
					}
				}else if(elementModels.getFirst().getAttribute("key4") != null){
					int i=0;
					while(i<5){
						elementModels.getFirst().removeAttribute("key"+i);
						i++;
					}
				}
			}
	}
	
	private String getKeywords(LinkedList<XmlElementModel> elementModel){


		 if (elementModel.getFirst().getAttribute("key9") != null) {
			String keys = elementModel.getFirst().getAttribute("key0");
			int i = 1;
			while (i < 9) {
				String key = elementModel.getFirst().getAttribute("key" + i);
				keys = keys + "," + key;
				i++;
			}
			return keys;
			
		} else {
			String keys = elementModel.getFirst().getAttribute("key0");
			int i = 1;
			while (i < 5) {
				String key = elementModel.getFirst().getAttribute("key" + i);
				keys = keys + "," + key;
				i++;
			}
			return keys;
		}
}
}
