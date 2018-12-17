package cn.ivase.Action;

import com.opensymphony.xwork2.ActionSupport;

import cn.ivase.Dao.DBConnection;
import cn.ivase.Dao.InitDB;

public class InstallAction extends ActionSupport {
	private String username;
	private String password;
	private String host;
	private String port;
	private String database_type;
	private String database_name;
	private String msg;
	private String action;
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String execute() throws Exception{
		if("test".equals(this.action)) {
			DBConnection db = new DBConnection();

			msg = db.testSQL("select * from users_basic");
			if(msg==null) {
				msg = "Select test Bad!\n";
			}
		}else {
			InitDB iDB = new InitDB(this.database_type);
			msg = iDB.InitProperties(this.host,this.port,this.username,this.password);
			msg += iDB.InstallDatabase(this.database_name);
			msg += iDB.InstallTable();
		}

		return INPUT;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getDatabase_type() {
		return database_type;
	}
	public void setDatabase_type(String database_type) {
		this.database_type = database_type;
	}
	public String getDatabase_name() {
		return database_name;
	}
	public void setDatabase_name(String database_name) {
		this.database_name = database_name;
	}

	
}
