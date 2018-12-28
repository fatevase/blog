package cn.ivase.Dao;

import java.util.List;
import java.util.Map;
/**
 * *对Comments数 据库进行操作 不全 因为不想写了
 *@Title CommentsDao.java
 *@description TODO
 *@time 2018年12月24日 下午12:17:52
 *@author FateVase
 *@version 1.0
 *
 *
*
 */
public interface CommentsDao {

	
	public int DeleteCommentsByArgs(String sreachKey,Object sreachValue);
	public int GetTotalComments();
	public List<Map<String,Object>> GetAllComments();
}
