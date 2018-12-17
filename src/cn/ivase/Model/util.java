package cn.ivase.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class util {
	private util() {}
	
	/**
	 * getWebRootPath
	 * @return
	 */
	public static String getWebRootPath(){
		String rootPath ="";
		try {
			ActionContext actionContext = ActionContext.getContext();
			ServletContext servletContext = (ServletContext)actionContext.get(ServletActionContext.SERVLET_CONTEXT);
				rootPath = servletContext.getRealPath("/");
		}catch(Exception e) {
			rootPath = null;
		}
	return rootPath;
	}
	
	public static String getFileContent(String filePath){
		String readContent = "no file";
		try{
		File file = new File(filePath);
		FileReader in = new FileReader(file);
		BufferedReader inTwo=new BufferedReader(in);
		StringBuffer stringbuff = new StringBuffer();
		String s = null;
		while((s=inTwo.readLine())!=null){
			byte b[] = s.getBytes();
			s = new String(b);
			stringbuff.append("\n"+s);
		}
		readContent = new String(stringbuff);
		in.close();
		}catch(Exception e){
			
		}
		return readContent;
	}
}
