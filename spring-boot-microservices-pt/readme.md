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

Please make a note of `Root Token` and replace this token value for property `spring.cloud.vault.token`.

# Sequence To Start the Services
- discovery-server
- configuration-server
- prodict-service
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
