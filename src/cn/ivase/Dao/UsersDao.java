package cn.ivase.Dao;

import java.util.List;
import java.util.Map;

import cn.ivase.Bean.UsersBasic;
/**
 * *�û������� �ʼд���� ����Ƚ���
 *@Title UsersDao.java
 *@description TODO
 *@time 2018��12��24�� ����12:21:48
 *@author FateVase
 *@version 1.0
 *
 *
*
 */
public interface UsersDao {
	public List<Map<String,Object>> GetAllUsers();
	public int ChangeUser(UsersBasic user);
	public int AddUser(UsersBasic user);
	public int AddUser(Map<String, Object> addParameter);
	public int AddSchoolUser(Map<String, Object> addParameter);
	public List<Map<String,Object>> GetUserByArgs(String args,Object values,boolean fuzzy);
	public int DeleteUserByArgs(String args,Object values);
	
	public Map<String,Object> GetUserByArgs(String aim, Map<String,Object> values);
}
