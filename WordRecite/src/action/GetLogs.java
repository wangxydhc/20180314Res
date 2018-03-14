package action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.ReciteLog;
import model.Word;
import serviceImp.ManagerImp;
import tools.Factory;

import com.opensymphony.xwork2.ActionSupport;

public class GetLogs extends ActionSupport {
	public void test1(){
		Word word=new ManagerImp().getWord(100);
		Session s=Factory.getSessionFactory().openSession();
		Transaction ts=s.beginTransaction();
		word=(Word)s.load(Word.class, word.getId());
		for(ReciteLog rl:word.getLog()){
			System.out.println(rl.getId());
		}
		ts.commit();
		s.close();
	}
	public void test2(){
		for(ReciteLog rl:new ManagerImp().getLogs(39))
			System.out.println(rl.getId());
		
	}
	public static void main(String[] args) {
		new GetLogs().test2();	
	}
	
}

