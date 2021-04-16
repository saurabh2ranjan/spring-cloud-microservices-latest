# spring-cloud-microservices-latest

# To start the vault server - copy the details of Root Token.

`λ vault server -dev

s.Kcxhgo63Lw0WEe0SCETwRap4`

# Configure DB credentials in vault

`
C:\Users\pc\Desktop\Programming_Techie\spring-cloud-microservices-latest\spring-cloud-microservices-using-vault (event-bus -> origin)
λ vault kv put secret/product-service @product-service.json
Key              Value
---              -----
created_time     2021-04-16T16:06:01.9892796Z
deletion_time    n/a
destroyed        false
version          1

C:\Users\pc\Desktop\Programming_Techie\spring-cloud-microservices-latest\spring-cloud-microservices-using-vault (event-bus -> origin)
λ vault kv put secret/order-service @order-service.json
Key              Value
---              -----
created_time     2021-04-16T16:06:25.3085222Z
deletion_time    n/a
destroyed        false
version          1
`

# Start the Keycloak 

`
C:\Users\pc\Desktop\Microservices Softwares\keycloak-12.0.4\keycloak-12.0.4\bin
λ standalone.bat -Djboss.http.port=8180
`

# Keycloak UI

http://localhost:8081

# Sequences to start the services

`
1) discovery-service
2) configuration-server
3) order-service (make sure MySQL DB is up)
4) product-service (make sure MongoDB is up)
5) gateway-service
`

![Diagram](https://user-images.githubusercontent.com/54174687/115062603-26890200-9f08-11eb-94e3-c58e32f4581d.PNG)

