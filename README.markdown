# Spring Boot JPA Project - CRUD de Clientes

Bem-vindo ao **Spring Boot JPA Project**! Este é um projeto simples de **CRUD (Create, Read, Update, Delete)** para gerenciamento de clientes, desenvolvido como parte do meu aprendizado em Java e Spring Boot. O projeto utiliza um conjunto de tecnologias modernas para construir uma aplicação backend robusta, conectada a um banco de dados PostgreSQL.

Este projeto foi inspirado no curso do professor **Nélio Alves**, cuja didática foi essencial para consolidar meus conhecimentos em desenvolvimento backend com Spring Boot.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework para desenvolvimento de aplicações web com configuração simplificada.
- **Spring Data JPA**: Para gerenciamento de persistência de dados com repositórios.
- **Hibernate**: Implementação do JPA para mapeamento objeto-relacional.
- **PostgreSQL 17.5**: Banco de dados relacional.
- **JDBC Driver do PostgreSQL**: Para integração entre o Spring Boot e o PostgreSQL.
- **Maven**: Ferramenta de build para gerenciamento de dependências.
- **pgAdmin**: Ferramenta para administração do banco de dados PostgreSQL.

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- **Java 17** ou superior
- **Maven 3.8.0** ou superior
- **PostgreSQL 17.5**
- **pgAdmin 4** (opcional, para gerenciamento do banco)
- Um editor de código como **IntelliJ IDEA** ou **VS Code**

## Configuração do Projeto

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/guimalicki/springboot-jpa-project.git
   cd springboot-jpa-project
   ```

2. **Configure o banco de dados PostgreSQL**:
   - Crie um banco de dados no PostgreSQL usando o pgAdmin ou a linha de comando:
     ```sql
     CREATE DATABASE clientes_db;
     ```
   - Atualize o arquivo `src/main/resources/application.properties` com as configurações do banco:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/clientes_db
     spring.datasource.username=seu_usuario
     spring.datasource.password=sua_senha
     spring.jpa.hibernate.ddl-auto=update
     spring.datasource.driver-class-name=org.postgresql.Driver
     spring.jpa.show-sql=true
     spring.jpa.properties.hibernate.format_sql=true
     ```

3. **Resolva dependências com Maven**:
   - No diretório raiz do projeto, execute:
     ```bash
     mvn clean install
     ```

4. **Configure o pgAdmin (opcional)**:
   - Para evitar erros como `pg_dump: server version mismatch`, certifique-se de que o pgAdmin use os binários do PostgreSQL 17.5:
     - No pgAdmin, vá para **File > Preferences > Paths > Binary Paths**.
     - Configure o caminho para `C:\Program Files\PostgreSQL\17\bin` (Windows) ou `/usr/lib/postgresql/17/bin` (Linux).
   - Para usar o `pg_dump` no terminal, adicione o diretório acima ao PATH do sistema.

## Como Executar

1. **Inicie a aplicação**:
   - Execute o comando abaixo para rodar o Spring Boot:
     ```bash
     mvn spring-boot:run
     ```
   - A aplicação estará disponível em `http://localhost:8080`.

2. **Teste o CRUD**:
   - Use ferramentas como **Postman** ou **curl** para interagir com os endpoints da API (ex.: `/clientes` para listar clientes).
   - Exemplo de chamada para criar um cliente (POST):
     ```bash
     curl -X POST http://localhost:8080/clientes -H "Content-Type: application/json" -d '{"nome":"João Silva","email":"joao@example.com"}'
     ```

3. **Gerencie o banco de dados**:
   - Use o pgAdmin para visualizar a tabela `clientes` no banco `clientes_db`.
   - Para criar um backup do banco:
     ```bash
     pg_dump -U seu_usuario -h localhost -d clientes_db -f backup.sql
     ```

## Estrutura do Projeto

```
springboot-jpa-project/
├── src/
│   ├── main/
│   │   ├── java/com/example/
│   │   │   ├── controller/    # Controladores REST para os endpoints
│   │   │   ├── entity/       # Entidades JPA (ex.: Cliente)
│   │   │   ├── repository/   # Repositórios JPA para acesso ao banco
│   │   │   └── Application.java  # Classe principal do Spring Boot
│   │   └── resources/
│   │       └── application.properties  # Configurações do banco e aplicação
├── pom.xml  # Dependências Maven
└── README.md
```

## Desafios e Soluções

Durante o desenvolvimento, enfrentei o erro `pg_dump: error: aborting because of server version mismatch` ao tentar fazer backup do banco com o pgAdmin. O problema foi resolvido ao configurar o pgAdmin para usar os binários do PostgreSQL 17.5 e adicionar o diretório `C:\Program Files\PostgreSQL\17\bin` ao PATH do sistema.

## Créditos

Este projeto foi desenvolvido como parte do meu aprendizado no curso do professor **Nélio Alves**, cuja orientação clara e prática foi fundamental para entender os conceitos de Spring Boot, JPA e integração com bancos de dados.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests com melhorias ou sugestões.
