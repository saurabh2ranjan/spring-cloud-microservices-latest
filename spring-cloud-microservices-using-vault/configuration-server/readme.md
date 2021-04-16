http://localhost:8888/order-service/default

```
{
    "name": "order-service",
    "profiles": [
        "default"
    ],
    "label": null,
    "version": "8c839fff211b6f08378b2e6693e4e6dd2c2dc7f9",
    "state": null,
    "propertySources": [
        {
            "name": "https://github.com/javaHelper/microservices-config-server/file:C:\\Users\\pc\\AppData\\Local\\Temp\\config-repo-9553752730842986097\\order-service.properties",
            "source": {
                "spring.datasource.url": "jdbc:mysql://localhost:3306/order-service",
                "spring.datasource.driver-class-name": "com.mysql.cj.jdbc.Driver",
                "spring.jpa.properties.hibernate.dialect": "org.hibernate.dialect.MySQL8Dialect",
                "spring.jpa.hibernate.ddl-auto": "update",
                "spring.datasource.initialization-mode": "always",
                "spring.jpa.show-sql": "true"
            }
        }
    ]
}
```


http://localhost:8888/order-service/prod

```
{
    "name": "order-service",
    "profiles": [
        "prod"
    ],
    "label": null,
    "version": "8c839fff211b6f08378b2e6693e4e6dd2c2dc7f9",
    "state": null,
    "propertySources": [
        {
            "name": "https://github.com/javaHelper/microservices-config-server/file:C:\\Users\\pc\\AppData\\Local\\Temp\\config-repo-9553752730842986097\\order-service.properties",
            "source": {
                "spring.datasource.url": "jdbc:mysql://localhost:3306/order-service",
                "spring.datasource.driver-class-name": "com.mysql.cj.jdbc.Driver",
                "spring.jpa.properties.hibernate.dialect": "org.hibernate.dialect.MySQL8Dialect",
                "spring.jpa.hibernate.ddl-auto": "update",
                "spring.datasource.initialization-mode": "always",
                "spring.jpa.show-sql": "true"
            }
        }
    ]
}
```


http://localhost:8888/product-service/default


```
{
    "name": "product-service",
    "profiles": [
        "default"
    ],
    "label": null,
    "version": "8c839fff211b6f08378b2e6693e4e6dd2c2dc7f9",
    "state": null,
    "propertySources": [
        {
            "name": "https://github.com/javaHelper/microservices-config-server/file:C:\\Users\\pc\\AppData\\Local\\Temp\\config-repo-9553752730842986097\\product-service.properties",
            "source": {
                "test.name": "test"
            }
        }
    ]
}
```

```
C:\Users\pc\Documents\workspace-MS\order-service
λ vault kv put secret/order-service @order-service.json	
Key              Value
---              -----
created_time     2021-04-13T14:24:43.7058846Z
deletion_time    n/a
destroyed        false
version          1
```

Another

```
C:\Users\pc\Documents\workspace-MS\product-service
λ vault kv put secret/product-service @product-service.json
Key              Value
---              -----
created_time     2021-04-13T14:25:39.7764197Z
deletion_time    n/a
destroyed        false
version          1
```

```
C:\Users\pc\Documents\workspace-MS\product-service
λ vault kv get secret/order-service
====== Metadata ======
Key              Value
---              -----
created_time     2021-04-13T14:24:43.7058846Z
deletion_time    n/a
destroyed        false
version          1

=============== Data ===============
Key                           Value
---                           -----
spring.datasource.password    root
spring.datasource.username    root
```


```
C:\Users\pc\Documents\workspace-MS\product-service
λ vault kv get secret/product-service
====== Metadata ======
Key              Value
---              -----
created_time     2021-04-13T14:25:39.7764197Z
deletion_time    n/a
destroyed        false
version          1

============= Data =============
Key                        Value
---                        -----
spring.data.mongodb.uri    mongodb://localhost:27017/product-service
```



> start the keyclock - 

C:\Users\pc\Desktop\Microservices Softwares\keycloak-12.0.4\keycloak-12.0.4\bin
λ standalone.bat -Djboss.http.port=8180

http://localhost:8081