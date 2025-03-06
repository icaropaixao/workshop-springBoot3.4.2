# Webservice Project 🛒

Este é um projeto Spring Boot que implementa um serviço web para gerenciar usuários, pedidos, produtos, categorias e pagamentos. O projeto utiliza JPA (Java Persistence API) para persistência de dados e o banco de dados H2 para desenvolvimento e testes.

## Tecnologias Utilizadas 🔧

- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Spring Data JPA**: Facilita a integração com bancos de dados relacionais.
- **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
- **Maven**: Gerenciador de dependências e build do projeto.
- **Java 21**: Versão do Java utilizada no projeto.

## Estrutura do Projeto 🗂️

### Entidades (`entities`)
- **User**: Usuários do sistema.
- **Order**: Pedidos realizados.
- **Product**: Produtos disponíveis.
- **Category**: Categorias de produtos.
- **OrderItem**: Itens de pedidos.
- **Payment**: Pagamentos associados a pedidos.
- **OrderStatus**: Status dos pedidos (WAITING_PAYMENT, PAID, SHIPPED).

### Serviços (`services`)
- **UserService**: Lógica de negócio para `User` (CRUD).
- **OrderService**: Lógica de negócio para `Order` (CRUD e cálculo de total).
- **ProductService**: Lógica de negócio para `Product` (CRUD).
- **CategoryService**: Lógica de negócio para `Category` (CRUD).

### Controladores (`resources`)
- **UserResource**: Endpoints REST para `User` (GET, POST, PUT, DELETE).
- **OrderResource**: Endpoints REST para `Order` (GET).
- **ProductResource**: Endpoints REST para `Product` (GET).
- **CategoryResource**: Endpoints REST para `Category` (GET).

### Exceções (`exceptions`)
- **ResourceNotFoundException**: Exceção para recursos não encontrados.
- **DatabaseException**: Exceção para erros de banco de dados.
- **ResourceExceptionHandler**: Manipulador de exceções globais.
- **StandardError**: Modelo de resposta para erros.

## Endpoints da API 📶

### Usuários (`/users`)
- **GET `/users`**: Retorna todos os usuários.
- **GET `/users/{id}`**: Retorna um usuário pelo ID.
- **POST `/users`**: Cria um novo usuário.
- **PUT `/users/{id}`**: Atualiza um usuário existente.
- **DELETE `/users/{id}`**: Remove um usuário.

### Pedidos (`/orders`)
- **GET `/orders`**: Retorna todos os pedidos.
- **GET `/orders/{id}`**: Retorna um pedido pelo ID.

### Produtos (`/products`)
- **GET `/products`**: Retorna todos os produtos.
- **GET `/products/{id}`**: Retorna um produto pelo ID.

### Categorias (`/category`)
- **GET `/category`**: Retorna todas as categorias.
- **GET `/category/{id}`**: Retorna uma categoria pelo ID.

## Como Executar o Projeto 🔑

1. **Pré-requisitos**:
   - Java 21 instalado.
   - Maven instalado.

2. **Clone o repositório**:
   ```bash
   https://github.com/icaropaixao/workshop-springBoot3.4.2.git
   
3. **Compile e execute o projeto**:
   ```bash
   mvn clean install
   mvn spring-boot:run

4. **Acesse a aplicação**:

   - **A aplicação estará disponível em http://localhost:8080**
   - **Para acessar o console do H2 Database, acesse http://localhost:8080/h2-console**


## ✒️ Autor

  <strong>Ícaro Reis da Paixão</strong> <a href="https://www.linkedin.com/in/ícaro-reis-dev" target="_blank"> <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn"></a>                                                                                                                                                                           
 
