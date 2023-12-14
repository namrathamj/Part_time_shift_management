// scripts.js
function login() {
    var username = document.getElementById("email").value;
    var password = document.getElementById("psw").value;

    // Create an object to hold login credentials

var formdata = new FormData();
formdata.append("username", username);
formdata.append("password", password);

    // Make an AJAX request to the server for authentication
    fetch('/login', {
        method: 'POST',
        body: formdata,
    })
    .then(response => response.text())
  .then(result =>     window.location.href = "../pages/user.html")
  .catch(error => console.log('error', error));

}

document.getElementById("loginButton").addEventListener("click", function (event) {
    event.preventDefault(); // Prevent the form from submitting normally
    login(); // Call the login function
});
