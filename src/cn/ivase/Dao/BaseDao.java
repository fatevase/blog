package cn.ivase.Dao;

import java.util.List;
import java.util.Map;
/**
 ** 自己在做完后自己抽出的一些公用的数据库操作 
 *
 * * 但是不想测试了 就没在数据库操作中使用
 * * 定义的基础数据库操作 不支持连表操作 
 *@Title BaseDao.java
 *@description TODO
 *@time 2018年12月24日 下午12:18:08
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
