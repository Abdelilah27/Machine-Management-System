
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="apple-touch-icon" sizes="76x76"
	href="template/img/apple-icon.png">
<link rel="icon" type="image/png" href="template/img/favicon.png">
<title>Recherche des machines par marque</title>
<script src="script/jquery-3.6.0.min.js"></script>
<script src="script/machineRecharche.js"></script>

<%@ include file="/include/css.jsp"%>

</head>

<body class="g-sidenav-show  bg-gray-200">
	<%@ include file="/include/Sidebar.jsp"%>
	<main
		class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
		<%@ include file="/include/NavBar.jsp"%>
		<div class="container-fluid py-4">
			<div class="row">
				<div class=" mt-4">
					<div class="card">
						<div class="card-header pb-0 px-3">
							<h6 class="mb-0">Recherche Machine Par Marque</h6>
						</div>
						<div class="card-body">
							<form action="RechercheMachineController" method="POST" role="form"
								class="text-start">
								
								<div class="input-group input-group-outline mb-3">
									<label class="form-label"></label> <select name=""
										class="form-control " onfocus="focused(this)"  onfocusout="defocused(this)" id="marque">
									</select> 
								</div>


								<div style="display: none"
									class="alert alert-danger alert-dismissible text-white"
									role="alert" id="notificationRemplir">
									<span class="text-sm">Aucune Machine n'a été trouvé</span>
									<button type="button" class="btn-close text-lg py-3 opacity-10"
										data-bs-dismiss="alert" aria-label="Close">
										<span aria-hidden="true">×</span>
									</button>
								</div>
								<div style="display: none"
									class="alert alert-success alert-dismissible text-white"
									role="alert" id="notificationModifier">
									<span class="text-sm">Veuillez choisir une marque</span>
									<button type="button" class="btn-close text-lg py-3 opacity-10"
										data-bs-dismiss="alert" aria-label="Close">
										<span aria-hidden="true">×</span>
									</button>
								</div>
								
								<div class="text-center">
									<button id="Recherche" type="button"
										class="RechercheMachhine btn bg-gradient-primary w-100 my-4 mb-2">Rechercher</button>
								</div>
								
								

							</form>
						</div>
					</div>
				</div>

			</div>
			<br> <br>
			<div class="row">
				<div class="col-12">
					<div class="card my-4">
						<div
							class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
							<div
								class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
								<h6 class="text-white text-capitalize ps-3">Liste Des
									machines par marque</h6>
							</div>
						</div>
						<div class="card-body px-0 pb-2">
							<div class="table-responsive p-0">
								<table class="table align-items-center mb-0">
									<thead>
										<tr>
											<th
												class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">ID</th>
											<th
												class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Reference</th>
											
											<th
												class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Date
												d'achat</th>
												<th
												class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Prix</th>
											<th
												class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
												Marque</th>
											
										</tr>
									</thead>
									<tbody id="content">






									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>




		</div>
		<%@ include file="/include/Footer.jsp"%>
		</div>
	</main>
	<%@ include file="/include/FixedPlugin.jsp"%>
	<%@ include file="/include/js.jsp"%>
</body>

</html>