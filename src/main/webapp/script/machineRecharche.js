$(document).ready(function() {

	$.ajax({
		url: "RechercheMachineController",
		data: { op: "load" },
		method: 'POST',
		success: function(data, textStatus, jqXHR) {
			console.log(data[1]);
			console.log(data[0]);
			remplirBox(data[0]);

		},
		error: function(data) {
			console.log("d")
		}
	});

	$("#Recherche").click(function() {
		if (document.getElementById("notificationModifier").style.display == "block") {
			$("#notificationModifier").css("display", "none");

		}
		if (document.getElementById("notificationRemplir").style.display == "block") {
			$("#notificationRemplir").css("display", "none");

		}
		if ($("#marque").val() == null) {
			$("#notificationModifier").css("display", "block");
		}
		$.ajax({
			url: "RechercheMachineController",
			data: { op: "search", indice: $("#marque").val() },
			method: 'POST',
			success: function(data, textStatus, jqXHR) {
				remplir(data[1]);
				remplirBox(data[0]);


			},
			error: function(data) {
				console.log(data[1]);
				console.log(data[0]);
			}
		});
	});


	function remplir(data) {
		var ligne = "";
		console.log("test: " + data[0]);

		if (data[0] == undefined) {
			console.log("hhhh");
			$("#notificationRemplir").css("display", "block");

		}
		data.forEach(e => {
			ligne += "<tr> <td> <div class='d-flex px-2 py-1'> <div class='d-flex flex-column justify-content-center'> <h6 class='mb-0 text-sm'>" + e.id + "</h6> </div> </div> </td> <td> <p class='text-xs font-weight-bold mb-0'>" + e.reference + "</p> </td> <td class='align-middle text-center text-sm'> <p class='text-xs font-weight-bold mb-0'>" + e.dateAchat + "</p> </td><td class='align-middle text-center text-sm'> <p class='text-xs font-weight-bold mb-0'>" + e.prix + "</p> </td><td class='align-middle text-center text-sm'> <p class='text-xs font-weight-bold mb-0'>" + e.marque.libelle + "</p> </td></tr>";
		});
		$("#content").html(ligne);
	}
	function remplirBox(data) {
		var ligne = "";
		var ligne1 = "";

		data.forEach(e => {


			ligne += "";
			ligne1 += "";
			ligne += "<option value='" + e.id + "'>" + e.libelle + "</option>";

		});
		ligne1 += "<option value='' disabled selected>Choisissez une marque </option>";
		$("#marque").html(ligne + ligne1);
	}
});