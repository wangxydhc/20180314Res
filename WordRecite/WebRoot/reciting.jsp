<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>


<body>
	<script src="sources/xml.js"></script>
	<script>
		function myFunction() {
		}
		function commit(int, handle) {
			for (i = 0; i < handle.length; i++)
				if (handle[i].name == "radioName" && handle[i].checked == true)
					v = handle[i].value;
			url = "ConfirmWord?" + "wordId=" + int + "&handle=" + v + "&timep="
					+ Math.random();
			loadXMLDoc(url, myFunction);
			button.type = "hidden"
		}

		function showLog_at() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById('youdao').src = 'show.jsp';
			}
		}
		function showLog(id) {
			url = "DisLog?wordId="+id;
			loadXMLDoc(url, showLog_at);
		}

		function showIFrame(s) {
			document.getElementById('youdao').src = 'http://www.youdao.com/w/eng/'
					+ s;
		}
	</script>



	<iframe id="youdao" align=right width=800 frameborder=0 height=1200
		marginheight=300 scrolling=auto
		src="http://dict.youdao.com/?keyfrom=dict2.top"></iframe>
	<br />
	<h1>开始背单词吧</h1>
	<br />
	<br />
	<br />
	<br />
	<!--<form>
		<s:property value="#request.fromRequestFromServlet" />
		<br />
		<s:property value="#session.mapFL" />
		<br> <input type="text"
			value=${requestScope.fromRequestFromServlet}></input>

	</form>
	<br />
	<s:property value="#session.abc" />
	<br />
			-->
	<s:iterator value="res" id="list_0">
		<form name="formname" id='#list_0.getId()'>
			<input type="hidden" name="wordId"
				value="<s:property value='#list_0.getId()'/>" /> 单词：
			<s:property value="#list_0.getWord()" />

			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
				value="查字典"
				onClick="showIFrame('<s:property value="#list_0.getWord()" />')" />

			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<button type=button onClick="showLog('<s:property value="#list_0.getId()" />')">showLog</button>

			<br /> <br /> 释义：
			<s:property value="#list_0.getParaphrase()" />
			<br /> <br />

			<s:radio name="radioName" id='#list_0.getId()' list="#request.map2"	value="" />
			<input type="button" value="提交" id="inputHH"
				onClick="commit('<s:property value="#list_0.getId()" />',this.parentNode.childNodes)" />
			<br />

		</form>
		<br />
	</s:iterator>



	<!--<s:property value="res.{word}"/>   -->
	<s:debug></s:debug>
</body>
</html>
