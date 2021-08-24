# Jumia Exercise Spring Boot (Back-end) services.


# Overview
This project is a Spring Boot Framwork backend REST APIs using CRUD to Integrate with (SQLite 3) DB to get a list of phone numbers and categorizing this list by country, state, country code and number.

# Main technology stack

* Java 1.8+
* Spring Boot 2.5.x
* Maven 4
* SQlite3 (CRUD+SQLiteDialect)
* Dockerfile (for the ability to build the project in a docker image)

# Preparation

Please must install Java 1.8 or even higher version

# Usage

* Clone Repository
```
git clone https://github.com/omosttafa/jumia-exercise-springboot-backend.git
cd jumia-exercise-springboot-backend
```

* Run back-end server on local machine
```
cd jumia-exercise-api/target/
java -jar jumia-exercise-api.jar 
```

* Run back-end server on docker
```
docker build -t jumia-exercise-api.jar .
docker run -p 9090:8080 jumia-exercise-api.jar
```


```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.5.4)

2021-08-24 15:18:07.778  INFO 28124 --- [           main] com.jumia.JumiaExerciseApiApplication    : Starting JumiaExerciseApiApplication using Java 16.0.2 on Omar-Mostafa with PID 28124 (O:\WORK\JUMIA\Workspace\jumia-exercise-api\target\classes started by lenovo in O:\WORK\JUMIA\Workspace\jumia-exercise-api)
2021-08-24 15:18:07.782  INFO 28124 --- [           main] com.jumia.JumiaExerciseApiApplication    : No active profile set, falling back to default profiles: default
2021-08-24 15:18:09.020  INFO 28124 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2021-08-24 15:18:09.119  INFO 28124 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 85 ms. Found 1 JPA repository interfaces.
2021-08-24 15:18:10.260  INFO 28124 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2021-08-24 15:18:10.282  INFO 28124 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2021-08-24 15:18:10.297  INFO 28124 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.52]
2021-08-24 15:18:10.604  INFO 28124 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2021-08-24 15:18:10.604  INFO 28124 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2752 ms
2021-08-24 15:18:11.020  INFO 28124 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2021-08-24 15:18:11.260  INFO 28124 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2021-08-24 15:18:11.357  INFO 28124 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2021-08-24 15:18:11.440  INFO 28124 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.4.32.Final
2021-08-24 15:18:11.665  INFO 28124 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
2021-08-24 15:18:11.825  INFO 28124 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: com.jumia.db.configurations.SQLiteDialect
2021-08-24 15:18:12.496  INFO 28124 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2021-08-24 15:18:12.507  INFO 28124 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2021-08-24 15:18:12.927  WARN 28124 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2021-08-24 15:18:13.687  INFO 28124 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-08-24 15:18:13.703  INFO 28124 --- [           main] com.jumia.JumiaExerciseApiApplication    : Started JumiaExerciseApiApplication in 6.89 seconds (JVM running for 7.697)

```

## REST APIs

After running the back-end server there will be two REST APIs available to consume:

## getAllCustomers() API
 
  To get the list of all customers phone numbers and return it as JSON response.

```
(GET) /customers 
```

* Request Example (Considering running on localhost)
```
http://localhost:8080/customers/
```

* Response Example
```
[
    {
        "id": "0",
        "name": "Walid Hammadi",
        "phone": "(212) 6007989253"
    },
    {
        "id": "1",
        "name": "Yosaf Karrouch",
        "phone": "(212) 698054317"
    },
    {
        "id": "2",
        "name": "Younes Boutikyad",
        "phone": "(212) 6546545369"
    },
    ..
    ..
]
```

## getCustomersFromCountry() API

  To get the list of phone numbers from DB and validate the numbers by a country regex pattern to identify the valid and not valid numbers. The validation result and country code is being added/included to the response JSON to represent the full list of customers phone numbers including the valid and not valid numbers.

```
(GET) /customers/{country}
```

* Request Examples
```
http://localhost:8080/customers/cameron
http://localhost:8080/customers/ethiopia
http://localhost:8080/customers/morocco
http://localhost:8080/customers/mozambique
http://localhost:8080/customers/mozambique
```

* Response Example (/morocco)
```
[
    {
        "id": "0",
        "name": "Walid Hammadi",
        "phone": "(212) 6007989253",
        "validation": "not valid",
        "countryCode": "+212"
    },
    {
        "id": "1",
        "name": "Yosaf Karrouch",
        "phone": "(212) 698054317",
        "validation": "valid",
        "countryCode": "+212"
    },
    ..
    ..
]
```

## Conclusion

* By running this Spring Boot backend it means there are running mircoservices represented through REST APIs ready for Frontend application to use.
* After building and running the backend APIs and testing the requests/responses, you can move forward to the frontend application mentioned in the related projects below.
* Frontend Application is implemented using VUE.JS Framework.

## Related Projects
[Jumia Exercise VUE.JS Frontend](https://github.com/omosttafa/jumia-exercise-vuejs-frontend)
