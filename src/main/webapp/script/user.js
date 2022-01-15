$(document).ready(function() {
	function login() {
		if (document.getElementById("notificationRemplir").style.display == "block") {
			$("#notificationRemplir").css("display", "none");

		}
		if (document.getElementById("notificationRemplir2").style.display == "block") {
			$("#notificationRemplir2").css("display", "none");

		}
		if ($('#username').val() == "" && $('#password').val() == "") {
			$("#notificationRemplir").css("display", "block");
			return false;


		} else if ($('#username').val() == "") {
			$("#notificationRemplir").css("display", "block");
			return false;

		} else if ($('#password').val() == "") {
			$("#notificationRemplir").css("display", "block");
			return false;

		}

		var sdata = {
			username: $('#username').val(),
			password: $('#password').val()
		};
		$.ajax({
			url: "UserController",
			type: "POST",
			data: sdata,
			dataType: 'JSON',
			success: function(data) {

				if (data.status === true) {
					//alert("Login Sucess");
					window.location.replace("statistics.jsp");
				}
				else {
					$("#notificationRemplir2").css("display", "block");
					return false;
				}
			}
		})
	}
	$("#connect").click(function() {
		login();
	});
});