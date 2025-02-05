# Testes Automatizados com Selenium e JUnit

Este repositório contém testes automatizados para a aplicação [BugBank](https://bugbank.netlify.app/) utilizando Selenium WebDriver e JUnit.

## 📌 Tecnologias Utilizadas
- Java
- Selenium WebDriver
- JUnit 5
- Microsoft Edge WebDriver

## 📋 Pré-requisitos
Antes de executar os testes, certifique-se de ter instalado:
- [Java JDK 8+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi) (caso esteja utilizando gerenciamento de dependências)
- [Microsoft Edge WebDriver](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/)

## 🚀 Configuração
1. Baixe e instale o WebDriver compatível com sua versão do Microsoft Edge.
2. Atualize o caminho do WebDriver no código:
```java
System.setProperty("webdriver.edge.driver", "C:/WebDriver/msedgedriver.exe");
```
3. Clone este repositório:
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```
4. Abra o projeto em sua IDE preferida (IntelliJ, Eclipse, VS Code, etc.).

## 🧪 Cenário de Teste
### Teste de Login
Este teste verifica se um usuário consegue fazer login na aplicação.
- Preenche o campo de e-mail
- Preenche a senha
- Clica no botão de login
- Valida se a mensagem de erro é exibida

## ▶️ Executando os Testes
Para rodar os testes, utilize sua IDE ou execute pelo terminal com:
```bash
mvn test
```

## 📄 Estrutura do Projeto
```
├── src
│   ├── test
│   │   ├── java
│   │   │   ├── LoginTest.java
├── pom.xml (caso use Maven)
├── README.md
```

## 🛠 Possíveis Melhorias
- Adicionar mais cenários de teste (ex.: login válido, recuperação de senha, etc.).
- Implementar Page Object Model (POM) para melhor organização do código.
- Testes cross-browser com Chrome e Firefox.
