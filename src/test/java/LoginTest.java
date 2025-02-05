import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:/WebDriver/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://bugbank.netlify.app/");
    }
    @AfterEach
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

    @Test
    public void testLoginComSucesso() {
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("nometeste@gmail.com");

        WebElement senhaInput = driver.findElement(By.name("password"));
        senhaInput.sendKeys("testedesenha");

        WebElement botaoLogin = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[1]"));
        botaoLogin.click();

        WebElement mensagemDeFalha = driver.findElement(By.xpath("//*[@id=\"btnCloseModal\"]"));
        assertTrue(mensagemDeFalha.isDisplayed(), "Usuário ou senha inválido.\n" +
                "Tente novamente ou verifique suas informações!");
    }

}

