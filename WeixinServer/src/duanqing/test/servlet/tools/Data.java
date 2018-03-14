package duanqing.test.servlet.tools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import duanqing.test.model.Msg;

public class Data {
	Configuration cfg = new Configuration().configure();
	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
	SessionFactory factory = cfg.buildSessionFactory(serviceRegistry); 
	
	public void save(Msg msg){
		
		Session s = factory.openSession();
		s.beginTransaction();
		s.save(msg);
		s.getTransaction().commit();		
		s.close();
	} 
	public String getCon(int id ){
		Session s=factory.openSession();
		s.beginTransaction();
		Msg msg=(Msg)s.load(Msg.class, id);
		return msg.getContent();
	}
}
