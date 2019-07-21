<link
	Href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	Rel="stylesheet" Id="bootstrap-css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<table class="table table-condens	ed table-hover">
	<thead>
		<tr>
			<th style="width: 10%">基本情報</th>
			<th style="width: 17%"></th>
			<th style="width: 10%"></th>
			<th style="width: 20%"></th>
			<th style="width: 10%"></th>
			<th style="width: 25%"></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>職稱</th>
			<td><input type="text" name="jobTitle" value="軟體工程師"
				class="form-control"></td>
			<th>生年月日</th>
			<td><input type="text" id="datepicker" class="form-control"
				placeholder="Choose"></td>
			<th>性別</th>
			<td>
				<div class="form-check-inline">
					<label class="customradio"><span class="radiotextsty">男</span>
						<input type="radio" checked="checked" name="gender"> <span
						class="checkmark"></span> </label>         <label class="customradio"><span
						class="radiotextsty">女</span> <input type="radio" name="gender">
						<span class="checkmark"></span> </label>
				</div>
			</td>
		</tr>
		<tr>
			<th>姓名</th>
			<td><input type="text" name="nameStr" value="SAPORO"
				class="form-control"></td>
			<th>攜帶電話</th>
			<td><input type="text" name="phoneNo" value="08012345678"
				class="form-control" onkeypress='validate(event)'></td>
			<th>E-mail</th>
			<td><input type="email" name="emailStr" value="test@gmail.com"
				class="form-control" onkeypress='validate(event)'></td>
		</tr>
		<tr>
			<th>配偶者</th>
			<td>
				<div class="form-check-inline">
					<label class="customradio"><span class="radiotextsty">有</span>
						<input type="radio" checked="checked" name="mate"> <span
						class="checkmark"></span> </label>         <label class="customradio"><span
						class="radiotextsty">無</span> <input type="radio" name="mate">
						<span class="checkmark"></span> </label>
				</div>
			</td>
			<th>獨居者</th>
			<td>
				<div class="form-check-inline">
					<label class="customradio"><span class="radiotextsty">是</span>
						<input type="radio" name="single"> <span class="checkmark"></span>
					</label>         <label class="customradio"><span
						class="radiotextsty">否</span> <input type="radio"
						checked="checked" name="single"> <span class="checkmark"></span>
					</label>
				</div>
			</td>
			<th>最近駅</th>
			<td><input type="text" name="closedStation" value="札幌駅"
				class="form-control"></td>

		</tr>
		<tr>
			<th>住所</th>
			<td colspan="5"><input type="text" name="address"
				value="北海道札幌市中央區南4條西" class="form-control"></td>
		</tr>
		<tr>
			<th>在留番號</th>
			<td><input type="text" name="residentNo" value="KG93638363FA"
				class="form-control"></td>
			<th>在留期間</th>
			<td colspan="3"><input type="text" id="residentStart"
				class="form-control-inline" placeholder="Choose" style="width: 40%">
				~ <input type="text" id="residentEnd" class="form-control-inline"
				placeholder="Choose" style="width: 40%"></td>
		</tr>
		<tr>
			<th rowspan="4">口座情報</th>
		</tr>
		<tr>
			<th>名義者</th>
			<td colspan="4"><input type="text" name="nameOwner" value="測試"
				class="form-control"></td>
		</tr>
		<tr>
			<th>銀行、支店</th>
			<td colspan="4"><input type="text" name="bankStr"
				value="三菱東京UFJ草家支店(291)" class="form-control"></td>
		</tr>
		<tr>
			<th>口座番號</th>
			<td colspan="4"><input type="text" name="accountNo"
				value="0101234566" class="form-control"></td>
		</tr>
		<tr>
			<th>護照番號</th>
			<td><input type="text" name="passportNo" value="3100999202"
				class="form-control"></td>
			<th>雇用保險被保險者番號</th>
			<td colspan="3"><input type="text" name="InsurantNo"
				value="123456789" class="form-control"></td>
		</tr>
		<tr>
			<th rowspan="9">扶養家族</th>
		</tr>
		<tr>
			<th>名前</th>
			<th>績柄</th>
			<th>生年月日</th>
			<th colspan="2">住所</th>
		</tr>
		<c:forEach var="num" begin="1" end="2" step="1">
			<tr>
				<td><input type="text" name="parentName${num}"
					value="測試${num}號" class="form-control"></td>
				<td><input type="text" name="parentRelationship${num}"
					value="複製人${num}號" class="form-control"></td>
				<td><input type="text" id="parentDate${num}"
					class="form-control" placeholder="Choose"></td>
				<td colspan="2"><input type="text" name="parentAddress${num}"
					value="瑞湖街62號富邦大樓209" class="form-control"></td>
			</tr>

		</c:forEach>

	</tbody>
	<tr>
		<td></td>
		<td></td>
		<td><a class="btn btn-success" href="#"><i
				class="icon-shopping-cart icon-white"></i> 送出 </a></td>
		<td><a class="btn btn-success" href="#"><i
				class="icon-shopping-cart icon-white"></i> 編輯 </a></td>
		<td></td>
		<td></td>
	</tr>
