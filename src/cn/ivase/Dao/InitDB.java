package cn.ivase.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import cn.ivase.Action.BaseAction;
import cn.ivase.Model.ConfigKeys;
import cn.ivase.Model.UsingProperties;
import cn.ivase.Model.util;
/**
 *  *初始化数据库
 *@Title InitDB.java
 *@description TODO
 *@time 2018年12月24日 下午12:20:51
 *@author FateVase
 *@version 1.0
 *
 *
*
 */
public class InitDB {
	private static      String             filePath        = "";
	private static      String             mysql_file_path = "";
	private static      String             global_filePath = "";
	private 			Connection         connection      = null;
	private 			PreparedStatement  prepared        = null;
	private static 		String			   connection_driver = null;
	private static 		String 			   connection_url = null;
	
	
	UsingProperties upp = new UsingProperties();
	public InitDB(String database_type) {

		filePath = util.getWebRootPath();
		try {
		System.out.println(util.getWebRootPath());

		}catch(Exception e) {}
		global_filePath = filePath+ConfigKeys.GLOBAL_REAL_PATH;
		if(database_type.equals("mysql")) {
			mysql_file_path += filePath+ConfigKeys.MYSQL_SQL_PATH;
			filePath = filePath+ConfigKeys.MYSQL_REAL_PATH;	
			
		} else if(database_type.equals("sqlserver")) {
			filePath = filePath+ConfigKeys.SQLSERVER_REAL_PATH;	
		} else {
			System.out.println("\n\n\tMy cn.ivase.Model.IniDB Exception:database_type error!\n\n");
		}
		try {
			upp.WriteProperties(filePath, ConfigKeys.DATABASE_CONNECTION_DBNAME, database_type);
			upp.GetAllProperties(filePath);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param host
	 * @param port
	 * @param username
	 * @param password
	 * @return
	 */
	public String InitProperties(String host,String port,String username,String password) {
		String msg = null;
		try {
			msg = "Start Init DataBase Properties...\n";
			upp.WriteProperties(filePath, "database.connection.host", host);
			upp.WriteProperties(filePath, "database.connection.port", port);
			upp.WriteProperties(filePath, "database.connection.username", username);
			upp.WriteProperties(filePath, "database.connection.password", password);
			msg += "Initialization Database Properties Files Successfully!\n";
		} catch(Exception e) {
		    System.out.println("\n\n\tMy cn.ivase.Model.IniDB Exception:WriteProperties error!\n\n"+e.toString());
		    msg += "Initialization Database Properties Files error! Can't wirte "+filePath+".\n";
		    return msg;
		}
		
		try {
			connection_driver = upp.GetValueByKey(filePath, ConfigKeys.DATABASE_CONNECTION_DRIVER);
			Class.forName(connection_driver);
			msg += "Database Driver Test Successfully!\n";
		} catch(Exception e) {
			msg += "Database Driver Test Bad!\n";
			System.out.println("\n\n\tMy cn.ivase.Model.IniDB Exception:Driver error!\n\n"+e.toString());
			return msg;
		}
		
		try {
			connection_url = GetMysqlConnectionAllUrl(upp, filePath);
			connection = DriverManager.getConnection(connection_url);
			if(!connection.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
				msg += "Connecting Database Successfully!\n";
				msg += "Next Step try Install Custom Database...\n";
			}
		} catch(Exception e) {
			msg += "Connecting Database Error,Check Your SQL Login Name AND Password\n";
			System.out.println("Connection:"+connection_url);
			System.out.println("\n\n\tMy cn.ivase.Model.IniDB Exception:GetConnection error!\n\n"+e.toString());
			
			return msg;
		}
		System.out.println(msg);
		return msg;
	}
	
	
	/**
	 * 
	 * @param database_name
	 */
	public String InstallDatabase(String database_name) {
		String out_msg = null;   

		if(connection == null) {
			return out_msg = "Install Database Error,Can't Building Connection\n";
		} else {
			out_msg = "Not found Database Try Building New Database\n";
		}
		
		if (UpPerpared("DROP DATABASE IF EXISTS "+database_name,new String[] {})>0) {
			out_msg += "Drop Old "+database_name+" Database.\n";
		}
		
		if (UpPerpared("CREATE DATABASE "+database_name,new String[] {})>0) {
			out_msg += "Install "+database_name+" Database Successfully.\n";
		} else {
			out_msg += "Install "+database_name+" Database Error.\n";
			return out_msg;
		}
		
		out_msg += "Try Update Database Properties Files...\n";
		
		try {
        	upp.WriteProperties(filePath, "database.connection.dbname", database_name);
        	out_msg += "Update Database Name To Database Properties Files Successfully!\n";
    	}catch(Exception e) {
    		out_msg += "Update Database Name To Database Properties Files Error!\n";
    		return out_msg;
    	}
		
		try {
			connection_driver = upp.GetValueByKey(filePath, "database.connection.driver");
			connection_url = GetMysqlConnectionAllUrl(upp,filePath);
			upp.WriteProperties(global_filePath, "database.connection.driver", connection_driver);
        	upp.WriteProperties(global_filePath, "database.connection.url", connection_url);
        	
        	out_msg += "Install Global Properties Files Successfully!\n";
    	}catch(Exception e) {
    		out_msg += "Install Global Properties Files  Error!\n";
    		return out_msg;
    	}
		
		try {
			connection_driver = upp.GetValueByKey(global_filePath, "database.connection.driver");
			connection_url = upp.GetValueByKey(global_filePath, "database.connection.url");
			connection = GetConnection(connection_driver,connection_url);
		}catch(Exception e) {
			System.out.println("Read Global Properties Have Some Error,check it Files.\n");
		}
		if(connection == null) {
			out_msg += "Connecting Database Error,Check Your Global Properties.\n";
			return out_msg;
		}
		//TODO: reflash spring

	    ResourceLoader resourceLoader = new DefaultResourceLoader();
	    ReloadableResourceBundleMessageSource auto = new ReloadableResourceBundleMessageSource();
		
		out_msg += "Globall Properties Setting over!\nNext Stap Try Install Table...\n";
		
        return out_msg;
	}
	
	/**
	 * 
	 * @param database_name
	 * @return
	 */
	public String InstallTable() {
		String out_msg = null;
		int e = RunSqlFile(mysql_file_path);
		if (e > 0) {
			out_msg = "Install Table Successfully!";
		} else {
			out_msg = "Install Table Error。";
		}
		return out_msg;
	}
	
	/**
	 * GetMysqlConnectionAllUrl
	 * @param upp
	 * @param filePath
	 * @return
	 */
private String GetMysqlConnectionAllUrl(UsingProperties upp,String filePath) {
    	String url = null;
    	url = upp.GetValueByKey(filePath, "database.connection.head")+
    			upp.GetValueByKey(filePath, "database.connection.host")+
    			":"+upp.GetValueByKey(filePath, "database.connection.port")+
    			"/"+upp.GetValueByKey(filePath, "database.connection.dbname")+
    			"?user="+upp.GetValueByKey(filePath, "database.connection.username")+
    			"&password="+upp.GetValueByKey(filePath, "database.connection.password")+
    			"&useSSL="+upp.GetValueByKey(filePath, "database.connection.useSSL");
    	return url;
    }
	

	/**
	 * GetMysqlConnectionUrl
	 * @param upp
	 * @param filePath
	 * @return
	 */
private String GetMysqlConnectionUrl(UsingProperties upp,String filePath) {
	String url = null;
	url = upp.GetValueByKey(filePath, "database.connection.head")+
			upp.GetValueByKey(filePath, "database.connection.host")+
			":"+upp.GetValueByKey(filePath, "database.connection.port")+
			"/"+upp.GetValueByKey(filePath, "database.connection.dbname")+
			"?useSSL="+upp.GetValueByKey(filePath, "database.connection.useSSL");
	return url;
}

	/**
	 * 
	 * @param driver
	 * @param url
	 * @return
	 * @throws Exception
	 */
private Connection GetConnection(String driver,String url) throws Exception {
	Connection conn = null;
		Class.forName(driver);
		conn = DriverManager.getConnection(url);
		if(!conn.isClosed())
		System.out.println("\n\n\tMy cn.ivase.Model.IniDB GetConnection:Get Successfully。\n\n");
	return conn;
}

	/**
	 * 
	 * @param perparedsql
	 * @param perparedarray
	 * @return
	 */
public int UpPerpared(String perparedsql,String[] perparedarray){
	int result = 0;
	try{
		prepared = connection.prepareStatement(perparedsql);
		for(int i=0;i<perparedarray.length;i++){
			prepared.setString(i+1, perparedarray[i]);
		}
		System.out.println(prepared.toString());
		result = prepared.executeUpdate();
	}catch(Exception e){
		result = -1;
		System.out.println("MysqlException:UpPerpared PreparedStatement error.");
	}finally{
		prepared = null;
	}
	return result;
}
public int RunSqlFile(String sql_file_path) {
	int out_msg = 0;
    try {
    	System.out.println(sql_file_path);
        // 创建ScriptRunner，用于执行SQL脚本
        String file_context = util.getFileContent(sql_file_path);
        String[] list_sql = file_context.split(";");
        for(int i=0;i<list_sql.length;i++) {
        	UpPerpared(list_sql[i],new String[] {});
        	System.out.println(list_sql[i]);
        	
        }
        out_msg = 1;
        // 执行SQL脚本
        // 若成功，打印提示信息
        System.out.println("====== SUCCESS ======");
    } catch (Exception e) {
        e.printStackTrace();
        out_msg = -1;
    }
    return out_msg;
}




}
