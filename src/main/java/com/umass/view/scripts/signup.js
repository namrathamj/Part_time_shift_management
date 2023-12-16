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

    var myHeaders = new Headers();
    myHeaders.append("Cookie", "JSESSIONID=5B49E558F62A692C4283277CE4E5A5D0");

    var formdata = new FormData();
    formdata.append("username", email);
    formdata.append("password", password);

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: formdata,
        redirect: 'follow'
    };

    fetch("http://localhost:8080/public/api/users", requestOptions)
        .then(response => response.text())
        .then(result => {
            if (result === "User registered successfully") {
                alert("Signup successful!");
                window.location.href = "/login";
            } else if (result === "USER ALREADY EXISTS") {
                alert("User already exists. Please use a different email or login.");
            } else {
                alert("Signup failed. Please try again later.");
            }
        })
        .catch(error => console.log('error', error));
}

document.getElementById("signupButton").addEventListener("click", signUp);
