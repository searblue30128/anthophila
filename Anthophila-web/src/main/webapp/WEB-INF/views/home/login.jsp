<!-- 未完成.... -->
<div class="Container">
	<div class="row">
		<div class="col-md-6">
			<a  href="${pageContext.request.contextPath}/home">
				<img class="col-md-4" src="${pageContext.request.contextPath}/resources/app/png/logo.png" ></img>
			</a>
			<!--<form role="form">

					<label for="userId">使用者名稱：</label>
					<input type="text" class="form-control" placeholder="USERID" id="userId" name="userId">
					<label for="password">密 碼：</label>
					<input type="password" class="form-control" placeholder="PASSWORD" id="password" name="password">

			<div class="checkbox">
				<input type="submit" value="登入" class="btn" />
			</div>
			</form>-->
			
			<form action="index" method = "post">
					<label for="userId">userId:</label>
					<input type="text" class="form-control" id="userName" name="userName">
					<label for="password">password:</label>
					<input type="password" class="form-control" id="password" name="password">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
					<input type="submit" value="login" class="btn" />
			</form>
			<br>
		</div>
	</div>
</div>