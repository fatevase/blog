package cn.ivase.Dao.Imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.ivase.Bean.UsersBasic;
import cn.ivase.Dao.UsersDao;
import cn.ivase.Model.timeSwitch;

public class UsersDaoImp implements UsersDao {
	private JdbcTemplate jdbcTemplate;
	public List<Map<String,Object>> GetAllUsers() {
		String selectSql = "select * from users_basic";
		List<Map<String,Object>> out_all = jdbcTemplate.queryForList(selectSql);
		return out_all;
	};
	public int ChangeUser(UsersBasic user) {
		int result = 0;
		
		if(isEmpty(user.getUid())) {
			result = -1;
		} 
		String core_sql = "";
		
		List change_value = new ArrayList<Object>();
		if(!isEmpty(user.getUsername())) {
			core_sql += " username=? ";
			change_value.add(user.getUsername());
		} else {
			core_sql += " username=username ";
		}
		if(!isEmpty(user.getPassword())) {
			core_sql += ", password=md5(?) ";
			change_value.add(user.getPassword());
		} else {
			core_sql += ", password=password ";
		}
		if(!isEmpty(user.getMail())) {
			core_sql += ", mail=? ";
			change_value.add(user.getMail());
		} else {
			core_sql += ", mail=mail ";
		}
		
		if(!isEmpty(user.getGroups())) {
			core_sql += ", groups=? ";
			change_value.add(user.getGroups());
		} else {
			core_sql += ", groups=groups ";
		}
		Object[] user_value = new Object[change_value.size()+1];
		for(int i=0;i<change_value.size();i++) {
			user_value[i] = change_value.get(i);
			System.out.println(user_value[i]);
		}
		user_value[change_value.size()]=user.getUid();
		
		String updateSql = "update users_basic set "+core_sql+"where uid=?";
		System.out.println(updateSql);
		result = jdbcTemplate.update(updateSql, user_value);
		System.out.println("---------"+result);
		return result;
	};
	
	@Override
	public int AddUser(UsersBasic user) {
		// TODO Auto-generated method stub
		int result = 0;
		Object[] insert_data = new Object[] {user.getUsername(),user.getPassword(),user.getMail(),timeSwitch.getUnixTime(),user.getGroups()};
		String insertSql = "insert users_basic(username,password,mail,created,groups) value(?,md5(?),?,?,?)";
		result = jdbcTemplate.update(insertSql, insert_data);
		return result;
	}
	
	public int AddUser(Map<String, Object> addParameter) {
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
			String update_sql = "insert into users_basic ("+ insert_core +") value("+ insert_value+")";
			System.out.println(update_sql);
			for(i=0;i<args.length;i++) {
				System.out.println("i ="+i +" args:"+args[i]);
			}
		return jdbcTemplate.update(update_sql, args);
	}
	
	public int AddSchoolUser(Map<String, Object> addParameter) {
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
			String update_sql = "insert into schoolusers ("+ insert_core +") value("+ insert_value+")";
			System.out.println(update_sql);
			for(i=0;i<args.length;i++) {
				System.out.println("i ="+i +" args:"+args[i]);
			}
		return jdbcTemplate.update(update_sql, args);
	}
	
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public boolean isEmpty(Object ob) {
		if(ob==null||ob.toString().length()==0) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public List<Map<String, Object>> GetUserByArgs(String args, Object values,boolean fuzzy) {
		String selectSql="";
		if(fuzzy) {
			selectSql = "select * from users_basic where "+args+" like ?";
			values = "%"+values+"%";
		} else {
			selectSql = "select * from users_basic where "+args+"=?";
		}
		System.out.println("selectSql:"+selectSql+"/////values:"+values.toString());
		List<Map<String,Object>> out_user = jdbcTemplate.queryForList(selectSql,values);
		return out_user;
	}
	@Override
	public int DeleteUserByArgs(String args,Object values) {
		String deleteSql = "delete from users_basic where "+args+"=?";
		System.out.println("deleteSql:"+deleteSql+"/////values:"+values.toString());
		int out_user = jdbcTemplate.update(deleteSql, values);
		return out_user;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * get user's target data from database where values satisfy 
	 * the corresponding key value si consisitent with database
	 * 
	 * @see cn.ivase.Dao.UsersDao#GetUserByArgs(java.lang.String, java.util.Map)
	 */
	@Override
	public Map<String,Object> GetUserByArgs(String aim, Map<String, Object> values) {
		String selectSql = "SELECT "+aim+" FROM users_basic ";
		String where_core = "";
		 Object[] select_value = new Object[values.size()];
		 int i=0;
	       for(String key : values.keySet()) {  
	    	   //TODO : deal with null data
	    	   select_value[i] = values.get(key);
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
	       System.out.println("GetUserByArgs result length->"+result.size());
		return result;
	}
	
	

}
