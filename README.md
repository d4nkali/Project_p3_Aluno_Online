# Projeto Aluno Online

Projeto Aluno Online feito no período da matéria de Tecnologias para Back End.

## API Aluno Online - Geral

Projeto de uma **API** *RESTful* feito no ecossistema *Spring* com o objetivo de gerenciar o cadastro de alunos, cadastro dos professores, gerenciamento das matérias, e gerenciamento das matriculas dos alunos usando a arquitetura **MVC** (Model-View-Controller) oferecendo a separação clara entre interface, lógica de negócios e acesso a dados.

## Módulos Usados

- Spring Boot - Framework principal para desenvolvimento da API.

- Spring Web - Modulo que ajuda na implementação de *endpoints* e suporte as *request* HTTP.

- Spring Data JPA - Modulo que facilita a interação com o banco de dados, simplificando o *crud*.

- Lombok - Modulo que facilita no código gerando os métodos como `get`, `set`, `toString` e entre outros, reduzindo a repetição de código.

- Driver PostgreSQL - Modulo necessário para o *Spring* se comunicar com o Banco de Dados **PostgreSQL**.

- Swagger - Modulo que gerar documentação interativa via uma url da API, facilitando a visualizar e testar as funcionalidades da API.

## Ferramentas e Tecnologias Usadas

- Linguagem **Java** 17 com Framework *Spring*.
- Gerenciador de dependências com **Maven**.
- Banco de Dados **PostgreSQL**.
- Ferramenta de Teste de *Endpoint* **Insomnia**.
- IDE **Intellij IDEA** e Editor de Código **Visual Studio Code**.
- Software Gerenciamento de Bancos **Dbeaver**.
- Padronizador de Código **EditorConfig**.

## Estrutura do Projeto

### 1. *Model*

O *model* ajuda a construir os atributos das classes de entidade do sistema.

A **API** possui 4 *models*: `Aluno`, `Professor`, `a` e `MatriculaAluno`.

### 2. *Controller*

O *controller* lida com as chamadas das **request** HTML e retorna os dados, implementando os *EndPoints* do *service*. Cada *model* possui um *controller*.

### 3. *Repository*

O *repository* define a interface para interagir com os dados que o *service* for pedir, fazendo papel de ponte entre a **API** e o Banco de Dados. Cada *model* possui um *repository*.

### 4. *Service*

O *service* contem as regras de negócios do repositório atuando de intermediário entre o *controller* e o *repository*. Cada *model* possui um *service*.

### 5. *DTO (Data Transfer Object)* 

Os DTO são usados para transportar dados entre as camadas sem expor diretamente as entidades do banco.

- `AtualizarNotasRequest`: DTO utilizado para enviar as notas a serem atualizadas de um aluno em uma disciplina.
- `DisciplinasAlunoResponse`: DTO que representa as disciplinas matriculadas por um aluno, incluindo informações como nome da disciplina, nome do professor, notas e status.
- `HistoricoAlunoResponse`: DTO que representa o histórico acadêmico de um aluno, exibindo todas as disciplinas cursadas e as respectivas notas.

### 6. *Enums* 

Contém as enumerações utilizadas no sistema.

- `MatriculaAlunoStatusEnum`: Enum que define os status possíveis de uma matrícula de aluno:
  - **MATRICULADO**: O aluno está matriculado na disciplina.
  - **TRANCADO**: O aluno trancou a matrícula na disciplina.
  - **APROVADO**: O aluno foi aprovado na disciplina.
  - **REPROVADO**: O aluno foi reprovado na disciplina.


### 7. *Config*

O config possui a configuração do Swagger para gerar a documentação da API.

### 8. *application.proprieties*

O arquivo [application.properties](api/src/main/resources/application.properties) configura a conexão do PostgreSQL com o Spring.

## Informações sobre o Banco:

- Banco de Dados: **PostgreSQL**.
- Porta: 5432.
- URL: [jdbc:postgresql://localhost:5432/projeto_aluno_online](jdbc:postgresql://localhost:5432/projeto_aluno_online).
- Database: `projeto_aluno_online`.
- Tabelas: 
  - Aluno.
  - Professor.
  - Disciplinas.
  - Matricula Aluno.
