# WeatherAppJava 🌤️

This is a simple Spring Boot application that fetches weather data using the OpenWeatherMap API and displays it via Thymeleaf templates.

## 🚀 Features

- Search for weather information by city name
- Uses OpenWeatherMap API for real-time data
- Simple web interface with Thymeleaf
- Proper error handling and validation



## 🔧 Technologies Used

- Java 17
- Spring Boot
- Thymeleaf
- OpenWeatherMap API
- Maven

## 📦 Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/srijana28/weatherapp.git
cd WeatherAppJava
```
### 2. Add Your OpenWeatherMap API Key

-To make this application work, you need an API key from OpenWeatherMap:
-Sign up at OpenWeatherMap and generate your API key.
-Open the file WeatherService.java.
-Find the line with the API URL and replace "your_api_key" with your actual key:

```bash
String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=your_api_key&units=metric";
```
### 3. Run the Application

You can run the application using Maven.
-Using Maven directly
```bash
mvn spring-boot:run
```
After it starts, open your browser and go to:

http://localhost:8080
Use the input field to search for the weather in your desired city.

### 🧪 Tests
To run tests:

```bash
mvn test
```


### 📄 License
This project is open-source and free to use.

### 🙌 Acknowledgements
-OpenWeatherMap API
-Spring Boot Documentation