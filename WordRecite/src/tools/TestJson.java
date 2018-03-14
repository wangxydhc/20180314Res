package tools;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

/**
 * @author wangxydhc
 *这个类用来检查两个文档的精确一致性
 */
public class TestJson {
	public static void  writeBefore() {
		int count=0;
		BufferedReader bre = null;
		BufferedReader bre2 = null;
		String in_1= "c:/workspaces/MyEclipse 2015/WordRecite/WebRoot/j.json";	
		String in_2 = "c:/workspaces/MyEclipse 2015/WordRecite/WebRoot/g.json";		
		String s1="",s2="";
		try {
			bre = new BufferedReader(new FileReader(in_1));// 此时获取到的bre就是整个文件的缓存流
			bre2 = new BufferedReader(new FileReader(in_2));// 此时获取到的bre就是整个文件的缓存流
			char []ct1=new char[1];
			char []ct2=new char[1];
			while (bre.ready()&&bre2.ready()){
				bre.read(ct1);
				bre2.read(ct2);
				if (ct1[0]!=ct2[0]){
					count++;
					System.out.println("cout="+count);
					System.out.println("出现了不相等");
					System.out.println("/-------------------------");
					System.out.println("ct1:"+ct1[0]+ "#####"+"ct2:"+ct2[0]+"##");
					System.out.println((int)(ct1[0]));
					System.out.println((int)(ct2[0]));
					System.out.println("IN_1: "+s1);
					System.out.println("IN_2: "+s2);
					s1+=ct1[0];
					s2+=ct2[0];
					System.in.read();
					System.out.println("-------------------------/");
				}
				else
				{
					System.out.println("/**************");
					s1+=ct1[0];
					s2+=ct2[0];
					System.out.println("**************/");
				}
			}
			bre.close();
			bre2.close();
		}// 关闭流	
		catch (Exception e) {
		}
		System.out.println("over");
		System.out.println("IN_1: "+s1);
		System.out.println("IN_2: "+s2);
	}
	public static void main(String[] args) {
		writeBefore();
	}
}
