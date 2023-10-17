package p25_09_2023;
//3. Zadatak ( opcioni)
//Napisati program koji:
//●	Ucitava stranicu https://demoqa.com/text-box
//●	Unosi informacije za 3 osobe koristeci petlju
//○	Full Name
//○	Email
//○	Current Address
//○	Permanent Address
//○	Klik na submit
//○	Ceka 2 sekunde
//○	Osvezava stranicu
//●	Zatvara pretrazivac

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/text-box");

        for (int i = 0; i < 3; i++) {

            Thread.sleep(2000);

            driver.findElement(By.id("userName")).clear();
            driver.findElement(By.id("userName")).sendKeys("pera");

            driver.findElement(By.id("userEmail")).clear();
            driver.findElement(By.id("userEmail")).sendKeys("pera@gmail.com");

            driver.findElement(By.id("currentAddress")).clear();
            driver.findElement(By.id("currentAddress")).sendKeys("Vozdova bb");

            driver.findElement(By.id("permanentAddress")).clear();
            driver.findElement(By.id("permanentAddress")).sendKeys("Vozdova bb");

            driver.findElement(By.cssSelector("#userForm #submit")).click();

            Thread.sleep(2000);

            driver.navigate().refresh();
        }

        driver.quit();
    }
}
