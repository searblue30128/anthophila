<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<style>
</style>

<div class="card">
	<div class="card-body">
		<div class="alert-group">
			<div class="alert-group">
				<c:forEach items="${companyMessage}" var="companyInfo">
					<div class="alert alert-info">${companyInfo}</div>
				</c:forEach>
				<c:forEach items="${monthlyMessage}" var="monthlyInfo">
					<div class="alert alert-info">
						<a id="monthlyMsgBtn" class="btn btn-info btn-sm"> 確認 </a>
						<a id="monthlyMsg"> ${monthlyInfo}</a>
					</div>
				</c:forEach>
				<c:forEach items="${warningMessage}" var="warningInfo">
					<div class="alert alert-danger">
						<a id="warningMsgBtn" class="btn btn-info btn-sm"> 確認 </a>
						<a id="warningMsg">${warningInfo}</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
				$("#monthlyMsgBtn").click( function() {
									alert("以下訊息已讀"+$("#monthlyMsg").text());
									$.get("/Anthophila-web/deleteMessage?" + "messageInfo="+ $("#monthlyMsg").text());
								});
				$("#monthlyMsgBtn").click( function() {
									alert("以下訊息已讀"+$("#warningMsg").text());
									$.get("/Anthophila-web/deleteMessage?" + "messageInfo="+ $("#warningMsg").text());
								});
			});
</script>
