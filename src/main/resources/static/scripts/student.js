document.addEventListener('DOMContentLoaded', function () {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var startTime = "2023-12-05T15:29:00.000";
    var endTime = "2023-12-16T18:31:00.000";

    var apiUrl = `http://localhost:8080/private/api/shifts?startTime=${startTime}&endTime=${endTime}`;

    var requestOptions = {
        method: 'GET',
        headers: myHeaders,
        redirect: 'follow'
    };

    fetch(apiUrl, requestOptions)
        .then(response => response.json())
        .then(result => populateTimeSlots(result))
        .catch(error => console.log('error', error));

    function populateTimeSlots(shifts) {
        var slotContainer = document.getElementById("slotContainer");

        shifts.forEach(function (shift) {
            var radioBtn = document.createElement("input");
            radioBtn.type = "radio";
            radioBtn.id = "timeSlot" + shift.id;
            radioBtn.name = "timeSlot";
            radioBtn.value = shift.startTime + "-" + shift.endTime;

            var label = document.createElement("label");
            label.htmlFor = "timeSlot" + shift.id;
            label.textContent = shift.startTime + " to " + shift.endTime;

            slotContainer.appendChild(radioBtn);
            slotContainer.appendChild(label);
            slotContainer.appendChild(document.createElement("br"));
        });
    }

    document.getElementById("requestButton").addEventListener("click", function () {
        var selectedDepartment = document.getElementById("Department").value;

        var selectedTimeSlot = document.querySelector('input[name="timeSlot"]:checked');

        if (!selectedTimeSlot) {
            alert("Please select a time slot.");
            return;
        }

        var timeSlotValue = selectedTimeSlot.value;

        console.log("Department Selected: " + selectedDepartment);
        console.log("Time Slot Selected: " + timeSlotValue);

        alert("Request submitted for department: " + selectedDepartment + " and time slot: " + timeSlotValue);
    });
});
