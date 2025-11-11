# 2025 SpringBoot DevStarter

A zero-setup Spring Boot starter project designed for instant local development.
Automatically spins up a PostgreSQL container via Testcontainers, supports frictionless CRUD development

---
### ⚙️ Stack Overview
| Dependency                                                   | Description                                                                                                                                       |
| ------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`org.springframework.boot:spring-boot-starter-web`**       | Embedded Tomcat server, Spring MVC framework, `@RestController`, routing, and JSON serialization (via Jackson).                                   |
| **`org.springframework.boot:spring-boot-starter-data-jdbc`** | Spring’s JDBC abstraction layer providing `JdbcTemplate`, `NamedParameterJdbcTemplate`, transaction management, and repository autoconfiguration. |
| **`org.springframework.boot:spring-boot-starter-test`**      | JUnit 5, Spring TestContext framework, AssertJ, Mockito, and Hamcrest for unit and integration testing.                                           |
| **`org.testcontainers:testcontainers`**                      | Core Testcontainers library for running and managing Docker containers directly from Java.                                                        |
| **`org.testcontainers:postgresql`**                          | Ready-made Testcontainers module that spins up a PostgreSQL instance automatically for development or testing.                                    |


---

### 🧠 Goal

To serve as a developer-first template where:

- No manual DB setup is required

- Testcontainers auto-provisions PostgreSQL

- Maven handles dependency management and build

- DevTools auto-refresh (coming next) ensures near-instant feedback loops
---

This project represents the bare minimum sane template for modern Spring Boot development in 2025.



---

## Opentelemetry

Download
```sh
curl -L -O https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar
```

Build your project
```sh
./mvnw clean package -DSkipTests
```

Set agent path and config file path
```sh
OTEL_JAVAAGENT_CONFIGURATION_FILE=telemetry.properties \
java -javaagent:./opentelemetry-javaagent.jar \
     -jar target/demo-0.0.1-SNAPSHOT.jar
```