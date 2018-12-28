package cn.ivase.Bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * *快结束的时候想到用modeldriven来获取数据
 *@Title BackEndBean.java
 *@description TODO
 *@time 2018年12月24日 下午12:22:52
 *@author FateVase
 *@version 1.0
 *
 *
*
 */
public class BackEndBean {
	
	String action;
	Map<String,Object> ActionOutPut = new HashMap<String,Object>();
	List<Map<String,Object>> all_contents;
	List<Map<String,Object>> all_comments;
	Comments commtents;
	Contents contents;
	String search_type;
	String search_value;
	Boolean search_fuzzy;

	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Map<String, Object> getActionOutPut() {
		return ActionOutPut;
	}
	public void setActionOutPut(Map<String, Object> actionOutPut) {
		ActionOutPut = actionOutPut;
	}

	public List<Map<String, Object>> getAll_contents() {
		return all_contents;
	}
	public void setAll_contents(List<Map<String, Object>> all_contents) {
		this.all_contents = all_contents;
	}
	
	public List<Map<String, Object>> getAll_comments() {
		return all_comments;
	}
	public void setAll_comments(List<Map<String, Object>> all_comments) {
		this.all_comments = all_comments;
	}
	public Comments getCommtents() {
		return commtents;
	}
	public void setCommtents(Comments commtents) {
		this.commtents = commtents;
	}
	public Contents getContents() {
		return contents;
	}
	public void setContents(Contents contents) {
		this.contents = contents;
	}
	public String getSearch_type() {
		return search_type;
	}
	public void setSearch_type(String search_type) {
		this.search_type = search_type;
	}
	public String getSearch_value() {
		return search_value;
	}
	public void setSearch_value(String search_value) {
		this.search_value = search_value;
	}
	public Boolean getSearch_fuzzy() {
		return search_fuzzy;
	}
	public void setSearch_fuzzy(Boolean search_fuzzy) {
		this.search_fuzzy = search_fuzzy;
	}
	
	
}
