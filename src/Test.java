import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
 
public class Test {
 private static  ChromeDriver driver;
 WebElement element;
 
 @BeforeClass
 
 //--------Setting the Browser and Opening the Browser-------------------
     public static void openBrowser(){
	 System.out.println("Stsrting the test");
	 System.setProperty("webdriver.chrome.driver","F:\\my works\\Softwares\\chromedriver.exe");
	 driver = new ChromeDriver();
 } 
 
 @org.junit.Test
 
 //--------Starting the Test------------
 
     public void Amazon(){
 
      System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
      
 //--------Loading Amazon.in-------------------
      
      driver.get("https://www.amazon.in/"); 
      driver.manage().window().maximize();
      
//----------Adding given Books to cart by using reusable method-----------------   
      
      this.addBookToCart("Experiences of Test Automation: Case Studies of Software Test Automation");
      
      this.addBookToCart("Agile Testing: A Practical Guide for Testers and Agile Teams");
      
      this.addBookToCart("Selenium WebDriver 3 Practical Guide: End-to-end automation testing for web and mobile browsers with Selenium WebDriver, 2nd Edition");
      
      
//-------moving to cart page--------------------------------
      
      driver.findElement(By.xpath(".//*[@id='nav-cart']")).click();
      
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      
//--------Selecting save for later---------------------      
      
      driver.findElement(By.xpath(".//*[@id='activeCartViewForm']/div[2]/div[3]/div[4]/div/div[1]/div/div/div[2]/div/span[2]/span/input")).click();
      
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      
//--------Deleting Item----------------------------------------      
      
      driver.findElement(By.xpath(".//*[@id='activeCartViewForm']/div[2]/div[2]/div[4]/div/div[1]/div/div/div[2]/div/span[1]/span/input")).click();
      
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      
//---------Increasing Quantity-------------------------------------      
      
      driver.findElement(By.xpath(".//*[@id='activeCartViewForm']/div[2]/div[1]/div[4]/div/div[3]/div/div/span/span/span/span")).click();
      
      driver.findElement(By.xpath(".//*[@id='dropdown1_2']")).click();
      
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
//----------making order as gift---------------------------------------      
      
      driver.findElement(By.cssSelector("#sc-buy-box-gift-checkbox")).click();
      
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      
//-----------Removing the copies-------------------------------------------      
      
driver.findElement(By.xpath(".//*[@id='activeCartViewForm']/div[2]/div[1]/div[4]/div/div[3]/div/div/span/span/span/span")).click();
      
      driver.findElement(By.xpath(".//*[@id='dropdown1_0']")).click();
      
      
      
      
      
      
     }
 
 public void addBookToCart(String name) {
	 
	 driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(name);
     driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(Keys.ENTER);
     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
     driver.findElement(By.cssSelector(".a-size-medium.s-inline.s-access-title.a-text-normal")).click();
     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
     
//-------Switching the window--------------------     
     for (String handle : driver.getWindowHandles()) {
   	  
   	    driver.switchTo().window(handle);
   	    
     }
     driver.findElement(By.id("add-to-cart-button")).click();
	 
 }
 
 
 
 @AfterClass
 //-----------Ending the Test---------------
 public static void closeBrowser(){
 driver.quit();
 }
}
