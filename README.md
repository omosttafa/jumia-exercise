# Jumia Exercise Spring Boot backend services.


# Overview
This project is a Spring Boot backend REST APIs using CRUD to Integrate with (SQLite 3) DB to get a list of phone numbers and categorizing this list by country, state, country code and number.

## REST APIs

* /customers 

This is a GET REST API to get the list of phone numbers from DB and retrun it as JSON response.

```
http://localhost:8080/customers/
```

* /customer/{country}

This is a GET REST API to get the list of phone numbers from DB and validate the numbers by a specific regex pattern to identify the valid and not valid numbers. The validation result and country code is being added/included to the response JSON to represent the full list of customers phone numbers including the valid and not valid numbers.

```
http://localhost:8080/customers/cameron
http://localhost:8080/customers/ethiopia
http://localhost:8080/customers/morocco
http://localhost:8080/customers/mozambique
http://localhost:8080/customers/mozambique

```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
=======
# jumia-exercise-vuejs-frontend
