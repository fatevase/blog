package cn.ivase.Service;

import java.util.Map;

import cn.ivase.Bean.UsersBasic;

public interface SignService {
	public int SignUp(UsersBasic user);
	public int SignIn(UsersBasic user);
	
}
