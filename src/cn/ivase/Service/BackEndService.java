package cn.ivase.Service;

import java.util.List;
import java.util.Map;
/**
 * *记录一下 数据库操作层只用来获取数据库数据
 * action层用于与前端数据进行交互的 禁止直接获取数据库内容 并且 尽量减少对数据的修改 
 * *只用于接收服务层 和前端发来的数据 和发送数据到前端
 * *服务层用于处理从数据库取到的值和加工将要放入数据库的值
 * *
 * *对于像后端这样需要从个数据库取数据的操作不要单独写出一个类来进行操作
 * *直接调用之前写的方法 或者将方法写在对应的数据库操作层
 * 
 * *当写到后端才意识到之前前端数据回显的一系列问题 记录一下 
 *@Title BackEndService.java
 *@description TODO
 *@time 2018年12月24日 下午12:25:12
 *@author FateVase
 *@version 1.0
 *
 */
public interface BackEndService {
	public Map<String,Object> ShowBackendIndex();
	public List<Map<String, Object>> ShowEssayIndex();
	public List<Map<String, Object>> ShowCommentsIndex();
}
