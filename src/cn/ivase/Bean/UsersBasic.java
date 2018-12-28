package cn.ivase.Bean;
/**
 * 数据库userbasic
 *@Title UsersBasic.java
 *@description TODO
 *@time 2018年12月24日 下午12:23:30
 *@author FateVase
 *@version 1.0
 *
 *
*
 */
public class UsersBasic {
	int uid;
	String username;
	String password;
	String mail;
	String validatekey;
	int created;
	int activated;
	String groups;
	public UsersBasic() {
		
	}
	public UsersBasic(int uid,String username,String password,String mail,String validatekey,int created,int activated,String groups) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.validatekey = validatekey;
		this.created = created;
		this.activated = activated;
		this.groups = groups;
	}
	
	
	@Override
	public String toString() {
		return "UsersBasic [uid=" + uid + ", username=" + username + ", password=" + password + ", mail=" + mail
				+ ", validatekey=" + validatekey + ", created=" + created + ", activated=" + activated + ", groups="
				+ groups + "]";
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getValidatekey() {
		return validatekey;
	}
	public void setValidatekey(String validatekey) {
		this.validatekey = validatekey;
	}
	public int getCreated() {
		return created;
	}
	public void setCreated(int created) {
		this.created = created;
	}
	public int getActivated() {
		return activated;
	}
	public void setActivated(int activated) {
		this.activated = activated;
	}
	public String getGroups() {
		return groups;
	}
	public void setGroups(String groups) {
		this.groups = groups;
	}
	



}
