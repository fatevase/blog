package cn.ivase.Dao;

import java.util.List;
import java.util.Map;
/**
 * *��Comments�� �ݿ���в��� ��ȫ ��Ϊ����д��
 *@Title CommentsDao.java
 *@description TODO
 *@time 2018��12��24�� ����12:17:52
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
