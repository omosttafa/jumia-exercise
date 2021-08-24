# Jumia Exercise Spring Boot (Back-end) services.


# Overview
This project is a Spring Boot backend REST APIs using CRUD to Integrate with (SQLite 3) DB to get a list of phone numbers and categorizing this list by country, state, country code and number.

# Main technology stack

* Java 1.8+
* Spring Boot 2.5.x
* Maven
* SQlite3 (CRUD+SQLiteDialect)

# Preparation

Please must install Java 1.8 or even higher version

# Usage

* Run back-end server
```
cd jumia-exercise-api/target/
java -jar jumia-exercise-api.jar 
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

* /customers 


This is a GET REST API to get the list of phone numbers from DB and retrun it as JSON response.

Request Example
```
http://localhost:8080/customers/
```

Response Example
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

* /customers/{country}

This is a GET REST API to get the list of phone numbers from DB and validate the numbers by a specific regex pattern to identify the valid and not valid numbers. The validation result and country code is being added/included to the response JSON to represent the full list of customers phone numbers including the valid and not valid numbers.

* Request Examples
```
http://localhost:8080/customers/cameron
http://localhost:8080/customers/ethiopia
http://localhost:8080/customers/morocco
http://localhost:8080/customers/mozambique
http://localhost:8080/customers/mozambique
```

* Response Example
```
[
    {
        "id": "31",
        "name": "EMILE CHRISTIAN KOUKOU DIKANDA HONORE ",
        "phone": "(237) 697151594",
        "validation": "valid",
        "countryCode": "+237"
    },
    {
        "id": "32",
        "name": "MICHAEL MICHAEL",
        "phone": "(237) 677046616",
        "validation": "valid",
        "countryCode": "+237"
    },
    ..
    ..
]
```
