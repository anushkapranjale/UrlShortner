# URL Shortener

A URL Shortener web application built using Java, Spring Boot, MySQL, HTML, CSS, and JavaScript. It converts long URLs into short links, redirects users to the original URLs, and tracks link clicks.

## Features

* Shorten long URLs using unique 6-character alphanumeric codes.
* Return the existing short URL when the same original URL is submitted again.
* Redirect users to the original URL.
* Track the number of clicks on each short URL.
* Validate URLs and handle invalid inputs.
* Store URL details in a MySQL database.
* Handle errors for invalid or unavailable short codes.
* Add basic security headers to HTTP responses.
* Provide a simple web interface for URL shortening.

## Tech Stack

* **Language:** Java
* **Backend:** Spring Boot
* **Database:** MySQL
* **Frontend:** HTML, CSS, JavaScript
* **API:** REST API
* **Build Tool:** Maven
* **IDE:** IntelliJ IDEA

## How It Works

1. The user enters a URL in the web interface.
2. The frontend sends a POST request to the backend.
3. The backend validates the submitted URL.
4. The application checks whether the URL already exists in the database.
5. If the URL exists, its existing short URL is returned. Otherwise, a new short code is generated and saved.
6. When the short URL is opened, the application redirects the user to the original URL and updates the click count.

## API Endpoints

### 1. Create a Short URL

**Method:** `POST`

**Endpoint:** `/api/urls`

Request body:

```json
{
  "originalUrl": "https://www.google.com"
}
```

Example response:

```json
{
  "originalUrl": "https://www.google.com",
  "shortCode": "abc123",
  "shortUrl": "http://localhost:8080/r/abc123"
}
```

### 2. Redirect to Original URL

**Method:** `GET`

**Endpoint:** `/r/{shortCode}`

Example:

`http://localhost:8080/r/abc123`

The application redirects the user to the original URL and increments the click count.

## Database Configuration

The application uses MySQL with the database name `urlshortener` and a table named `urls`.

The table stores information such as:

* ID
* Original URL
* Short code
* Click count
* Creation timestamp

Configure your local MySQL connection in `src/main/resources/application.properties` before running the application.

**Security note:** Do not commit database passwords or other credentials to GitHub.

## How to Run Locally

### Prerequisites

* Java
* MySQL Server
* Maven (or the included Maven Wrapper)
* IntelliJ IDEA or another Java IDE

### Steps

1. Clone this repository.
2. Create a MySQL database named `urlshortener`.
3. Configure your database username and password in `application.properties`.
4. Run the Spring Boot application.
5. Open the application in your browser:

`http://localhost:8080/`

## Project Structure

```text
urlshortner/
├── src/
│   └── main/
│       ├── java/com/anushka/urlshortner/
│       │   ├── config/
│       │   ├── controller/
│       │   ├── dto/
│       │   ├── entity/
│       │   ├── exception/
│       │   ├── repository/
│       │   └── service/
│       └── resources/
│           ├── static/
│           │   ├── index.html
│           │   ├── style.css
│           │   └── script.js
│           └── application.properties
├── pom.xml
└── README.md
```

## Future Improvements

* Custom short URLs
* URL expiration
* QR code generation
* Detailed analytics dashboard
* Rate limiting
* User authentication
* Cloud deployment

## Author

**Anushka Pranjale**
