package cn.ivase.Dao.Imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cn.ivase.Dao.CommentsDao;

public class CommentsDaoImp implements CommentsDao {
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int DeleteCommentsByArgs(String sreachKey, Object sreachValue) {
		// TODO Auto-generated method stub
		String deleteSql = "delete from comments where "+sreachKey+"=?";
		System.out.println("deleteSql:"+deleteSql+"/////values:"+sreachValue.toString());
		return jdbcTemplate.update(deleteSql, sreachValue);
	}

	@Override
	public int GetTotalComments() {
		String selectSql = "select count(*) from comments";
		int total = (Integer)jdbcTemplate.queryForObject(selectSql, Integer.class, new Object[]{});
		return total;
	}

	@Override
	public List<Map<String, Object>> GetAllComments() {
		String selectSql = "select * from comments";
		return jdbcTemplate.queryForList(selectSql);
	}
	
}
