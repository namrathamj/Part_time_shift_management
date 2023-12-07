// scripts.js
document.getElementById("requestButton").addEventListener("click", function() {
    var selectedDepartment = document.getElementById("Department").value;

    var selectedTimeSlot = document.querySelector('input[name="timeSlot"]:checked');

    if (!selectedTimeSlot) {
        alert("Please select a time slot.");
        return;
    }

    var timeSlotValue = selectedTimeSlot.value;

    // You can perform further actions here based on the selected department and time slot
    console.log("Department Selected: " + selectedDepartment);
    console.log("Time Slot Selected: " + timeSlotValue);

    // For example, you can make an API call or perform other operations based on the selected values
    // This is just a placeholder for the functionality you might want to implement
    alert("Request submitted for department: " + selectedDepartment + " and time slot: " + timeSlotValue);
});
