package action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.ReciteLog;
import model.Word;
import serviceImp.ManagerImp;
import tools.Factory;
import tools.GetWebRoot;

import com.opensymphony.xwork2.ActionSupport;

public class GetWeb extends ActionSupport {

	public String get(){	
		System.out.println("f"+new GetWebRoot().get("j.json"));
		return "SUCCESS";
	}

	public static void main(String[] args) {
		GetWeb gw=new GetWeb();
		gw.get();
	}
}

