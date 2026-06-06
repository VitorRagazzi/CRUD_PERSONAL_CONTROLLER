# 📋 Personal Controller

API REST desenvolvida em Java com Spring Boot para gerenciamento de alunos através das operações básicas de CRUD (Create, Read, Update e Delete).

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- SQLite
- Maven
- Lombok
- REST API
- Swagger 

## 📌 Funcionalidades

### Alunos
- Criar aluno
- Buscar aluno por ID
- Listar todos os alunos
- Atualizar aluno
- Excluir aluno

### Agendamentos
- Criar agendamento
- Buscar agendamento por ID
- Listar agendamentos
- Atualizar agendamento
- Excluir agendamento

## 🏗️ Estrutura do Projeto

```text
src/main/java/br/com/crud/personalcontroller
│
├── config
│   └── SQLiteDialect.java
│
├── controller
│   ├── AgendamentoController.java
│   └── AlunosController.java
│
├── database
│   │
│   ├── model
│   │   │
│   │   ├── dto
│   │   │   ├── AgendamentoDTO.java
│   │   │   └── AlunosDTO.java
│   │   │
│   │   ├── Agendamento.java
│   │   └── Alunos.java
│   │
│   └── repository
│       ├── AgendamentoRepository.java
│       └── AlunosRepository.java
│
├── service
│   ├── AgendamentoService.java
│   ├── AlunosService.java
│   │
│   └── serviceImpl
│       ├── AgendamentoServiceImpl.java
│       └── AlunosServiceImpl.java
│
├── exception
├── handler
├── utils
│
└── PersonalcontrollerApplication.java
```

## Arquitetura MVC
- Controller: Recebe as requisições HTTP.
- Service: Contém as regras de negócio.
- Repository: Responsável pelo acesso aos dados.
- Model: Representa as entidades do sistema.

### Responsabilidades

| Camada | Responsabilidade |
|----------|----------|
| Controller | Exposição dos endpoints REST |
| Service | Regras de negócio |
| Repository | Persistência de dados |
| Model | Entidades do sistema |
| Exception/Handler | Tratamento global de exceções |
| Config | Configurações do SQLite |

## ⚙️ Como Executar

### Clone o projeto

```bash
git clone https://github.com/VitorRagazzi/CRUD_PERSONAL_CONTROLLER.git
```

### Entre na pasta

```bash
cd CRUD_PERSONAL_CONTROLLER
```

### Execute a aplicação

```bash
mvn spring-boot:run
```

A aplicação será iniciada em:

```text
http://localhost:8082
```

## 📖 Documentação da API

Após iniciar o projeto, acesse:

```text
http://localhost:8082/swagger-ui/index.html
```

Ou diretamente:

```text
http://localhost:8082/swagger-ui/index.html#/
```

A documentação Swagger permite:

- Visualizar todos os endpoints
- Testar requisições diretamente pelo navegador
- Ver modelos de entrada e saída
- Consultar códigos de resposta

## 🗄️ Banco de Dados

O sistema utiliza SQLite, um banco de dados leve baseado em arquivo.

Vantagens:

- Não necessita instalação de servidor
- Fácil configuração
- Ideal para projetos de estudo e APIs CRUD

## 🎯 Objetivo

Este projeto foi desenvolvido para praticar:

- Desenvolvimento de APIs RESTful
- Spring Boot
- JPA/Hibernate
- SQLite
- Arquitetura em camadas
- Tratamento de exceções
- Documentação com Swagger/OpenAPI
- Boas práticas de desenvolvimento backend

## 📄 Licença

---

Projeto desenvolvido para fins de estudo e aprimoramento de conhecimentos em Java e Spring Boot.
