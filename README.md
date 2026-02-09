# 🗓️ Agendador de Serviços – Java + Spring Boot

API REST para gerenciamento de **agendamentos de serviços**, desenvolvida com **Java e Spring Boot**. O projeto implementa operações básicas de CRUD e segue padrões comuns utilizados em projetos profissionais.

## 🚀 Tecnologias Utilizadas

* Java 21+
* Spring Boot
* Spring Web
* Spring Data JPA
* Lombok
* Hibernate
* Banco de Dados H2 / PostgreSQL (configurável)
* Maven / Gradle

## 📂 Estrutura do Projeto

```
src/main/java
└── com.seuusuario.agendador
    ├── controller
    ├── service
    ├── repository
    ├── dto
    ├── entity
    └── AgendadorApplication.java
```

* **controller** → Camada responsável pelos endpoints REST
* **service** → Regras de negócio
* **repository** → Acesso ao banco de dados
* **dto** → Objetos de transferência de dados
* **entity** → Entidades JPA

## 📌 Funcionalidades

* ✅ Criar agendamento
* 📄 Listar agendamentos
* ✏️ Atualizar agendamento
* ❌ Deletar agendamento

## 🔗 Endpoints Principais (Exemplo)

| Método | Endpoint             | Descrição              |
| ------ | -------------------- | ---------------------- |
| POST   | `/agendamentos`      | Criar novo agendamento |
| GET    | `/agendamentos`      | Listar agendamentos    |
| PUT    | `/agendamentos/{id}` | Atualizar agendamento  |
| DELETE | `/agendamentos`      | Remover agendamento    |

## 🧾 Exemplo de Request (JSON)

```json
{
  "cliente": "João Silva",
  "dataHoraAgendamento": "2026-02-10T14:00"
}
```

## ▶️ Como Executar o Projeto

1. Clone o repositório:

```bash
git clone https://github.com/hitamarpereiras/java_com_spring_CRUD.git
```

2. Acesse a pasta do projeto:

```bash
cd agendador-servicos
```

3. Execute a aplicação:

```bash
./mvnw spring-boot:run
```

ou

```bash
./gradlew bootRun
```

4. A API estará disponível em:

```
http://localhost:8080
```

## 🛠️ Possíveis Melhorias Futuras

* Autenticação e autorização (JWT / Spring Security)
* Paginação e filtros
* Validações com Bean Validation
* Documentação com Swagger / OpenAPI
* Deploy em ambiente cloud

## 📄 Licença

Este projeto é livre para estudo e uso pessoal.

---

💡 *Projeto desenvolvido para fins educacionais e prática com Java + Spring Boot.*
