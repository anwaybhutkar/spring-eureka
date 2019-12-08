# spring-eureka
Micro-services POC using Spring Eureka.

There are two micro-services (Eureka Client / Discovery) are registered under Eureka Server. 
Eureka Server is configured with Zuul proxy which redirects weather or places related requests to respective micro-services.

- `Eureka Server`: Which registers all services and also act as a gateway which redirects requests to respective services.

- `places-service (Eureka Client / Discovery)`: Places service has details several places which are stored in `h2 database`. Places service calls weather service to get weather information of any particular place.

- `weather -service (Eureka Client / Discovery)`: Weather service use [open weather map](https://openweathermap.org) APIs to fetch weather information of place.

![System Design](/components.jpg)

## Setup
1. [Get your open map API key](https://openweathermap.org/appid)
2. Add your open weather map API key in `weather-service` `application.properties` under property `openweathermap.api.key`

## Run Application.
1. Run Eureka Server.
   - `mvn install`
   - `mvn spring-boot:run`
   
2. Run weather-service.
   - `mvn install`
   - `mvn spring-boot:run`
   
3. Run places-service.
   - `mvn install`
   - `mvn spring-boot:run`
   
- Once all services are up, it will be registered under Eureka Server and you can see all registered services on `http://localhost:8070`
- You can see all places along with weather details from Eureka Server (Gateway) on `http://localhost:8070/api/places-service/places` or directly access places-service `http://localhost:8071/places` as it is not yet behind any vpn.
- Same for weather, to get weather details of any place you can go through gateway `http://localhost:8070/api/weather-service/Pune/India` or directly access weather-service `http://localhost:8072/Pune/India`
 
