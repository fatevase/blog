package cn.ivase.Service.Imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.ivase.Dao.CommentsDao;
import cn.ivase.Dao.ContentsDao;
import cn.ivase.Model.timeSwitch;
import cn.ivase.Service.BackEndService;

public class BackEndServiceImp implements BackEndService {
	ContentsDao contentsDao;
	CommentsDao commentsDao;
	public ContentsDao getContentsDao() {
		return contentsDao;
	}
	public void setContentsDao(ContentsDao contentsDao) {
		this.contentsDao = contentsDao;
	}
	public CommentsDao getCommentsDao() {
		return commentsDao;
	}
	public void setCommentsDao(CommentsDao commentsDao) {
		this.commentsDao = commentsDao;
	}
	@Override
	public Map<String, Object> ShowBackendIndex() {
		Map<String, Object> result = new HashMap<String,Object>();	
		result.put("TotalContents", contentsDao.GetTotalContents());
		result.put("TotalComments", commentsDao.GetTotalComments());
		return result;
	}
	@Override
	public List<Map<String, Object>> ShowEssayIndex() {
		List<Map<String,Object>> get_essay = contentsDao.GetAllContents();
		List<Map<String,Object>> out_essay =new ArrayList<Map<String,Object>>();
		for(int i=0;i<get_essay.size();i++) {
			Map<String,Object> get_single = get_essay.get(i);
			Map<String,Object> out_single = new HashMap<String,Object>();
			out_single.put("created", timeSwitch.UnixToDate((Integer)get_single.get("created")));
			out_single.put("title",get_single.get("title"));
			out_essay.add(out_single);
		}
		return out_essay;
	}
	@Override
	public List<Map<String, Object>> ShowCommentsIndex() {
		List<Map<String,Object>> get_comments = commentsDao.GetAllComments();
		List<Map<String,Object>> out_comments =new ArrayList<Map<String,Object>>();
		for(int i=0;i<get_comments.size();i++) {
			Map<String,Object> get_single = get_comments.get(i);
			Map<String,Object> out_single = new HashMap<String,Object>();
			out_single.put("created", timeSwitch.UnixToDate((Integer)get_single.get("created")));
			out_single.put("text",get_single.get("text"));
			out_comments.add(out_single);
		}
		return out_comments;
	}
	

}
