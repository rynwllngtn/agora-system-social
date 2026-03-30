# Changelog

Todas as mudanças notáveis na API do **Agora System** serão documentadas neste arquivo.

O formato é baseado no [Keep a Changelog](https://keepachangelog.com/pt-BR/1.1.0/).

---

## [Unreleased]

### Added
- Adicionado atributo *List<Comment> comments* em entidade `Post`.
- Criação de entidade `Comment`, com classe `repository` respectiva.

### Changed
- Alterado a função `DatabaseSeeder` para popular o banco com nova entidade `Comment`.

---

## [0.2.0] - 2026-03-30

### Added
- Implementação do endpoint *PUT /posts/{id}*.
- Implementação do endpoint *DELETE /posts/{id}*, com tratamento de exceções personalizados.
- Implementação do endpoint *POST*.
- Implementação do endpoint *GET /posts/{id}*, com tratamento de exceção personalizado.
- Implementação do endpoint *GET /posts*.
- Implementação do endpoint *GET /profiles/{id}/posts*.
- Adicionado atributo *List<Post> posts* em entidade `Profile`.
- Implementação do padrão DTO para abstração e encapsulamento de `Profile`, aparecendo como `AuthorDTO`, em sua relação com `Post`.
- Criação da entidade `Post`, com classes `repository`, `service` e `controller` respectivas.

### Changed
- Alterado a função `DatabaseSeeder` para popular o banco com nova entidade `Post`.
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
- Implementação do endpoint *POST*.
- Implementação do endpoint *GET /profiles/{id}*, com tratamento de exceção personalizado.
- Implementação do endpoint *GET /profiles*.
- Criação do `DatabaseSeeder` para popular o banco de dados com 50 profiles de teste na primeira inicialização.
- Criação da entidade `Profile`, com classes `repository`, `service` e `controller` respectivas.

### Changed
- Alterado o formato do id UUID para String, usando o construtor ObjectId do MongoDB como padrão.

### Fixed
- Correção no mapeamento das propriedades do `application.yaml` para garantir a conexão e representação UUID correta.