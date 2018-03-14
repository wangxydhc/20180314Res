package action;

import java.util.Date;

import model.ReciteLog;
import model.Word;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import serviceImp.ManagerImp;
import tools.Factory;

import com.opensymphony.xwork2.ActionSupport;

import daoImp.WordDaoImp;


public class AddWordAndLog extends ActionSupport{
	private String word;
	private int level;
	private int method;
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getMethod() {
		return method;
	}
	public void setMethod(int method) {
		this.method = method;
	}
	public String excute(){	
		ManagerImp manager=new ManagerImp();		
		ReciteLog rl=new ReciteLog();
		rl.setMethod(this.getMethod());
		rl.setStatus(this.getLevel());
		rl.setUsername("wangxy");
		manager.saveReciteLog(rl, word);		
		return "SUCCESS";
	}
	public static void main(String[] args) {
		AddWordAndLog d=new AddWordAndLog();
		d.word="newWordTsetss";
		d.excute();		
	}
	
}
