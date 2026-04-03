# Changelog

Todas as mudanças notáveis na API do **Agora System** serão documentadas neste arquivo.

O formato é baseado no [Keep a Changelog](https://keepachangelog.com/pt-BR/1.1.0/).

---

## [Unreleased]

### Added
- Criação dos endpoints de listagem para buscar todos os `Comment` relacionados a um `Post` ou `Profile` específico, garantindo o acesso aos dados após a remoção das listas embutidas nas entidades.
- Criação de novos métodos de comunicação interna no `PostService` e novos mapeamentos de rota no `ProfileController`.
- Configuração do `MongoConfiguration` e implementação da anotação `@CreatedDate` na entidade `Post`, delegando o controle de tempo para o framework.
- Implementação de consultas customizadas no `ProfileRepository`, `PostRepository` e `CommentRepository` para converter dados diretamente da base para DTOs.
- Criação do método `findAuthorById` no `ProfileService`, usado por `PostService` e `CommentService` para buscar referências de autores sem expor a entidade completa.
- Criação das classes `ProfilePostDTO`, `PostAddressDTO`, `PostDTO` e `PostCommentDTO`, `CommentDTO` e `CommentPostDTO`, garantindo JSONs enxutos e blindagem de dados.

### Changed
- Refatoração dos métodos em `ProfileController`, `PostController` e `CommentController` para que todos os retornos de endpoints devolvam DTOs, adicionando uma camada de segurança.
- Migração do campo de data das entidades `Post` e `Comment` de `Date` para `Instant`, adequando-se ao padrão moderno do Java.
- Alterado nome do atributo *isActive* para *active* na entidade `Profile`, mantendo o padrão nativo do framework.
- Modificado o endpoint update das entidades para transitar dados de forma segura utilizando DTOs em vez das entidades originais.
- Reorganizado a classe `DatabaseSeeder`, separando a criação de entidades em métodos independentes e ajustando o relacionamento entre entidades.

### Removed
- Removido services e controllers findAll para `Profile`, `Post` e `Comment`.
- Removido atributos List<> de entidades `Profile` e `Post`.

---

## [v0.3.0] - 2026-04-01

### Added
- Adicionado atributo className e getter em `ObjectNotFoundException`, possibilitando manuseio mais preciso.
- Implementação do endpoint *PUT /comments/{id}*.
- Implementação do endpoint *DELETE /comments/{id}*, com tratamento de exceções personalizados.
- Implementação do endpoint *POST* para entidade Comment.
- Implementação do endpoint *GET /comments/{id}*, com tratamento de exceção personalizado.
- Implementação do endpoint *GET /comments*.
- Adicionado atributo *List<Comment> comments* em entidade `Post`.
- Implementação do DTO `PostDTO` para abstração da entidade `Post` em sua relação com `Comment`.
- Criação de entidade `Comment`, com classe `repository` respectiva.

### Changed
- Alterado parâmetro de String para Class<?> em `ObjectNotFoundException`, limitando a entrega para somente classes.
- Transferido método responsável pela atualização dos dados para a classe da própria entidade.
- Alterado a classe `DatabaseSeeder` para popular o banco com nova entidade `Comment`.

### Fixed
- Corrigido lançamento de exceção incorretos em services.

---

## [0.2.0] - 2026-03-30

### Added
- Implementação do endpoint *PUT /posts/{id}*.
- Implementação do endpoint *DELETE /posts/{id}*, com tratamento de exceções personalizados.
- Implementação do endpoint *POST* para entidade Post.
- Implementação do endpoint *GET /posts/{id}*, com tratamento de exceção personalizado.
- Implementação do endpoint *GET /posts*.
- Implementação do endpoint *GET /profiles/{id}/posts*.
- Adicionado atributo *List<Post> posts* em entidade `Profile`.
- Implementação do padrão DTO para abstração da entidade `Profile`, aparecendo como `AuthorDTO` em sua relação com `Post`.
- Criação da entidade `Post`, com classes `repository`, `service` e `controller` respectivas.

### Changed
- Alterado a classe `DatabaseSeeder` para popular o banco com nova entidade `Post`.
- Reduzido população automática de banco para 10 profiles e posts.

### Fixed
- Corrigido nome do objeto do erro `ObjectNotFoundException` fixo como profile para retornar nome correto entregue como parâmetro.
- Corrigido dados e vinculo incompletos entre `Post` e `Profile` ao usar endpoint *POST*.
- Adicionado comentário para esclarecimento de atributo ambíguo.
- Corrigido CHANGELOG confusa.

---

## [0.1.0] - 2026-03-29

### Added
- Implementação do endpoint *PUT /profiles/{id}*.
- Implementação do endpoint *DELETE /profiles/{id}*, com tratamento de exceções personalizados.
- Implementação do endpoint *POST para entidade Profile*.
- Implementação do endpoint *GET /profiles/{id}*, com tratamento de exceção personalizado.
- Implementação do endpoint *GET /profiles*.
- Criação da classe `DatabaseSeeder` para popular o banco de dados com 50 profiles de teste na primeira inicialização.
- Criação da entidade `Profile`, com classes `repository`, `service` e `controller` respectivas.

### Changed
- Alterado o formato do id UUID para String, usando o construtor ObjectId do MongoDB como padrão.

### Fixed
- Correção no mapeamento das propriedades do `application.yaml` para garantir a conexão e representação UUID correta.