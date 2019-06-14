<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<div class="card">
	<div class="card-body">
		<div class="row">
			<div class="col-md-2 border-right">
				<h4>使用者</h4>
			</div>
			<div class="col-md-6">
				<button type="button" class="btn btn-sm btn-primary">Add User</button>
			</div>

		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover ">
					<thead class="bg-light ">
						<tr>
							<th>
								<div class="form-check-inline">
									<label class="form-check-label"> <input
										type="checkbox" class="form-check-input" value="">
									</label>
								</div>
							</th>
							<th>Username</th>
							<th>Name</th>
							<th>Email</th>
							<th>Role</th>
							<th>Posts</th>
							<th>Edit</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<div class="form-check-inline">
									<label class="form-check-label"> <input
										type="checkbox" class="form-check-input" value="">
									</label>
								</div>
							</td>
							<td><a href="#"><small>Johnyahua</small></a></td>
							<td><small>Doe</small></td>
							<td><small>john@example.com</small></td>
							<td><small>Admin</small></td>
							<td><a href="#"><small>5</small></a></td>
							<td><a href="#"><i class="fa fa-pencil-square-o"></i></a>
								<a href="#"><i class="fa fa-eye"></i></a> <a href="#"><i
									class="fa fa-trash"></i></a></td>
						</tr>
						<tr>
							<td>
								<div class="form-check-inline">
									<label class="form-check-label"> <input
										type="checkbox" class="form-check-input" value="">
									</label>
								</div>
							</td>
							<td><a href="#"><small>Johnyahua</small></a></td>
							<td><small>Doe</small></td>
							<td><small>john@example.com</small></td>
							<td><small>Admin</small></td>
							<td><a href="#"><small>5</small></a></td>
							<td><a href="#"><i class="fa fa-pencil-square-o"></i></a>
								<a href="#"><i class="fa fa-eye"></i></a> <a href="#"><i
									class="fa fa-trash"></i></a></td>
						</tr>


					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(function() {
	console.log($('.panel-group'));
	$('.col-md-3').show(10);
// 	$('.col-md-3').css("display","none");
});
</script>