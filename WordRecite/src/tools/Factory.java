package tools;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
public  class Factory {
private  static SessionFactory sf=null;	
	public static void beforeclass(){
		sf=new AnnotationConfiguration().configure().buildSessionFactory();
	}
	public static SessionFactory getSessionFactory(){
		beforeclass();
		return sf;
	}
}
