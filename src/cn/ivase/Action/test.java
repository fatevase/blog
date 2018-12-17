package cn.ivase.Action;

import cn.ivase.Dao.InitDB;

public class test {
	private static String username = "root";
	private static String password = "zhu980122";
	private static String host = "localhost";
	private static String port = "3306";
	private static String database_type = "mysql";
	private static String database_name ="vase";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InitDB idb = new InitDB(database_type);
		String msg = idb.InitProperties(host,port,username,password);
		// idb.InstallDB(database_type, database_name);
	}

}
