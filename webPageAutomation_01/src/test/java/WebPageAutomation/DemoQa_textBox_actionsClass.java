package WebPageAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoQa_textBox_actionsClass {

	public static void main(String[] args) {

	DemoQa_textBox_actionsClass.keyboardActions();
	
	}
	
	public static void mouseActions () {
		
		
	}

	public static void keyboardActions () {
		
		//Web driver setup and browser launch....................................
		
				WebDriverManager.chromedriver().setup();
				
				WebDriver driver = new ChromeDriver();
				driver.get("https://demoqa.com/elements");
				driver.manage().window().maximize();
			
		//creating object of Actions class.......................
				
				Actions actions = new Actions(driver);

				FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver);
				fWait.pollingEvery(Duration.ofMillis(3000));
				fWait.pollingEvery(Duration.ofMillis(200));
				fWait.ignoring(Exception.class);
				fWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Text Box']")));
				
				WebElement textBoxWord = driver.findElement(By.xpath("//span[text()='Text Box']"));
				textBoxWord.click();

		//performing keyboard actions...using Actions class......................................
				
				WebElement fullNameTextBox = driver.findElement(By.xpath("//input[@id='userName']"));

				FluentWait<WebDriver> fWait2 = new FluentWait<WebDriver>(driver);
				fWait2.pollingEvery(Duration.ofMillis(3000));
				fWait2.pollingEvery(Duration.ofMillis(200));
				fWait2.ignoring(Exception.class);
				fWait2.until(ExpectedConditions.visibilityOf(fullNameTextBox));
				
				
				fullNameTextBox.sendKeys("my name is -> minato namikaze");
				
				actions.sendKeys(Keys.TAB);
				actions.perform();
				
				actions.sendKeys("mymailid@gmail.com");
				actions.perform();

				actions.sendKeys(Keys.TAB);
				actions.perform();
				
				actions.sendKeys("this is my \"address\" to select all and copy using actions class or keyboard actions handling");
				actions.perform();
				
				actions.keyDown(Keys.CONTROL);
				actions.sendKeys("a");
				actions.keyUp(Keys.CONTROL);
				actions.build().perform();
				
				actions.keyDown(Keys.CONTROL);
				actions.sendKeys("c");
				actions.keyUp(Keys.CONTROL);
				actions.build().perform();
				
				actions.sendKeys(Keys.TAB);
				actions.perform();
				
				actions.keyDown(Keys.CONTROL);
				actions.sendKeys("v");
				actions.keyUp(Keys.CONTROL);
				actions.build().perform();
				
				actions.sendKeys(Keys.TAB);
				actions.perform();

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				actions.click();
				actions.perform();
			
		//closing current tab/page.................
				
				driver.close();
				System.out.println("page is clossed.......");
		
	}
	
	
}
