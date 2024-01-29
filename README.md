# Tweetero API
<p align="justify">
    O Tweetero é uma aplicação com persistência em bancos de dados, onde você pode publicar o que estiver pensando ou sentindo no momento. Ideal para integrar com uma interface e dar aquele up no seu portifolio.
<p>

## Configurações Iniciais:

<p align="justify">
    Para por a API Tweetero no ar, será necessário definir um banco de dados para que ela possa persistir os dados, o tweetero usa Postgres então você precisará criar um banco de dados usando-o.

- Caso não tenha o postgres poderá baixa-lo nos links abaixo:
    - Postgres para [Windows](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)
    - Postgres para [Linux](https://www.postgresql.org/download/linux/#generic)

Com o postgres já instalado, crie um banco de dados com o nome que preferir, em seguida mude o nome do arquivo `application-example.properties` para `application.properties` e altere os dados para acesso do seu banco:

```
spring.datasource.url= jdbc:postgresql://localhost:5432/database-name
spring.datasource.username=your-username-login
spring.datasource.password=your-password-login

# Atualiza as tabelas conforme mudamos coisas na API
spring.jpa.hibernate.ddl-auto=update 

# Evita conflitos de metadados criados pelo Hibernate (ORM)
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```
Com isso feito, você pode rodar a aplicação e ela estará funcionando localmente na porta 8080:

>http://localhost:8080 
<p>