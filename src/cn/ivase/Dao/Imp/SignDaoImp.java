package cn.ivase.Dao.Imp;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.ivase.Bean.UsersBasic;
import cn.ivase.Dao.SignDao;
import cn.ivase.Model.timeSwitch;

public class SignDaoImp implements SignDao {
	private JdbcTemplate jdbcTemplate;
	@Override
	public int SignUp(UsersBasic user) {
		// TODO Auto-generated method stub
		int result = 0;
		Object[] insert_data = new Object[] {user.getUsername(),user.getPassword(),user.getMail(),timeSwitch.getUnixTime()};
		String insertSql = "insert users_basic(username,password,mail,created) value(?,md5(?),?,?)";
		result = jdbcTemplate.update(insertSql, insert_data);
		return result;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int SignIn(UsersBasic user) {
		// TODO Auto-generated method stub
		int result = 0;
		Object[] updata_value = new Object[] {timeSwitch.getUnixTime(),user.getUsername(),user.getPassword()};
		String update_sql = "update users_basic set activated=? where username=? and password=md5(?)";
		result = jdbcTemplate.update(update_sql, updata_value);
		return result;
	}

	@Override
	public int CheckLoginState() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