</table>

<script type="text/javascript">
	/* birth */
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : 'mm/dd/yy',
			changeMonth : true,
			changeYear : true,
			yearRange : '-100y:c+nn',
			maxDate : '-1d'
		});

		$("#residentStart").datepicker({
			dateFormat : 'yy/mm/dd',
			changeMonth : true,
			changeYear : true,
			yearRange : '-100y:c+nn',
			maxDate : '0d'
		});

		$("#residentEnd").datepicker({
			dateFormat : 'yy/mm/dd',
			changeMonth : true,
			changeYear : true,
			yearRange : '-100y:c+nn',
		});

		for (var i = 0; i < 8; i++) {
			$("#parentDate" + (i + 1)).datepicker({
				dateFormat : 'yy/mm/dd',
				changeMonth : true,
				changeYear : true,
				yearRange : '-100y:c+nn',
			});
		}

		$('th').css({
			"vertical-align" : "middle",
			"writing-mode" : "horizontal-tb"
		});
		$('td').css({
			"vertical-align" : "middle"
		});
	});
	function validate(evt) {
		var theEvent = evt || window.event;

		// Handle paste
		if (theEvent.type === 'paste') {
			key = event.clipboardData.getData('text/plain');
		} else {
			// Handle key press
			var key = theEvent.keyCode || theEvent.which;
			key = String.fromCharCode(key);
		}
		var regex = /[0-9]|\./;
		if (!regex.test(key)) {
			theEvent.returnValue = false;
			if (theEvent.preventDefault)
				theEvent.preventDefault();
		}
	}
</script>

<style type="text/css">

/* Custom Radio Button Start*/
.radiotextsty {
	color: #A5A4BF;
	font-size: 18px;
}

.customradio {
	display: block;
	position: relative;
	padding-left: 30px;
	margin-bottom: 0px;
	cursor: pointer;
	font-size: 18px;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

/* Hide the browser's default radio button */
.customradio input {
	position: absolute;
	opacity: 0;
	cursor: pointer;
}

/* Create a custom radio button */
.checkmark {
	position: absolute;
	top: 0;
	left: 0;
	height: 22px;
	width: 22px;
	background-color: white;
	border-radius: 50%;
	border: 1px solid #BEBEBE;
}

/* On mouse-over, add a grey background color */
.customradio:hover input ~ .checkmark {
	background-color: transparent;
}

/* When the radio button is checked, add a blue background */
.customradio input:checked ~ .checkmark {
	background-color: white;
	border: 1px solid #BEBEBE;
}

/* Create the indicator (the dot/circle - hidden when not checked) */
.checkmark:after {
	content: "";
	position: absolute;
	display: none;
}

/* Show the indicator (dot/circle) when checked */
.customradio input:checked ~ .checkmark:after {
	display: block;
}

/* Style the indicator (dot/circle) */
.customradio .checkmark:after {
	top: 2px;
	left: 2px;
	width: 16px;
	height: 16px;
	border-radius: 50%;
	background: #A3A0FB;
}

/* Custom Radio Button End*/
</style>