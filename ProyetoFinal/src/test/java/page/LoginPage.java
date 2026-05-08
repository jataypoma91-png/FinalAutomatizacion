package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(){
        driver.get("https://qalab.bensg.com/store");
    }

    public void clicInicioSesión(){
        WebElement iniciar =driver.findElement(By.xpath("//span[contains(text(), 'Iniciar sesión')]"));
        iniciar.click();
    }

    public void crearCuenta(){
        WebElement crear = driver.findElement(By.xpath("//div[@class='no-account']/a"));
        crear.click();
    }

    public void formulario(String nombre, String apellidos, String email, String contraseña, String fecha){
       WebElement rd = driver.findElement(By.id("field-id_gender-1"));
       rd.click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(nombre);
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(apellidos);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(contraseña);
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys(fecha);
        WebElement check1 = driver.findElement(By.xpath("//input[@name='optin']"));
        check1.click();
        WebElement check2 = driver.findElement(By.xpath("//input[@name='psgdpr']"));
        check2.click();
        WebElement check3 = driver.findElement(By.xpath("//input[@name='newsletter']"));
        check3.click();
        WebElement check4 = driver.findElement(By.xpath("//input[@name='customer_privacy']"));
        check4.click();
    }

    public void botonIngresar(){
        WebElement boton =driver.findElement(By.xpath("//button[@data-link-action='save-customer']"));
        boton.click();
    }

    public String nombreUsuario()throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement usuario = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[@title='Ver mi cuenta de cliente']")));
        Thread.sleep(3000);
        return usuario.getText();
    }
}
