# Agora System (API)

![Java](https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=java)
![Status](https://img.shields.io/badge/Status-EM%20EVOLUÇÂO-success?style=for-the-badge)
![Version](https://img.shields.io/badge/version-v0.2.1-blue?style=for-the-badge)

O Agora System é um projeto de simulação bancária. Ele é um projeto para os meus estudos de programação e a intenção e evoluí-lo junto comigo.  
O objetivo aqui não é criar um banco real, mas sim colocar em prática os conceitos e boas práticas de código à medida que os domino.

---

![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

---

## Aprendizado

Nesta fase do projeto, o foco não foi a interface gráfica, mas sim a robustez do lado do servidor. O desenvolvimento desta versão ajudou a consolidar:

- **Spring Boot & Injeção de Dependências:** Substituição de instanciações manuais pelo controle do Spring (`@Autowired`, `@Service`, `@RestController`).
- **Spring Data JPA:** Eliminação de consultas SQL manuais e DAOs abstratos através da implementação de `Repositories`.
- **Design de API RESTful:** Criação de *Controllers* para expor os dados da aplicação via rotas HTTP (ex: `GET /users`).
- **Arquitetura em Camadas:** Divisão de responsabilidades entre *Controllers*, *Services*, *Repositories* e *Entities*.

---

## Funcionalidades Atuais

- **API REST:** Métodos para listagem e consulta de Usuários e Contas.
- **Mapeamento Relacional:** Entidades `User` e `Account` mapeadas com herança `SINGLE_TABLE`.
- **Database Seeding:** Preenchimento automático do banco de dados para testes utilizando `CommandLineRunner`.

---

## Como testar a conexão?

Caso queira rodar o código e ver a comunicação com o banco na sua máquina:

1. Clone o repositório:
   ```bash
   git clone https://github.com/rynwllngtn/agora-system-api.git
   ```
2. Renomeie o arquivo `application.example.properties` para `application.properties`.
3. Insira as suas credenciais do MySQL local e o nome da base de dados no novo arquivo.
4. Rode a aplicação usando o Maven Wrapper na raiz do projeto:
   ```bash
   ./mvnw spring-boot:run
   ```
   ou inicie a classe Main diretamente pela sua IDE (como no IntelliJ).
5. Acesse `http://localhost:8080/users` no seu navegador ou Postman para ver o retorno em JSON da API.

---

## Linha do Tempo

Estou mantenho um registro detalhado de cada mudança que aplico na API do sistema.  
Você pode acompanhar essa evolução no meu [CHANGELOG.md](./CHANGELOG.md).