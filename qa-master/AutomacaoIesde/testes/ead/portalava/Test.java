package ead.portalava;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
	public static void Pause5sec() {
		try { Thread.sleep(5000);} 
		catch (InterruptedException e) { e.printStackTrace();}
	}
	public static void Pause10sec() {
		try { Thread.sleep(10000);} 
		catch (InterruptedException e) { e.printStackTrace();}
	}
	public static void Pause30sec() {
		try { Thread.sleep(30000);} 
		catch (InterruptedException e) { e.printStackTrace();}
	}
	

	@org.junit.Test
	public void test() {
				
		        // Create a new instance of the browser driver
				System.setProperty("webdriver.gecko.driver", "C:\\eclipseLib/geckodriver.exe");
				//"System.setProperty("webdriver.chrome.driver", "C:\\eclipseLib/chromedriver.exe");
				
				WebDriver driver = new FirefoxDriver();
				
				//implicit wait
		        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		        // And now use this to visit the EAD
		        driver.get("https://www.sinonimos.com.br/depoimento/");
		        driver.manage().window().maximize();

		        
		        Random rnd = new Random();
		        String str = "";
		        String str1 = "";
		        String sob = "";
		        int supName = 0;
		        
		        for (int i = 0; i < 10; i++) {
		        	 supName = (rnd.nextInt(99));
		        	 String str2 = "Aluno";
		        	 str = String.valueOf(supName);
		        	 str1 = str2.concat(str) ;
		        }
		        for (int i = 0; i < 10; i++) {
		        	 supName = (rnd.nextInt(100));
		        	 String str2 = " teste";
		        	 str = String.valueOf(supName);
		        	 sob = str2.concat(str) ;
		        }
		                
		        String aluno = str1.concat(sob);
		        
		       //code to do something on new window
		        //send CPF
		        //driver.findElement(By.id("cpf")).sendKeys("72580858822");
		        
		        //send name
		        driver.findElement(By.id("q")).sendKeys(aluno);
		        
		        System.exit(0);
		        
		        //send RG
		        driver.findElement(By.id("rg")).sendKeys("129968036"); 
		        
		        //send born date
		        driver.findElement(By.id("dtNascimento")).sendKeys("06/12/1995");
		        
		        //select civil state
		        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Estado civil'])[1]/following::span[1]")).click();
		        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Selecione'])[3]/following::span[2]")).click();
		        
		        //send DDD
		        driver.findElement(By.id("ddd_celular")).sendKeys("41");
		        
		        //send number
		        driver.findElement(By.id("celular")).sendKeys("9000000000");
		        
		        //send DDD home number
		        driver.findElement(By.id("ddd_telefone")).sendKeys("41");
		        
		        //send home number
		        driver.findElement(By.id("telefone")).sendKeys("30000000");
		        
		        //send email
		        driver.findElement(By.id("email")).sendKeys("101@teste.com");
		        
		        //send CEP
		        driver.findElement(By.id("cep")).sendKeys("83050115");
		        
		        driver.findElement(By.id("numero")).sendKeys("100");
		        Pause5sec();
		        
		        driver.findElement(By.id("comboid")).click(); 
		        Pause30sec();
		        
		        driver.findElement(By.id("comboid")).click(); 
		        
		        String[] options = {"Continuar", "Fechar"};
		        JOptionPane.showOptionDialog(null, "Teste Efetuado",
		                "Click a button",
		                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			

		

	}

}
