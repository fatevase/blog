package cn.ivase.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.ivase.Model.ConfigKeys;
import cn.ivase.Model.UsingProperties;
import cn.ivase.Model.util;


public class DBConnection {

//	final private static String            MYSQL_URL     = "jdbc:mysql://localhost:3306/vase";	
//	final private static String            MYSQLUSER     = "root";
//	final private static String            PASSWORD      = "980122";	
	private static       String			   CLASS_FORNAME = "/com.mysql.jdbc.Driver";
	private 			 Statement         statement     = null;
	private 			 ResultSet 	       resultset     = null;
	private 			 Connection        connection    = null;
	private 			 PreparedStatement prepared      = null;
	private static       String            CONNECTION_URL= ""; 
	
	/**
	 * DBConnection 
	 * init
	 */
	public DBConnection() {
		String filePath = util.getWebRootPath()+ConfigKeys.GLOBAL_REAL_PATH;
		UsingProperties upp = new UsingProperties();
		CLASS_FORNAME = upp.GetValueByKey(filePath, ConfigKeys.DATABASE_CONNECTION_DRIVER);
		CONNECTION_URL= upp.GetValueByKey(filePath, ConfigKeys.DATABASE_CONNECTION_URL);
		if(connection==null || statement==null) {
		try{
			Class.forName(CLASS_FORNAME);
			connection = DriverManager.getConnection(CONNECTION_URL);
			statement = connection.createStatement();
			
		}catch(Exception e){
			System.out.println("MysqlException:mysql error.");
		}
		}
	}
	
	/**
	 * testSQL:test my connection successfully
	 * @param sql 
	 */
	public String testSQL(String sql){
		String out_msg = null;
		try{
			resultset = statement.executeQuery(sql);
			while(resultset.next()){
				System.out.println("ResultSet get:"+resultset.getString(2));
				out_msg += "ResultSet get:"+resultset.getString(2)+"\n";
			}
		}catch(Exception e){
			System.out.println("MysqlException:executeQuery error.");
		}finally{
			resultset = null;
		}
		return out_msg;
	}
	
	/**
	 * executeQuery execute select sql string
	 * @param perparedsql
	 * @param perparedarray
	 * @return
	 */
	
	public ResultSet ExePerpared(String perparedsql,String[] perparedarray){
		
		try{
			prepared = connection.prepareStatement(perparedsql);
			for(int i=0;i<perparedarray.length;i++){
				prepared.setString(i+1, perparedarray[i]);
			}
			System.out.println(prepared.toString());
			resultset = prepared.executeQuery();
		}catch(Exception e){
			System.out.println("MysqlException:ExePerpared PreparedStatement error.");
		}finally{
			prepared = null;
		}
		return resultset;
	}
	

	/**
	 * executeUpdate execute update or delete sql
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
	
	/**
	 * close all DBConnection res
	 */
	public void CloseAll() {
		try{
			resultset = null;
			prepared = null;
			connection.close();
			statement.close();
		}catch(Exception e){
			System.out.println("MysqlException:Close Mysql error.");
		}
	}
	
	/**
	 * ResultSet to list <map>
	 * @param rs
	 * @return
	 */
	public List<Map<String,String>> ResultToListMap(ResultSet rs){
		 List<Map<String, String>> data_list = new ArrayList<Map<String,String>>();
		
		try{
			ResultSetMetaData all_data = rs.getMetaData();
			int data_col_num = all_data.getColumnCount();
			System.out.println("data_col_num:"+data_col_num);

			//��ȡ����
			while(rs.next()){
				Map<String,String> data_map =new HashMap<String,String>();
				System.out.println("Start for loop");
				for(int i=1;i<=data_col_num;i++) {
					data_map.put(all_data.getColumnName(i),rs.getString(i));
					System.out.println("all_data:"+all_data.getColumnName(i)+":"+rs.getString(i));
				}
				data_list.add(data_map);
			}
		}catch(Exception e){
			data_list = null;
			System.out.println("MysqlException:ResultToListMap ResultSet error.");
		}finally{
			rs = null;
		}
		return data_list;
	}
  
	/**
	 * get resultset col name
	 * @param rs
	 * @return
	 */
	public String[] GetResultColName(ResultSet rs) {
		ResultSetMetaData all_data;
		String[] col_name;
		try{		
			all_data = rs.getMetaData();
			int data_col_num = all_data.getColumnCount();
			col_name = new String[data_col_num];
			col_name = new String[data_col_num];
			for(int i=0;i<data_col_num;i++) {
				col_name[i] = (all_data.getColumnName(i+1));
			}
		}catch(Exception e){
			col_name = null;
		}finally {
			rs = null;
			all_data = null;
		}
		return col_name;
		
	}
	
	
}
