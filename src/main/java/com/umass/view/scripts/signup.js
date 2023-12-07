function signUp() {
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var domain = email.substring(email.lastIndexOf("@") + 1);
    if (domain !== "umass.edu") {
        alert("Enter a valid email ID");
        return false;
    }

    var password = document.getElementById("psw").value;
    var passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    if (!passwordRegex.test(password)) {
        alert("Password must contain at least 1 capital letter, 1 number, one symbol, and should be at least 8 characters long.");
        return false;
    }

    // Store user data in localStorage
    var userData = {
        name: name,
        password: password
    };
    localStorage.setItem(email, JSON.stringify(userData));

    alert("Signup successful!");
    window.location.href = "../pages/login.html";
}

document.getElementById("signupButton").addEventListener("click", signUp);
