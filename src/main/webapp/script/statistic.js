$(document).ready(function() {
	$.ajax({
		url: "StatisticController",
		data: { op: "load" },
		method: 'POST',
		success: function(data) {
			console.log(data[0]);
			console.log("ddd");
			console.log(data[1]);
			

			var marque = [];
			var machine = [];

			for (var i in data[1]) {
				marque.push("Marque: " + data[1][i].marque.libelle);
				machine.push(data[1][i].count);
			}
		
			
			$("#nombreMachine").html(data[0]);
			console.log(data[2]);
			$("#nombreMarque").html(data[2]);
			console.log(data[2]);
			var chartdata = {
				labels: marque,
				datasets: [
					{
						label: 'Marque',
						backgroundColor: '#000',
						borderColor: '#444',
						hoverBackgroundColor: 'rgba(255,255,255, 0.9)',
						hoverBorderColor: 'rgba(0,0,0,0.75)',
						data: machine,
					}
				]
			}
			var ctx = $("#mycanvas");
			var barGraph = new Chart(ctx, {
				type: 'bar',
				data: chartdata
			})
			
			var ctx1 = $("#mycanvas1");
			var barGraph = new Chart(ctx1, {
				type: 'line',
				data: chartdata
			})
			
			var ctx2 = $("#mycanvas2");
			var barGraph = new Chart(ctx2, {
				type: 'doughnut',
				data: chartdata
			})
		},
		error: function(data) {
			console.log(data);
		}
	});


});