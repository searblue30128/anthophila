<!DOCTYPE html>
<html class="no-js">

<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta name="viewport" content="width=device-width" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/styles.css">
	<script type="text/javascript">
	</script>

	<!-- jQuery文件。要在 bootstrap.min.js 之前引入 -->
	<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
	<!-- popper.min.js 用於彈跳視窗、提示、下拉選單 -->
	<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
	<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
	<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>

	<!-- 要導入的資源檔案 START 以下記入  -->
	<!-- 新 Bootstrap4 核心 CSS 文件 -->
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/bootstrap.css">
	<!-- 要導入的資源檔案 END  -->

	<!-- 設置網頁TITLE START -->
	<title><spring:message code="${titleKey}" text="Be株式会社" /></title>
	<c:set var="titleKey">
	    <tiles:insertAttribute name="title" ignore="true" />
	</c:set>
	<!-- 設置網頁TITLE END -->

</head>

<body>
		<!-- 網頁主要內容部分 START -->
		   <div class="container">
		       <tiles:insertAttribute name="body" />
		   		<!-- 底部 floor -->
		       <p style="text-align: center; background: #e5eCf9;">Copyright &copy; 2019 CompanyName</p>
		   </div>

		<!-- 網頁主要內容部分 END -->
</body>
</html>