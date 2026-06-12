# api-java-de-crud-de-produtos-criada-pelo-copilot-cli

Projeto Spring Boot de exemplo com CRUD de produtos.

Build & run locally:

mvn package
java -jar target/products-api-0.0.1-SNAPSHOT.jar

Testes:

mvn test

Docker:

docker build -t products-api .
docker run -p 8080:8080 products-api
