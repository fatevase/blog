package cn.ivase.Dao;

import cn.ivase.Bean.UsersBasic;
/**
 * *注册的类 用的还是userbean传志。。。
 *  *懒得改成Map类型了
 *@Title SignDao.java
 *@description TODO
 *@time 2018年12月24日 下午12:21:05
 *@author FateVase
 *@version 1.0
 *
 *
 *
 */
public interface SignDao {
	public int SignUp(UsersBasic user);
	public int SignIn(UsersBasic user);
	public int CheckLoginState();
}
