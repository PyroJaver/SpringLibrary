

## Description

This is my pet project on Spring. I wanted to do library web application to learn Spring. I have used **Spring Boot**, **Spring MVC**, 
**Hibernate**, **PostgreSQL**,  for views I have used **Thymeleaf** template. For testing I have
used **JUnit**, 


## Data Base Configuration
During the development process, I used PostgreSQL. You should change the configuration in hibernate.properties to the
values corresponding to your database, and execute the following commands:
```sh
CREATE TABLE Person (
    id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    full_name varchar(100) NOT NULL UNIQUE,
    year_of_birth int NOT NULL
);
```
```sh
CREATE TABLE Book (
    id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    title varchar(100) NOT NULL,
    author varchar(100) NOT NULL,
    year int NOT NULL,
    person_id int REFERENCES Person(id) ON DELETE SET NULL,
    taken_at date
```


