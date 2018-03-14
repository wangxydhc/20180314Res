package wangxy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


import org.junit.Test;

import tools.GetBook;

public  class TestClass {
	private static SessionFactory sf=null;
	
	public static void beforeclass(){
		sf=new AnnotationConfiguration().configure().buildSessionFactory();
	}
	public static Session getSession(){
		return sf.openSession();
	}
	
	
	public static void testSchemaExport() throws Throwable
	{
		new SchemaExport(new AnnotationConfiguration().configure()).create(true, true);
		beforeclass();
		Session s =getSession();
		Transaction tx=s.beginTransaction();
		GetBook.run("http://123.207.162.129:8080/WordRecite/wordBook.txt",s);
		tx.commit();
		s.close();
	}
	public static void main(String[] args) {
		try {
			TestClass.testSchemaExport();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
