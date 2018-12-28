package cn.ivase.Action;

import java.util.HashMap;
import java.util.Map;

import cn.ivase.Bean.UsersBasic;
import cn.ivase.Model.util;
import cn.ivase.Service.SignService;
import cn.ivase.Service.UsersService;

public class SignAction extends BaseAction {
	SignService signService;

	UsersService usersService;
	UsersBasic user;
	int ErrorCode=0;
	Map<String,Object> ActionOutPut = new HashMap<String,Object>();
	
	public String SignUp() {
		if(usersService.GetUserByArgs("username", user.getUsername(), false).size()>0) {
			ErrorCode = -1;
			return INPUT;
		} else {
			if(signService.SignUp(user)>0) {
				return SUCCESS;
			}else {
				ErrorCode = -2;
				return INPUT;
			}
			
		}
	}
	public String SignIn() {

			if(signService.SignIn(user)>0) {
				Map<String,Object> values = new HashMap<String,Object>();
				values.put("username", user.getUsername());
				getSession().setAttribute("username",user.getUsername()); 
				getSession().setAttribute("uid", usersService.GetUserByArgs("uid", values)); 
				getSession().setAttribute("groups",usersService.GetUserByArgs("groups", values)); 
				ErrorCode = 1;
				ActionOutPut.put("signin_msg","SIGNIN-SUCC");
				return INPUT;
			}else {
				getSession().setAttribute("username", null); 
				getSession().setAttribute("uid", null); 
				getSession().setAttribute("groups", null); 
				ErrorCode = -1;
				ActionOutPut.put("signin_msg","SIGNIN-FAIL");
				return INPUT;
			}	
	}
	
	public String SignOut() {
		try {
			getSession().setAttribute("username", null); 
			getSession().setAttribute("uid", null); 
			getSession().setAttribute("groups", null); 
			ActionOutPut.put("signout_msg","SIGNOUT-SUCC");
		}catch(Exception e){
			ActionOutPut.put("signout_msg","SIGNOUT-FAIL");
		}
		return SUCCESS;
	}
	
	public String AddSchoolUser() {
		Map<String,Object> school_user =new HashMap<String ,Object>();
		school_user.put("userid", user.getUsername());
		int result = usersService.AddSchoolUser(school_user);
		if(result > 0) {
			ErrorCode = result;
			getSession().setAttribute("username", user.getUsername()); 
			getSession().setAttribute("uid", "2"); 
			getSession().setAttribute("groups", "editor"); 
			this.getActionOutPut().put("LoginSchool", "error");
			this.getActionOutPut().put("error", result);
		} else {
			ErrorCode = -1;
			this.getActionOutPut().put("LoginSchool", "error");
			this.getActionOutPut().put("error", -1);
		}
		return SUCCESS;
	}
		

	public SignService getSignService() {
		return signService;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public void setSignService(SignService signService) {
		this.signService = signService;
	}
	
	public UsersBasic getUser() {
		return user;
	}

	public void setUser(UsersBasic user) {
		this.user = user;
	}


	public int getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(int errorCode) {
		ErrorCode = errorCode;
	}
	public Map<String, Object> getActionOutPut() {
		return ActionOutPut;
	}
	public void setActionOutPut(Map<String, Object> actionOutPut) {
		ActionOutPut = actionOutPut;
	}


	
}
