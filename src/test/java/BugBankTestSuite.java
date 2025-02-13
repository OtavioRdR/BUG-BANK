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
    public void cadastroELogin(){

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://bugbank.netlify.app/");

        testCadastroDeNovoUsuario();
        testLoginComUsuarioCadastrado();

    }



    @Test
    @Order(1)
    public void testCadastroDeNovoUsuario() {
        WebElement botaoRegistro = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]"));
        botaoRegistro.click();

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input")) .sendKeys("usuario.teste@gmail.com");
        driver.findElement(By.name("name")) .sendKeys("Usuário Teste");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input")) .sendKeys("senha123");
        driver.findElement(By.name("passwordConfirmation")) .sendKeys("senha123");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[2]/form/button")));
        js.executeScript("arguments[0].click();", driver.findElement(By.id("btnCloseModal")));
    }

    @Test
    @Order(2)
    public void testLoginComUsuarioCadastrado() {
        driver.findElement(By.name("email")) .sendKeys("usuario.teste@gmail.com");
        driver.findElement(By.name("password")) .sendKeys("senha123");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[contains(text(),'Acessar')]")));


    }


    @Test
    @Order(3)
    public void testLoginComSenhaErrada() {

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://bugbank.netlify.app/");

        driver.findElement(By.name("email")) .sendKeys("usuario.teste@gmail.com");
        driver.findElement(By.name("password")) .sendKeys("senhaErrada");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[contains(text(),'Acessar')]")));

        JavascriptExecutor btnFechar = (JavascriptExecutor) driver;
        btnFechar.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[1]")));

    }

    @Test
    @Order(4)
    public void testLoginComEmailInexistente() {

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://bugbank.netlify.app/");

        driver.findElement(By.name("email")) .sendKeys("naoexiste@gmail.com");
        driver.findElement(By.name("password")) .sendKeys("senha123");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[contains(text(),'Acessar')]")));

        JavascriptExecutor btnFechar = (JavascriptExecutor) driver;
        btnFechar.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[1]")));

    }
    @Test
    @Order(5)
    public void testSaqueSemSaldo() throws InterruptedException {

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://bugbank.netlify.app/");

        testCadastroDeNovoUsuario();
        Thread.sleep(5000);
        testLoginComUsuarioCadastrado();
        Thread.sleep(5000);

        JavascriptExecutor btnSaque = (JavascriptExecutor) driver;
        btnSaque.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"btn-SAQUE\"]")));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"modalText\"]"));

        JavascriptExecutor btnFecharSaque = (JavascriptExecutor) driver;
        btnFecharSaque.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"btnCloseModal\"]")));
    }


    @Test
    @Order(6)
    public void testExtrato() throws InterruptedException {

        cadastroELogin();

        driver.findElement(By.xpath("//*[@id=\"btn-EXTRATO\"]")).click();
        Thread.sleep(5000);
        driver.findElements(By.xpath("//*[@id=\"btnBack\"]"));

    }

    @Test
    @Order(7)
    public void testTransferenciaEntreContas() throws InterruptedException {

        cadastroELogin();

        driver.findElement(By.xpath("//*[@id=\"btn-TRANSFERÊNCIA\"]")).click();
        Thread.sleep(5000);

        driver.findElement(By.name("accountNumber")) .sendKeys("177");
        driver.findElement(By.name("digit")) .sendKeys("3");
        driver.findElement(By.name("transferValue")) .sendKeys("3000");
        driver.findElement(By.name("description")) .sendKeys("din  din");
        Thread.sleep(2000);

        driver.findElements(By.xpath("//*[@id=\"btnCloseModal\"]"));
    }

    @Test
    @Order(8)
    public void testVisualizacaoDeSaldo() throws InterruptedException {
        testExtrato();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"textBalanceAvailable\"]"));
        Thread.sleep(2000);

        JavascriptExecutor btnFecharExtrato = (JavascriptExecutor) driver;
        btnFecharExtrato.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"btnBack\"]")));
    }

    @Test
    @Order(9)
    public void testLogout() throws InterruptedException {
        cadastroELogin();
        Thread.sleep(2000);

        JavascriptExecutor btnSairLogout = (JavascriptExecutor) driver;
        Thread.sleep(2000);

        btnSairLogout.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"btnExit\"]")));
    }

    @Test
    @Order(10)
    public void testCadastroComEmailJaCadastrado() throws InterruptedException {
        cadastroELogin();
        Thread.sleep(2000);

        JavascriptExecutor btnSairLogout = (JavascriptExecutor) driver;
        Thread.sleep(2000);

        btnSairLogout.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"btnExit\"]")));
        Thread.sleep(2000);
        testCadastroDeNovoUsuario();
        Thread.sleep(2000);

    }
}
