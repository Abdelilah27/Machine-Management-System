
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta http-equiv="Cache-Control"
	content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="apple-touch-icon" sizes="76x76"
	href="../assets/img/apple-icon.png">
<link rel="icon" type="image/png" href="../assets/img/favicon.png">
<title>Gestion Des Machines</title>
<script src="script/jquery-3.6.0.min.js"></script>
<script src="script/user.js"></script>
<%@ include file="/include/css.jsp"%>
</head>

<body class="bg-gray-200">
	<div class="container position-sticky z-index-sticky top-0">
		<div class="row">
			<div class="col-12">
				<!-- Navbar -->
				<%@ include file="/include/NavBar2.jsp"%>
				<!-- End Navbar -->
			</div>
		</div>
	</div>
	<main class="main-content  mt-0">
		<div class="page-header align-items-start min-vh-100"
			style="background-image: url('https://images.unsplash.com/photo-1497294815431-9365093b7331?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1950&q=80');">
			<span class="mask bg-gradient-dark opacity-6"></span>
			<div class="container my-auto">
				<div class="row">
					<div class="col-lg-4 col-md-8 col-12 mx-auto">
						<div class="card z-index-0 fadeIn3 fadeInBottom">
							<div
								class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
								<div
									class="bg-gradient-primary shadow-primary border-radius-lg py-3 pe-1">
									<h4 class="text-white font-weight-bolder text-center mt-2 mb-0">Sign
										in</h4>
									<div class="row mt-3">
										<div class="col-2 text-center ms-auto">
											<a class="btn btn-link px-3" href="javascript:;"> <i
												class="fa fa-facebook text-white text-lg"></i>
											</a>
										</div>
										<div class="col-2 text-center px-1">
											<a class="btn btn-link px-3" href="javascript:;"> <i
												class="fa fa-github text-white text-lg"></i>
											</a>
										</div>
										<div class="col-2 text-center me-auto">
											<a class="btn btn-link px-3" href="javascript:;"> <i
												class="fa fa-google text-white text-lg"></i>
											</a>
										</div>
									</div>
								</div>
							</div>
							<div class="card-body">
								<form role="form" class="text-start" action="UserController">
									<div class="input-group input-group-outline my-3">
										<label class="form-label">Username</label> <input
											id="username" type="text" class="form-control">
									</div>
									<div class="input-group input-group-outline mb-3">
										<label class="form-label">Password</label> <input
											id="password" type="password" class="form-control">
									</div>
									<div
										class="form-check form-switch d-flex align-items-center mb-3">
										<input class="form-check-input" type="checkbox"
											id="rememberMe"> <label
											class="form-check-label mb-0 ms-2" for="rememberMe">Remember
											me</label>
									</div>
									<div style="display: none"
										class="alert alert-danger alert-dismissible text-white"
										role="alert" id="notificationRemplir">
										<span class="text-sm">Veuillez remplir tout les champs</span>
										<button type="button"
											class="btn-close text-lg py-3 opacity-10"
											data-bs-dismiss="alert" aria-label="Close">
											<span aria-hidden="true">×</span>
										</button>
									</div>
									<div style="display: none"
										class="alert alert-danger alert-dismissible text-white"
										role="alert" id="notificationRemplir2">
										<span class="text-sm">Utilisateur introuvable</span>
										<button type="button"
											class="btn-close text-lg py-3 opacity-10"
											data-bs-dismiss="alert" aria-label="Close">
											<span aria-hidden="true">×</span>
										</button>
									</div>
									<!-- 								<div style="display: none" -->
									<!-- 									class="alert alert-success alert-dismissible text-white" -->
									<!-- 									role="alert" id="notificationModifier"> -->
									<!-- 									<span class="text-sm">Veuillez choisir une date</span> -->
									<!-- 									<button type="button" class="btn-close text-lg py-3 opacity-10" -->
									<!-- 										data-bs-dismiss="alert" aria-label="Close"> -->
									<!-- 										<span aria-hidden="true">×</span> -->
									<!-- 									</button> -->
									<!-- 								</div> -->
									<div class="text-center">
										<button type="button" id="connect"
											class="btn bg-gradient-primary w-100 my-4 mb-2">Sign
											in</button>
									</div>
									<p class="mt-4 text-sm text-center">
										Don't have an account? <a href=""
											class="text-primary text-gradient font-weight-bold">Sign
											up</a>
									</p>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%@ include file="/include/Footer2.jsp"%>
		</div>
	</main>
	<%@ include file="/include/FixedPlugin.jsp"%>
	<%@ include file="/include/js.jsp"%>
</body>

</html>