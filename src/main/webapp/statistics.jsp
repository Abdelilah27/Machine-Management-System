


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
<%@ include file="/include/css.jsp"%>

<script src="script/jquery-3.6.0.min.js"></script>
<script src="script/statistic.js"></script>
<script type="text/javascript" src="script/chart.min.js"></script>
</head>
<body class="g-sidenav-show  bg-gray-200">

	<%@ include file="/include/Sidebar.jsp"%>

	<main
		class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
		<%@ include file="/include/NavBar.jsp"%>
		<div class="container-fluid py-4">
			<div class="row">
				<div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
					<div class="card">
						<div class="card-header p-3 pt-2">
							<div
								class="icon icon-lg icon-shape bg-gradient-dark shadow-dark text-center border-radius-xl mt-n4 position-absolute">
								<i class="material-icons opacity-10">weekend</i>
							</div>
							<div class="text-end pt-1">
								<p class="text-sm mb-0 text-capitalize">Nombre de Machine</p>
								<h4 id="nombreMachine" class="mb-0">$53k</h4>
							</div>
						</div>
						<hr class="dark horizontal my-0">
						<div class="card-footer p-3"></div>
					</div>
				</div>
				<div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
					<div class="card">
						<div class="card-header p-3 pt-2">
							<div
								class="icon icon-lg icon-shape bg-gradient-primary shadow-primary text-center border-radius-xl mt-n4 position-absolute">
								<i class="material-icons opacity-10">person</i>
							</div>
							<div class="text-end pt-1">
								<p class="text-sm mb-0 text-capitalize">Nombre de Marque</p>
								<h4 id="nombreMarque" class="mb-0">2,300</h4>
							</div>
						</div>
						<hr class="dark horizontal my-0">
						<div class="card-footer p-3"></div>
					</div>
				</div>




			</div>

			<div class="row mt-4">
				<div class="col-md-5 mt-4 ">
					<div class="card z-index-2  ">
						<div
							class="card-header p-0 position-relative mt-n4 mx-3 z-index-2 bg-transparent">
							<div
								class="bg-gradient-info shadow-info border-radius-lg py-3 pe-1">
								<div class="chart" id="chart-container">
									<canvas id="mycanvas2" style="height: 40vh; width: 80vw"
										class="chart-canvas" height="160"></canvas>
								</div>
							</div>
						</div>
						<div class="card-body">
							<h6 class="mb-0 ">Statistique - Pie</h6>
							<p class="text-sm ">Nombre de machine par marque</p>
							<hr class="dark horizontal">

						</div>
					</div>
				</div>
				<div class="col-md-6 mt-4">
					<div class="card z-index-2  ">
						<div
							class="card-header p-0 position-relative mt-n4 mx-3 z-index-2 bg-transparent">
							<div
								class="bg-gradient-success shadow-success border-radius-lg py-3 pe-1">
								<div class="chart" id="chart-container">
									<canvas id="mycanvas" class="chart-canvas" height="244"></canvas>
								</div>
							</div>
						</div>
						<div class="card-body">
							<h6 class="mb-0 ">Statistique - Bar</h6>
							<p class="text-sm ">Nombre de machine par marque</p>
							<hr class="dark horizontal">

						</div>
					</div>
				</div>
<!-- 				<div class="col-lg-4 col-md-6 mt-4 mb-4"> -->
<!-- 					<div class="card z-index-2 "> -->
<!-- 						<div -->
<!-- 							class="card-header p-0 position-relative mt-n4 mx-3 z-index-2 bg-transparent"> -->
<!-- 							<div -->
<!-- 								class="bg-gradient-primary shadow-primary border-radius-lg py-3 pe-1"> -->
<!-- 								<div class="chart"> -->
<!-- 									<div class="chart" id="chart-container"> -->
<!-- 										<canvas id="mycanvas1" class="chart-canvas" height="170"></canvas> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class="card-body"> -->
<!-- 							<h6 class="mb-0 ">Statistique - Line</h6> -->
<!-- 							<p class="text-sm ">Nombre de machine par marque</p> -->
<!-- 							<hr class="dark horizontal"> -->

<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->


			</div>

			<%@ include file="/include/Footer.jsp"%>
		</div>
	</main>
	<%@ include file="/include/FixedPlugin.jsp"%>
	<%@ include file="/include/js.jsp"%>

</body>

</html>