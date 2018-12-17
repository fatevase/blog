package cn.ivase.Model;

public class ConfigKeys {
	private ConfigKeys() {}
	public static final String MYSQL_REAL_PATH = "WEB-INF/database/mysql.properties";
	public static final String SQLSERVER_REAL_PATH = "WEB-INF/database/sqlserver.properties";
	public static final String GLOBAL_REAL_PATH = "WEB-INF/Global.properties";
	public static final String MYSQL_SQL_PATH = "WEB-INF/database/mysql_table.sql";
	
	public static final String DATABASE_CONNECTION_URL = "database.connection.url";
	public static final String DATABASE_CONNECTION_IMPLEMENTATION = "database.connection.implementation";
	public static final String DATABASE_DRIVER_NAME = "database.driver.name";
	public static final String DATABASE_DRIVER_CONFIG = "database.driver.config";
	public static final String DATABASE_CONNECTION_HOST = "database.connection.host";
	public static final String DATABASE_CONNECTION_USERNAME = "database.connection.username";
	public static final String DATABASE_CONNECTION_PASSWORD = "database.connection.password";
	public static final String DATABASE_CONNECTION_DBNAME = "database.connection.dbname";
	public static final String DATABASE_CONNECTION_ENCODING = "dbencoding";
	public static final String DATABASE_CONNECTION_DRIVER = "database.connection.driver";
	public static final String DATABASE_CONNECTION_STRING = "database.connection.string";
	public static final String DATABASE_CONNECTION_PORT = "database.connection.port";
	public static final String DATABASE_POOL_MIN = "database.connection.pool.min";
	public static final String DATABASE_POOL_MAX = "database.connection.pool.max";
	public static final String DATABASE_USE_TRANSACTIONS = "database.use.transactions";
	public static final String DATABASE_DATASOURCE_NAME = "database.datasource.name";
	public static final String DATABASE_ERROR_PAGE = "database.error.page";
	public static final String DATABASE_MYSQL_UNICODE = "mysql.unicode";
	public static final String DATABASE_MYSQL_ENCODING = "mysql.encoding";
	public static final String DATABASE_AUTO_KEYS = "database.support.autokeys";
	public static final String DATABASE_SUPPORT_SUBQUERIES = "database.support.subqueries";
}
