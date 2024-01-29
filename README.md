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

## Modelos:

- O formato de um **usuário** é:
    - `id` ⇒ numérico, gerado automaticamente
    - `avatar` ⇒ String, é uma url de imagem, não pode ser nulo
    - `username` ⇒ String de tamanho máximo 100, não pode ser nulo
- O formato de um **tweet** é:
    - `id` ⇒ numérico, gerado automaticamente
    - `text` ⇒ String de tamanho máximo 280, não pode ser nulo

## End Points:

- **POST** `/users`

    <details>

    - Deve receber (pelo `body` da request) um parâmetro `username` e um `avatar`, contendo o username do usuário e a sua foto de avatar:
        
        ```java
        {
            username: "bobesponja",
        	avatar: "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
        }
        ```
        
    - Por fim, retorna a mensagem  `status 201 (CREATED)` com o objeto que foi criado
        
        ```java
        {
        	id: 1,
            username: "bobesponja",
        	avatar: "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
        }
        ```
        
    - Não pode criar um usuário com `username` repetido. Nesse caso, retorna status `409 (CONFLICT)`.
</details>


- **POST** `/tweets`

    <details>

    - Deve receber (pelo body da request), os parâmetros `text` e `userId`:
        
        ```java
        {
            userId: 1,
            text: "eu amo hamburguer de siri"
        }
        ```
        
    - O tweet será salvo na tabela de tweets
    - Por fim, retorna o status `201 (CREATED)` com o objeto contendo as informações do tweet e do usuário:
        
        ```java
        {
          "id": 20,
          "text": "eu amo hamburguer de siri",
          "user": {
            "id": 1,
            "username": "bobesponja",
            "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
          }
        }
        ```
        
    - Caso o usuário fornecido não exista, retorna `404 (NOT FOUND)`.

    </details>

- **GET** `tweets`

    <details>

    - Retorna todos os tweets publicados com o status 200 (OK).
    ```java
    [
    {
        "id": 20,
        "text": "meu primeiro tweet",
        "user": {
            "id": 1,
            "username": "bobesponja",
            "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
        }
    },
    {
        "id": 21,
        "text": "eu moro numa pedra",
        "user": {
            "id": 2,
            "username": "patrick",
            "avatar": "https://gartic.com.br/imgs/mural/te/tettyzinhah15/patrick-estrela.png"
        }
    },
    {
        "id": 22,
        "text": "eu amo hambúrguer de siri",
        "user": {
            "id": 1,
            "username": "bobesponja",
            "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
        }
    }
    ]
    ```
</details>

- **GET** `/tweets/user/:userId`

    <details>

    - Retorna todos os tweets publicados do usuário recebido por parâmetro de rota com o status `200 (OK)`.
        
        ```java
        [
          {
            "id": 20,
            "text": "meu primeiro tweet",
            "user": {
              "id": 1,
              "username": "bobesponja",
              "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
            }
          },
          {
            "id": 22,
            "text": "eu amo hambúrguer de siri",
            "user": {
              "id": 1,
              "username": "bobesponja",
              "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
            }
          }
        ]
        ```
    </details>
