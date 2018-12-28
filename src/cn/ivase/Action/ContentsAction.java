package cn.ivase.Action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ModelDriven;

import cn.ivase.Bean.BackEndBean;
import cn.ivase.Model.util;
import cn.ivase.Service.ContentsService;

public class ContentsAction extends BaseAction implements ModelDriven<BackEndBean>{
	ContentsService contentsService;
	BackEndBean backendbean = new BackEndBean();
	
	@Override
	public BackEndBean getModel() {
		// TODO Auto-generated method stub
		return backendbean;
	}
	
	public ContentsService getContentsService() {
		return contentsService;
	}

	public void setContentsService(ContentsService contentsService) {
		this.contentsService = contentsService;
	}
	
	public String ShowContents() {
		backendbean.setAll_contents(contentsService.ShowSomeContents());
		System.out.println("ShowContents():all count contents: "+backendbean.getAll_contents().size());
		return SUCCESS;
	}
	
	public String DeleteContent() {
		if(!util.CheckSignState()) {
			backendbean.getActionOutPut().put("DeleteContentMsg", "OutLine");
			return SUCCESS;
		} 
		try {
			int result = contentsService.DeleteContentsByArgs("cid", backendbean.getContents().getCid());
			backendbean.getActionOutPut().put("DeleteContentMsg", result);
			return SUCCESS;
		}catch(Exception e) {
			backendbean.getActionOutPut().put("DeleteContentMsg", "error-not-fund-post-msg");
			return SUCCESS;
		}
	}
	
	public String AddContent() {
		if(!util.CheckSignState()) {
			backendbean.getActionOutPut().put("addContentMsg", "OutLine");
			return SUCCESS;
		} 
		try {
			Map<String,Object> addParameter = new HashMap<String,Object>();
			addParameter.put("title", backendbean.getContents().getTitle());
			addParameter.put("text", backendbean.getContents().getText());
			addParameter.put("classify", backendbean.getContents().getClassify());
			addParameter.put("authorId", getSession().getAttribute("uid"));
			int result = contentsService.AddContents(addParameter);
			backendbean.getActionOutPut().put("addContentMsg", result);
			return SUCCESS;
		}catch(Exception e) {
			backendbean.getActionOutPut().put("addContentMsg", "error-not-fund-post-msg");
			return SUCCESS;
		}
	}
	
	public String WritePrepare() {
		Map<String,Object> judges =new HashMap<String,Object>();
		judges.put("cid", backendbean.getContents().getCid());
		Map<String,Object> text = contentsService.GetContentsByArgs("*", judges);
		backendbean.getContents().setText(text.get("text").toString());
		backendbean.getContents().setTitle(text.get("title").toString());
		backendbean.getContents().setClassify(text.get("classify").toString());
		return SUCCESS;
	}
	
	public String PostContent() {
		int result = 0;
		if(!util.CheckSignState()) {
			backendbean.getActionOutPut().put("addContentMsg", "OutLine");
			return SUCCESS;
		} 
		try {
			Map<String,Object> addParameter = new HashMap<String,Object>();
			addParameter.put("title", backendbean.getContents().getTitle());
			addParameter.put("text", backendbean.getContents().getText());
			addParameter.put("classify", backendbean.getContents().getClassify());
			
			if(backendbean.getContents().getCid() != 0) {
				addParameter.put("cid", backendbean.getContents().getCid());
				result = contentsService.ChangeContents(addParameter, "cid");
				backendbean.getActionOutPut().put("changeContentMsg", result);
			} else {
				backendbean.getActionOutPut().put("changeContentMsg", "not-change-content-pattern");
				addParameter.put("authorId", getSession().getAttribute("uid"));
				result = contentsService.AddContents(addParameter);
			}
			backendbean.getActionOutPut().put("addContentMsg", result);
			return SUCCESS;
		}catch(Exception e) {
			backendbean.getActionOutPut().put("addContentMsg", "error-not-fund-post-msg");
			return SUCCESS;
		}
	}
	
	public String SearchContents() {
		if(!util.CheckSignState()) {
			backendbean.getActionOutPut().put("searchContents", "OutLine");
			return SUCCESS;
		} 
		backendbean.setAll_contents(contentsService.GetContentsByArgs(backendbean.getSearch_type(),
									backendbean.getSearch_value(),backendbean.getSearch_fuzzy()));
		return SUCCESS;
	}



}
