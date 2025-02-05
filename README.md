# Stefanini - API para Registro de Tarefas

Este projeto é uma API para registro de tarefas, construída com Java 17, Spring Boot, Flyway, MapStruct e outros frameworks. Ele permite a interação com o banco de dados para registrar, gerenciar e listar tarefas.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Security**
- **Flyway para gerenciamento de migrações de banco de dados**
- **MapStruct para mapeamento de objetos**
- **Lombok para geração automática de código**
- **SQL Server (Microsoft)**

## Pré-requisitos

Antes de rodar o projeto, verifique se você possui os seguintes pré-requisitos:

- **Java 17** ou versão superior instalado na sua máquina.
- **Maven** instalado. Você pode verificar isso rodando o comando `mvn -v`.
- **Banco de dados SQL Server** configurado e em execução.

## Configuração do Projeto

### Passo 1: Clonar o Repositório

Clone este repositório na sua máquina local:

```bash
https://github.com/WilkerVinicios/stefanini.git
cd stefanini
```

### Passo 2: Configuração do Banco de Dados

Este projeto utiliza SQL Server como banco de dados. 
Você deve configurar as variaveis de ambiente na IDE ou no server:

```bash
Exemplo de configuração:
DB_USERNAME=seulogin
DB_PASSWORD=suasenha
```

### Passo 3: Configuração de Migrações com Flyway

O Flyway será utilizado para gerenciar as migrações do banco de dados. 
Verifique se o arquivo de migração está na pasta src/main/resources/db/migration. 
O Flyway irá executar automaticamente as migrações quando a aplicação for iniciada.

### Passo 4: Dependências do Maven

Este projeto utiliza o Maven para gerenciamento de dependências e construção do projeto. 
As dependências essenciais estão listadas no arquivo pom.xml.


# Rodando a Aplicação

## Passo 1: Compilar e Executar
Após configurar o banco de dados, você pode compilar e executar o projeto com Maven. 
Use os seguintes comandos no terminal ou pela IDE:

```bash
mvn clean install
mvn spring-boot:run
```

A aplicação será iniciada e estará disponível em http://localhost:8080.

## Passo 2: Testar a API
### Na pasta *collection* dentro do repositorio tem a collection para utilização no postman.

A API oferece endpoints para interagir com o sistema. 
Você pode testar as funcionalidades usando ferramentas como Postman.

### Exemplo de Request (POST):
```bash
POST http://localhost:8080/stefanini/tarefa/salvar
Content-Type: application/json

{
  "titulo": "Estudar Java",
  "descricao": "Estudar o básico de Java.",
  "status": "PENDENTE"
}
```
```bash
Retorno:
Tarefa salva com sucesso.
```

### Exemplo de Request (GET) listar todos.
```bash
Get http://localhost:8080/stefanini/tarefa/listar

```
```bash
Retorno:
[
    {
        "id": 2,
        "titulo": "Estudar Spring Boot",
        "descricao": "Estudar o básico de Spring Boot.",
        "status": "EM_ANDAMENTO",
        "dataCriacao": "2025-02-05T10:04:03.137"
    },
	{
		"id": 3,
		"titulo": "Estudar Java",
		"descricao": "Estudar o básico de Java.",
		"status": "PENDENTE",
		"dataCriacao": "2025-02-05T11:23:16.933"
	}
]
```

### Exemplo de Request (GET) listar por ID.
```bash
GET http://localhost:8080/stefanini/tarefa/listar/{id}

```
```bash
Retorno:
{
    "id": 3,
    "titulo": "Estudar Java",
    "descricao": "Estudar o básico de Java.",
    "status": "PENDENTE",
    "dataCriacao": "2025-02-05T11:23:16.933"
}
```

### Exemplo de Request (PUT)
```bash
POST http://localhost:8080/stefanini/tarefa/editar/{id}

{
    "id": 3,
    "titulo": "Estudar Java",
    "descricao": "Estudar o básico de Java.",
    "status": "EM_ANDAMENTO"
}
```
```bash
Retono:
Tarefa editada com sucesso.
```

### Exemplo de Request (DELETE)
```bash
DELETE http://localhost:8080/stefanini/tarefa/excluir/{id}

```
```bash
Retorno:
Tarefa excluída com sucesso.
```

## Estrutura do projeto
```bash
src/
 └── main/
     ├── java/
     │   └── com/br/stefanini/
     │       ├── config/          # Configurações gerais, incluindo segurança 
     │       ├── controller/      # Contém os controladores REST
     │       ├── dto/             # Contem os DTOs da aplicação
     │       ├── entity/          # Contém as entidades
     │       ├── enums/           # Contém os enums
     │       ├── exception/       # Contém exceções personalizadas
     │       ├── mapper/          # Contém os mappers
     │       ├── repository/      # Repositórios JPA
     │       └── service/         # Lógica de negócio    
     └── resources/
         ├── db/
         │   └── migration/          # Scripts Flyway para migrações do banco
         └── application.properties  # Configurações da aplicação
```
## Video de Apresentação do funcionamento da API.

https://drive.google.com/file/d/1PYD8D_dHD3R7snvgd2HLrgU6ucTEkcuE/view?usp=drive_link
