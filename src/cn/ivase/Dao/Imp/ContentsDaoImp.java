package cn.ivase.Dao.Imp;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.ivase.Dao.ContentsDao;

public class ContentsDaoImp implements ContentsDao {
	JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		
	}
	
	@Override
	public List<Map<String, Object>> GetAllContents() {
		String selectSql = "select * from contents where status = 'publish' order by created DESC";
		return jdbcTemplate.queryForList(selectSql);
	}

	@Override
	public int ChangeContents(Map<String,Object> changeParameter,String judgeKey) {
		// TODO Auto-generated method stub
		String update_core = "";
		String update_where = "";
		 Object[] args = new Object[changeParameter.size()];
		 int i=0;
	       for(String key : changeParameter.keySet()) {  
	    	   //TODO : deal with null data   
	    	   if(key.equals(judgeKey)) {
	    		   args[changeParameter.size()-1] = changeParameter.get(key);
	    		   update_where = "where "+ judgeKey +" = ? ";
	    		   continue;
	    	   }
	    	   args[i] = changeParameter.get(key);
	            if(i==0) {
	            	update_core = key + " = ? ";
	            } else{
	            	update_core = update_core +", "+ key + " = ? ";
	            }
	            i++;   
	       }
			String update_sql = "update contents set "+ update_core + update_where;
			System.out.println(update_sql);
			for(i=0;i<args.length;i++) {
				System.out.println("i ="+i +" args:"+args[i]);
			}
		return jdbcTemplate.update(update_sql, args);
	}

	@Override
	public int AddContents(Map<String, Object> addParameter) {
		// TODO Auto-generated method stub
		String insert_core = "";
		String insert_value = "";
		 Object[] args = new Object[addParameter.size()];
		 int i=0;
	       for(String key : addParameter.keySet()) {  
	    	   //TODO : deal with null data   
	    	   args[i] = addParameter.get(key);
	            if(i==0) {
	            	insert_core = key ;
	            	insert_value = " ? ";
	            } else{
	            	insert_core = insert_core + ", "+ key ;
	            	insert_value = insert_value+ ", ? ";
	            }
	            
	            i++;   
	       }
			String update_sql = "insert into contents ("+ insert_core +") value("+ insert_value+")";
			System.out.println(update_sql);
			for(i=0;i<args.length;i++) {
				System.out.println("i ="+i +" args:"+args[i]);
			}
		return jdbcTemplate.update(update_sql, args);
	}

	@Override
	public List<Map<String, Object>> GetContentsByArgs(String sreachKey, Object sreachValue, boolean fuzzy) {
		String selectSql="";
		if(fuzzy) {
			selectSql = "SELECT contents.cid,contents.title,contents.created,"
					+ "contents.modified,contents.text,contents.authorId,"
					+ "contents.status,contents.password,contents.commentsNum,"
					+ "contents.classify,users_basic.username FROM "
					+ "contents,users_basic WHERE "
					+ "contents.authorId = users_basic.uid and "
					+ sreachKey +" LIKE ? order by contents.created DESC";
			sreachValue = "%"+sreachValue+"%";
		} else {
			selectSql = "SELECT contents.cid,contents.title,contents.created,"
					+ "contents.modified,contents.text,contents.authorId,"
					+ "contents.status,contents.password,contents.commentsNum,"
					+ "contents.classify,users_basic.username FROM "
					+ "contents,users_basic WHERE "
					+ "contents.authorId = users_basic.uid and "
					+ sreachKey +" = ? order by contents.created DESC";
		}
		System.out.println("ContentsDao GetContentsByArgs selectSql:"+selectSql+"/////values:"+sreachValue.toString());
		return jdbcTemplate.queryForList(selectSql,sreachValue);
	}

	@Override
	public int DeleteContentsByArgs(String sreachKey, Object sreachValue) {
		String deleteSql = "delete from contents where "+sreachKey+"=?";
		System.out.println("deleteSql:"+deleteSql+"/////values:"+sreachValue.toString());
		return jdbcTemplate.update(deleteSql, sreachValue);
	}

	@Override
	public Map<String, Object> GetContentsByArgs(String target, Map<String, Object> judges) {
		String selectSql = "SELECT "+target+" FROM contents ";
		String where_core = "";
		 Object[] select_value = new Object[judges.size()];
		 int i=0;
	       for(String key : judges.keySet()) {  
	    	   //TODO : deal with null data
	    	   select_value[i] = judges.get(key);
	    	   System.out.println(select_value[i]);
	            if(i==0) {
	            	where_core = " WHERE "+ where_core + key + " = ? ";
	            } else {
	            	where_core = where_core +" AND "+ key + " = ? ";
	            }
	            i++;   
	       }
	       selectSql = selectSql + where_core +" order by created DESC";
		return jdbcTemplate.queryForMap(selectSql,select_value);
	}

	@Override
	public int GetTotalContents() {
		int total = (Integer)jdbcTemplate.queryForObject("select count(*) from contents", Integer.class, new Object[]{});
		return total;
	}
	
	/**
	 * 根据传入的参数统计总和 当传入null时默认获取所有
	 */
	public int GetTotalContents(Map<String,Object> factor) {
		String select_core = "";
		String selectSql = "SELECT COUNT(*) FROM contents ";
		Object[] args;
 	   if(factor==null) {
 		  args = new Object[] {};
	   } else {
		  args = new Object[factor.size()];
		  int i=0;
	       for(String key : factor.keySet()) {  
	    	   args[i] = factor.get(key);
	            if(i==0) {
	            	select_core ="WHERE "+ key + " = ? ";
	            } else{
	            	select_core = select_core +" AND "+ key + " = ? ";
	            }
	            i++;   
	       }
	       selectSql = selectSql + select_core ;
	   }
		int total = (Integer)jdbcTemplate.queryForObject(selectSql, Integer.class, args);

		System.out.println("my total:"+total);
		return total;
	}

}
