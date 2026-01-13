# Pismo Account

Serviço responsável pelo gerenciamento de contas e transações 

## Tecnologias

* [Kotlin](https://kotlinlang.org/)
* [SpringBoot](https://spring.io/projects/spring-boot)
* [Docker](https://www.docker.com)
* [Gradle (Groovy)](https://gradle.org)

## Estrutura do projeto

```
C:.
├───account
│   └───src
│       ├───main
│       │   ├───kotlin
│       │   │   └───org
│       │   │       └───pismo
│       │   │           └───account
│       │   │               ├───config
│       │   │               ├───context
│       │   │               ├───controller
│       │   │               ├───domain
│       │   │               ├───dto
│       │   │               ├───encode
│       │   │               ├───facade
│       │   │               ├───mapper
│       │   │               ├───repository
│       │   │               └───service
│       │   └───resources
│       ├───test
│       │   ├───kotlin
│       │   │   └───component
│       │   │       └───test
│       │   └───resources
│       └───testFixtures
│           └───kotlin
│               └───component
│                   ├───config
│                   └───provider
├───app
│   └───src
│       ├───main
│       │   ├───kotlin
│       │   └───resources
│       └───test
│           ├───kotlin
│           └───resources
├───commons
│   └───src
│       ├───main
│       │   ├───kotlin
│       │   │   └───org
│       │   │       └───pismo
│       │   │           └───commons
│       │   │               ├───aspect
│       │   │               ├───config
│       │   │               ├───encode
│       │   │               ├───exception
│       │   │               └───facade
│       │   └───resources
│       ├───test
│       │   ├───kotlin
│       │   └───resources
│       └───testFixtures
│           └───kotlin
│               └───component
│                   └───config
└───transaction
    └───src
        ├───main
        │   ├───kotlin
        │   │   └───org
        │   │       └───pismo
        │   │           └───transaction
        │   │               ├───context
        │   │               ├───controller
        │   │               ├───domain
        │   │               ├───dto
        │   │               ├───enum
        │   │               ├───facade
        │   │               ├───mapper
        │   │               ├───repository
        │   │               └───service
        │   └───resources
        └───test
            ├───kotlin
            │   └───component
            │       ├───config
            │       ├───provider
            │       └───test
            └───resources

```

### Build do projeto e execução local via docker

```bash
  docker build -t pismo-app:latest .
  docker run -p 8080:8080 pismo-app:latest
```

### Endpoints:
* POST http://localhost:8080/accounts
* GET http://localhost:8080/accounts/{account_id}
* POST http://localhost:8080/transactions

### Endpoints de apoio:
* H2 http://localhost:8080/h2-console (ulr: jdbc:h2:mem:testdb / user: sa / pass: )
* Swagger http://localhost:8080/h2-console (ulr: jdbc:h2:mem:testdb / user: sa / pass: )
