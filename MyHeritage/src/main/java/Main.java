import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.apache.commons.io.FileUtils;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\test scripts\\tools\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://google.com");

        driver.findElement(By.xpath("//*[text()=\"Прийняти\"]")).click();
        WebElement element = driver.findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]"));
        element.sendKeys("My Heritage", Keys.ENTER);
        driver.findElement(By.xpath("//div[@class=\"g tF2Cxc\"]")).click();
        driver.findElement(By.xpath("//div[@class=\"get_dna_test_button\"]")).click();

        String priceoffer = driver.findElement(By.className("offer_price")).getText();
        String text = "Price = € ";
        //System.out.println(priceoffer);

        Pattern pt = Pattern.compile("\\d+(\\\\.\\\\d+)?");
        Matcher mt = pt.matcher(priceoffer);
        if (mt.find()) {
            System.out.println(mt.group());
            String price = mt.group();

            String result = text + price;


            File f = new File("savetxt.txt");
            try {
                FileUtils.writeStringToFile(f, result, Charset.defaultCharset());
            } catch (IOException exc) {
                exc.printStackTrace();
            }

        }
    }
}


