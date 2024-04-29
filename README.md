# Controle de Vendas e Estoque - Backend
Este projeto é uma aplicação de controle de vendas e estoque desenvolvida com JAVA Spring Boot.

### Tecnologias Utilizadas
* Java
* Spring Boot
* PostgreSQL
* JdbcTemplate

### Funcionalidades
* Registro e gerenciamento de vendas
* Registro e gerenciamento de produtos
* Interação com o frontend para comunicação de dados

### Como Executar
* Certifique-se de ter o JDK e o Maven instalados.
* Clone este repositório.
* Configure o arquivo application.properties com as credenciais do banco de dados.
* Abra o terminal na pasta do projeto.
* Execute mvn clean install para compilar o projeto.
* Execute mvn spring-boot:run para iniciar o servidor.
* Clone e execute o projeto [`Front-end`](https://github.com/felipesousa7/controle-estoque-vendas-front)

### Estrutura do Projeto
* model: Classes de modelo, como Sale e Product.
* repositories: Repositórios para acesso aos dados.
* services: Serviços para lógica de negócios.
* controllers: Controladores REST para endpoints da API.

### Endpoints Disponíveis
* GET /api/sales - Lista todas as vendas.
* POST /api/sales - Cria uma nova venda.
* GET /api/sales/{id} - Obtém os detalhes de uma venda específica.
* PUT /api/sales/{id} - Atualiza uma venda existente.
* DELETE /api/sales/{id} - Remove uma venda.
