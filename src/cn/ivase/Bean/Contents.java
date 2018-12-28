
package cn.ivase.Bean;

/**
 * 文章的所有数据库
 *@Title Contents.java
 *@description TODO
 *@time 2018年12月24日 下午12:24:09
 *@author FateVase
 *@version 1.0
 *
 *
*
 */
public class Contents {
	int cid;
	String title;
	int created;
	int modified;
	String text;
	int authorId;
	String classify;
	String status;
	String password;
	int commentsNum;
	
	
	@Override
	public String toString() {
		return "Contents [cid=" + cid + ", title=" + title + ", created=" + created + ", modified=" + modified
				+ ", text=" + text + ", authorId=" + authorId + ", classify=" + classify + ", status=" + status
				+ ", password=" + password + ", commentsNum=" + commentsNum + "]";
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCreated() {
		return created;
	}
	public void setCreated(int created) {
		this.created = created;
	}
	public int getModified() {
		return modified;
	}
	public void setModified(int modified) {
		this.modified = modified;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCommentsNum() {
		return commentsNum;
	}
	public void setCommentsNum(int commentsNum) {
		this.commentsNum = commentsNum;
	}
	
}
