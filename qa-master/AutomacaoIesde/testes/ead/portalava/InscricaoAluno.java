package ead.portalava;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InscricaoAluno {
	public static void Pause5sec() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void Pause10sec() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void Pause40sec() {
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//random name
	public String nomeAluno() {
		Random rnd = new Random();
		String str = "";
		String str1 = "";
		String sob = "";
		int supName = 0;

		for (int i = 0; i < 10; i++) {
			supName = (rnd.nextInt(99));
			String str2 = "Aluno";
			str = String.valueOf(supName);
			str1 = str2.concat(str);
		}
		for (int i = 0; i < 10; i++) {
			supName = (rnd.nextInt(100));
			String str2 = " teste";
			str = String.valueOf(supName);
			sob = str2.concat(str);
		}

		return str1.concat(sob);
	}
	
	//random email
	public String emailGenerator() {
		Random rnd = new Random();
		String str = "";
		String str1 = "";
		String sob = "";
		int supName = 0;

		for (int i = 0; i < 10; i++) {
			supName = (rnd.nextInt(99));
			String str2 = "aluno";
			str = String.valueOf(supName);
			str1 = str2.concat(str);
		}
		for (int i = 0; i < 10; i++) {
			supName = (rnd.nextInt(100));
			String str2 = "@iesde.com.br";
			str = String.valueOf(supName);
			sob = str.concat(str2);
		}

		return str1.concat(sob);
	}

	// CPF generator
	public class CPF {

		public String generate() {

			Random r = new Random();

			StringBuilder sbCpfNumber = new StringBuilder();

			for (int i = 0; i < 9; i++) {

				sbCpfNumber.append(r.nextInt(9));

			}

			return generateDigits(sbCpfNumber.toString());

		}

		public boolean validateCPF(String cpf) {

			if (cpf.length() == 11) {

				if (cpf.equals(generateDigits(cpf.substring(0, 9)))) {

					return true;
				}
			}
			return false;
		}

		private String generateDigits(String digitsBase) {

			StringBuilder sbCpfNumber = new StringBuilder(digitsBase);

			int total = 0;

			int multiple = digitsBase.length() + 1;

			for (char digit : digitsBase.toCharArray()) {

				long parcial = Integer.parseInt(String.valueOf(digit)) * (multiple--);

				total += parcial;
			}

			int resto = Integer.parseInt(String.valueOf(Math.abs(total % 11)));

			if (resto < 2) {
				resto = 0;
			} else {
				resto = 11 - resto;
			}

			sbCpfNumber.append(resto);

			if (sbCpfNumber.length() < 11) {
				return generateDigits(sbCpfNumber.toString());
			}
			return sbCpfNumber.toString();
		}
	}

	@Test
	public void cadastroAluno() {
		//import generators
		String aluno = nomeAluno();
		String email = emailGenerator();
		CPF myCPF = new CPF();
		String cpf = myCPF.generate();

		// Create a new instance of the browser driver
		System.setProperty("webdriver.gecko.driver", "C:\\eclipseLib/geckodriver.exe");
		// "System.setProperty("webdriver.chrome.driver",
		// "C:\\eclipseLib/chromedriver.exe");

		WebDriver driver = new FirefoxDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);

		// implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// And now use this to visit the EAD
		driver.get("http://inscricao2.ead.unifacvest.com.br.lab08.dev.iesde.com.br/");
		driver.manage().window().maximize();

		// Select new register
		WebElement novoCadastro = driver.findElement(By.id("test_processo_seletivo"));
		novoCadastro.click();

		// select courses
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Curso'])[1]/following::span[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Selecione o curso'])[3]/following::span[2]")).click();

		// select state
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Estado'])[1]/following::button[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Paraíba'])[1]/following::span[2]")).click();

		// wait 5 seconds
		Pause10sec();

		// select city
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cidade'])[1]/following::span[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Selecione'])[2]/following::input[1]")).clear();
		WebElement cidade = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Selecione'])[2]/following::input[1]"));
		cidade.sendKeys("curitiba");
		cidade.sendKeys(Keys.ENTER);

		Pause10sec();

		// select polo location
		driver.findElement(By.name("EnderecoPoloID")).click();

		Pause10sec();

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
		Pause5sec();
		
		//click to buy
		WebElement comprar = driver.findElement(By.id("comboid"));
		comprar.click();	
		
		//wait for comboid present
		wait.until(  ExpectedConditions.visibilityOfElementLocated(By.id("comboid")));

		System.out.println("Elemento visivel");
		
		comprar.click();
		
		for (String winHandle : driver.getWindowHandles()) {
			// switch focus of WebDriver to the next found window handle (that's your newly
			driver.switchTo().window(winHandle);
		}
		
		System.out.println("Teste Finalizado");

		
	}

}
