function approveShift(shiftId) {
	var myHeaders = new Headers();
	myHeaders.append("Content-Type", "application/json");

	var raw = JSON.stringify([{
		"id": shiftId,
		"approverUsername": "ADMIN"
	}]);

	var requestOptions = {
		method: 'PUT',
		headers: myHeaders,
		body: raw,
		redirect: 'follow'
	};

	fetch("http://localhost:8080/private/bookings/status", requestOptions)
		.then(response => response.json())
		.then(result => {
			alert("Approved successfully");
			location.reload() ;
		});
}

document.addEventListener('DOMContentLoaded', function() {
	var myHeaders = new Headers();
	myHeaders.append("Content-Type", "application/json");

	var today = new Date();
	var formattedToday = today.toISOString().split('T')[0] + 'T00:00:00.000';

	var thirtyDaysFromNow = new Date();
	thirtyDaysFromNow.setDate(thirtyDaysFromNow.getDate() + 30);
	var formattedThirtyDaysFromNow = thirtyDaysFromNow.toISOString().split('T')[0] + 'T00:00:00.000';

	var raw = JSON.stringify({
		"startTime": formattedToday,
		"endTime": formattedThirtyDaysFromNow
	});

	var requestOptions = {
		method: 'POST',
		headers: myHeaders,
		body: raw,
		redirect: 'follow'
	};

	function fetchShiftsAndUpdateView() {
		fetch("http://localhost:8080/private/bookings/status.unapproved", requestOptions)
			.then(response => response.json())
			.then(result => displayShiftRequests(result))
			.catch(error => console.log('error', error));

		function displayShiftRequests(shifts) {
			var shiftRequestsDiv = document.getElementById("shiftRequests");

			shifts.forEach(function(shift, index) {
				var requestNumber = index + 1;

				var requestDiv = document.createElement("div");
				requestDiv.innerHTML = "<h3>Request no: " + requestNumber + "</h3>" +
					"<p>Name: " + shift.userId + "</p>" +
					"<p>Department: " + shift.type + "</p>" +
					"<p>Shift Timings: " + shift.startTime + " to " + shift.endTime + "</p>" +
					"<div class='buttons'>" +
					"<button onclick='approveShift(" + shift.id + ")'>APPROVE</button>" +
					"<button onclick='reject(" + shift.id + ")'>REJECT</button>" +
					"</div>";

				shiftRequestsDiv.appendChild(requestDiv);
			});
		}
	}

	fetchShiftsAndUpdateView();
});
