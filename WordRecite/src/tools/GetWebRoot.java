package tools;

import java.io.File;

public class GetWebRoot {
	public String get(String filename) {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		if (classLoader == null) {
			classLoader = ClassLoader.getSystemClassLoader();
		}
		java.net.URL url2 = classLoader.getResource("");
		String ROOT_CLASS_PATH = url2.getPath() + "\\";
		System.out.println(ROOT_CLASS_PATH);
		File rootFile = new File(ROOT_CLASS_PATH);
		String WEB_INFO_DIRECTORY_PATH = rootFile.getParent() + "\\";
		System.out.println(WEB_INFO_DIRECTORY_PATH);
		File webInfoDir = new File(WEB_INFO_DIRECTORY_PATH);
		String SERVLET_CONTEXT_PATH = webInfoDir.getParent() + "\\";
		
		String path = SERVLET_CONTEXT_PATH +  filename;
		path = path.replaceAll("%20", " ");
		System.out.println(path);
		return path;
	}
	public static void main(String[] args) {
		new GetWebRoot().get("g.json");
	}
}
