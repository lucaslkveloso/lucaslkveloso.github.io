package ead.portalava;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Teste {

	@Test
	public void cadastroAluno() {
		//import generators
		Auxiliar aux = new Auxiliar();
		
		String aluno = aux.nomeAluno();
		String email = aux.emailGenerator();
		String cpf = aux.CPF();		

		// Create a new instance of the browser driver
		System.setProperty("webdriver.gecko.driver", "C:\\eclipseLib/geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver","C:\\eclipseLib/chromedriver.exe");

		WebDriver driver = new FirefoxDriver();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// And now use this to visit the EAD
		driver.get("http://inscricao2.ead.unifacvest.com.br.lab08.dev.iesde.com.br/");
		driver.manage().window().maximize();

		// Select new register
		WebElement novoCadastro = driver.findElement(By.id("novoCadastro"));
		novoCadastro.click();

		// select courses
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Curso'])[1]/following::span[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Selecione o curso'])[3]/following::span[2]")).click();

		// select state
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Estado'])[1]/following::button[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Paraíba'])[1]/following::span[2]")).click();

		// wait 5 seconds
		Auxiliar.Pause10sec();

		// select city
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cidade'])[1]/following::span[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Selecione'])[2]/following::input[1]")).clear();
		WebElement cidade = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Selecione'])[2]/following::input[1]"));
		cidade.sendKeys("curitiba");
		cidade.sendKeys(Keys.ENTER);

		Auxiliar.Pause10sec();

		// select polo location
		driver.findElement(By.name("EnderecoPoloID")).click();

		Auxiliar.Pause10sec();

		// close old tab
		driver.close();

		for (String winHandle : driver.getWindowHandles()) {
			// switch focus of WebDriver to the next found window handle (that's your newly
			// opened window)
			driver.switchTo().window(winHandle);
		}

		// send CPF
		driver.findElement(By.id("cpf")).sendKeys(cpf);
		System.out.println(cpf);

		// send name
		driver.findElement(By.id("nome")).sendKeys(aluno);
		System.out.println(aluno);

		// send RG
		driver.findElement(By.id("rg")).sendKeys("129968036");

		// send born date
		driver.findElement(By.id("dtNascimento")).sendKeys("06/12/1995");

		// select civil state
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Estado civil'])[1]/following::span[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Selecione'])[3]/following::span[2]")).click();

		// send DDD
		driver.findElement(By.id("ddd_celular")).sendKeys("41");

		// send number
		driver.findElement(By.id("celular")).sendKeys("9000000000");

		// send DDD home number
		driver.findElement(By.id("ddd_telefone")).sendKeys("41");

		// send home number
		driver.findElement(By.id("telefone")).sendKeys("30000000");

		// send email
		driver.findElement(By.id("email")).sendKeys(email);
		System.out.println(email);

		// send CEP
		driver.findElement(By.id("cep")).sendKeys("83050115");

		driver.findElement(By.id("numero")).sendKeys("100");
		Auxiliar.Pause40sec();
		
		//click to buy
		driver.findElement(By.id("comboid")).click();

		System.out.println("Teste Finalizado");

		
	}

}
