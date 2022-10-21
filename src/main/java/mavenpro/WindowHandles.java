package mavenpro;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {




	public static void main(String[] args) throws InterruptedException {


		//ChromeOptions options = new ChromeOptions();
		//options.setHeadless(true);


		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
		/*Set <String> s= driver.getWindowHandles();
		for(String i : s) {
			String t = driver.switchTo().window(i).getTitle();
			System.out.println(t);
		}
		 */
		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); 

		driver.findElement(By.xpath("//*[@id=\"main_navbar\"]/ul/li[4]/a")).click();

		driver.switchTo().window(parentWindowHandler);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
		String parentWindowHandler1 = driver.getWindowHandle();
		String subWindowHandler1 = null;
		driver.findElement(By.xpath("//*[@id=\"Seperate\"]/button")).click();

		Set<String> handles1 = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator1 = handles1.iterator();
		while (iterator1.hasNext()){

			subWindowHandler1 = iterator1.next();
		}
		driver.switchTo().window(subWindowHandler1); 
		//Maximize the child window
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id=\"main_navbar\"]/ul/li[4]/a")).click();
		driver.switchTo().window(parentWindowHandler1);
		String title = driver.getTitle();
		System.out.println(title);




		Thread.sleep(20000);
	}

}