package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/*
dd/*fff
*/

import model.JsonModel;/*  */
import model.ReciteLog;
import model.Word;

import org.hibernate.Session;
import org.hibernate.Transaction;

import serviceImp.ManagerImp;
import tools.ConvertTool;
import tools.Factory;

import com.opensymphony.xwork2.ActionSupport;

import daoImp.WordDaoImp;


public class DisLog extends ActionSupport{
	private int wordId;

	public int getWordId() {
		return wordId;
	}
	public void setWordId(int wordId) {
		this.wordId = wordId;		
	}
	public String open(){
		new ManagerImp().generateJson(wordId);
		return "SUCCESS";
	}
	public static void main(String[] args) {
		DisLog sl=new DisLog();
		sl.setWordId(1300);
		sl.open();
	}
	
}
