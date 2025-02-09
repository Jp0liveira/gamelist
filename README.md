# 🎮 GameList API

**GameList** é uma API REST desenvolvida com **Spring Boot** para gerenciar listas de jogos.  

---

## 📌 Tecnologias Utilizadas

- **Linguagem:** Java 21+
- **Framework:** Spring Boot
- **Banco de Dados:** H2 (memória) e PostgreSQL
- **ORM:** Spring Data JPA / Hibernate
- **API REST:** Padrão RESTful
- **Segurança:** CORS Policy
- **Deploy:** Railway (opcional) / Docker

---

## 🚀 Funcionalidades

- 📌 **Gerenciar jogos:** Listar todos os jogos e visualizar detalhes individuais.  
- 📂 **Gerenciar listas de jogos:** Criar e organizar listas de jogos personalizadas.  
- 🔄 **Reordenar jogos na lista:** Atualizar a posição de um jogo dentro de uma lista.  
- 🌐 **API RESTful:** Comunicação via **HTTP/JSON** utilizando **GET, POST, PUT e DELETE**.  

---

## 📎 Endpoints

### 🎲 Jogos (`/games`)
- **GET `/games`** → Retorna uma lista de jogos (`GameMinDTO`).
- **GET `/games/{id}`** → Retorna os detalhes de um jogo específico (`GameDTO`).

### 📂 Listas de Jogos (`/lists`)
- **GET `/lists`** → Retorna todas as listas (`GameListDTO`).
- **GET `/lists/{listId}/games`** → Retorna os jogos dentro de uma lista específica.
- **POST `/lists/{listId}/replacement`** → Move um jogo de posição dentro da lista.

---

## 🛠️ Como Rodar o Projeto

### 1️⃣ Clone o repositório  
```sh
git clone https://github.com/seu-usuario/gamelist.git
sh cd gamelist
````

### 2️⃣ Execute o projeto
```sh
./mvnw spring-boot:run
````

### 3️⃣ Acesse a API
```sh
http://localhost:8080/games
````

## Conceitos Implementados
- ✅ Fundamentos de APIs REST
  - Comunicação HTTP entre cliente e servidor
  - Formato JSON para requisições e respostas
  - Padrão REST para organização dos endpoints

- ✅ Arquitetura do Projeto
  - Estruturação de projetos Spring Boot
  - MVC: Controllers, Services, Repositories
  - DTOs para otimizar transferência de dados
  - Banco de dados com JPA e Hibernate
  
- ✅ Banco de Dados e Consultas Avançadas
  - Mapeamento ORM com Hibernate
  - Relacionamentos N-N e classe de associação
  - Consultas SQL personalizadas no Spring Data JPA
  
- ✅ Boas Práticas e Deploy
  - Configuração de perfis (test, dev, prod)
  - Deploy no Railway com PostgreSQL
  - Configuração de CORS para segurança
  - Docker 

## 📜 Licença
Este projeto está sob a licença MIT.
