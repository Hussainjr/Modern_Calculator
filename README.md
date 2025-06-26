# Modern Calculator Web Application

A responsive, modern calculator built with Spring Boot and Thymeleaf. Features a beautiful UI with dark mode, mobile support, and both web and REST-style endpoints.

## Features
- Modern, glassmorphism-inspired UI with dark mode toggle
- Fully responsive: works on desktop, tablet, and mobile
- Basic arithmetic operations: add, subtract, multiply, divide
- End-to-end DTO layer with ModelMapper integration
- Supports both form-based and REST-style endpoints

## Tech Stack
- Java 17
- Spring Boot 3
- Thymeleaf
- ModelMapper (DTO mapping)
- HTML5, CSS3 (responsive, modern design)

## Getting Started

### Prerequisites
- Java 17+
- Maven

### Setup
1. **Clone the repository:**
   ```bash
   git clone <your-repo-url>
   cd demo
   ```
2. **Build and run the application:**
   ```bash
   mvn spring-boot:run
   ```
3. **Open in your browser:**
   [http://localhost:8080/](http://localhost:8080/)

## Usage

### Web UI
- Use the calculator interface at [http://localhost:8080/](http://localhost:8080/)
- Toggle dark mode with the button in the top right
- Fully usable on all devices

### REST-style Endpoints

#### Addition (Path Variables)
```
GET /add/{a}/{b}
Example: http://localhost:8080/add/5/3
```
#### Subtraction (Request Parameters)
```
GET /subtract?number1=10&number2=4
Example: http://localhost:8080/subtract?number1=10&number2=4
```

#### (You can add similar endpoints for multiply/divide if needed)

## Project Structure
- `src/main/java/com/test/CalculatorController.java` — Controller with form and REST endpoints
- `src/main/java/com/test/CalculatorService.java` — Business logic
- `src/main/java/com/test/CalculatorRequestDTO.java` — Request DTO
- `src/main/java/com/test/CalculatorResponseDTO.java` — Response DTO
- `src/main/resources/templates/index.html` — Main UI (Thymeleaf)

## Customization
- UI and logic are easily extendable for scientific functions, history, or REST APIs
- Add more endpoints or JSON support as needed

## License
This project is for educational/demo purposes. Feel free to use and modify! 