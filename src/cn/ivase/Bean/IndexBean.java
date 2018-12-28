package cn.ivase.Bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * index页面
 *@Title IndexBean.java
 *@description TODO
 *@time 2018年12月24日 下午12:23:42
 *@author FateVase
 *@version 1.0
 *
 *
*
 */
public class IndexBean {
	
	int coid;
	int uid;
	int parent;
	String action;
	String comment_text;
	int errormsg;
	List<Map<String,Object>> all_index;
	List<Map<String,Object>> all_page;
	List<Map<String,Object>> all_comments;
	Map<String,Object> ActionOutPut = new HashMap<String,Object>();
	Map<String,Object> ActionEntry = new HashMap<String,Object>();


	int cid;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCoid() {
		return coid;
	}
	public void setCoid(int coid) {
		this.coid = coid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	
	public String getComment_text() {
		return comment_text;
	}
	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	public int getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(int errormsg) {
		this.errormsg = errormsg;
	}
	
	public List<Map<String, Object>> getAll_index() {
		return all_index;
	}
	public void setAll_index(List<Map<String, Object>> all_index) {
		this.all_index = all_index;
	}
	public List<Map<String, Object>> getAll_page() {
		return all_page;
	}
	public void setAll_page(List<Map<String, Object>> all_page) {
		this.all_page = all_page;
	}
	public List<Map<String, Object>> getAll_comments() {
		return all_comments;
	}
	public void setAll_comments(List<Map<String, Object>> all_comments) {
		this.all_comments = all_comments;
	}
	public Map<String, Object> getActionOutPut() {
		return ActionOutPut;
	}
	public void setActionOutPut(Map<String, Object> actionOutPut) {
		ActionOutPut = actionOutPut;
	}
	
	public Map<String, Object> getActionEntry() {
		return ActionEntry;
	}
	public void setActionEntry(Map<String, Object> actionEntry) {
		ActionEntry = actionEntry;
	}
	
}
