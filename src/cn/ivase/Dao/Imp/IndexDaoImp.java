package cn.ivase.Dao.Imp;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class IndexDaoImp implements cn.ivase.Dao.IndexDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Map<String, Object>> ShowIndex() {
		// TODO Auto-generated method stub
		String selectSql = "select * from contents";
		List<Map<String,Object>> out_all = jdbcTemplate.queryForList(selectSql);
		return out_all;
	}
	

	@Override
	public List<Map<String, Object>> ShowPage(String args, Object values,boolean fuzzy) {
		// TODO Auto-generated method stub
		String selectSql="";
		if(fuzzy) {
			selectSql = "select contents.cid,contents.title,contents.created,"
					+ "contents.modified,contents.text,contents.authorId,"
					+ "contents.status,contents.password,contents.commentsNum,"
					+ "users_basic.username from "
					+ "contents,users_basic where "
					+ "contents.authorId = users_basic.uid and "
					+ args +" like ? order by contents.created DESC";
			values = "%"+values+"%";
		} else {
			selectSql = "select contents.cid,contents.title,contents.created,"
					+ "contents.modified,contents.text,contents.authorId,"
					+ "contents.status,contents.password,contents.commentsNum,"
					+ "users_basic.username from "
					+ "contents,users_basic where "
					+ "contents.authorId = users_basic.uid and "
					+ args +" = ? order by contents.created DESC";
		}
		System.out.println("selectSql:"+selectSql+"/////values:"+values.toString());
		List<Map<String,Object>> out_user = jdbcTemplate.queryForList(selectSql,values);
		return out_user;
	}

	@Override
	public List<Map<String, Object>> ShowComments(String args ,Object values,boolean fuzzy) {
		// TODO Auto-generated method stub
		String selectSql="";
		if(fuzzy) {
			selectSql = "select comments.coid,comments.cid,comments.owenrId,"
					+ "users_basic.username,comments.created,comments.ip,"
					+ "comments.text,comments.parent,comments.status ,users_basic.username "
					+ " from comments,users_basic where comments.owenrId=users_basic.uid and "+args+"like ?";
			values = "%"+values+"%";
		} else {
			selectSql = "select comments.coid,comments.cid,comments.owenrId,"
					+ "users_basic.username,comments.created,comments.ip,"
					+ "comments.text,comments.parent,comments.status ,users_basic.username "
					+ " from comments,users_basic where comments.owenrId=users_basic.uid and "+args+"=?";
			
		}
		System.out.println("selectSql:"+selectSql+"/////values:"+values.toString());
		List<Map<String,Object>> out_user = jdbcTemplate.queryForList(selectSql,values);
		return out_user;
	}

	@Override
	public int InsertComments(Map<String, Object> values) {
		// TODO Auto-generated method stub
		String insertSql = "insert into comments(cid,created,owenrId,ip,text,parent) value(?,?,?,?,?,?)";
		Object[] insertValue = new Object[] {values.get("cid"),values.get("created"),
											 values.get("owenrId"),values.get("ip"),
											 values.get("text"),values.get("parent")};
		System.out.println("insertSql:"+insertSql+"/////values:"+values.toString());
		return jdbcTemplate.update(insertSql,insertValue);
	}

	@Override
	public int UpdateContent(Map<String, Object> values) {
		// TODO Auto-generated method stub
		String updateSql = "update contents set commentsNum=commentsNum+1 where cid = ?";
		Object[] updateValue = new Object[] {values.get("cid")};
		System.out.println("insertSql:"+updateSql+"/////values:"+values.get("cid"));
		return jdbcTemplate.update(updateSql,updateValue);
	}
}



