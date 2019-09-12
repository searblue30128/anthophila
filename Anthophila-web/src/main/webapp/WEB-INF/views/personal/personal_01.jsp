
<meta http-equiv="Content-Type"content="text/html;charset=UTF-8"/>
<link
	Href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	Rel="stylesheet" Id="bootstrap-css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<head>
   <sec:csrfMetaTags />   <!-- (1) https://terasolunaorg.github.io/guideline/5.0.x/en/Security/CSRF.html-->
</head>
<table class="table table-condensed table-hover">
	<thead>
		<tr>
			<th style="width: 10%">基本情報</th>
			<th style="width: 17%"></th>
			<th style="width: 10%">員工編號</th>
			<th style="width: 20%">${personalInfo.accountNo}</th>
			<th style="width: 10%"></th>
			<th style="width: 25%"></th>
		</tr>
	</thead>
	<tbody>
		<form>
			<tr>
				<th>職稱</th>
				<td><input type="text" name="jobTitle" value="${personalInfo.jobTitle}"
					class="form-control"></td>
				<th>生年月日</th>
				<td><input type="text" id="datepicker" class="form-control"
					placeholder="Choose" value="${personalInfo.birthday}"></td>
				<th>性別</th>
				<td>
					<div class="form-check-inline">
						<label class="customradio"><span class="radiotextsty">男</span>
							<input type="radio" name="gender" value="M" ${personalInfo.gendor == "M" ? 'checked' :''}> <span
							class="checkmark"></span> </label>         <label class="customradio"><span
							class="radiotextsty">女</span> <input type="radio" name="gender" value="F" ${personalInfo.gendor != "M" ? 'checked' :''}>
							<span class="checkmark"></span> </label>
					</div>
				</td>
			</tr>
			<tr>
				<th>姓名</th>
				<td><input type="text" name="nameStr" value="${personalInfo.name}"
					class="form-control"></td>
				<th>攜帶電話</th>
				<td><input type="text" name="phoneNo" value="${personalInfo.phoneNo}"
					class="form-control" onkeypress='validate(event)'></td>
				<th>E-mail</th>
				<td><input type="email" name="emailStr" value="${personalInfo.email}"
					class="form-control" onkeypress='validate(event)'></td>
			</tr>
			<tr>
				<th>配偶者</th>
				<td>
					<div class="form-check-inline">
						<label class="customradio"><span class="radiotextsty">有</span>
							<input type="radio" name="mate" value="Y" ${personalInfo.mate == "Y" ? 'checked' :''}> <span
							class="checkmark"></span> </label>         <label class="customradio"><span
							class="radiotextsty">無</span> <input type="radio" name="mate" value="N" ${personalInfo.mate != "Y" ? 'checked' :''}>
							<span class="checkmark"></span> </label>
					</div>
				</td>
				<th>獨居者</th>
				<td>
					<div class="form-check-inline">
						<label class="customradio"><span class="radiotextsty">是</span>
							<input type="radio" name="single"  value="Y" ${personalInfo.liveAlone == "Y" ? 'checked' :''}> <span class="checkmark"></span>
						</label>         <label class="customradio"><span
							class="radiotextsty">否</span> <input type="radio"
							name="single" value="N" ${personalInfo.liveAlone != "Y" ? 'checked' :''}> <span class="checkmark"></span>
						</label>
					</div>
				</td>
				<th>最近駅</th>
				<td><input type="text" name="closedStation" value="${personalInfo.nearStation}"
					class="form-control"></td>
	
			</tr>
			<tr>
				<th>住所</th>
				<td colspan="5"><input type="text" name="address"
					value="${personalInfo.address}" class="form-control"></td>
			</tr>
			<tr>
				<th>在留番號</th>
				<td><input type="text" name="residentNo" value="${personalInfo.residenceCardNo}"
					class="form-control"></td>
				<th>在留期間</th>
				<td colspan="3"><input type="text" id="residentStart"
					class="form-control-inline" placeholder="Choose" style="width: 40%" value="${personalInfo.residenceDateStart}">
					~ <input type="text" id="residentEnd" class="form-control-inline"
					placeholder="Choose" style="width: 40%" value="${personalInfo.residenceDateEnd}"></td>
			</tr>
			<tr>
				<th rowspan="4">口座情報</th>
			</tr>
			<tr>
				<th>名義者</th>
				<td colspan="4"><input type="text" name="nameOwner" value="${personalInfo.bankAccountName}"
					class="form-control"></td>
			</tr>
			<tr>
				<th>銀行、支店</th>
				<td colspan="4"><input type="text" name="bankStr"
					value="${personalInfo.bankAccountBranch}" class="form-control"></td>
			</tr>
			<tr>
				<th>口座番號</th>
				<td colspan="4"><input type="text" name="accountNo"
					value="${personalInfo.bankAccountNo}" class="form-control"></td>
			</tr>
			<tr>
				<th>護照番號</th>
				<td><input type="text" name="passportNo" value="${personalInfo.passportNo}"
					class="form-control"></td>
				<th>雇用保險被保險者番號</th>
				<td colspan="3"><input type="text" name="InsurantNo"
					value="${personalInfo.hiredInsuranceInsuredNo}" class="form-control"></td>
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
			<tr>
				<td><input type="text" name="parentName1"
					value="${personalInfo.dependentRelativeName1}" class="form-control"></td>
				<td><input type="text" name="parentRelationship1"
					value="${personalInfo.dependentRelativeRelation1}" class="form-control"></td>
				<td><input type="text" id="parentDate1"
					class="form-control" placeholder="Choose" value="${personalInfo.dependentRelativeBirthday1}"></td>
				<td colspan="2"><input type="text" name="parentAddress1"
					value="${personalInfo.dependentRelativeAddress1}" class="form-control"></td>
			</tr>
			<tr>
				<td><input type="text" name="parentName2"
					value="${personalInfo.dependentRelativeName2}" class="form-control"></td>
				<td><input type="text" name="parentRelationship2"
					value="${personalInfo.dependentRelativeRelation2}" class="form-control"></td>
				<td><input type="text" id="parentDate2"
					class="form-control" placeholder="Choose" value="${personalInfo.dependentRelativeBirthday2}"></td>
				<td colspan="2"><input type="text" name="parentAddress2"
					value="${personalInfo.dependentRelativeAddress2}" class="form-control"></td>
			</tr>
			<tr>
				<td><input type="text" name="parentName3"
					value="${personalInfo.dependentRelativeName3}" class="form-control"></td>
				<td><input type="text" name="parentRelationship3"
					value="${personalInfo.dependentRelativeRelation3}" class="form-control"></td>
				<td><input type="text" id="parentDate3"
					class="form-control" placeholder="Choose" value="${personalInfo.dependentRelativeBirthday3}"></td>
				<td colspan="2"><input type="text" name="parentAddress3"
					value="${personalInfo.dependentRelativeAddress3}" class="form-control"></td>
			</tr>
	</tbody>
	<tr>
		<td></td>
		<td></td>
		<td><a class="btn btn-success disabled" id="saveBtn" href="javascript:"><i
				class="icon-shopping-cart icon-white"></i> 儲存 </a></td>
		<td><a class="btn btn-success" id="editBtn" href="javascript:"><i
				class="icon-shopping-cart icon-white"></i> 編輯 </a></td>
		<td></td>
		<td></td>
	</tr>
	</form>
