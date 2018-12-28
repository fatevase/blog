package cn.ivase.Action;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.opensymphony.xwork2.ModelDriven;

import cn.ivase.Bean.IndexBean;
import cn.ivase.Model.util;
import cn.ivase.Service.IndexService;

public class IndexAction extends BaseAction implements ModelDriven<IndexBean>{
	IndexService indexService;
	public IndexBean indexbean = new IndexBean();

	@Override
	public IndexBean getModel() {
		return indexbean;
	}
	
	
	public IndexService getIndexService() {
		return indexService;
	}

	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}

	public String ShowIndex() {
		indexbean.setAll_index(indexService.ShowIndex());
		//all_index = indexService.ShowIndex();
		/*for(Map<String, Object> single:all_index) {
			System.out.println("title------"+single.get("title"));
		}*/
		return SUCCESS;
	} 
	

	
	public String PostComment() {
		//TODO insert comment
		Map<String,Object> comment = new HashMap<String,Object>();
		//cid,created,owenrId,ip,text,parent
		comment.put("cid",indexbean.getCid());
		comment.put("owenrId", getSession().getAttribute("uid"));
		comment.put("ip", "0.0.0.0");
		comment.put("text", indexbean.getComment_text());
		comment.put("parent", 0);
		System.out.println("\n"+indexbean.getCid()+"   "+indexbean.getComment_text()+"\n");
		if(indexService.InsertComments(comment)>0) {
			indexbean.setErrormsg(1);
		} else {
			indexbean.setErrormsg(-1);
		}
		return SUCCESS;
		
	}
	
	public String ShowPage() {
		indexbean.setAll_page(indexService.ShowPage("cid", indexbean.getCid(), false));
		indexbean.setAll_comments(indexService.ShowComments("cid", indexbean.getCid(), false));
		if(indexbean.getAll_page().size()>0) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}
	
	public String ShowTag() {
		Map<String,Object> factor =new HashMap<String,Object>();
		if("GetContentsTotal".equals(indexbean.getAction())) {
			Object[] someMap ;
			//jsp 传map类型的数据到action页面中是会变成数组，所以使用数组的取值方法 [0]
			someMap = (Object[])indexbean.getActionEntry().get("CotentTotal_1");
			factor.put("classify", someMap[0]);
			indexbean.getActionOutPut().put("CotentTotal_1", indexService.ShowContentTotal(factor));
			
			someMap = (Object[])indexbean.getActionEntry().get("CotentTotal_2");
			factor.put("classify", someMap[0]);
			indexbean.getActionOutPut().put("CotentTotal_2", indexService.ShowContentTotal(factor));
			
			someMap = (Object[])indexbean.getActionEntry().get("CotentTotal_3");
			factor.put("classify", someMap[0]);
			indexbean.getActionOutPut().put("CotentTotal_3", indexService.ShowContentTotal(factor));

		}
		
		return SUCCESS;
	}
	


	
}
