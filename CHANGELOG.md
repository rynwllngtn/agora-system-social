# Changelog

Todas as mudanças notáveis na API do **Agora System** serão documentadas neste arquivo.

O formato é baseado no [Keep a Changelog](https://keepachangelog.com/pt-BR/1.1.0/).

---

## [Unreleased]

### Added
- Implementação do padrão DTO para abstração e encapsulamento de `Profile`, aparecendo como `AuthorDTO`, em sua relação com `Post`.
- Criação da entidade `Post`, com classe `repository` respectiva.

### Changed
- Alterado a função `DatabaseSeeder` para popular o banco com nova entidade `Post`.

---

## [0.1.0] - 2026-03-29

### Added
- Implementação do endpoint *PUT /users/{id}*.
- Implementação do endpoint *DELETE /users/{id}*, com tratamento de exceções personalizados.
- Implementação do endpoint *POST*.
- Implementação do endpoint *GET /users/{id}*, com tratamento de exceção personalizado.
- Implementação do endpoint *GET /users*.
- Implementação do serviço *findAll*.
- Criação do `DatabaseSeeder` para popular o banco de dados com 50 usuários de teste na primeira inicialização.
- Criação da entidade `User`, com classes `repository`, `service` e `controller` respectivas.

### Changed
- Alterado a entidade `User` para `Profile`, garantindo distinção e vinculo entre sistema Core e Social.
- Alterado o formato do id UUID para String, usando o construtor ObjectId do MongoDB como padrão.

### Fixed
- Correção no mapeamento das propriedades do `application.yaml` para garantir a conexão e representação UUID correta.