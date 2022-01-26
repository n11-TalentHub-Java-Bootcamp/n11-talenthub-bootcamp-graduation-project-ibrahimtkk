# api-gateway-service

Netflix Zuul tabanlı api gateway servisi.

http://microservices.io/patterns/apigateway.html

## Derleme

### Build

```
./gradlew clean build
```

### Birim Testleri çalıştırmak

```
./gradlew clean test
```

### Entegrasyon Testlerini Çalıştırmak

```
./gradlew clean integrationTest
```


## Çalıştırma

Projeyi derlemek için

```
./gradlew clean fatJar
```

Derlenen projeyi çalıştırmak için

```
java -jar build/libs/api-gateway-service-all-1.0-SNAPSHOT.jar 
```

Derlenen projeyi development modunda çalıştırmak için

```
java -jar build/libs/api-gateway-service-all-1.0-SNAPSHOT.jar -p 8030 -d
```


## Servisin çalıştığını denemek için

```
curl -H "Content-Type: application/json" -X GET http://master.qa.ononay:8030
```
