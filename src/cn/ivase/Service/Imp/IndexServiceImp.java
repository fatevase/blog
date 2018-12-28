package cn.ivase.Service.Imp;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import cn.ivase.Dao.ContentsDao;
import cn.ivase.Dao.IndexDao;
import cn.ivase.Model.timeSwitch;
import cn.ivase.Service.IndexService;

public class IndexServiceImp implements IndexService {
	IndexDao indexDao;
	ContentsDao contentsDao;
	TransactionTemplate transactionTemplate;
	public IndexDao getIndexDao() {
		
		return indexDao;
	}

	public void setIndexDao(IndexDao indexDao) {
		
		this.indexDao = indexDao;
	}

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	

	public ContentsDao getContentsDao() {
		return contentsDao;
	}

	public void setContentsDao(ContentsDao contentsDao) {
		this.contentsDao = contentsDao;
	}

	@Override
	public List<Map<String, Object>> ShowIndex() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> page = contentsDao.GetAllContents();
		for(Map<String, Object> single : page) {
		    single.remove("modified");
		    single.remove("authorId");
		    single.put("created", timeSwitch.UnixToDate((Integer)single.get("created")));
		}
		return page;
	}

	@Override
	public List<Map<String, Object>> ShowPage(String args, Object values, boolean fuzzy) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> page = contentsDao.GetContentsByArgs(args, values, fuzzy);
		for(Map<String, Object> single : page) {
		    single.remove("modified");
		    single.put("created", timeSwitch.UnixToDate((Integer)single.get("created")));
		}
		return page;
	}

	@Override
	public List<Map<String, Object>> ShowComments(String args, Object values, boolean fuzzy) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> comments = indexDao.ShowComments(args, values, fuzzy);
		for(Map<String, Object> single : comments) {
			single.put("created", timeSwitch.UnixToDate((Integer)single.get("created")));
		}
		return comments;
	}

	@Override
	public int InsertComments(final Map<String, Object> values) {
		// TODO Auto-generated method stub
		values.put("created", timeSwitch.getAccurateUnixTime());
		Object result = transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus arg0) {
				// TODO Auto-generated method stub
				int result = indexDao.InsertComments(values);
				result = indexDao.UpdateContent(values);
				return result;
			}
			
		});
		return (Integer)result;
	}
	
	public int ShowContentTotal(Map<String,Object> factor) {
		return contentsDao.GetTotalContents(factor);
	}

}
