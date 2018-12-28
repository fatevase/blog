package cn.ivase.Service;

import java.util.List;
import java.util.Map;

public interface ContentsService {
	public List<Map<String,Object>> GetAllContents();
	public int ChangeContents(Map<String,Object> changeParameter,String judgeKey);
	public int AddContents(Map<String,Object> addParameter);
	public List<Map<String,Object>> GetContentsByArgs(String sreachKey,Object sreachValue,boolean fuzzy);
	public int DeleteContentsByArgs(String sreachKey,Object sreachValue);
	public Map<String,Object> GetContentsByArgs(String target, Map<String,Object> judges);
	public List<Map<String,Object>> ShowSomeContents();
}
