# Steps 

This project is developed using Spring Boot Microservices architecture. In this example - we've used below technologies
- Spring Boot v2.4.2
- Spring Cloud API Gateway
- Spring Cloud Config
- Resilient4J
- Keyloak
- Hashicorp Vault
- Spring Security - OAuth2 Client and Resource Server
- Eureaka
- MySQL
- MongoDB
- Java 15

# Enable Hashicorp Vault Locally

This tutorial doesn't cover setup of Hashicorp locally
- Start the Hashicorp

```curl
λ vault server -dev

The unseal key and root token are displayed below in case you want to
seal/unseal the Vault or re-authenticate.

Unseal Key: 18U94gZePd3Ex/TeRKWWZSfj+HVnYU2K73CWtSIYMy4=
Root Token: s.odPBOcpylPfST9NO6pmTA1yP
```

Then execute the below steps

```curl
C:\Users\pc\Desktop\CQRS\springboot-microservices-project\Data (master -> origin)
λ vault kv put secret/order-service @order-service.json
Key              Value
---              -----
created_time     2021-05-13T07:15:40.1103065Z
deletion_time    n/a
destroyed        false
version          1

C:\Users\pc\Desktop\CQRS\springboot-microservices-project\Data (master -> origin)
λ vault kv put secret/product-service @product-service.json
Key              Value
---              -----
created_time     2021-05-13T07:15:43.7050413Z
deletion_time    n/a
destroyed        false
version          1

C:\Users\pc\Desktop\CQRS\springboot-microservices-project\Data (master -> origin)
λ vault kv put secret/inventory-service-credentials @inventory-service-credentials.json
Key              Value
---              -----
created_time     2021-05-13T07:16:13.7870986Z
deletion_time    n/a
destroyed        false
version          1

```

# Start the keyloak

User created in the keyloak - Username - testuser , password - test

```
C:\Users\pc\Desktop\Microservices Softwares\keycloak-12.0.4\keycloak-12.0.4\bin>standalone.bat -Djboss.http.port=8180
```

![image](https://user-images.githubusercontent.com/54174687/118106551-5a6a2100-b3fb-11eb-90a2-0062f317f250.png)

![image](https://user-images.githubusercontent.com/54174687/118106596-62c25c00-b3fb-11eb-93e0-13fdf9e33df3.png)

![image](https://user-images.githubusercontent.com/54174687/118106615-66ee7980-b3fb-11eb-8626-64dbb00497b8.png)

![image](https://user-images.githubusercontent.com/54174687/118106623-69e96a00-b3fb-11eb-9ca4-4deca460dc3f.png)

![image](https://user-images.githubusercontent.com/54174687/118106634-6c4bc400-b3fb-11eb-97e4-206cad014b91.png)

![image](https://user-images.githubusercontent.com/54174687/118106645-6eae1e00-b3fb-11eb-8e93-3f8540ad8a78.png)



Please make a note of `Root Token` and replace this token value for property `spring.cloud.vault.token`.

# Sequence To Start the Services
- discovery-server
- configuration-server
- product-service
- order-service
- inventory-service
- notification-service
- api-gateway-service


![image](https://user-images.githubusercontent.com/54174687/118103619-bf237c80-b3f7-11eb-9522-649e5ce495ea.png)

# Eureka Dashboard
http://localhost:8761/

![image](https://user-images.githubusercontent.com/54174687/118105592-34904c80-b3fa-11eb-86c2-c6829489aab6.png)




# Architecture Diagram - 

![image](https://user-images.githubusercontent.com/54174687/118103295-6358f380-b3f7-11eb-8ee8-c767ff93c3fe.png)

# How to test the app

- http://localhost:8080/api/product - put this url in browser

![image](https://user-images.githubusercontent.com/54174687/118107202-19264100-b3fc-11eb-9ce5-31e5ec9956d8.png)

Put username and password as testuser/test

![image](https://user-images.githubusercontent.com/54174687/118107307-378c3c80-b3fc-11eb-9c2f-4735255dae02.png)


![image](https://user-images.githubusercontent.com/54174687/118109099-5f7c9f80-b3fe-11eb-81ae-8f238b1b5e10.png)



