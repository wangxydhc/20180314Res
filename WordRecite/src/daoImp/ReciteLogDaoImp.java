package daoImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.ReciteLogDao;
import tools.Factory;
import model.ReciteLog;
import model.Word;

public class ReciteLogDaoImp {
	private Session session;
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
	public List<ReciteLog> getLogs(int id) {		
		Word word=(Word)session.get(Word.class, id);
		return word.getLog();
	}
	

	public  void saveLog(ReciteLog rl){
		session.save(rl);
	}
	
	


	

}
