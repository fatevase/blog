package cn.ivase.Dao;

import cn.ivase.Bean.UsersBasic;
/**
 * *ע����� �õĻ���userbean��־������
 *  *���øĳ�Map������
 *@Title SignDao.java
 *@description TODO
 *@time 2018��12��24�� ����12:21:05
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
