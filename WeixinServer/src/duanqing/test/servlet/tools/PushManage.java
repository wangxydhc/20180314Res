package duanqing.test.servlet.tools;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import duanqing.test.model.Msg;

public class PushManage {


	public String PushManageXml(InputStream is) throws JDOMException {

		String returnStr = "";
		String toName = "";
		String fromName = "";
		String type = "";
		String con = "";
		String event = "";
		String eKey = "";

		try {

			SAXBuilder sax = new SAXBuilder();
			Document doc = sax.build(is);
			Element root = doc.getRootElement();

			List list = root.getChildren();
			for (int j = 0; j < list.size(); j++) {

				Element first = (Element) list.get(j);

				if (first.getName().equals("ToUserName")) {
					toName = first.getValue().trim();
//					System.out.println(toName);

				} else if (first.getName().equals("FromUserName")) {
					fromName = first.getValue().trim();
//					System.out.println(fromName);

				} else if (first.getName().equals("MsgType")) {
					type = first.getValue().trim();
				} else if (first.getName().equals("Content")) {
					con = first.getValue().trim();
//					System.out.println(con);

				} else if (first.getName().equals("Event")) {
					event = first.getValue().trim();
				} else if (first.getName().equals("EventKey")) {
					eKey = first.getValue().trim();
				}
			}
		} catch (IOException e) {
		}

		if (type.equals("event")) {
			if (event.equals("subscribe")) {

			} else if (event.equals("unsubscribe")) {

			} else if (event.equals("CLICK")) {
				if (eKey.equals("V1")) {
					returnStr = getBackXMLTypeText(toName, fromName, "����˲˵�1");
				} else if (eKey.equals("V2")) {
					returnStr = getBackXMLTypeText(toName, fromName, "����˲˵�2");
				}
			}
		} else if (type.equals("text")) {
			returnStr = getBackXMLTypeText(toName, fromName, "message:" + con);
		}
		Msg msg=new Msg();
		msg.setContent(con);
//		System.out.println(msg.getContent()+"&&&&");
		Data handler=new Data();
		handler.save(msg);
//		System.out.println(handler.getCon(1));
//		System.out.println(returnStr);
		return returnStr;		
	}

	/**
	 * �����ı���Ϣ
	 * 
	 * @author xiaowu
	 * @since 2013-9-27
	 * @param toName
	 * @param FromName
	 * @param content
	 * @return
	 */
	private String getBackXMLTypeText(String toName, String fromName,
			String content) {

		String returnStr = "";

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String times = format.format(new Date());

		Element rootXML = new Element("xml");

		rootXML.addContent(new Element("ToUserName").setText(fromName));
		rootXML.addContent(new Element("FromUserName").setText(toName));
		rootXML.addContent(new Element("CreateTime").setText(times));
		rootXML.addContent(new Element("MsgType").setText("text"));
		rootXML.addContent(new Element("Content").setText(content));

		Document doc = new Document(rootXML);

		XMLOutputter XMLOut = new XMLOutputter();
		returnStr = XMLOut.outputString(doc);

		return returnStr;
	}

	/**
	 * ����ͼƬ��Ϣ(��ͼģʽ)
	 * 
	 * @author xiaowu
	 * @since 2013-9-27
	 * @param toName
	 * @param FromName
	 * @param content
	 * @return
	 */
	private String getBackXMLTypeImg(String toName, String fromName,
			String title, String content, String url, String pUrl) {

		String returnStr = "";

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String times = format.format(new Date());

		Element rootXML = new Element("xml");

		rootXML.addContent(new Element("ToUserName").setText(fromName));
		rootXML.addContent(new Element("FromUserName").setText(toName));
		rootXML.addContent(new Element("CreateTime").setText(times));
		rootXML.addContent(new Element("MsgType").setText("news"));
		rootXML.addContent(new Element("ArticleCount").setText("1"));

		Element fXML = new Element("Articles");
		Element mXML = null;

		mXML = new Element("item");
		mXML.addContent(new Element("Title").setText(title));
		mXML.addContent(new Element("Description").setText(content));
		mXML.addContent(new Element("PicUrl").setText(pUrl));
		mXML.addContent(new Element("Url").setText(url));
		fXML.addContent(mXML);
		rootXML.addContent(fXML);

		Document doc = new Document(rootXML);

		XMLOutputter XMLOut = new XMLOutputter();
		returnStr = XMLOut.outputString(doc);

		return returnStr;
	}

	/**
	 * ����ͼƬ��Ϣ(��ͼģʽ)
	 * 
	 * @author xiaowu
	 * @since 2013-9-27
	 * @param toName
	 * @param FromName
	 * @param content
	 * @return
	 */
	private String getBackXMLTypeImg(String toName, String fromName,
			String title, String content, String url) {

		String returnStr = "";

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String times = format.format(new Date());

		Element rootXML = new Element("xml");

		rootXML.addContent(new Element("ToUserName").setText(fromName));
		rootXML.addContent(new Element("FromUserName").setText(toName));
		rootXML.addContent(new Element("CreateTime").setText(times));
		rootXML.addContent(new Element("MsgType").setText("news"));
		rootXML.addContent(new Element("ArticleCount").setText("1"));

		Element fXML = new Element("Articles");
		Element mXML = null;

		// String url = "";
		String ss = "";
		mXML = new Element("item");
		mXML.addContent(new Element("Title").setText(title));
		mXML.addContent(new Element("Description").setText(content));
		mXML.addContent(new Element("PicUrl").setText(ss));
		mXML.addContent(new Element("Url").setText(url));
		fXML.addContent(mXML);
		rootXML.addContent(fXML);

		Document doc = new Document(rootXML);

		XMLOutputter XMLOut = new XMLOutputter();
		returnStr = XMLOut.outputString(doc);

		return returnStr;
	}

	/**
	 * ����������Ϣ
	 * 
	 * @author xiaowu
	 * @since 2013-9-27
	 * @param toName
	 * @param FromName
	 * @param content
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getBackXMLTypeMusic(String toName, String fromName,
			String content) {

		String returnStr = "";

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String times = format.format(new Date());

		Element rootXML = new Element("xml");

		rootXML.addContent(new Element("ToUserName").setText(fromName));
		rootXML.addContent(new Element("FromUserName").setText(toName));
		rootXML.addContent(new Element("CreateTime").setText(times));
		rootXML.addContent(new Element("MsgType").setText("music"));

		Element mXML = new Element("Music");

		mXML.addContent(new Element("Title").setText("����"));
		mXML.addContent(new Element("Description").setText("�������������泩��"));
		mXML.addContent(new Element("MusicUrl").setText(content));
		mXML.addContent(new Element("HQMusicUrl").setText(content));

		rootXML.addContent(mXML);

		Document doc = new Document(rootXML);

		XMLOutputter XMLOut = new XMLOutputter();
		returnStr = XMLOut.outputString(doc);

		return returnStr;
	}
}
