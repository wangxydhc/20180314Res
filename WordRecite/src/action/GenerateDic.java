package action;

import wangxy.TestClass;

import com.opensymphony.xwork2.ActionSupport;

public class GenerateDic extends ActionSupport {
	public String generate(){
		try {
			TestClass.testSchemaExport();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "SUCCESS";
	}
}
