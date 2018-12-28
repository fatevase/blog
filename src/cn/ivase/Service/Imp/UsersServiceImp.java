package cn.ivase.Service.Imp;

import java.util.List;
import java.util.Map;

import cn.ivase.Bean.UsersBasic;
import cn.ivase.Dao.UsersDao;
import cn.ivase.Model.timeSwitch;
import cn.ivase.Service.UsersService;

public class UsersServiceImp implements UsersService{
	private UsersDao usersDao;

	public List<Map<String, Object>> GetAllUsers() {
		// TODO Auto-generated method stub
		return usersDao.GetAllUsers();
	}


	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Override
	public int ChangeUser(UsersBasic user) {
		// TODO Auto-generated method stub	
		return usersDao.ChangeUser(user);
	}


	@Override
	public int AddUser(UsersBasic user) {
		// TODO Auto-generated method stub
		return usersDao.AddUser(user);
	}


	@Override
	public List<Map<String, Object>> GetUserByArgs(String args, Object values,boolean fuzzy) {
		// TODO Auto-generated method stub
		return usersDao.GetUserByArgs(args, values,fuzzy);
	}


	@Override
	public int DeleteUserByArgs(String args, Object values) {
		// TODO Auto-generated method stub
		return usersDao.DeleteUserByArgs(args, values);
	}


	@Override
	public Object GetUserByArgs(String aim, Map<String, Object> values) {
		// TODO Auto-generated method stub
		Map<String,Object> one_user =usersDao.GetUserByArgs(aim, values);
		
		return one_user.get(aim);
	}


	@Override
	public int AddUser(Map<String, Object> addParameter) {
		// TODO Auto-generated method stub
		addParameter.put("created", timeSwitch.getAccurateUnixTime());
		return usersDao.AddUser(addParameter);
	}


	@Override
	public int AddSchoolUser(Map<String, Object> addParameter) {
		// TODO Auto-generated method stub
		return usersDao.AddSchoolUser(addParameter);
	}

	

	
}
