
# 📇 Controle de Contatos

Este é um projeto de controle de contatos usando Spring 3.2.7 e Java 21, com um banco de dados PostgreSQL rodando em um contêiner Docker. 

## 🚀 Como Iniciar

### 🐳 Configuração do Docker

Certifique-se de ter o Docker instalado. Use a versão 17beta1 do PostgreSQL na porta 5455:

```bash
docker run --name postgres -e POSTGRES_PASSWORD=mysecretpassword -d -p 5455:5432 postgres:17beta1
```

### 🔧 Configuração do Projeto

Clone o repositório e navegue até a pasta do projeto:

```bash
git clone https://github.com/ThiCastroo/ControleContatosApp.git
cd ControleContatosApp/ContactManagement
```

### 📦 Dependências

Certifique-se de ter o Maven instalado. Em seguida, instale as dependências:

```bash
mvn clean install
```

### ▶️ Executando a Aplicação

Certifique-se de estar na pasta correta.

Inicie a aplicação Spring Boot:

```bash
mvn spring-boot:run
```

## 🔑 Segurança

Este aplicativo utiliza JWT para autenticação. 

1. **Obter o Token:** Use a API de token disponível no Swagger para obter o token. Forneça seu nome de usuário e senha.
2. **Autorizar no Swagger:** Adicione o token na seção de autorização do Swagger.
3. **Validade do Token:** O token é válido por 2 horas. Após esse período, obtenha um novo token.

## 📋 Endpoints e APIs

A seguir estão os endpoints disponíveis na aplicação:

### 🧑‍🤝‍🧑 Pessoa Resource

- **GET /api/pessoas/{id}** - Retorna os dados de uma Pessoa por ID
- **PUT /api/pessoas/{id}** - Atualiza o registro de uma Pessoa existente por ID
- **DELETE /api/pessoas/{id}** - Remove uma Pessoa por ID
- **GET /api/pessoas** - Lista todos os dados de Pessoas
- **POST /api/pessoas** - Cria uma nova Pessoa
- **GET /api/pessoas/maladireta/{id}** - Retorna os dados de uma Pessoa por ID para mala direta

### 📞 Contato Resource

- **GET /api/contatos/{id}** - Retorna os dados de um Contato por ID
- **PUT /api/contatos/{id}** - Atualiza o registro de um Contato existente por ID
- **DELETE /api/contatos/{id}** - Remove uma Pessoa por ID
- **GET /api/contatos** - Lista todos os Contatos
- **POST /api/contatos** - Adiciona um novo Contato a uma Pessoa
- **GET /api/contatos/pessoa/{idPessoa}** - Lista todos os Contatos de uma Pessoa

### 🔒 Auth Controller

- **GET /token** - Retorna o token para autorizar a aplicação

## 🔍 Consultas SQL

Algumas consultas SQL úteis para testar no PostgreSQL:

- **Obter mala direta:**

  ```sql
  SELECT tp.id, tp.nome, 'malaDireta: ' || tp.endereco || ' - Cep: ' || tp.cep || ' - Cidade: ' || tp.cidade || ' - UF: ' || tp.uf AS mala_direta
  FROM tb_pessoa tp;
  ```

- **Listar todos os contatos:**

  ```sql
  SELECT * FROM tb_contato;
  ```

- **Listar todas as pessoas:**

  ```sql
  SELECT * FROM tb_pessoa;
  ```

- **Listar contatos de uma pessoa específica:**

  ```sql
  SELECT tc.id, tc.tipo_contato, tc.contato, tc.pessoa_id 
  FROM tb_contato tc 
  INNER JOIN tb_pessoa tp ON tc.pessoa_id = tp.id 
  WHERE tp.id = 1;
  ```

---

## 📬 Contato

Para mais informações, entre em contato: [thiagogyorgy.castro@gmail.com](mailto:thiagogyorgy.castro@gmail.com)

---
