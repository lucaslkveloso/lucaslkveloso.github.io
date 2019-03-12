package ead.portalava;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class postDepoimentosTest {

	@Test
	public void sendDepoimentos() {
        // Create a new instance of the Firefox driver
		//System.setProperty("webdriver.gecko.driver", "C:\\eclipseLib/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\eclipseLib/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // And now use this to visit Google
        driver.get("http://util.lab08.dev.iesde.com.br/teste.html");
        driver.manage().window().maximize();
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find inputs of form
        WebElement formNome = driver.findElement(By.name("Nome"));
        WebElement formEmail = driver.findElement(By.name("Email"));
        WebElement formCurso = driver.findElement(By.name("CursoID"));
        WebElement formDepoimento = driver.findElement(By.name("Depoimento"));
        WebElement formSubmit = driver.findElement(By.name("Submit"));

        // Enter something to form
        formNome.sendKeys("Lucas 6");
        formEmail.sendKeys("teste@novoteste.com");
        formCurso.sendKeys("291");
        formDepoimento.sendKeys("Lorem ipsum dolor sit amet, "
        		+ "ionsectetur adipiscing elit, sed do eiusmod tempor "
        		+ "incididunt ut labore et dolore magna aliqua. Ut enim ad"
        		+ " minim veniam, quis nostrud exercitation ullamco laboris nisi"
        		+ " ut aliquip ex ea commodo consequat. Duis aute irure dolor in "
        		+ "reprehenderit in voluptate velit esse cillum dolore eu fugiat "
        		+ "nulla pariatur. Excepteur sint occaecat cupidatat non proident");

               
        // Now submit the form. WebDriver will find the form for us from the element
        formSubmit.click();

        //List title of page
        System.out.println("Page title is: " + driver.getTitle());
        
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
