# Agora System (API)

![Java](https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=java)
![Status](https://img.shields.io/badge/Status-JDBC%20Conclu%C3%ADdo-success?style=for-the-badge)
![Version](https://img.shields.io/badge/version-v1.0.0-blue?style=for-the-badge)

O Agora System é um projeto de simulação bancária. Ele é um projeto para os meus estudos de programação e a intenção e evoluí-lo junto comigo.

O objetivo aqui não é criar um banco real, mas sim colocar em prática os conceitos e boas práticas de código à medida que os domino.

---

![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

---

## Aprendizado

Nesta fase do projeto, o foco não foi a interface gráfica, mas sim a robustez do lado do servidor. O desenvolvimento desta versão ajudou a consolidar:

- **Padrão DAO:** Separação entre os objetos e a estrutura de banco de dados, utilizando interfaces (`UserDao`, `AccountDao`).
- **Padrão Factory:** Utilização do `DaoFactory` para instanciar as implementações de acesso a dados, adicionando uma camada de abstração sobre como os objetos são criados.
- **JDBC Puro:** Compreensão sobre `Connection`, `PreparedStatement` e extração de dados com `ResultSet`, incluindo o mapeamento objeto-relacional manual.
- **Gestão de Identidade:** Implementação de um cache manual utilizando `HashMap` durante a extração de dados, evitando a duplicação de objetos e garantindo a identidade correta do usuário.
- **Tratamento de Exceções Blindado:** Captura de `SQLException` e conversão para exceções personalizadas (`DatabaseException`), protegendo a aplicação contra vazamento de detalhes da infraestrutura.

---

## Funcionalidades Atuais

- CRUD completo para Usuários.
- CRUD completo para Contas (Corrente e Poupança), lidando com Chaves Estrangeiras.
- Utilitários dinâmicos de instanciação de objetos.
- Script de teste de integração na classe `Main`.

## Como testar a conexão?

Caso queira rodar o código e ver a comunicação com o banco na sua máquina:

1. Clone o repositório:
   ```bash
   git clone https://github.com/rynwllngtn/agora-system-api.git
   ```
3. Faça o download das bibliotecas usando:
   ```
   mvn clean install
   ```
   Ou use as ferramentas da sua IDE (como no Intellij).
2. Renomeie o arquivo `db.example.properties` para `db.properties` e insira as suas credenciais do MySQL local.

4. Compile e execute a classe Main (que contém o script de teste de integração).

---

## Linha do Tempo

Estou mantenho um registro detalhado de cada mudança que aplico na API do sistema.  
Você pode acompanhar essa evolução no meu [CHANGELOG.md](./CHANGELOG.md).