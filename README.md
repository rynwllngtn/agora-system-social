# Agora System Social (API)

![Java](https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=java)
![Status](https://img.shields.io/badge/Status-EM%20EVOLUÇÂO-success?style=for-the-badge)
![Version](https://img.shields.io/badge/version-v0.3.2-blue?style=for-the-badge)

O **Agora System Social** é um microsserviço projetado para lidar com as interações sociais (Perfis, Publicações e Comentários) do ecossistema Agora System.  
O objetivo deste módulo é explorar o paradigma NoSQL, aplicando conceitos avançados de modelagem de dados, performance de leitura e integridade estrutural em APIs RESTful.

---

![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white)

---

## Aprendizado e Arquitetura

O desenvolvimento deste microsserviço focou fortemente em boas práticas de mercado, segurança e estabilidade da aplicação:

- **Modelagem NoSQL (MongoDB):** Aplicação de conceitos de Referenciação e Desnormalização para evitar o limite de tamanho de documentos (*Unbounded Arrays*), garantindo consultas de alta performance.
- **Blindagem de Dados (DTOs & Validation):** Separação estrita entre Entidades de Domínio e *Data Transfer Objects* (DTOs). Uso do `spring-boot-starter-validation` (`@Valid`, `@NotBlank`, `@NotNull`) para impedir a corrupção de dados e a injeção de valores nulos na base.
- **Tratamento Global de Exceções:** Implementação de `@ControllerAdvice` para interceptar e padronizar erros da base de dados e falhas de validação, retornando respostas amigáveis para o cliente (Front-end).
- **Semântica RESTful:** Uso adequado dos verbos HTTP (GET, POST, PUT, DELETE) e Status Codes corretos (`201 Created` com header `Location`, `204 No Content`, etc).

---

## 📡 Endpoints da API

A API foi projetada focando na separação de responsabilidades e na usabilidade para o front-end, retornando sempre versões enxutas das entidades.

### Perfis (`/profiles`)
| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/profiles` | Cria um novo perfil de usuário. |
| `GET` | `/profiles/{id}` | Retorna os dados completos de um perfil. |
| `PUT` | `/profiles/{id}` | Atualiza um perfil existente. Exige payload completo blindado. |
| `DELETE`| `/profiles/{id}` | Remove um perfil da base de dados. |
| `GET` | `/profiles/{id}/posts` | Lista todas as publicações criadas por um perfil. |
| `GET` | `/profiles/{id}/comments` | Lista todos os comentários feitos por um perfil. |

### Publicações (`/posts`)
| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/posts` | Cria uma nova publicação atrelada a um autor. |
| `GET` | `/posts/{id}` | Retorna os dados de uma publicação específica. |
| `PUT` | `/posts/{id}` | Atualiza o título e/ou corpo da publicação. |
| `DELETE`| `/posts/{id}` | Remove uma publicação. |
| `GET` | `/posts/{id}/comments`| Lista todos os comentários pertencentes a uma publicação. |

### Comentários (`/comments`)
| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/comments` | Adiciona um comentário a uma publicação existente. |
| `GET` | `/comments/{id}` | Retorna os dados de um comentário. |
| `PUT` | `/comments/{id}` | Atualiza o texto de um comentário. |
| `DELETE`| `/comments/{id}` | Remove um comentário do sistema. |

## Exemplos de Cargas

Para as rotas de criação (`POST`) e atualização (`PUT`), a API espera cargas no formato JSON. Com a arquitetura de *Flattening*, o Front-end não necessita de enviar objetos aninhados, apenas os respetivos IDs de referência.

**Criação de Perfil (`POST /profiles`)**
```json
{
  "profileHolder": "e9ae33b8-d638-4b6b-9de8-5d598a410e66"
  "userName": "Ryan Wellington",
  "birthDate": "07-01-2002"
}
```

**Atualização de Perfil (`PUT /profiles`)**
```json
{
  "userName": "Ryan Wellington",
  "birthDate": "07-01-2002"
  "active": "false"
}
```

**Criação de Publicação (`POST /posts`)**
```json
{
  "title": "A minha primeira publicação!",
  "body": "A testar a nova arquitetura do Agora System Social.",
  "author": "60f7a9b8e4b0a1b2c3d4e5f6"
}
```

**Atualização de Publicação (`PUT /posts/{id}`)**
```json
{
  "title": "Título atualizado",
  "body": "Corpo da publicação corrigido."
}
```

**Criação de Comentário (`POST /comments`)**
```json
{
  "body": "Excelente arquitetura! Código muito limpo.",
  "author": "60f7a9b8e4b0a1b2c3d4e5f6",
  "post": "55f7a9b8e4b0a1b2c3d4e9x8"
}
```

**Atualização de Comentário (`PUT /comments/{id}`)**
```json
{
  "body": "Péssima arquitetura! Código muito sujo."
}
```

---

## Como testar a aplicação localmente?

Para rodar a API na sua máquina, você precisará do **Java 25** e de uma instância do **MongoDB** rodando localmente.

1. Clone o repositório:
   ```bash
   git clone https://github.com/rynwllngtn/agora-system-social.git

2. Renomeie o arquivo `application.example.yaml` para `application.yaml`.
3. Insira as suas credenciais do MongoDB local e o nome da base de dados no novo arquivo.
4. Rode a aplicação usando o Maven Wrapper na raiz do projeto:
   ```bash
   ./mvnw spring-boot:run
   ```
   ou inicie a classe Main diretamente pela sua IDE (como no IntelliJ).
5. Acesse `http://localhost:8080/users` no seu navegador ou Postman para ver o retorno em JSON da API.


## Linha do Tempo

Estou mantenho um registro detalhado de cada mudança que aplico na API do sistema.  
Você pode acompanhar essa evolução no meu [CHANGELOG.md](./CHANGELOG.md).
