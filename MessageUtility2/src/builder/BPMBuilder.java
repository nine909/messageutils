package builder;

import java.util.LinkedList;

import msgutils.message.factory.XmlBuilder;
import msgutils.message.model.XmlDataTree;
import msgutils.message.model.XmlElementModel;
import enums.BPMCommand;
import enums.PathBPM;

public class BPMBuilder extends XmlBuilder{

	/*** sand command authorization to SMAF Node ***/
	public void buildAuthenBPMR(XmlDataTree bpmrDataTree) throws Exception {
		this.setDataTree(new XmlDataTree(bpmrDataTree.toString()));
		
		LinkedList<XmlElementModel> elementModels = this.getElements(PathBPM.BPM.getPath());
		if(elementModels != null){
			elementModels.getFirst().setAttribute("type", "request");
			elementModels.getFirst().setAttribute("command", BPMCommand.authen.name());
			
		} else throw new Exception("Input DataTree from BPMRParser");
	}
	
	/*** report message for the Command Add ,Delete and Replace ***/
	public void buildReportBPMR(XmlDataTree bpmrDataTree, String bpmResultCode) throws Exception {
		this.setDataTree(new XmlDataTree(bpmrDataTree.toString()));
		
		LinkedList<XmlElementModel> bpmElementModels = this.getElements(PathBPM.BPM.getPath());
		if(bpmElementModels != null){
			bpmElementModels.getFirst().setAttribute("type", "request");
			bpmElementModels.getFirst().setAttribute("command", BPMCommand.report.name());
			bpmElementModels.getFirst().removeAttribute("password");
			
			this.removeElement(PathBPM.E01_PROVISION.getPath());
			
			this.setBPMResultCode(bpmResultCode);
		} else throw new Exception("Input DataTree from BPMRParser");
	}
	
	/*** Response result ***/
	public void buildBPMA(XmlDataTree bpmrDataTree, String bpmResultCode ,String e01ResultCode ,String e01Description ,String e01Data) throws Exception {
		this.setDataTree(new XmlDataTree(bpmrDataTree.toString()));
		
		LinkedList<XmlElementModel> bpmElementModels = this.getElements(PathBPM.BPM.getPath());
		if(bpmElementModels != null){
			bpmElementModels.getFirst().setAttribute("type", "response");
			bpmElementModels.getFirst().removeAttribute("password");
			if(e01ResultCode != null && e01Description != null ){
				LinkedList<XmlElementModel>e01ElementModels = this.getElements(PathBPM.E01_PROVISION.getPath());
				if(e01ElementModels.getFirst().getAttribute("data") == null){
					this.removeElement(PathBPM.DATA.getPath());
				}
				e01ElementModels.getFirst().addAttribute("resultcode", e01ResultCode);
				e01ElementModels.getFirst().addAttribute("description", e01Description);
				
				if(e01Data != null){
					this.setData(e01Data);
				}
			}else{
				this.removeElement(PathBPM.E01_PROVISION.getPath());
			}
			this.setBPMResultCode(bpmResultCode);
			
		} else throw new Exception("Input DataTree from BPMRParser");
	}
	
	
	private void setBPMResultCode(String bpmResultCode){
		LinkedList<XmlElementModel> elementModels = this.getElements(PathBPM.BPM.getPath());
		if(elementModels != null){
			XmlElementModel models = XmlElementModel.newInstance();
			models.setName("Result-Code");
			models.addAttribute("value", bpmResultCode);
		
			elementModels.getFirst().addChildren(models);
		}
		
	}
	
	private void setData(String e01Data){
		LinkedList<XmlElementModel> e01ElementModels = this.getElements(PathBPM.E01_PROVISION.getPath());
		String keyAttribute = e01ElementModels.getFirst().getAttribute("key");
		if(e01ElementModels != null && keyAttribute != null){
				if(!e01ElementModels.getFirst().addAttribute("data", e01Data)){
					e01ElementModels.getFirst().setAttribute("data", e01Data);
				}
			}else{
				XmlElementModel dataElementModels = XmlElementModel.newInstance();
				dataElementModels.setName("data");
				dataElementModels.addAttribute("data", e01Data);
				e01ElementModels.getFirst().addChildren(dataElementModels);
			}
	}
	@Override
	protected LinkedList<XmlElementModel> getElements(String path){
		try {
			return super.getElements(path, false);
		} catch (Exception e) {
			 return null;
		}
	}

	
}
