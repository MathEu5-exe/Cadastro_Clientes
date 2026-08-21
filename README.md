# Sistema de Cadastro de Clientes com Busca de CEP

Projeto desenvolvido em **Java** com **JavaFX** para a disciplina de **Programação II** do curso de Ciência da Computação da Universidade Estadual do Norte do Paraná (UENP). 

A aplicação permite realizar o cadastro de clientes, consultar endereços via CEP automaticamente e visualizar a listagem atualizada em tempo real.
---

## 🚀 Funcionalidades

* **Consulta de CEP em Tempo Real:** Preenchimento automático dos campos de logradouro, cidade (localidade) e estado ao informar o CEP e clicar em *Buscar*.
* **Tratamento de Erros de CEP:** Validação de formato e exibição de mensagens de alerta específicas em caso de falha de conexão ou CEP não localizado.
* **Cadastro com ID Auto-incremental:** Atribuição automática e estática da numeração única de cada cliente cadastrado (`codigo`).
* **Tabela Dinâmica (`TableView`):** Exibição em tempo real dos clientes armazenados em memória com atualização imediata a cada gravação.
* **Limpeza de Formulário:** Botão para resetar rapidamente todos os campos da tela.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 11
* **Interface Gráfica:** JavaFX (FXML + Scene Builder)
* **Gerenciador de Dependências:** Apache Maven
* **Requisições HTTP:** Apache HttpClient (`org.apache.httpcomponents:httpclient`)
* **Processamento JSON:** Jackson Databind (`com.fasterxml.jackson.core:jackson-databind`)
* **Feito no IntelliJ**

---

## 📁 Estrutura do Projeto

```text
src/
└── main/
    ├── java/
    │   ├── module-info.java                     # Declarações e permissões do módulo JavaFX
    │   └── com/mycompany/cadastro_cliente/
    │       ├── App.java                         # Classe principal (main)
    │       ├── PrimaryController.java           # Controlador da interface
    │       ├── Buscador.java                    # Integração com serviço de CEP[cite: 1]
    │       ├── Cliente.java                     # Modelo de dados do Cliente[cite: 1]
    │       └── Endereco.java                    # Modelo de dados do Endereço[cite: 1]
    └── resources/
        └── com/mycompany/cadastro_cliente/
            └── primary.fxml                     # Interface gráfica do usuário
