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
  function AddWordAndLog(node_m,node_l){
  			var i=0;
  			var j=0;
  			var method1;var level1; 	
 		 	for (i = 0; i < node_m.length; i++)
				if (node_m[i].checked == true)
					method1 = node_m[i].value;
			for (j = 0; j < node_l.length; j++)
				if (node_l[j].checked == true)
					level1 = node_l[j].value;			
			document.getElementById('fff').value=method1;			
			document.getElementById('ggg').value=level1;
  			w=document.getElementById('word_id').value; 	
  			url="AddWordAndLog?word="+w+"&method="+method1+"&level="+level1+"&timep="+Math.random();			
			loadXMLDoc(url, function nothing(){
			});
  }
  </script>
 		 		
 	<form> 
  <p>First name: <input type="text" id = "fff" name="fname" /></p>
  <p>Last name: <input type="text" id ='ggg' name="lname" /></p>
  
</form>
  <form>
		<s:textfield name="word_name" id="word_id" value="" label="单词" />
		<br/>
		<s:radio name="method_name" id="method_id"
		list="#{1:'英to汉',2:'汉to英'}" value="1" />
		<br/>
		<s:radio name="level_name" id='level_id'
		list="#{1:'完全不会',2:'有点儿印象',3:'基本掌握',4:'太简单了'}" value="1" />
		<br/>
		<button type=button onClick="AddWordAndLog(document.getElementsByName('method_name'),document.getElementsByName('level_name'))">确定</button>
	</form>	
	
<s:debug></s:debug>
  </body>
</html>
