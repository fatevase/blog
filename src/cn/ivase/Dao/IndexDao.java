package cn.ivase.Dao;


import java.util.List;
import java.util.Map;
/**
 * *ǰ��������ʾ
 *@Title IndexDao.java
 *@description TODO
 *@time 2018��12��24�� ����12:20:11
 *@author FateVase
 *@version 1.0
 *
 *
*
 */
public interface IndexDao {
	public List<Map<String,Object>> ShowIndex();
	public List<Map<String,Object>> ShowPage(String args, Object values,boolean fuzzy);
	public List<Map<String,Object>> ShowComments(String args ,Object values,boolean fuzzy);
	
	public int InsertComments(Map<String,Object> values);
	
	public int UpdateContent(Map<String,Object> values);
}
