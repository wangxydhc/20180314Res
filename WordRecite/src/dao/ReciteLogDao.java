package dao;

import java.util.List;

import org.hibernate.Session;

import model.ReciteLog;
import model.Word;

public interface ReciteLogDao {
	public  boolean saveLog(ReciteLog l,int id);
	boolean saveLog(ReciteLog l, String word);
	List<ReciteLog> getLogs(int id);
	public void setSession(Session session);
	public void saveLog(ReciteLog rl);
}
