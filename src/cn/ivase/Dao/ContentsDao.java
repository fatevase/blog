package cn.ivase.Dao;

import java.util.List;
import java.util.Map;

import cn.ivase.Bean.UsersBasic;
/**
  ** �����µ����ݿ���� ������ ��д�������ѯ��һЩ����
  **   BaseDao���ݴ󲿷��ǴӸ����г��
 *@Title ContentsDao.java
 *@description TODO
 *@time 2018��12��24�� ����12:18:45
 *@author FateVase
 *@version 1.0
 *
 *
*
 */
public interface ContentsDao {

	public List<Map<String,Object>> GetAllContents();
	public int ChangeContents(Map<String,Object> changeParameter,String judgeKey);
	public int AddContents(Map<String,Object> addParameter);
	public List<Map<String,Object>> GetContentsByArgs(String sreachKey,Object sreachValue,boolean fuzzy);
	public int DeleteContentsByArgs(String sreachKey,Object sreachValue);
	
	public Map<String,Object> GetContentsByArgs(String target, Map<String,Object> judges);
	
	public int GetTotalContents();
	public int GetTotalContents(Map<String,Object> factor);
}
