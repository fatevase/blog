package cn.ivase.Action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ModelDriven;

import cn.ivase.Bean.BackEndBean;
import cn.ivase.Service.BackEndService;

public class BackEndAction extends BaseAction implements ModelDriven<BackEndBean>{
	public BackEndBean backendbean = new BackEndBean();
	BackEndService backendService;
	@Override
	public BackEndBean getModel() {
		// TODO Auto-generated method stub
		return backendbean;
	}
	
	public String ShowBackendIndex() {
		if("getCountIndex".equals(backendbean.getAction())) {
			Map<String,Object> showData = backendService.ShowBackendIndex();
			backendbean.setActionOutPut(showData);
			return "putcount";
		}
		if("getCommentsIndex".equals(backendbean.getAction())) {
			backendbean.setAll_comments(backendService.ShowCommentsIndex());
			return "putcomm";
		}
		
		if("getContentsIndex".equals(backendbean.getAction())) {
			backendbean.setAll_contents(backendService.ShowEssayIndex());
			return "putessa";
		}
		return ERROR;
		
	}

	public BackEndBean getBackendbean() {
		return backendbean;
	}

	public void setBackendbean(BackEndBean backendbean) {
		this.backendbean = backendbean;
	}

	public BackEndService getBackendService() {
		return backendService;
	}

	public void setBackendService(BackEndService backendService) {
		this.backendService = backendService;
	}
	
	
}
