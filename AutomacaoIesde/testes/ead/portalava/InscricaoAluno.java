package ead.portalava;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InscricaoAluno {

	@Test
	public static void main(String[] args) {
		//import generators
		Auxiliar aux = new Auxiliar();
		String aluno = aux.nomeAluno();
		String email = aux.emailGenerator();
		String cpf = aux.CPF();

		// Create a new instance of the browser driver

		for (int i = 0; i <= 1; i ++) {				
			if (i==0){
				System.setProperty("webdriver.chrome.driver","C:\\eclipseLib/chromedriver.exe");
				WebDriver driver = new ChromeDriver();
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
				Auxiliar.Pause5sec();
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
				WebElement Scpf = driver.findElement(By.id("cpf"));
				Scpf.sendKeys(Keys.HOME);
				Scpf.sendKeys(cpf);
				System.out.println(cpf);

				// send name
				driver.findElement(By.id("nome")).sendKeys(aluno);
				System.out.println(aluno);

				// send RG
				driver.findElement(By.id("rg")).sendKeys("129968036");

				// send born date
				WebElement dtanasc = driver.findElement(By.id("dtNascimento"));
				dtanasc.sendKeys(Keys.HOME);
				dtanasc.sendKeys("06121995");

				// select civil state
				driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Estado civil'])[1]/following::span[1]")).click();
				driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Selecione'])[3]/following::span[2]")).click();

				// send DDD
				driver.findElement(By.id("ddd_celular")).sendKeys("41");

				// send number
				WebElement cel = driver.findElement(By.id("celular"));
				cel.sendKeys(Keys.HOME);
				cel.sendKeys("9000000000");

				// send DDD home number
				driver.findElement(By.id("ddd_telefone")).sendKeys("41");

				// send home number
				WebElement tel = driver.findElement(By.id("telefone"));
				tel.sendKeys(Keys.HOME);
				tel.sendKeys("30000000");


				// send email
				driver.findElement(By.id("email")).sendKeys(email);
				System.out.println(email);

				// send CEP
				WebElement cepUsuario = driver.findElement(By.id("cep"));
				cepUsuario.sendKeys(Keys.HOME);
				cepUsuario.sendKeys("83050115");

				driver.findElement(By.id("numero")).sendKeys("100");
				Auxiliar.Pause10sec();
				
				//click to buy
				driver.findElement(By.id("comboid")).click();	
				
				Auxiliar.Pause10sec();
				
				if (tel.isEnabled()) {					
					tel.click();
					tel.sendKeys(Keys.TAB);
					System.out.println("Teste Passou aqui");

					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("window.scrollBy(0,250)", "");
					Auxiliar.Pause5sec();
					driver.findElement(By.id("comboid")).click();	
					Auxiliar.Pause10sec();					
				}
				else {		
					System.out.println("Teste Finalizado");
				}
			
				
				String[] options = {"Continuar", "Fechar"};
				int x = JOptionPane.showOptionDialog(null, "Teste Chrome Efetuado, deseja fechar o browser?",
						"Click a button",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if ( x == 0) {
					//driver.navigate().to("http://ead.portalava.com.br.lab08.dev.iesde.com.br/");
					System.out.println("Finalizado");
				
				} else {
					//Close the browser
					driver.quit();
				}				
				System.out.println("Teste Finalizado");				
			}
		
			else {			
				System.setProperty("webdriver.gecko.driver", "C:\\eclipseLib/geckodriver.exe");
				WebDriver driver = new FirefoxDriver();
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
				Auxiliar.Pause5sec();
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
				WebElement dtanasc = driver.findElement(By.id("dtNascimento"));
				dtanasc.sendKeys(Keys.HOME);
				dtanasc.sendKeys("06121995");

				// select civil state
				driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Estado civil'])[1]/following::span[1]")).click();
				driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Selecione'])[3]/following::span[2]")).click();

				// send DDD
				driver.findElement(By.id("ddd_celular")).sendKeys("41");

				// send number
				WebElement cel = driver.findElement(By.id("celular"));
				cel.sendKeys(Keys.HOME);
				cel.sendKeys("9000000000");

				// send DDD home number
				driver.findElement(By.id("ddd_telefone")).sendKeys("41");

				// send home number
				WebElement tel = driver.findElement(By.id("telefone"));
				tel.sendKeys(Keys.HOME);
				tel.sendKeys("30000000");


				// send email
				driver.findElement(By.id("email")).sendKeys(email);
				System.out.println(email);

				// send CEP
				WebElement cepUsuario = driver.findElement(By.id("cep"));
				cepUsuario.sendKeys("83050-115");

				driver.findElement(By.id("numero")).sendKeys("100");
				Auxiliar.Pause10sec();
				
				//click to buy
				WebElement comprar = driver.findElement(By.id("comboid"));
				comprar.click();

				Auxiliar.Pause40sec();
							
				if (tel.isEnabled()) {					
					tel.click();
					tel.sendKeys(Keys.TAB);
					System.out.println("Teste Passou aqui");

					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("window.scrollBy(0,250)", "");
					
					Auxiliar.Pause5sec();			
					WebElement comprar2 = driver.findElement(By.id("comboid"));
					jse.executeScript("arguments[0].click();", comprar2);	
					Auxiliar.Pause10sec();					
				}
				else {		
					System.out.println("Teste Finalizado");
				}		
				
				JOptionPane.showMessageDialog(null, "Teste Firefox Finalizado");

				driver.quit();
				JOptionPane.showMessageDialog(null, "Teste Firefox Finalizado, clique no botão Concluir");
			}
		}
	}
}
