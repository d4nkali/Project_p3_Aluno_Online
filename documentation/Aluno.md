# API Aluno Online - Aluno

Objetivo: Gerenciar o cadastro de alunos, armazenando informações como nome, e-mail, CPF e gerando um código identificador único.

---

### **1. Controller**

O *controller* lida com as requisições HTTP para a rota `/alunos` e se comunica com o *service* para executar as operações de negócio.

#### **Annotations em `AlunoController`:**

- `@RestController`: Define a classe como um controlador *RESTful*.
- `@RequestMapping("/alunos")`: Define a rota base `/alunos`.
- `@PostMapping`: Mapeia requisições HTTP POST para o método `criarAluno()`.
- `@PutMapping("/{id}")`: Mapeia requisições HTTP PUT para o método `atualizarAlunoPorID()`.
- `@RequestBody`: Converte o corpo da requisição para o objeto `Aluno`.
- `@ResponseStatus(HttpStatus.CREATED)`: Retorna o status 201 (Created) após a criação do objeto `aluno` ser feita com sucesso.
- `@ResponseStatus(HttpStatus.NO_CONTENT)`: Retorna o status 204 (No Content) após a atualização do aluno.


#### **Endpoints:**

- `POST /alunos`: Cria um novo aluno.
- `GET /alunos`: Lista todos os alunos.
- `GET /alunos/{id}`: Busca um aluno pelo seu ID.
- `DELETE /alunos/{id}`: Deleta um aluno pelo seu ID.
- `PUT /alunos/{id}`: Atualiza um aluno pelo seu ID.

---

### **2. Model**

A classe *model* define os atributos e a estrutura de dados do aluno.

#### **Annotations em `Aluno`:**

- `@Entity`: Marca a classe como uma entidade JPA representada como tabela no banco de dados.
- `@Id`: Define a chave primária.
- `@GeneratedValue(strategy = GenerationType.IDENTITY)`: Configura a geração automática do valor da chave primária.
- `@NoArgsConstructor` e `@AllArgsConstructor` (*Lombok*): Gera construtores sem e com parâmetros, respectivamente.
- `@Data` (*Lombok*): Gera automaticamente métodos *getter*, *setter*, *toString*, entre outros.

---

### **3. Repository**

O *repository* gerencia a interação com o banco de dados.

#### **Annotation em `AlunoRepository`:**

- `@Repository`: Define a interface como um repositório Spring Data JPA.

---

### **4. Service**

O *service* contém as regras de negócio e atua como intermediário entre o *controller* e o *repository*.

#### **Annotations em `AlunoService`:**

- `@Service`: Marca a classe como um serviço no Spring.
- `@Autowired`: Injeta automaticamente o `AlunoRepository`.

#### **Métodos em `AlunoService`:**

1. `criarAluno(Aluno aluno)`: Salva um aluno no banco de dados.
2. `listarTodosAlunos()`: Retorna uma lista de todos os alunos.
3. `buscarAlunoPorId(Long id)`: Busca um aluno pelo ID.
4. `deletarAlunoPorId(Long id)`: Deleta um aluno pelo ID.
5. `atualizarAlunoPorID(Long id, Aluno aluno)`: Atualiza as informações de um aluno pelo ID.
