package duanqing.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.JDOMException;

import duanqing.test.servlet.tools.PushManage;
import duanqing.test.servlet.tools.SHA1;

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
	@Override
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
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html,charset=utf-8");
		response.setCharacterEncoding("UTF-8");
//		System.out.println(java.nio.charset.Charset.defaultCharset());
		PrintWriter out = response.getWriter();
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		String reSignature = null;
		String s="what happened";
		PushManage ps=new PushManage();
		try {
			s=ps.PushManageXml(request.getInputStream());
		} catch (JDOMException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			String[] str = { TOKEN, timestamp, nonce };
			Arrays.sort(str);
			String bigStr = str[0] + str[1] + str[2];
			reSignature = new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
/*			out.print(reSignature);
			out.print(s);*/

		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}
