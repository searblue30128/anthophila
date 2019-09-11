<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

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
				<%
					ArrayList<String> monthlyList = (ArrayList<String>) request.getAttribute("monthlyMessage");
					int monthlyMsgSize = monthlyList.size();
					for (int i = 0; i < monthlyMsgSize; i++) {
				%>
				<div class="alert alert-info">
					<a id="monthlyMsgBtn<%=i%>" class="btn btn-info btn-sm"> 確認 </a>
					<a id="monthlyMsg<%=i%>"><%=monthlyList.get(i)%></a>
				</div>
				<%
					}
					ArrayList<String> warningList = (ArrayList<String>) request.getAttribute("warningMessage");
					int warningMsgSize = warningList.size();
					for (int i = 0; i < warningMsgSize; i++) {
				%>
				<div class="alert alert-danger">
					<a id="warningMsgBtn<%=i%>" class="btn btn-info btn-sm"> 確認 </a>
					<a id="warningMsg<%=i%>"><%=warningList.get(i)%></a>
				</div>
				<%
					}
				%>

			</div>
		</div>
	</div>
</div>
<script>
$(document).ready(function() {
		<%for (int i = 0; i < warningMsgSize; i++) {%>
			$("#warningMsgBtn<%=i%>").click( function() {
				alert("以下訊息已讀"+$("#warningMsg<%=i%>").text());
				$.get("/Anthophila-web/deleteMessage?" + "messageInfo="+ $("#warningMsg<%=i%>").text());
			});
		<%}
		for (int i = 0; i < monthlyMsgSize; i++) {%>
			$("#monthlyMsgBtn<%=i%>").click( function() {
				alert("以下訊息已讀"+$("#monthlyMsg<%=i%>").text());
				$.get("/Anthophila-web/deleteMessage?" + "messageInfo="+ $("#monthlyMsg<%=i%>").text());
			});
		<%}%>
});
</script>
