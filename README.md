# api-java-de-crud-de-produtos-criada-pelo-copilot-cli

Projeto Spring Boot de exemplo com CRUD de produtos.

Build & run locally:

Opção 1 — executar com Maven (execução direta):
mvn spring-boot:run

Opção 2 — empacotar e executar jar:
mvn -DskipTests package
java -jar target/products-api-0.0.1-SNAPSHOT.jar

(para rodar em background no PowerShell):
Start-Process -NoNewWindow -FilePath 'java' -ArgumentList '-jar','target\\products-api-0.0.1-SNAPSHOT.jar'

Teste simples (PowerShell):
Invoke-RestMethod http://localhost:8080/products

Testes:

mvn test

Docker:

docker build -t products-api .
docker run -p 8080:8080 products-api
