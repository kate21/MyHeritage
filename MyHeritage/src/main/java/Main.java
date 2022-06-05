import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\test scripts\\tools\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.xpath("//*[text()=\"Прийняти\"]")).click();
        WebElement element = driver.findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]"));
        element.sendKeys("My Heritage", Keys.ENTER);
        driver.findElement(By.xpath("//div[@class=\"g tF2Cxc\"]")).click();
        driver.findElement(By.xpath("//div[@class=\"get_dna_test_button\"]")).click();
        String text = driver.findElement(By.className("offer_price")).getText();
        System.out.println(text);


//end

    }


}
