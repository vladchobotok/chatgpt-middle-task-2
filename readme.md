# Weather Application

## Description
The Weather Application is a Spring Boot application that allows users to retrieve weather data for a specific city or zip code. The application integrates with the OpenWeatherMap API to fetch real-time weather data and persists it to a PostgreSQL database. It also includes a Spring Scheduler to periodically refresh weather data from the API.

## Prerequisites
Before running the Weather Application, make sure you have the following installed:
- Java JDK 11 or higher
- PostgreSQL (if not installed, you can use a cloud-hosted PostgreSQL service)
- OpenWeatherMap API key (sign up at https://openweathermap.org/ to obtain an API key)

## Setup and Configuration
1. Clone the repository or download the project as a zip file and extract it to your desired location.
2. Open the project in your preferred IDE or text editor.

### Configuration
1. Configure the PostgreSQL Database:
    - Create a PostgreSQL database for the application (e.g., "weather_app_db").
    - Update the database connection properties in the `application.properties` file, located in the `src/main/resources` directory:
      ```
      spring.datasource.url=jdbc:postgresql://your_postgresql_host:5432/weather_app_db
      spring.datasource.username=your_postgresql_username
      spring.datasource.password=your_postgresql_password
      ```
      Replace `your_postgresql_host`, `your_postgresql_username`, and `your_postgresql_password` with your actual PostgreSQL database credentials.

2. Configure the OpenWeatherMap API Key:
    - Sign up at https://openweathermap.org/ to obtain an API key.
    - In the `WeatherService` class, update the method `fetchAndSaveWeatherData()` to include your API key:
      ```
      public Weather fetchAndSaveWeatherData(String location) {
          WeatherData weatherData = weatherApiClient.getWeatherData(location, "your_openweathermap_api_key");
          // Rest of the code
      }
      ```
      Replace `"your_openweathermap_api_key"` with your actual OpenWeatherMap API key.

## Running the Application
1. Build the application using the following command:
    ```
   ./mvnw clean package
    ```

If you are on Windows, use `mvnw.cmd` instead of `./mvnw`.

2. Run the application using the following command:
    ```
   java -jar target/weather-application.jar
    ```

The application should now be running on `http://localhost:8080`.

## API Endpoints
- To retrieve weather data by city: `GET http://localhost:8080/weather/byCity/{city_name}`
- To retrieve weather data by zip code: `GET http://localhost:8080/weather/byZipCode/{zip_code}`

Replace `{city_name}` and `{zip_code}` with the desired city name or zip code.

## Contributions
Contributions to the Weather Application are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.

## License
This Weather Application is open-source and distributed under the MIT License. See the `LICENSE` file for details.

## Feedback

**Was it easy to complete the task using AI?**

    That was a bit challenging task. 

**How long did task take you to complete?**

    It took me around 2 hours.

**Was the code ready to run after generation? What did you have to change to make it usable?**

    Almost all the code was ready to run after generation, but if it wasn't, I just wrote more prompts to ChatGPT,
    with additional hints to him.

**Which challenges did you face during completion of the task?**

    Lack of knowledge of the ChatGPT.

**Which specific prompts you learned as a good practice to complete the task?**

    For example, step-by-step, error handling, testing and documentation prompts. 