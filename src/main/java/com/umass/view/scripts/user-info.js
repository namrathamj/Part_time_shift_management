function resetPassword() {
    var newPass = document.getElementById("new_passwd").value;
    var retypePass = document.getElementById("retype_passwd").value;

    if (newPass !== retypePass) {
        alert("Passwords don't match. Please retype correctly.");
    } else {
        alert("Reset successful!");
        // Additional code for password reset logic can be added here if needed
    }
}

document.getElementById("ResetButton").addEventListener("click", resetPassword);


