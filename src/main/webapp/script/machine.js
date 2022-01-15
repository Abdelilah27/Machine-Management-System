$(document).ready(function() {
	var indiceId;
	var dataTest;
	var check = false;
	$.ajax({
		url: "MachineController",
		data: { op: "load" },
		method: 'POST',
		success: function(data, textStatus, jqXHR) {
			dataTest = data[1].slice();
			remplir(data[1]);
			remplirBox(data[0]);


		},
		error: function(data) {
			console.log(data);
		}
	});


	$("#ajouterMachine").click(function() {

		var reference = $("#ref").val();
		var prix = $("#prix").val();
		var dateAchat = $("#dateAchat").val();
		var marque = $("#marque").val();
		isExiste(dataTest, $("#ref").val());
		if (ref == "" || prix == "" || dateAchat == "") {
			if (document.getElementById("notificationSuppr").style.display == "block") {
				$("#notificationSuppr").css("display", "none");

			}
			if (document.getElementById("notificationAjouter").style.display == "block") {
				$("#notificationAjouter").css("display", "none");

			} if (document.getElementById("refExiste").style.display == "block") {
				$("#refExiste").css("display", "none");

			}
			if (document.getElementById("notificationModifier").style.display == "block") {
				$("#notificationModifier").css("display", "none");

			}
			$("#notificationRemplir").css("display", "block");

		} if (check == false) {
			$.ajax({
				url: "MachineController",
				data: { ref: reference, prix: prix, dateAchat: dateAchat, marque: marque },
				method: 'POST',
				success: function(data) {

					if (document.getElementById("refExiste").style.display == "block") {
						$("#refExiste").css("display", "none");

					}

					if (document.getElementById("notificationSuppr").style.display == "block") {
						$("#notificationSuppr").css("display", "none");

					}
					if (document.getElementById("notificationAjouter").style.display == "block") {
						$("#notificationAjouter").css("display", "none");

					}
					$("#notificationAjouter").css("display", "block");

					remplir(data[1]);
					remplirBox(data[0]);
					isExiste(data, $("#ref").val());
					$("#ref").val("");
					$("#prix").val("");
					$("#dateAchat").val("");
					$("#notificationRemplir").css("display", "none");
				},
				error: function(data) {
					console.log(data);
				}
			});
		} else {
			check = false;

		}


	});

	$("#content").on('click', '.delete', function() {
		var indice = $(this).attr('indice');
		console.log(indice);
		$.ajax({
			url: "MachineController",
			data: { op: "delete", indice: indice },
			method: 'POST',
			success: function(data) {
				if (document.getElementById("notificationAjouter").style.display == "block") {
					$("#notificationAjouter").css("display", "none");

				}
				if (document.getElementById("refExiste").style.display == "block") {
					$("#refExiste").css("display", "none");

				}

				if (document.getElementById("notificationSuppr").style.display == "block") {
					$("#notificationSuppr").css("display", "none");

				}
				if (document.getElementById("notificationModifier").style.display == "block") {
					$("#notificationModifier").css("display", "none");

				}
				if (document.getElementById("notificationRemplir").style.display == "block") {
					document.getElementById("notificationRemplir").style.display = "none"
				}

				$("#notificationSuppr").css("display", "block");
				remplir(data[1]);
				remplirBox(data[0]);
			},
			error: function(data) {
				console.log(data);
			}
		});
	});

	$("#content").on('click', '.update', function() {
		indiceId = $(this).attr('indice');
		var indiceRef = $(this).attr('indice2');
		var indicePrix = $(this).attr('indice3');
		var indiceDate = $(this).attr('indice4').text;
		var indiceIDM = $(this).attr('indice5');
		var date = $(this).closest("tr").find(' td:eq(2)').text();


		$("#ref").val(indiceRef);
		$("#prix").val(indicePrix);
		$("#dateAchat").val(formatDate(date));		
		
		console.log("hh" + indiceIDM)
		
		//$("#marque").val(indiceIDM);

		if (document.getElementById("refExiste").style.display == "block") {
			$("#refExiste").css("display", "none");

		}
		if (document.getElementById("notificationSuppr").style.display == "block") {
			$("#notificationSuppr").css("display", "none");

		}

		if (document.getElementById("notificationModifier").style.display == "block") {
			$("#notificationModifier").css("display", "none");

		}
		if (document.getElementById("notificationAjouter").style.display == "block") {
			$("#notificationAjouter").css("display", "none");

		}


		$("button#modifierMachine").css("display", "block");
		const buttonM = document.getElementById('ajouterMachine');
		buttonM.disabled = true;
		if (document.getElementById("notificationRemplir").style.display == "block") {
			document.getElementById("notificationRemplir").style.display = "none"
		} else {
			$("#notificationRemplir").attr("display", "block");
		}

	});

	$("#modifier").on('click', '.modifierMac', function() {
		isExiste(dataTest, $("#ref").val());
		if ($("#ref").val() == "" || $("#prix").val() == "" || $("#dateAchat").val() == "") {
			$("#notificationRemplir").css("display", "block");
		}
		if (check == false) {
			$.ajax({
				url: "MachineController",
				data: { op: "update", indice1: indiceId, indice2: $("#ref").val(), indice3: $("#dateAchat").val(), indice4: $("#prix").val(), indice5: $("#marque").val() },
				method: 'POST',
				success: function(data) {
					remplir(data[1]);
					remplirBox(data[0]);
					$("button#modifierMachine").css("display", "none");
					$("#notificationModifier").css("display", "block");
					$("button#ajouterMachine").enabled;
					$("#notificationRemplir").css("display", "none");
					$("#ref").val("");
					$("#prix").val("");
					$("#dateAchat").val("");
					const buttonM = document.getElementById('ajouterMachine');
					buttonM.disabled = false;
					isExiste(data, $("#ref").val());
				},
				error: function(data) {
					console.log(data);
				}
			});
		} else {
			check = false;

		}

	});



	function remplir(data) {
		var ligne = "";
		data.forEach(e => {

			ligne += "<tr> <td> <div class='d-flex px-2 py-1'> <div class='d-flex flex-column justify-content-center'> <h6 class='mb-0 text-sm'>" + e.id + "</h6> </div> </div> </td> <td> <p class='text-xs font-weight-bold mb-0'>" + e.reference + "</p> </td> <td class='align-middle text-center text-sm'> <p class='text-xs font-weight-bold mb-0'>" + e.dateAchat + "</p> </td><td class='align-middle text-center text-sm'> <p class='text-xs font-weight-bold mb-0'>" + e.prix + "</p> </td><td class='align-middle text-center text-sm'> <p class='text-xs font-weight-bold mb-0'>" + e.marque.libelle + "</p> </td> <td class='align-middle text-center'><button indice=" + e.id + " class=' delete btn bg-gradient-danger mb-0 toast-btn' type='button' data-target='dangerToast'>Supprimer</button></td> <td class='align-middle text-center'><button indice=" + e.id + " indice2=" + e.reference + " indice3=" + e.prix + " indice4=" + e.dateAchat + " indice5=" + e.marque.libelle + " class=' update btn bg-gradient-success mb-0 toast-btn' type='button' data-target='successToast'>Modifier</button> </td> </tr>";
		});
		$("#content").html(ligne);


	}

	function isExiste(data, lib) {
		dataTest = data.slice();

		for (var i = 0; i < data.length; i++) {
			console.log("aa:  + " + data[i].reference);
			if (data[i].reference == lib) {
				$("#refExiste").css("display", "block");
				$("#notificationAjouter").css("display", "none");
				console.log("eeeeee");
				check = true;
			}
		}

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
	function formatDate(date) {
		var d = new Date(date),
			month = '' + (d.getMonth() + 1),
			day = '' + d.getDate(),
			year = d.getFullYear();

		if (month.length < 2)
			month = '0' + month;
		if (day.length < 2)
			day = '0' + day;

		return [year, month, day].join('-');
	}

});