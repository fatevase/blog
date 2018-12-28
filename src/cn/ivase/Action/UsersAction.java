package cn.ivase.Action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import cn.ivase.Bean.UsersBasic;
import cn.ivase.Model.timeSwitch;
import cn.ivase.Service.UsersService;

public class UsersAction extends BaseAction {
	UsersService usersService;
	public List<Map<String,Object>> all_users;
	public String ActionMsg ;
	public String ErrorMsg;
	public UsersBasic user;
	public String search_type;
	public String getErrorMsg() {
		return ErrorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		ErrorMsg = errorMsg;
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

	public String search_value;
	public UsersBasic getUser() {
		return user;
	}

	public void setUser(UsersBasic user) {
		this.user = user;
	}

	public String GetAllUsers() {	
		setAll_users(usersService.GetAllUsers());
		return SUCCESS;
	}
	public String SearchUsers() {
		setAll_users(usersService.GetUserByArgs(search_type, search_value,true));
		return SUCCESS;
	}
	
	public String ChangeUser() {	
		int change_msg = usersService.ChangeUser(user);
		return GetAllUsers();
	}
	
	public String AddUser() {
		if(usersService.GetUserByArgs("username", user.getUsername(),false).size()==0) {
			int insert_msg = usersService.AddUser(user);
		} else {
			ErrorMsg = "该用户名已存在";
		}	
		return GetAllUsers();
	}
	
	public String DeleteUser() {
			int delete_msg = usersService.DeleteUserByArgs("uid", user.getUid());
		if(delete_msg<=0){
			ErrorMsg = "无法删除该用户";
			System.out.println("cant it:"+delete_msg);
		} else {
			System.out.println("can it:"+delete_msg);
		}
		return GetAllUsers();
	}
	
	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	
	
	
	public String getActionMsg() {
		return ActionMsg;
	}

	public void setActionMsg(String actionMsg) {
		ActionMsg = actionMsg;
	}


	
	public List<Map<String, Object>> getAll_users() {
		return all_users;
	}

	public void setAll_users(List<Map<String, Object>> all_users) {
		for(int i=0;i<all_users.size();i++) {
			Map<String,Object> single = all_users.get(i);		
			single.put("activated", timeSwitch.UnixToDate((Integer)single.get("activated")));
		}
		this.all_users = all_users;
	}


	


}
