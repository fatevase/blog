package cn.ivase.Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.ivase.Dao.DBConnection;

import com.opensymphony.xwork2.ActionSupport;

public class ManageUserAction extends ActionSupport {
	private String action ;
	private String user_id;
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String userId) {
		user_id = userId;
	}

	private List<Map<String,String>> all_user;
	DBConnection db = new DBConnection();
	public List<Map<String, String>> getAll_user() {
		return all_user;
	}

	public void setAll_user(List<Map<String, String>> allUser) {
		all_user = allUser;
	}

	public String ShowUser() {

		String perparedsql = "select * from user_basic";
		String[] perparedarray = new String[]{};
		all_user = db.ResultToListMap(db.ExePerpared(perparedsql, perparedarray));
		for(int i=0;i<all_user.size();i++) {
			Map<String,String> data_map =new HashMap<String,String>();
			data_map = all_user.get(i);
			System.out.println("-------"+data_map.get("user_name"));
		}
		return INPUT;
	}
	
	public String DelUser() {
		String perparedsql = "delete from user_basic where user_id = ?";
		String[] perparedarray = new String[]{user_id};
		int i = db.UpPerpared(perparedsql, perparedarray);
		return ShowUser();
	}
}
