package cn.ivase.Dao;

import java.util.List;
import java.util.Map;

import cn.ivase.Bean.UsersBasic;
/**
  ** 对文章的数据库操作 较完整 内写了连表查询的一些东西
  **   BaseDao内容大部分是从该类中抽出
 *@Title ContentsDao.java
 *@description TODO
 *@time 2018年12月24日 下午12:18:45
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
