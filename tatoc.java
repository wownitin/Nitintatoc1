package newpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.Iterator;
import java.util.Set;
 
public class tatoc {
 
public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
driver.get("http://10.0.1.86/tatoc");
driver.findElement(By.xpath("/html/body/div/div[2]/a[1]")).click();
driver.findElement(By.className("greenbox")).click();

driver.switchTo().frame(0);
WebElement BOXNO1 = driver.findElement(By.id("answer"));
String Box1 = BOXNO1.getAttribute("class");
String Box2 = "";
while(!Box1.equals(Box2)){
  
   driver.switchTo().defaultContent();
    driver.switchTo().frame(0);
    driver.findElement(By.cssSelector("a")).click();
    driver.switchTo().frame(0);
    Box2=driver.findElement(By.id("answer")).getAttribute("class");
     }
driver.switchTo().defaultContent();
driver.switchTo().frame(0).findElement(By.linkText("Proceed")).click();

 
Actions act=new Actions(driver);
WebElement drop = driver.findElement(By.cssSelector("#dropbox"));
WebElement drag = driver.findElement(By.cssSelector("#dragbox"));
act.dragAndDrop(drag, drop).build().perform();
driver.findElement(By.linkText("Proceed")).click();

driver.findElement(By.linkText("Launch Popup Window")).click();
String MainWindow=driver.getWindowHandle();
String subWindow = null;
Set<String> windows = driver.getWindowHandles();
Iterator itr = windows.iterator();
while(itr.hasNext()){
	subWindow = (String) itr.next();
}
driver.switchTo().window(subWindow);
driver.findElement(By.id("name")).sendKeys("TATOC");
driver.findElement(By.id("submit")).click();
driver.switchTo().window(MainWindow);
driver.findElement(By.linkText("Proceed")).click();
	
	driver.findElement(By.linkText("Generate Token")).click();
		String Cookie_val = driver.findElement(By.id("token")).getText();
		Cookie ck = new Cookie("Token", Cookie_val.substring(7));
		driver.manage().addCookie(ck);
		driver.findElement(By.linkText("Proceed")).click();


}
 
}