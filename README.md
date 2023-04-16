# Desafio Técnico
Sistemas desenvolvidos para o desafio técnico da KontHub.
Consiste em duas aplicações: o backend e o frontend. A aplicação backend é construída utilizando o framework spring boot, ela consome a API do GitHub, obtendo o usuário e seus repositórios. Já a plicação frontend, consome a api backend, pegando os dados e tratando-os.

## Pré-requisitos
[Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

[Node JS](https://nodejs.org/en)

[IDE Spring Tools Suite 4](https://spring.io/tools) (ou outra IDE que trabalhe com spring boot)

[Visual Studio Code](https://code.visualstudio.com/)

## Execução do projeto:
 1. Realize o clone do projeto na sua máquina
 2. Importe o projeto backend para área de trabalho do STS (Nesse momento o STS provavelmente irá baixar as dependências automaticamente)
 3. Clique com o botão direito no projeto na área de trabalho do STS, vá em Run As e clique em Spring Boot App (seu projeto estará rodando).
 4. Abra o VSCode na pasta do projeto frontend.
 5. Rode o comando ```npm install``` na pasta do projeto
 6. Depois de ter instalado as dependências, rode o comando ```npm start```

## Estrutura de pastas utilizadas no projeto
```
desafioback/ 
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
|   |   |   |   ├── kounthub/
|   |   |   |   |   ├── desafioback/
│   │   │   │   |   |   |   ├── controller/
│   │   │   │   │   |   |   |   ├── UsuarioController.java  ## Comunica com a parte externa da aplicação
│   │   │   │   |   |   |   ├── models/
│   │   │   │   │   |   |   |   ├── Falha.java  ## Model para representar as falhas
│   │   │   │   │   |   |   |   ├── Repositorio.java
│   │   │   │   │   |   |   |   ├── Usuario.java
│   │   │   │   |   |   |   ├── service/
│   │   │   │   │   |   |   |   ├── UsuarioService.java  ## Implementa as regras de negócio da aplicação
|   |   |   |   |   |   ├── DesafiobackApplication.java 
│   │   ├── resources/
│   │   │   ├── application.properties
│   ├── test/
│   │   ├── java/
│   │   │   ├── com/
|   |   |   |   ├── kounthub/
|   |   |   |   |   ├── desafioback/
│   │   │   │   |   |   ├── DesafiobackApplicationTests.java  ## Local onde fica os testes
```
