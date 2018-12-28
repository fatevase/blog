package cn.ivase.Service.Imp;

import cn.ivase.Dao.CommentsDao;
import cn.ivase.Service.CommentsService;

public class CommentsServiceImp implements CommentsService {
	CommentsDao commentsDao;

	public CommentsDao getCommentsDao() {
		return commentsDao;
	}

	public void setCommentsDao(CommentsDao commentsDao) {
		this.commentsDao = commentsDao;
	}


	
}
