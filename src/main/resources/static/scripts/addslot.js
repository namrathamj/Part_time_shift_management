document.addEventListener('DOMContentLoaded', function () {
    var form = document.getElementById('shiftForm');
    form.addEventListener('submit', function (event) {
        event.preventDefault();

        var department = document.getElementById('department').value;
        var timeFrom = document.getElementById('time-from').value;
        var timeTo = document.getElementById('time-to').value;
        var capacity = parseInt(document.getElementById('capacity').value, 10);

        // Create a shift object
        var shift = {
            startTime: timeFrom,
            endTime: timeTo,
            type: department, // Use "Department" as the "type" field
            capacity: capacity,
            id: null // Let the server generate the ID
        };

        // Call the API to create a shift
        createShift(shift);
    });

    function createShift(shift) {
        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        var requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: JSON.stringify(shift),
            redirect: 'follow'
        };

        fetch("http://localhost:8080/private/api/shifts", requestOptions)
            .then(response => response.json())
            .then(result => {
                // Handle the success response
                console.log(result);
                alert('Shift added successfully!');
            })
            .catch(error => {
                // Handle the error
                console.log('error', error);
                alert('Error adding shift. Please try again.');
            });
    }
});
