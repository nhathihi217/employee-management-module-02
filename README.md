# Employee Management — Module 2: Custom Bean & IoC

Lab 2 demonstrates Spring-managed beans, the IoC container, and constructor-based dependency injection.

## Requirements

- JDK 17+
- Maven 3.6+

## Run

```bash
mvn spring-boot:run
```

The application runs at `http://localhost:8080`.

## Demonstration endpoints

Format a name using the `@Service`-managed `UtilityService`:

```bash
curl 'http://localhost:8080/api/employees/format-name?name=nguyen%20van%20an'
```

Create an employee preview. The `EmployeeService` uses the custom `ModelMapper` bean and `UtilityService` to map the request, normalize the name, and generate an employee code:

```bash
curl -X POST http://localhost:8080/api/employees/preview \
  -H 'Content-Type: application/json' \
  -d '{"fullName":"nguyen van an","email":"an@example.com"}'
```

Example response (the employee code is randomly generated):

```json
{
  "employeeCode": "NGU-1A2B3C4D",
  "fullName": "Nguyen Van An",
  "email": "an@example.com"
}
```

## Concepts shown

- `@Service` registers `UtilityService` and `EmployeeService` as Spring beans.
- `@Configuration` and `@Bean` register one reusable `ModelMapper` bean.
- Constructor injection supplies dependencies to `EmployeeService` and `EmployeeController` without field-level `@Autowired`.
- `EmployeeController` exposes the services through REST endpoints.

Run tests with `mvn test`.
