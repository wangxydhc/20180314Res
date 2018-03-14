package duanqing.test.servlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.JDOMException;

import duanqing.test.servlet.tools.PushManage;
import duanqing.test.servlet.tools.SHA1;



@SuppressWarnings("serial")
public class CheckSignatureServlet extends HttpServlet {

	private static final String TOKEN = "wangxydhc149278";

	/**
	 * Constructor of the object.
	 */
	public CheckSignatureServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println(request);
		out.print(request);
		File file = new File("d:/text.txt");
		file.createNewFile();
		FileWriter fileWriter = null;
		InputStream is=request.getInputStream();
		PushManage push = new PushManage();
		String getXml = null;
		try {
			getXml = push.PushManageXml(is);
		} catch (JDOMException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
        out.print(getXml);
        System.out.println(getXml);
		try {
			fileWriter = new FileWriter(file, true);
			fileWriter.write(getXml.toCharArray());
		} catch (IOException e) {			
			e.printStackTrace();
		} finally {
			try {
				if (fileWriter != null)
					fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		String reSignature = null;
		try {
			String[] str = { TOKEN, timestamp, nonce };
			Arrays.sort(str);
			String bigStr = str[0] + str[1] + str[2];
			reSignature = new SHA1().getDigestOfString(bigStr.getBytes())
					.toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != reSignature && reSignature.equals(signature)) {
			//请求来自微信
			out.print(echostr);
			out.print("test successlly");
			System.out.println("#################");
			System.out.println(request.getInputStream().toString());
			   System.out.println("getXml"+getXml);
		} else {
			out.print("error request! the request is not from weixin server");
					}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
