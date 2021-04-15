http://localhost:8888/product-service/default

```
{
    "name": "product-service",
    "profiles": [
        "default"
    ],
    "label": null,
    "version": "e40bd379101ec860378eecf2e40c65b2745ec00a",
    "state": null,
    "propertySources": [
        {
            "name": "https://github.com/javaHelper/microservices-config-server/file:C:\\Users\\pc\\AppData\\Local\\Temp\\config-repo-8472806513291709286\\product-service.properties",
            "source": {
                "test.name": "test1"
            }
        }
    ]
}
```

http://localhost:8888/product-service/prod


```
{
    "name": "product-service",
    "profiles": [
        "prod"
    ],
    "label": null,
    "version": "e40bd379101ec860378eecf2e40c65b2745ec00a",
    "state": null,
    "propertySources": [
        {
            "name": "https://github.com/javaHelper/microservices-config-server/file:C:\\Users\\pc\\AppData\\Local\\Temp\\config-repo-8472806513291709286\\product-service.properties",
            "source": {
                "test.name": "test1"
            }
        }
    ]
}
```


http://localhost:8081/api/test

```
test1
```

```
curl -X POST \
  http://localhost:8900/api/product \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: c49cc7ad-325e-32fe-9a7d-f37fb8b1be73' \
  -d '{
	"name" : "iPhone 12",
	"description" : "iPhone 12 Gold",
	"price": 1230
}'
```

GET => http://localhost:8900/api/product

POST => http://localhost:8081/actuator/refreshbus

# Swagger URL

http://localhost:8081/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config