# 📄 README - Testes Automatizados do BugBank

## 📌 Sobre
Este projeto contém testes automatizados para validar as principais funcionalidades do BugBank, um sistema de banco digital. Os testes foram implementados utilizando Selenium WebDriver e JUnit, proporcionando uma abordagem eficiente para garantir a qualidade do software.

## 📋 Testes Implementados
Os seguintes cenários de teste foram cobertos:
- **Cadastro de novo usuário:** Verifica se um novo usuário pode se cadastrar com sucesso.
- **Login com usuário cadastrado:** Confirma se um usuário cadastrado pode fazer login.
- **Login com senha errada:** Testa a resposta do sistema ao tentar login com senha incorreta.
- **Login com email inexistente:** Verifica a reação do sistema ao tentar login com um email que não está registrado.
- **Saque sem saldo:** Avalia se o sistema impede saques quando não há saldo disponível.
- **Visualização de extrato:** Verifica se o usuário pode visualizar seu extrato bancário.
- **Transferência entre contas:** Testa a funcionalidade de transferência de fundos entre contas.
- **Visualização de saldo:** Confirma se o usuário consegue ver o saldo da conta.
- **Logout:** Garante que o usuário pode se desconectar do sistema.
- **Cadastro com email já cadastrado:** Verifica se o sistema impede o cadastro com um email já utilizado.

## 🛠 Tecnologias Utilizadas
As seguintes tecnologias e ferramentas foram utilizadas no desenvolvimento dos testes:
- **Java:** Linguagem de programação utilizada para implementar os testes.
- **Selenium WebDriver:** Ferramenta para automação de navegadores web.
- **JUnit:** Framework de testes para Java.
- **EdgeDriver:** WebDriver utilizado para automatizar o navegador Microsoft Edge.

## 🚀 Como executar os testes
Para executar os testes, siga os passos abaixo:
1. **Instale o Java JDK:** Certifique-se de ter o Java Development Kit instalado em sua máquina.
2. **Instale o Maven:** Se necessário, instale o Maven para gerenciar as dependências do projeto.
3. **Configure o WebDriver:** Baixe e configure o WebDriver no caminho correto (por exemplo, `C:/WebDriver/msedgedriver.exe`).
4. **Clone este repositório:** Faça o clone deste repositório para sua máquina local.
5. **Execute os testes:** Navegue até a pasta do projeto no terminal e execute os testes com o comando `mvn test`.

## 📂 Documentos Anexos
- [BDD - Testes](path/to/bdd.doc): Documento com a descrição dos cenários de teste (Behavior Driven Development).
- [Evidência do Bug](path/to/evidencia_do_bug.doc): Relatório com as evidências dos bugs encontrados durante a execução dos testes.

## 📝 Exemplo de Código de Teste

Aqui está um exemplo de como os testes foram implementados:

```java
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BugBankTestSuite {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.edge.driver", "C:/WebDriver/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://bugbank.netlify.app/");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void cadastroELogin() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://bugbank.netlify.app/");
        testCadastroDeNovoUsuario();
        testLoginComUsuarioCadastrado();
    }

    // Outros métodos de teste...

}
