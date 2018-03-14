package action;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ReciteLevel;
import model.Word;

import org.apache.catalina.connector.Request;
import org.apache.commons.collections.map.LinkedMap;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import serviceImp.ManagerImp;
import tools.Factory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import daoImp.WordDaoImp;


public class ShowWords extends ActionSupport{	

	private int nums;
	private List<Word>res=new ArrayList<Word>();
	public List<Word> getRes() {
		return res;
	}
	public void setRes(List<Word> res) {
		this.res = res;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public String start() {		
		ManagerImp manager=new ManagerImp();
		res=manager.getWordArrays(nums);	
		Map mapForLevel=ReciteLevel.toMap();
//		System.out.println("*****************************");
//		ActionContext ac=ActionContext.getContext();	
//		Map<String ,Object> session=ac.getSession();
		HttpServletRequest request=ServletActionContext.getRequest();
//		HttpServletResponse response = ServletActionContext.getResponse();  
//		HttpServletRequest request2=(HttpServletRequest)ac.get(ServletActionContext.HTTP_REQUEST);
//		HttpServletResponse response2=(HttpServletResponse)ac.get(ServletActionContext.HTTP_RESPONSE);		
//		request.setAttribute("fromRequestFromServlet", "fromRequestFromServlet");
//		request2.setAttribute("fromRequestFromContext", "fromRequestFromContext");			
//		session.put("abc", "abc");		
//		List list=new LinkedList<String>();
//		list.add("dd");
//		list.add("df");
//		session.put("mapFL", list);
		request.setAttribute("map2", mapForLevel);
//		System.out.println(mapForLevel);		
		return "SUCCESS";
	}

	public static void main(String[] args) {
		ShowWords sw = new ShowWords();
		sw.setNums(900);
		sw.start();
	}
}
