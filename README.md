# Projeto Aluno Online

Projeto Aluno Online feito no período da matéria de Tecnologias para Back End.

## API Aluno Online - Geral

Projeto de uma **API** *RESTful* feito no ecossistema *Spring* com o objetivo de gerenciar o cadastro de alunos, cadastro dos professores, gerenciamento das matérias, e gerenciamento das matriculas dos alunos usando a arquitetura **MVC** (Model-View-Controller) oferecendo a separação clara entre interface, lógica de negócios e acesso a dados.

## Módulos Usados

- Spring Boot.
- Spring Web.
- Spring Data JPA.
- Lombok.
- Driver PostgreSQL.

## Ferramentas e Tecnologias Usadas

- Linguagem **Java** 17 com Framework *Spring*.
- Gerenciador de dependências com **Maven**.
- Banco de Dados **PostgreSQL**.
- Ferramenta de Teste de *Endpoint* **Insomnia**.
- IDE **Intellij IDEA** e Editor de Código **Visual Studio Code**.
- Software Gerenciamento de Bancos **Dbeaver**.
- Padronizador de Código **EditorConfig**.

## Estrutura do Projeto

### 1. *Controller*

O *controller* lida com as chamadas das **request** HTML e retorna os dados, implementando os *EndPoints* do *service*.

### 2. *Model*

O *model* ajuda a construir os atributos das classes de entidade.

### 3. *Repository*

O *repository* define a interface para interagir com os dados que o *service* for pedir, fazendo papel de ponte entre a **API** e o Banco de Dados.

### 4. *Service*

O *service* contem as regras de negócios do repositório atuando de intermediário entre o *controller* e o *repository*.

## Informações sobre o Banco:

- Banco de Dados: **PostgreSQL**.
- Porta: 5432.
- URL: [jdbc:postgresql://localhost:5432/projeto_aluno_online](jdbc:postgresql://localhost:5432/projeto_aluno_online).
- Database: `projeto_aluno_online`.
- Tabelas: 
  - Aluno.

## Documentação Detalhada

Para mais informações detalhadas sobre os módulos **Aluno**, incluindo sua estrutura e métodos, consulte os arquivos: 

- [Aluno.md](documentation/Aluno.md).
