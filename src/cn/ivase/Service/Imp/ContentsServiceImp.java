package cn.ivase.Service.Imp;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import cn.ivase.Dao.CommentsDao;
import cn.ivase.Dao.ContentsDao;
import cn.ivase.Model.timeSwitch;
import cn.ivase.Service.ContentsService;

public class ContentsServiceImp implements ContentsService {
	ContentsDao contentsDao;
	CommentsDao commentsDao;
	
	public CommentsDao getCommentsDao() {
		return commentsDao;
	}

	public void setCommentsDao(CommentsDao commentsDao) {
		this.commentsDao = commentsDao;
	}

	TransactionTemplate transactionTemplate;

	public ContentsDao getContentsDao() {
		return contentsDao;
	}

	public void setContentsDao(ContentsDao contentsDao) {
		this.contentsDao = contentsDao;
	}

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public List<Map<String, Object>> GetAllContents() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> contents = contentsDao.GetAllContents();
		for(Map<String, Object> single : contents) {
			single.put("modified", timeSwitch.UnixToDate((Integer)single.get("modified")));
		    single.put("created", timeSwitch.UnixToDate((Integer)single.get("created")));
		}
		return contents;
	}

	@Override
	public int ChangeContents(Map<String, Object> changeParameter, String judgeKey) {
		// TODO Auto-generated method stub
		return contentsDao.ChangeContents(changeParameter, judgeKey);
	}

	@Override
	public int AddContents(Map<String, Object> addParameter) {
		// TODO Auto-generated method stub
		addParameter.put("created", timeSwitch.getAccurateUnixTime());
		return contentsDao.AddContents(addParameter);
	}

	@Override
	public List<Map<String, Object>> GetContentsByArgs(String sreachKey, Object sreachValue, boolean fuzzy) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> contents = contentsDao.GetContentsByArgs(sreachKey,sreachValue,fuzzy) ;
		for(Map<String, Object> single : contents) {
			single.put("modified", timeSwitch.UnixToDate((Integer)single.get("modified")));
		    single.put("created", timeSwitch.UnixToDate((Integer)single.get("created")));
		}
		return contents;
	}


	@Override
	public int DeleteContentsByArgs(final String sreachKey, final Object sreachValue) {
		// TODO Auto-generated method stub
		int result = transactionTemplate.execute(new TransactionCallback<Integer>() {
			@Override
			public Integer doInTransaction(TransactionStatus arg0) {
				// TODO Auto-generated method stub
				int result = commentsDao.DeleteCommentsByArgs(sreachKey,sreachValue);
				result = contentsDao.DeleteContentsByArgs(sreachKey, sreachValue);
				return result;
			}
		});
		return result;
	}

	@Override
	public Map<String, Object> GetContentsByArgs(String target, Map<String, Object> judges) {
		// TODO Auto-generated method stub
		Map<String, Object> contents = contentsDao.GetContentsByArgs(target,judges) ;
		if(contents.get("modified")!=null) {
			contents.put("modified", timeSwitch.UnixToDate((Integer)contents.get("modified")));
		}
		if(contents.get("created")!=null) {
			contents.put("created", timeSwitch.UnixToDate((Integer)contents.get("created")));
		}
		return contents;
	}

	@Override
	public List<Map<String, Object>> ShowSomeContents() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> contents = contentsDao.GetContentsByArgs("cid","",true) ;
		for(Map<String, Object> single : contents) {
			single.put("modified", timeSwitch.UnixToDate((Integer)single.get("modified")));
		    single.put("created", timeSwitch.UnixToDate((Integer)single.get("created")));
		    single.remove("text");
		}
		return contents;
	}


	
}
