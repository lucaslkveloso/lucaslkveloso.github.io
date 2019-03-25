package ead.portalava;


import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GerarTermo {

	@Test
	public void gerarTermo() {
		
		//Import class @Auxiliar.
		Auxiliar aux = new Auxiliar();
		String aluno = aux.nomeAluno();
		String email = aux.emailGenerator();
		String cpf = aux.CPF();
		
		
		// for string use the format aux.emailGenerator();
		// for time function use the format Auxiliar.Pause10sec();
		
		
        // Create a new instance of the Firefox driver
		System.setProperty("webdriver.gecko.driver", "C:\\eclipseLib/geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\eclipseLib/chromedriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // And now use this to visit Google
        driver.get("http://ead.portalava.com.br.lab08.dev.iesde.com.br/login");
        driver.manage().window().maximize();
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");
        
        WebElement login = driver.findElement(By.id("exampleInputEmail1"));
        login.click();
        login.sendKeys("lucas.veloso@iesde.com.br");
        
        WebElement password = driver.findElement(By.id("exampleInputPassword1"));
        password.click();
        password.sendKeys("abcd");
        
        //login
        driver.findElement(By.xpath("//button[@type='submit'][contains(.,'Acessar')]")).click();
        
        Auxiliar.Pause5sec();
        //select profile
        driver.findElement(By.xpath("//a[contains(.,'ADMINISTRADOR')]")).click();
        
        //select matricula
        driver.findElement(By.xpath("//a[@role='button'][contains(.,'Matrícula')]")).click();
        
        Auxiliar.Pause5sec();
        
        //termo de adesão
        driver.findElement(By.xpath("//a[@tabindex='-1'][contains(.,'Confirmar local e gerar termo de adesão')]")).click();
        
        Auxiliar.Pause10sec();
        
        //Novo termo
        driver.findElement(By.xpath("//a[@class='btn btn-primary'][contains(.,'Novo')]")).click();
        
        Auxiliar.Pause5sec();
        
        //Seleção da certificadora
        WebElement certificadora = driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(.,'Selecione...')]"));
        certificadora.click();
        WebElement certificadora1 = driver.findElement(By.xpath("(//input[contains(@type,'text')])[1]"));
        certificadora1.click();
        certificadora1.sendKeys("UNIFACVEST EAD");
        certificadora1.sendKeys(Keys.ENTER);
       

        
        String[] options = {"Continuar", "Fechar"};
        int x = JOptionPane.showOptionDialog(null, "Teste Efetuado",
                "Click a button",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if ( x == 0) {
        	//driver.navigate().to("http://ead.portalava.com.br.lab08.dev.iesde.com.br/");
        	System.out.println("Finalizado");
        
        } else {
	        //Close the browser
	        driver.quit();
        }
    }

}
