
document.addEventListener('DOMContentLoaded', function () {
    // Wait for the DOM content to be fully loaded

    // Find the form and attach a submit event listener
    var form = document.querySelector('.add-slots form');
    form.addEventListener('submit', function (event) {
        // Prevent the default form submission behavior
        event.preventDefault();

        // Get the values from the form
        var department = document.getElementById('department').value;
        var timeFrom = document.getElementById('time-from').value;
        var timeTo = document.getElementById('time-to').value;

        // Save the slots to local storage
        saveSlots(department, timeFrom, timeTo);

        // Show an alert indicating successful slot addition
        alert('Slot added successfully!');
    });

    // Function to save slots to local storage
    function saveSlots(department, timeFrom, timeTo) {
        // Get existing slots from local storage or initialize an empty array
        var existingSlots = JSON.parse(localStorage.getItem('slots')) || [];

        // Add the new slot to the array
        var newSlot = {
            department: department,
            timeFrom: timeFrom,
            timeTo: timeTo
        };
        existingSlots.push(newSlot);

        // Save the updated array back to local storage
        localStorage.setItem('slots', JSON.stringify(existingSlots));
    }
});