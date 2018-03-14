package tools;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.hibernate.Session;

import model.Word;

public class GetBook {
	public static void run(String s,Session session) throws Throwable {
		BufferedReader br;
//		FileInputStream fileInStr = new FileInputStream(s);
//		InputStreamReader InSR = new InputStreamReader(fileInStr);
//		br = new BufferedReader(InSR);
			
			URL realUrl = new URL(s);			
			URLConnection connection = realUrl.openConnection();			
			connection.connect();
			br = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "UTF-8"));		
		String[] before = new String[2];
		before[0] = "";
		before[1] = "";
		while (br.ready()) {
			// before鏄瘡娆¤鍙栦笂涓�鍚庝繚瀛樼殑璇嶏紝鍥犱负鏈‘瀹氬悗闈㈡槸鍚﹁繕鏈夊悗缁紝鏆傛椂涓嶅瓨鍌�
			String line = br.readLine();
			before = handleLine(line, before,session);
		}
		//鏈�悗瑕佹妸before閲岀殑杈撳嚭鏉�
		session.save(new Word(before[0],before[1]));
		br.close();
	}

	public static String[] handleLine(String line, String[] before,Session session ) {
		String[] res = new String[2];
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '.' && line.charAt(i) != '/') {
				while (i>=0&&line.charAt(i) != ' ')
					i--;
				if (i<0)
					break;
				res[0] = line.substring(0, i);
				res[1] = line.substring(i, line.length());
				handle(res, before,session);
				return before;
			} else if (line.charAt(i) != ' ' && !isLetter(line.charAt(i))
					&& line.charAt(i) != '/') {
				res[0] = line.substring(0, i);
				res[1] = line.substring(i, line.length());
				handle(res, before,session);
				return before;
			}
		}
		//濡傛灉涓嶇鍚堟媶鍒嗘潯浠讹紝鐩存帴璧嬪�鍒皉es
		res[0] = "";
		res[1] = line;
		handle(res, before,session);
		return before;
	}

	public static void handle(String[] res, String[] before,Session session) {
		res[0] = res[0].trim();
		res[1] = res[1].trim();
		if (res[0].length() <= 0 || res[1].length() <= 0)
			if (res[1].length() <= 2 || res[0].length() <= 2) //涓哄崟涓瓧姣嶇殑鎯呭喌锛岃垗寮�			
				;
			 else {//灏嗘湰琛屾坊鍔犲埌涓婁竴涓崟璇嶇殑瑙ｉ噴鍚庨潰
				before[1] = before[1] + " " + res[1];
			}

		else {//濡傛灉鏈鏄彟涓�釜鍗曡瘝锛岃緭鍑轰笂涓�缂撳瓨鐨勫崟璇�
			System.out.println(before[0]+" "+before[1]);
			if (before[0] != "" && before[1] != "") {				
				session.save(new Word(before[0],before[1]));
			}
			//鏇存柊before
			before[0] = res[0];
			before[1] = res[1];
		}
	}



	public static boolean isLetter(Character c) {
		if (c >= 'a' && c <= 'z')
			return true;
		if (c >= 'A' && c <= 'Z')
			return true;
		return false;
	}
}
