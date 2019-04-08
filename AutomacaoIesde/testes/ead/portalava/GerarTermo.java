package ead.portalava;


import java.util.concurrent.TimeUnit;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GerarTermo {

	@Test
	public static void main(String[] args) {
		
		//Import class @Auxiliar.
		Auxiliar aux = new Auxiliar();
		String aluno = aux.nomeAluno();
		String email = aux.emailGenerator();
		String cpf = aux.CPF();
		
		
		// for string, use the format aux.emailGenerator();
		// for time function, use the format Auxiliar.Pause10sec();
		
		
        // Create a new instance of the Firefox driver
		//System.setProperty("webdriver.gecko.driver", "C:\\eclipseLib/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\eclipseLib/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
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
            //select profile
        driver.findElement(By.xpath("//a[contains(.,'ADMINISTRADOR')]")).click();
        
        //select matricula
        driver.findElement(By.xpath("//a[@role='button'][contains(.,'Matrícula')]")).click();
            
        //termo de adesão
        driver.findElement(By.xpath("//a[@tabindex='-1'][contains(.,'Confirmar local e gerar termo de adesão')]")).click();
        
        //Novo termo
        driver.findElement(By.xpath("//a[@class='btn btn-primary'][contains(.,'Novo')]")).click();
            
        //select certificadora
        WebElement certificadora = driver.findElement(By.xpath("//span[@class='filter-option pull-left'][contains(.,'Selecione...')]"));
        certificadora.click();
        WebElement certificadora1 = driver.findElement(By.xpath("(//input[contains(@type,'text')])[1]"));
        certificadora1.click();
        certificadora1.sendKeys("UNIFACVEST EAD");
        certificadora1.sendKeys(Keys.ENTER);
        
        //insert CPF
        WebElement CPF = driver.findElement(By.id("cpf"));
        CPF.sendKeys(Keys.HOME);
        CPF.sendKeys(cpf);
        CPF.sendKeys(Keys.TAB);
        System.out.println(cpf);

        Auxiliar.Pause10sec();
        
        //send name student 
        WebElement Aluno = driver.findElement(By.id("nome"));
        Aluno.click();
        Aluno.sendKeys(aluno);
        Aluno.sendKeys(Keys.TAB);
        System.out.println(aluno);
        
        WebElement Celular = driver.findElement(By.id("celular")); 
        Celular.sendKeys(Keys.HOME);
        Celular.sendKeys("41988590779");
        
        //Send Email
        WebElement Email = driver.findElement(By.id("email"));
        Email.click();
        Email.sendKeys(email);
        System.out.println(email);
        Email.sendKeys(Keys.TAB);

        Auxiliar.Pause5sec();

        //Send born date
        WebElement dtNasc = driver.findElement(By.id("dtnascto"));
        dtNasc.click();
        dtNasc.sendKeys(Keys.HOME);
        dtNasc.sendKeys("06/12/1995");
        
        driver.findElement(By.xpath("//button[contains(@data-id,'estadocivil')]")).click();
        driver.findElement(By.xpath("//span[@class='text'][contains(.,'SOLTEIRO (A)')]")).click();
        
        //Select RG
        WebElement Rg = driver.findElement(By.id("rg"));
        Rg.click();
        Rg.sendKeys(Keys.HOME);
        Rg.sendKeys("129968036");

        //Select State
        driver.findElement(By.xpath("(//span[contains(@class,'filter-option pull-left')])[3]")).click();
        driver.findElement(By.xpath("//span[@class='text'][contains(.,'PRParaná')]")).click();
        
		//Select emissor
        driver.findElement(By.id("rg_org")).sendKeys("ssp");
        
        //Select CEP
        WebElement CEP = driver.findElement(By.id("cep"));
        CEP.sendKeys(Keys.HOME);
        CEP.sendKeys("83050-115");
        CEP.sendKeys(Keys.TAB);
        
        Auxiliar.Pause5sec();

        //Select Number
        WebElement Numero = driver.findElement(By.id("numero"));
        Numero.sendKeys("100");
        Numero.sendKeys(Keys.TAB);

        //Select Curso        
        driver.findElement(By.xpath("(//div[contains(@class,'form-group has-feedback')])[16]")).click();
        WebElement SelectCurso = driver.findElement(By.xpath("(//input[@type='text'])[14]"));
        SelectCurso.click();
        SelectCurso.sendKeys("BACHARELADO ADMINISTRAcAO - UNIFACVEST EAD");
        driver.findElement(By.xpath("//span[@class='text'][contains(.,'135624 - 48 MESES - BACHARELADO ADMINISTRAÇÃO - UNIFACVEST EAD')]")).click();

        Auxiliar.Pause5sec();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

        //Select Regional
        driver.findElement(By.id("regional_")).click();
        WebElement SelectRegional = driver.findElement(By.xpath("(//input[contains(@type,'text')])[15]"));
        SelectRegional.click();
        SelectRegional.sendKeys("PR");
        SelectRegional.sendKeys(Keys.ENTER);

        Auxiliar.Pause10sec();

        //Select Local
        driver.findElement(By.id("enderecopoloid_")).click();
        WebElement SelectLocal = driver.findElement(By.xpath("(//input[contains(@type,'text')])[16]"));
        SelectLocal.click();
        SelectLocal.sendKeys(".COM INFORMATICA");
        SelectLocal.sendKeys(Keys.ENTER);

        //Select campanha
        driver.findElement(By.id("campanhaid_")).click();
        WebElement SelectCampanha = driver.findElement(By.xpath("(//span[@class='text'][contains(.,'2019 - SITE')])[1]"));
        SelectCampanha.click();

        //Scroll page
        jse.executeScript("window.scrollBy(0,250)", "");

        //Select date 
        driver.findElement(By.id("dataid_")).click();
        driver.findElement(By.xpath("//a[@tabindex='0'][contains(.,'06/05/2019')]")).click();

        driver.findElement(By.id("btnConfirmar")).click();

        System.out.println("Teste Finalizado");

    }

}