</table>

<script type="text/javascript">

var token = $("meta[name='_csrf']").attr("content");  <!-- (2) -->
var header = $("meta[name='_csrf_header']").attr("content");  <!-- (3) -->
$(document).ajaxSend(function(e, xhr, options) {
    xhr.setRequestHeader(header, token);  <!-- (4) -->
});
	/* birth */
	$(function() {
		$("input").attr('disabled', true);
		$("#datepicker").datepicker({
			dateFormat : 'yy-mm-dd',
			changeMonth : true,
			changeYear : true,
			yearRange : '-100y:c+nn',
			maxDate : '-1d'
		});

		$("#residentStart").datepicker({
			dateFormat : 'yy-mm-dd',
			changeMonth : true,
			changeYear : true,
			yearRange : '-100y:c+nn',
			maxDate : '0d'
		});

		$("#residentEnd").datepicker({
			dateFormat : 'yy-mm-dd',
			changeMonth : true,
			changeYear : true,
			yearRange : '-100y:c+nn',
		});

		for (var i = 0; i < 8; i++) {
			$("#parentDate" + (i + 1)).datepicker({
				dateFormat : 'yy-mm-dd',
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
	
	$("#saveBtn").click(function(){
		  $("input").attr('disabled', true);
		  $("#saveBtn").addClass("disabled");
		  $("#editBtn").removeClass("disabled");
		  $.ajax({
	            type: "post",
	            url: "personal_01_ajax",
	            data: $('form').serialize(),
	            timeout: 15000,
	            success: function(data) {
	                  console.log("ajax success");
	                  console.log($('form').serialize());
	            },
	            complete: function() {
	            	console.log("ajax complete");
	            },
	            error: function(xhr, ajaxOptions, thrownError){
	            	console.log("ajax failed");
                }
	        });
	});
	$("#editBtn").click(function(){
		  $("input").attr('disabled', false);
		  $("#saveBtn").removeClass("disabled");
		  $("#editBtn").addClass("disabled");
	});
	function getCookie(name){
	    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
	    if(arr != null) return unescape(arr[2]); return null;
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