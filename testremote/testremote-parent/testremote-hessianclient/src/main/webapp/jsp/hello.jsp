<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%  
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href="<%=basePath%>"> 
<meta name="Keywords" content="" />
<meta name="description" content="" />
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/demo.css">
<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
<script type="text/javascript" src="jslib/jquery.min.js"></script>
<script type="text/javascript" src="jslib/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#user_DataGrid').datagrid({
    		url: encodeURI(getRootPath() + "/getUsers.do"),
    		queryParams:{userName:$("#userName").val()},
    		method:"post",
    		width: "auto",
    		height:"auto",
			fitColumns: true,
			fit:true,
			loadMsg:"请稍后,正在加载中......",
			pagination:true,
			singleSelect:true,
			pageSize:20,
			title:'用户列表',
	    	columns:[[  
				{field:'userId',title:'用户ID',width:120},
				{field:'username',title:'用户姓名',align:'right',width:120},
				{field:'age',title:'年龄',align:'right',width:120}					
	    	]]
   		});
		
		$("#searchBtn").click(function(){
			$('#user_DataGrid').datagrid("reload",{userName:$("#userName").val()}); 
		});
	});
	function getRootPath(){
		var curWwwPath = window.document.location.href;
	    //获取主机地址之后的目录，如： /ems/Pages/Basic/Person.jsp
	    var pathName = window.document.location.pathname;
	    var pos = curWwwPath.indexOf(pathName);
	    //获取主机地址，如： http://localhost:8080
	    var localhostPath = curWwwPath.substring(0, pos);
	    //获取带"/"的项目名，如：/ems
	    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	    return(localhostPath + projectName);
	}
</script>
</head>
<body>
	${message}
	<input type="text" name="userName" id="userName"/>
	<input type="button" id="searchBtn" value="搜索"/>
	<table id="user_DataGrid" ></table>
</body>
</html>