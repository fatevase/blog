package cn.ivase.Service.Imp;

import java.util.Map;

import cn.ivase.Bean.UsersBasic;
import cn.ivase.Dao.SignDao;
import cn.ivase.Service.SignService;

public class SignServiceImp implements SignService {
	public SignDao signDao;
	public SignDao getSignDao() {
		return signDao;
	}

	public void setSignDao(SignDao signDao) {
		this.signDao = signDao;
	}

	@Override
	public int SignUp(UsersBasic user) {
		// TODO Auto-generated method stub
		return signDao.SignUp(user);
	}

	@Override
	public int SignIn(UsersBasic user) {
		// TODO Auto-generated method stub
		return signDao.SignIn(user);
	}


}
