// scripts.js
function login() {
    var email = document.getElementById("email").value;
    var password = document.getElementById("psw").value;

    // Get the user data from localStorage
    var storedData = JSON.parse(localStorage.getItem(email));

    // Check if the email exists in localStorage
    if (!storedData) {
        alert("Email not registered. Please sign up.");
        return false;
    }

    // Check if the entered password matches the stored password
    if (password !== storedData.password) {
        alert("Passwords don't match. Please try again.");
        return false;
    }

    alert("Login successful!");
    window.location.href = "../pages/user.html";
}

document.getElementById("loginButton").addEventListener("click", login);
