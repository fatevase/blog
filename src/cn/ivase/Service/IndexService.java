package cn.ivase.Service;

import java.util.List;
import java.util.Map;

public interface IndexService {
	public List<Map<String,Object>> ShowIndex();
	public List<Map<String,Object>> ShowPage(String args, Object values,boolean fuzzy);
	public List<Map<String,Object>> ShowComments(String args, Object values,boolean fuzzy);
	public int InsertComments(Map<String,Object> values);
	public int ShowContentTotal(Map<String,Object> factor);
}
