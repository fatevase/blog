package cn.ivase.Dao.Imp;

import java.util.HashMap;
import java.util.Map;

import cn.ivase.Dao.ContentsDao;

public class testMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Object> values = new HashMap<String,Object>();
		//values.put("classify","±ä³É");
		int c = GetTotalContents(values);
	}
	
	public static int GetTotalContents(Map<String,Object> factor) {
		String select_core = "";
		String selectSql = "SELECT COUNT(*) FROM contents ";
		Object[] args;
 	   if(factor==null) {
 		  args = new Object[] {};
	   } else {
		  args = new Object[factor.size()];
		  int i=0;
	       for(String key : factor.keySet()) {  
	    	   //TODO : deal with null data   
	    	   args[i] = factor.get(key);
	            if(i==0) {
	            	select_core ="WHERE "+ key + " = ? ";
	            } else{
	            	select_core = select_core +" AND "+ key + " = ? ";
	            }
	            i++;   
	       }
	       selectSql = selectSql + select_core ;
	   }
		 
		System.out.println(selectSql);
		for(int i=0;i<args.length;i++) {
			System.out.println("["+i+"]="+args[i]);
		}
		return 0;
	}

}
