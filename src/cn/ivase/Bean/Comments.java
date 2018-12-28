package cn.ivase.Bean;
/**
 * 评论的所有数据库
 *@Title Comments.java
 *@description TODO
 *@time 2018年12月24日 下午12:24:40
 *@author FateVase
 *@version 1.0
 *
 *
*
 */
public class Comments {
	int coid;
	int cid;
	int created;
	int owenrId;
	String ip;
	String text;
	String type;
	String status;
	int parent;
	
	@Override
	public String toString() {
		return "Comments [coid=" + coid + ", cid=" + cid + ", created=" + created + ", owenrId=" + owenrId + ", ip="
				+ ip + ", text=" + text + ", type=" + type + ", status=" + status + ", parent=" + parent + "]";
	}
	public int getCoid() {
		return coid;
	}
	public void setCoid(int coid) {
		this.coid = coid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCreated() {
		return created;
	}
	public void setCreated(int created) {
		this.created = created;
	}
	public int getOwenrId() {
		return owenrId;
	}
	public void setOwenrId(int owenrId) {
		this.owenrId = owenrId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
}
