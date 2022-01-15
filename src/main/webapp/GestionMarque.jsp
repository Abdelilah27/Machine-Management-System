
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="apple-touch-icon" sizes="76x76"
	href="template/img/apple-icon.png">
<link rel="icon" type="image/png" href="template/img/favicon.png">
<title>Gestion Des Marques</title>
<script src="script/jquery-3.6.0.min.js"></script>
<script src="script/marque.js"></script>

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
							<h6 class="mb-0">Nouvelle Marque</h6>
						</div>
						<div class="card-body">
							<form action="MarqueController" method="POST" role="form"
								class="text-start">
								<div class="input-group input-group-outline my-3">
									<label class="form-label">Code</label> <input id="code"
										type="text" class="form-control" onfocus="focused(this)"
										onfocusout="defocused(this)">
								</div>
								<div class="input-group input-group-outline mb-3">
									<label class="form-label">Libelle</label> <input id="libelle"
										type="text" class="form-control" onfocus="focused(this)"
										onfocusout="defocused(this)">
								</div>

								<div style="display: none" class="alert alert-danger alert-dismissible text-white"
									role="alert" id ="notificationRemplir">
									<span class="text-sm">Veuillez remplir tout les champs
									</span>
									<button type="button" class="btn-close text-lg py-3 opacity-10"
										data-bs-dismiss="alert" aria-label="Close">
										<span aria-hidden="true">×</span>
									</button>
								</div>
								
								<div style="display: none"
									class="alert alert-success alert-dismissible text-white"
									role="alert" id="notificationModifier">
									<span class="text-sm">Bien Modifié </span>
									<button type="button" class="btn-close text-lg py-3 opacity-10"
										data-bs-dismiss="alert" aria-label="Close">
										<span aria-hidden="true">×</span>
									</button>
								</div>
								<div style="display: none"
									class="alert alert-success alert-dismissible text-white"
									role="alert" id="notificationAjouter">
									<span class="text-sm">Bien Ajouté </span>
									<button type="button" class="btn-close text-lg py-3 opacity-10"
										data-bs-dismiss="alert" aria-label="Close">
										<span aria-hidden="true">×</span>
									</button>
								</div>
								<div style="display: none"
									class="alert alert-danger alert-dismissible text-white"
									role="alert" id="notificationSuppr">
									<span class="text-sm">Bien Supprimé </span>
									<button type="button" class="btn-close text-lg py-3 opacity-10"
										data-bs-dismiss="alert" aria-label="Close">
										<span aria-hidden="true">×</span>
									</button>
								</div>
								<div class="text-center">
									<button id="ajouterMarque" type="button"
										class="ajouterM btn bg-gradient-primary w-100 my-4 mb-2">Ajouter</button>
								</div>
								<div id="modifier" class="text-center">
									<button style="display: none" type="button" id="mm"
										class="modifierMarque btn bg-gradient-success w-100 my-4 mb-2">Modifier</button>
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
									marques</h6>
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
												class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Code</th>
											<th
												class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Libelle</th>
											<th
												class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Supprimer</th>
											<th
												class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Modifier</th>
											<th class="text-secondary opacity-7"></th>
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