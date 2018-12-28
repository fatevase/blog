package cn.ivase.Dao;

import java.util.List;
import java.util.Map;
/**
 ** �Լ���������Լ������һЩ���õ����ݿ���� 
 *
 * * ���ǲ�������� ��û�����ݿ������ʹ��
 * * ����Ļ������ݿ���� ��֧��������� 
 *@Title BaseDao.java
 *@description TODO
 *@time 2018��12��24�� ����12:18:08
 *@author FateVase
 *@version 1.0
 *
 *
*
 */
public interface BaseDao {


	public int InsertData(String table,Map<String, Object> addParameter);
	public int UpdateData(String table,String judgeKey,Map<String, Object> updateParameter);
	public int DeleteData(String table,String judgeKey,Map<String, Object> deleteParameter);
	public int DeleteDataByOneArgs(String table,String sreachKey, Object sreachValue);
	public int GetDataTotal(String table,Map<String,Object> factor) ;
	public Map<String,Object> GetAimDataByArgs(String table,String Aimcolumn, Map<String, Object> getParameter);
	public List<Map<String, Object>> GetDataByArgs(String table,String column, Object args,boolean fuzzy);
	public List<Map<String, Object>> GetDataByOneArgs(String table,String sreachKey, Object sreachValue);
}
