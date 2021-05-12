# How to setup project!

- Setup SQL in the MySQL DB.

```sql
use test;
create table department (
	department_id bigint not null auto_increment,
	department_address varchar(255),
	department_code varchar(255),
	department_name varchar(255),
	primary key (department_id)
) engine=InnoDB;

INSERT INTO `test`.`department` (`department_id`, `department_address`, `department_code`, `department_name`) VALUES ('1', '3rd Cross Street, Achalpur', 'AD-001', 'Advisory');
INSERT INTO `test`.`department` (`department_id`, `department_address`, `department_code`, `department_name`) VALUES ('2', '2nd West Street, Wood, Achalpur', 'TX-001', 'Tax');

create table user (
	user_id bigint not null auto_increment,
	department_id bigint,
	email varchar(255),
	first_name varchar(255),
	last_name varchar(255),
	primary key (user_id)
) engine=InnoDB;

INSERT INTO `test`.`user` (`user_id`, `department_id`, `email`, `first_name`, `last_name`) VALUES ('1', '1', 'john.doe@gmailcom', 'John', 'Doe');
INSERT INTO `test`.`user` (`user_id`, `department_id`, `email`, `first_name`, `last_name`) VALUES ('2', '1', 'pradnya.satpute@gmail.com', 'Pradnya', 'Satpute');
INSERT INTO `test`.`user` (`user_id`, `department_id`, `email`, `first_name`, `last_name`) VALUES ('3', '2', 'neha.parate@gmail.com', 'Neha', 'Parate');
INSERT INTO `test`.`user` (`user_id`, `department_id`, `email`, `first_name`, `last_name`) VALUES ('4', '2', 'harshita.dekate@gmail.com', 'Harshita', 'Dekate');
```

This project is developed using Spring Boot Microservices - uses below technologies

- Maven
- Spring Boot v2.4.2
- Spring Cloud API Gateway
- Spring Cloud Config
- Resilient4J
- OpenFeign
- MySQL

# Sequence To Start the Services

- service-registry
- cloud-config-server
- department-service
- user-service
- api-gateway
- admin-service


# Eureka Dashboard

- http://localhost:8761/

![image](https://user-images.githubusercontent.com/54174687/118023993-cc9b2100-b37b-11eb-9840-ffb7a2f3ebfa.png)



# Once You Deploy the App

- Execute the below statements via Postman or any Rest client.

Request

```curl
curl -X GET \
  http://localhost:9191/departments/1 \
  -H 'cache-control: no-cache' \
  -H 'postman-token: e5a32be1-f64f-b348-637e-8ea1fc594435'
```
Response

```
{
    "departmentId": 1,
    "departmentName": "Advisory",
    "departmentAddress": "3rd Cross Street, Achalpur",
    "departmentCode": "AD-001"
}
```

Request

```java
curl -X GET \
  http://localhost:9191/users/1 \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 6bd67ea7-d985-8ada-7327-e3c43099d8c3'
```

Response

```java
{
    "user": {
        "userId": 1,
        "firstName": "John",
        "lastName": "Doe",
        "email": "john.doe@gmailcom",
        "departmentId": 1
    },
    "department": {
        "departmentId": 1,
        "departmentName": "Advisory",
        "departmentAddress": "3rd Cross Street, Achalpur",
        "departmentCode": "AD-001"
    }
}
```

# To check if Config Server works

Resquest

```
http://localhost:9191/users/readKey
```

Response

```
{
    "name": "Prateek",
    "description": "Java Develoepr"
}
```



App Design - We've shown how to make the use of `RestTemplate` and `OpenFeign` to make the interservice communication.

![image](https://user-images.githubusercontent.com/54174687/118023124-ca849280-b37a-11eb-80db-11ba7107940a.png)
