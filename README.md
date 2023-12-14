Part_time_shift_management
A management system to handle part-time work shifts between employees and employers. It is a web-based application designed to streamline the scheduling and management of part-time shifts. It utilizes MongoDB as the database, Java for the backend logic, and HTML, CSS, and JavaScript for the user interface.

Getting Started:
#Prerequisites:
Install MongoDB:Ensure MongoDB is installed on your machine. 
Install Maven:
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
brew install maven
mvn -v
export PATH="/usr/local/Cellar/maven/<your_maven_version>/bin:$PATH"

Ensure that Maven is installed on your machine.


#Clone the repository:
git clone https://github.com/namrathamj/Part_time_shift_management
#Navigate to the Project Directory:
cd Part_time_shift_management/src/main/java/com/umass
Run the Application:
# Build the Java application
mvn clean install

# Run the application
mvn spring-boot:run
Access the Application:

Open your web browser and go to http://localhost:8080

Contributing:
Fork the repository.
Create a new branch for your feature: git checkout -b feature-name.
Commit your changes: git commit -m 'Add new feature'.
Push to the branch: git push origin feature-name.
Open a pull request to be reviewed before merging.
