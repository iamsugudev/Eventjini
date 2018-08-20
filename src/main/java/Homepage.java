import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Homepage {
	@Test
	public void test() throws Exception{

		System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://pltfrm.eventjini.com/");
		driver.findElement(By.linkText("Log in / Sign up")).click();
		
		Thread.sleep(2000);
		String winHandleBefore = driver.getWindowHandle();
		System.out.println(winHandleBefore);
		
		for(String winHandle : driver.getWindowHandles()){
			System.out.println(winHandle);
		    driver.switchTo().window(winHandle);
		}
			
		driver.findElement(By.id("userName")).sendKeys("sugusara18061995@gmail.com");
		driver.findElement(By.id("loginPsd-Fd")).sendKeys("Welcome123$");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='login']/form/div[2]/div[2]/input")).click();
		Thread.sleep(4000);
		driver.switchTo().window(winHandleBefore);
		
		System.out.println("checking the headers");
		String input1 = "About Us";
		String input2 = "OUR EVENTS";
		String input3 = "SUPPORT";
		String input4 = "PARTNERS";
		String input5 = "CART";
		String menu1 = driver.findElement(By.linkText("ABOUT US")).getText();
		System.out.println(menu1);
		String menu2 = driver.findElement(By.xpath("//*[@id='menu-item-2624']/a")).getText();
		System.out.println(menu2);
		String menu3 = driver.findElement(By.xpath("//*[@id='menu-item-2208']/a")).getText();
		System.out.println(menu3);
		String menu4 = driver.findElement(By.xpath("//*[@id='menu-item-2340']/a")).getText();
		System.out.println(menu4);
		String menu5 = driver.findElement(By.xpath("//*[@id='menu-item-2678']/a")).getText();
		System.out.println(menu5);
		if(input1.equalsIgnoreCase(menu1)&&input2.equals(menu2)&&input3.equals(menu3)&&input4.equals(menu4)&&input5.equals(menu5))
		{
			System.out.println("Headers are working as expected");
		}else
		{
			System.out.println("Headers are failed");
		}
		
		driver.quit();
	}
}
