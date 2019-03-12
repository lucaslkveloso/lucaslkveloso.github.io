package ead.portalava;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class loginPortal {

	@Test
	public void sendDepoimentos() {
        // Create a new instance of the browser driver
		System.setProperty("webdriver.gecko.driver", "C:\\eclipseLib/geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\eclipseLib/chromedriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // And now use this to visit the EAD
        driver.get("http://ead.portalava.com.br.lab08.dev.iesde.com.br/");
        driver.manage().window().maximize();

        // Find inputs of form
        WebElement loginEmail = driver.findElement(By.name("email"));
        WebElement loginSenha = driver.findElement(By.name("senha"));
        WebElement loginSubmit = driver.findElement(By.cssSelector("button.btn.btn-primary.aj-btn-login"));

        // Enter something to form
        loginEmail.sendKeys("lucas.veloso@iesde.com.br");
        loginSenha.sendKeys("abcd");
               
        // Now submit the form. WebDriver will find the form for us from the element
        loginSubmit.click();

        //List title of page
        System.out.println("Page title is: " + driver.getTitle());
 
        
        WebElement perfilAdministrador = driver.findElement(By.linkText("ADMINISTRADOR"));
        perfilAdministrador.click();
        
        WebElement menuRelatorio = driver.findElement(By.linkText("Relatórios"));
        menuRelatorio.click();
        
        WebElement menuPaiRelatorio = driver.findElement(By.linkText("Moderação"));
        menuPaiRelatorio.click();
        
        WebElement menuModeracao = driver.findElement(By.linkText("Moderação de conteúdo"));
        menuModeracao.click();     
        
        
        WebElement selectInstituicao = driver.findElement(By.cssSelector("button.btn.dropdown-toggle.btn-default"));
        Select dropdown = new Select(selectInstituicao);
        dropdown.selectByVisibleText("SÃO LUÍS");
        
        WebElement btnBuscar = driver.findElement(By.id("btnBuscar"));
        btnBuscar.click();
        
        String[] options = {"Continuar", "Fechar"};
        int x = JOptionPane.showOptionDialog(null, "Teste Efetuado",
                "Click a button",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if ( x == 0) {
        	driver.navigate().to("http://ead.portalava.com.br.lab08.dev.iesde.com.br/");
        	System.out.println("Finalizado");
        
        } else {
	        //Close the browser
	        driver.quit();
        }
        
    }

}
