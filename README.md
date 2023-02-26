#Weather Check

Weather Check is a Spring Boot application that allows users to retrieve weather information by providing a pincode and date. The application makes use of an API to fetch weather data based on the user's input.

Features

Users can input a pincode and date to retrieve weather information.
The application makes use of an external API to fetch weather data.
The retrieved data is displayed in JSON format.


Installation

Clone the repository from GitHub:
git clone https://github.com/rajkumarDhumal/Weather-Check.git
Open the project in your preferred IDE.
Build and run the application.


Usage

To use the application, make a POST request to the /weather endpoint with the following payload:

json
{
    "pincode": "123456",
    "date": "2023-02-26"
}

pincode: The pincode for which weather information is required.
date: The date for which weather information is required. The date should be in YYYY-MM-DD format.
The application will return the weather information for the provided pincode and date in JSON format.


API Documentation

The application makes use of Swagger to provide API documentation. To view the documentation, navigate to http://localhost:8080/swagger-ui.html in your browser. This will display the API documentation page, where you can view the available endpoints and their descriptions.


Technologies Used

Spring Boot, 
Swagger, 
Java 
