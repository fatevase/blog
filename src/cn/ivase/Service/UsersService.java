package cn.ivase.Service;

import java.util.List;
import java.util.Map;

import cn.ivase.Bean.UsersBasic;

public interface UsersService {
	public List<Map<String,Object>> GetAllUsers();
	public int ChangeUser(UsersBasic user);
	public int AddUser(UsersBasic user);
	public int AddUser(Map<String, Object> addParameter);
	public int AddSchoolUser(Map<String, Object> addParameter);
	public List<Map<String,Object>> GetUserByArgs(String args,Object values,boolean fuzzy);
	public int DeleteUserByArgs(String args,Object values);
	
	public Object GetUserByArgs(String aim, Map<String,Object> values);
}
