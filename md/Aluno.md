## API Aluno Online - Aluno

Objetivo de gerenciar o cadastro de alunos, armazenando informações como nome, email, CPF e geração de um código identificador único.

### 1. *Controller*

O *controller* lida com as **request** HTML para `aluno` e comunicar com o *service*.

#### Annotations em `AlunoController`:

- *@RestController*: Define a classe como um controlador *RESTful*.
- *@RequestMapping("/alunos")*: Define a rota `/alunos`.
- *@PostMapping*: Mapeia requisições HTTP POST para o método `criarAluno()`.
- *@RequestBody*: Converte o corpo da **request** para o objeto `Aluno`.
- *@ResponseStatus(HttpStatus.CREATED)*: Retorna o status 201 (Created) após a criação do objeto `aluno` ser feita com sucesso.

### 2. *Model*

O *model* ajuda a construir os atributos de `aluno`.

#### Annotations em  `Aluno`:

- *@Entity*: Marca a classe como uma entidade **JPA** e representa como uma tabela no banco de dados.
- *@Id*: Define chave primária no banco.
- *@GeneratedValue(strategy = GenerationType.IDENTITY)*: Gera automaticamente o valor da chave primária `id`.
- *@NoArgsConstructor*: Gera um construtor sem parâmetros (*Lombok*).
- *@AllArgsConstructor*: Gera um construtor com todos os parâmetros (*Lombok*).
- *@Data*: Usa o *Lombok* para gerar métodos uteis.

### 3. *Repository*

O *repository* define a interface para interagir com o banco de dados.

#### Annotation em `AlunoRepository`:

- *@Repository*: Define a interface como um repositório de dados.

### 4. *Service*

O *service* contem as regras de negócios do repositório.

#### Annotations em `AlunoService`:

- *@Service*: Marca a classe como um serviço *Spring*.
- *@Autowired*: Permite a injeção do `AlunoRepository`.

### Endpoints em `AlunoService`:
- *criarAluno(Aluno aluno)*: Salva o aluno no banco de dados.
