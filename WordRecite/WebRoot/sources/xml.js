var xmlhttp;
		function loadXMLDoc(url, cfunc) {
			if (window.XMLHttpRequest) {// IE7+, Firefox, Chrome, Opera, Safari ДњТы
				xmlhttp = new XMLHttpRequest();
			} else {// IE6, IE5 ДњТы
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = cfunc;
			xmlhttp.open("GET", url, true);
			xmlhttp.send();
		}