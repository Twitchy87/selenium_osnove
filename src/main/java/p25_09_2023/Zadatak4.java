package p25_09_2023;
//4. Zadatak
//Napisati program koji:
//●	Maksimizuje stranicu
//●	Ucitava stranicu https://demoqa.com/webtables
//●	Vrsi klik na edit dugme prvog reda
//●	Unosi informacije za sva polja u edit formi
//●	Klik na submit
//●	Ceka par sekundi
//●	Zatvara pretrazivac

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/webtables");

        driver.findElement(By.cssSelector("#edit-record-1 > svg")).click();

        Thread.sleep(1000);

        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("Pera");

        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("Peric");

        driver.findElement(By.id("userEmail")).clear();
        driver.findElement(By.id("userEmail")).sendKeys("Pera@gmail.com");

        driver.findElement(By.id("age")).clear();
        driver.findElement(By.id("age")).sendKeys("37");

        driver.findElement(By.id("salary")).clear();
        driver.findElement(By.id("salary")).sendKeys("7700");

        driver.findElement(By.id("department")).clear();
        driver.findElement(By.id("department")).sendKeys("IT");

        Thread.sleep(3000);

        driver.findElement(By.id("submit")).click();

        Thread.sleep(3000);

        driver.quit();
    }
}
