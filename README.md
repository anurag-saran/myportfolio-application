# myportfolio-application

customer-service : 8086
account-service : 8084
portfolio-service : 8085
stockprice-service : 8083

## Start Minikube
```
minikube start --cpus 4  --memory 8192
Build each app 
mvn clean install -DskipTests
```
## Run Spring App and apply correcrt profile
```
-Dspring.profiles.active=production
./mvnw spring-boot:run -Dspring.profiles.active=standalone
cd ../Stock
java -jar target/stock-20.06.1-SNAPSHOT.jar -Dspring.profiles.active=standalone
```
## Build containers
```
⋅⋅⋅ cd ../portfolio
⋅⋅⋅ mvn clean install -DskipTests
⋅⋅⋅ docker build --tag portfolio:1.6 -f src/main/docker/Dockerfile .
⋅⋅⋅ cd ../account
⋅⋅⋅ mvn clean install -DskipTests
⋅⋅⋅ docker build --tag account:1.6 -f src/main/docker/Dockerfile .
⋅⋅⋅ cd ../customer/
⋅⋅⋅ mvn clean install -DskipTests
⋅⋅⋅ docker build --tag customer:1.6 -f src/main/docker/Dockerfile .
⋅⋅⋅ cd ../stock/
⋅⋅⋅ mvn clean install -DskipTests
⋅⋅⋅ docker build --tag stock:1.6 -f src/main/docker/Dockerfile .
⋅⋅⋅ cd ../photo-service/
⋅⋅⋅ mvn clean install -DskipTests
⋅⋅⋅ docker build --tag photo:1.6 -f src/main/docker/Dockerfile .
⋅⋅⋅ cd ../service-ui
⋅⋅⋅ ng build
⋅⋅⋅ docker build --tag webui:1.6 -f Dockerfile .
⋅⋅⋅ docker build -t service-ui-image .
```
##Docker Setup
### create network
docker network create -d bridge myservice
### cusomter service container
docker container run --network myservice --name customer-container -d -p 8086:8086 customer:1.4
### portfolio service container
docker container run --network myservice --name portfolio-container -d -p 8085:8085 portfolio:1.4
### stock service container
docker container run --network myservice --name stock-container -d -p 8083:8083 stock:1.4
### account service container
docker container run --network myservice --name account-container -d -p 8087:8087 account:1.4
### photo service container
docker container run --network myservice --name photo-container -d -p 8084:8084 photo:1.4
### account service container
docker run -ti -p 4200:4200 webui:1.4

## Run Docker containers
+ docker run -ti -p 8089:8085 portfolio:1.4
+ docker run -ti -p 8085:8085 portfolio:1.4
+ docker run -ti -p 8087:8087 account:1.4
+ docker run -ti -p 8086:8086 customer:1.4
+ docker run -ti -p 8083:8083 stock:1.4
+ docker run -ti -p 8084:8084 photo:1.4
+ docker run -ti -p 4200:4200 webui:1.4

## Tag Docker containers
+ docker tag customer:1.6 quay.io/asaran/customer:1.6
+ docker tag account:1.6 quay.io/asaran/account:1.6
+ docker tag stock:1.6 quay.io/asaran/stock:1.6
+ docker tag portfolio:1.6 quay.io/asaran/portfolio:1.6
+ docker tag photo:1.6 quay.io/asaran/photo:1.6
+ docker tag webui:1.6 quay.io/asaran/webui:1.6

## Push Docker containers
+ docker login quay.io
+ docker push quay.io/asaran/customer:1.6
+ docker push quay.io/asaran/account:1.6
+ docker push quay.io/asaran/stock:1.6
+ docker push quay.io/asaran/portfolio:1.6
+ docker push quay.io/asaran/photo:1.6
+ docker push quay.io/asaran/webui:1.6

## Run docker Command for frontend
+ docker build -t service-ui-image .
+ docker run --name service-ui-container -d -p 127.0.0.1:8088:80 service-ui-image

## View Docker Logs
+ docker logs -f a4b6f643ef70

## One liner to stop / remove all of Docker containers:
+ docker stop $(docker ps -a -q)
+ docker rm $(docker ps -a -q)
## Run docker Command for frontend
+ docker build -t service-ui-image .
+ docker run --name service-ui-container -d -p 127.0.0.1:8088:80 service-ui-image

## View Docker Logs
+ docker logs -f a4b6f643ef70
