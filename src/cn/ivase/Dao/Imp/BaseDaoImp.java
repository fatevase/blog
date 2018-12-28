package cn.ivase.Dao.Imp;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;

import cn.ivase.Dao.BaseDao;

public class BaseDaoImp implements BaseDao {
	JdbcTemplate jdbcTemplate;
	TransactionTemplate transactionTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	@Override
	public int InsertData(String table, Map<String, Object> addParameter) {

		String insert_core = "";
		String insert_value = "";
		 Object[] args = new Object[addParameter.size()];
		 int i=0;
	       for(String key : addParameter.keySet()) {  

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
		String update_sql = "insert into "+table+" ("+ insert_core +") value("+ insert_value+")";
		return jdbcTemplate.update(update_sql, args);
	}
	
	@Override
	public int UpdateData(String table, String judgeKey,Map<String, Object> updateParameter) {

		String update_core = "";
		String update_where = "";
		 Object[] args = new Object[updateParameter.size()];
		 int i=0;
	       for(String key : updateParameter.keySet()) {  

	    	   if(key.equals(judgeKey)) {
	    		   args[updateParameter.size()-1] = updateParameter.get(key);
	    		   update_where = "where "+ judgeKey +" = ? ";
	    		   continue;
	    	   }
	    	   args[i] = updateParameter.get(key);
	            if(i==0) {
	            	update_core = key + " = ? ";
	            } else{
	            	update_core = update_core +", "+ key + " = ? ";
	            }
	            i++;   
	       }
			String update_sql = "update "+table+" set "+ update_core + update_where;
			System.out.println(update_sql);

		return jdbcTemplate.update(update_sql, args);
	}
	@Override
	public int DeleteData(String table,String judgeKey, Map<String, Object> deleteParameter) {

		String delete_core = "";
		String delete_where = "";
		 Object[] args = new Object[deleteParameter.size()];
		 int i=0;
	       for(String key : deleteParameter.keySet()) {  
	    	   //TODO : deal with null data   
	    	   if(key.equals(judgeKey)) {
	    		   args[deleteParameter.size()-1] = deleteParameter.get(key);
	    		   delete_where = "where "+ judgeKey +" = ? ";
	    		   continue;
	    	   }
	    	   args[i] = deleteParameter.get(key);
	            if(i==0) {
	            	delete_core = key + " = ? ";
	            } else{
	            	delete_core = delete_core +", "+ key + " = ? ";
	            }
	            i++;   
	       }
			String update_sql = "DELETE FOROM "+table+" "+ delete_core + delete_where;
		return jdbcTemplate.update(update_sql, args);
	}
	@Override
	public Map<String, Object> GetAimDataByArgs(String table, String Aimcolumn, Map<String, Object> getParameter) {
		String selectSql = "SELECT "+Aimcolumn+" FROM "+table+" ";
		String where_core = "";
		 Object[] select_value = new Object[getParameter.size()];
		 int i=0;
	       for(String key : getParameter.keySet()) {  
	    	   //TODO : deal with null data
	    	   select_value[i] = getParameter.get(key);
	    	   System.out.println(select_value[i]);
	            if(i==0) {
	            	where_core = " WHERE "+ where_core + key + " = ? ";
	            } else {
	            	where_core = where_core +" AND "+ key + " = ? ";
	            }
	            i++;   
	       }
	       selectSql = selectSql + where_core;
	       Map<String,Object> result = null;
	       result  = jdbcTemplate.queryForMap(selectSql,select_value);
		return result;
	}
	@Override
	public List<Map<String, Object>> GetDataByArgs(String table, String column, Object args, boolean fuzzy) {
		String selectSql="";
		if(fuzzy) {
			selectSql = "SELECT * FROM "+table+" WHERE "+column+" like ?";
			args = "%"+args+"%";
		} else {
			selectSql = "select * from users_basic where "+column+"=?";
		}
		List<Map<String,Object>> out_user = jdbcTemplate.queryForList(selectSql,args);
		return out_user;
	}
	@Override
	public int GetDataTotal(String table, Map<String, Object> factor) {
		String select_core = "";
		String selectSql = "SELECT COUNT(*) FROM "+table+" ";
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
		return total;
	}
	@Override
	public int DeleteDataByOneArgs(String table,String sreachKey, Object sreachValue) {
		String deleteSql = "delete from "+table+" where "+sreachKey+"=?";

		return jdbcTemplate.update(deleteSql, sreachValue);
	}
	
	@Override
	public List<Map<String, Object>> GetDataByOneArgs(String table,String sreachKey, Object sreachValue) {
		String selectSql = "SELECT * FROM "+table;
		if(sreachKey != null && sreachValue !=null) {
			selectSql = selectSql + " where "+sreachKey+"=? ";
		}
		return jdbcTemplate.queryForList(selectSql, sreachKey);
	}
	
	
}
