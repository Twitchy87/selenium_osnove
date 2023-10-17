package p26_09_2023;
//4. Zadatak
//Napisati program koji ucitava stranicu https://www.ebay.com/ i bira kategoriju “Crafts”

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak4 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://www.ebay.com/");

        Thread.sleep(2000);

        Select selectCategory = new Select(driver.findElement(By.id("gh-cat")));
        selectCategory.selectByVisibleText("Crafts");

        Thread.sleep(2000);

        driver.quit();
    }
}
