// Function to handle the button click and navigate to the specified URL
function navigateToHome() {
    window.location.href = "../pages/supervisor-dashboard.html";
}

// Attach the function to the button click event
document.getElementById("homeButton").addEventListener("click", navigateToHome);
