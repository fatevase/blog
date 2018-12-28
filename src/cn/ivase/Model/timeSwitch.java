package cn.ivase.Model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class timeSwitch {

	
	public static int getUnixTime(){
		int day=60 * 60 * 24;		
		int currentTime= (int) (System.currentTimeMillis() / 1000);
		return currentTime-(currentTime+8*3600)%day;
	}//获取unix time 精确度 ： 天
	
	public static int getAccurateUnixTime(){
		return (int) (System.currentTimeMillis() / 1000);
	}//获取unix time 精确度 ：秒
	
	
	public static String UnixToDate(int ms){
		String str = "";              
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
            long msl=(long)ms*1000;  
            if(ms>0){  
                try {  
                    str=sdf.format(msl);                    
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            } else {
            	str = "未知";
            }       
   return str;  
   }//unix 转 string
  
	public static String AccurateUnixToDate(int ms){
		String str = "";              
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
            long msl=(long)ms*1000;  
            if(ms>0){  
                try {  
                    str=sdf.format(msl);                    
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            } else {
            	str = "未知";
            }       
   return str;  
   }//精确的 unix 转 string

	
	public static int DateToUnix(String date){
		int UnixTime=0;
		 try {  
			            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
			            
			              UnixTime = (int)(sdf.parse(date).getTime()/1000);  
			          } catch (Exception e) {  
			              e.printStackTrace();  
			              return UnixTime; 
			          }  
			          return UnixTime;  
	}
	
	public static int AccurateDateToUnix(String date){
		int UnixTime=0;
		 try {  
			            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
			            
			              UnixTime = (int)(sdf.parse(date).getTime()/1000);  
			          } catch (Exception e) {  
			              e.printStackTrace();  
			              return UnixTime; 
			          }  
			          return UnixTime;  
	}
}// 精确的 string 转 unix
