package tools;

import org.hibernate.dialect.MySQL5InnoDBDialect;


public class MySQLDialectUTF8 extends MySQL5InnoDBDialect {
	 @Override  
     public String getTableTypeString() {  
         return "DEFAULT CHARSET=utf8";    
     }  
}
