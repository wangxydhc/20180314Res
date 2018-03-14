package daoImp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import model.ReciteLog;
import model.Word;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.WordDao;
import tools.Factory;

public class WordDaoImp  {
	private Session session;
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}

	public  boolean saveWord(Word w) {
		session.save(w);
		return true;
	}
	
	

	

	public  Word getWord(int id) {
	
		Word w = (Word) this.session.get(Word.class, id);

		return w;
	}

	public Word getWord(String content) {
	
		Query q=this.session.createQuery("from Word t where t.word = '"+content+"'");		
		Word w=new Word();
		w=((List<Word>)q.list()).get(0);
		if (q.list().size()==0)
			return null;
		else
			return w;
		
	}
	public static void main(String[] args) {
		Word w=new WordDaoImp().getWord("mygirl");
		System.out.println(w.getId());
	}

	public boolean exist(String content){
		Query q =session.createQuery("from Word t where t.word = '"+content+"'");	
			if (q.list().size()==0){
				return false;
			}
			else
				return true;
	}
	
	public boolean exist(int id){
		Query q =session.createQuery("from Word t where t.id = "+id);	
			if (q.list().size()==0){
				return false;
			}
			else
				return true;
	}	


	public Word getByContent(String content) {
		if(!this.exist(content))
			return null;		
		Query q =session.createQuery("from Word t where t.word = '"+content+"'");
		List<Word> resList=(List<Word>)q.list();	
		Word w=resList.get(0);		
		return w;
	}


}
