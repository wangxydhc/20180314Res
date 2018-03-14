package tools;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

public class WriteJson {
	public static String formatString(String s) {
	    if (s != null) {
	          s = s.replaceAll("\ufeff", "");
	    }
	    return s;
	}
	public static void  writeBefore(String in,String out) {
		in=new GetWebRoot().get(in);
		out=new GetWebRoot().get(out);
		BufferedReader bre = null;
		OutputStreamWriter pw = null;// 定义一个流
		String line;
		String begin = "{\"JSChart\":{\"datasets\":[{\"type\":\"line\",\"data\":";
		String end = "}]}}";
		try {
			bre = new BufferedReader(new FileReader(in));// 此时获取到的bre就是整个文件的缓存流
			pw = new OutputStreamWriter(new FileOutputStream(out),
					"utf8");// 确认流的输出文件和编码格式，此过程创建了“test.txt”实例
			pw.write(begin.trim());
			while ((line = bre.readLine()) != null)
			{
				line=formatString(line);
				pw.write(line);}
			pw.write(end.trim());
			bre.close();
			pw.close();
		}// 关闭流
		catch (Exception e) {
		}
		;
	}

}
