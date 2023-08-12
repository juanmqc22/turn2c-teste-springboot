# teste-cliente-springboot

## Projeto de teste de cliente com Spring Boot


### Apresentando o Projeto:
https://www.loom.com/share/7b9486adc7ad416a88e80b68bfb74402?sid=85b927ac-942a-48e7-987e-f64c4732d52e

### Tecnologias e métodos utilizadas:
- Java
- Spring Boot
- Spring Data JPA
- Spring Web
- MySQL Database
- Lombok
- Maven
- Utilização de DTOs
- Utilização de exception handler

### Como executar o projeto:
- Clonar o repositório;
- Importar o projeto na IDE;
- Executar o projeto;
- Acessar o endereço: http://localhost:8080/clientes
- Utilizar o Postman/Insomnia para testar os endpoints
- Utilizar o MySQL Workbench para verificar os dados no banco de dados;

### Endereços

- `GET /clientes`: Retorna a lista de todos os clientes.
- `GET /clientes/{id}`: Retorna os detalhes do cliente com o ID especificado.
- `POST /clientes`: Cria um novo cliente.
- `PUT /clientes/{id}`: Atualiza os detalhes do cliente com o ID especificado.
- `DELETE /clientes/{id}`: Remove o cliente com o ID especificado.

### Endpoints:
#### Listar todos os clientes:
curl --location 'http://localhost:8080/clientes'
#### Listar cliente por id:
curl --location 'http://localhost:8080/clientes/1'


