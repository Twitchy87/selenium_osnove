package d25_09_2023;
//1.	Zadatak
//●	Maksimizirati prozor
//●	Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//●	Prijavite se na sistem
//○	Username: Admin
//○	Password: admin123
//●	Cekanje od 5s
//●	U input za pretragu iz navigacije unesite tekst Me
//●	Kliknite na prvi rezultat pretrage (to ce biti Time)
//●	Cekanje od 1s
//●	Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
//●	Klinkite na logout
//●	Cekanje od 5s
//●	Zatvorite pretrazivac

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(5000);

        driver.findElement(By.cssSelector("input[placeholder='Username']")).clear();
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin123");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Thread.sleep(5000);

        driver.findElement(By.cssSelector("[placeholder='Search']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Search']")).sendKeys("Me");

        driver.findElement(By.xpath("//*[@class='oxd-main-menu']/li[1]/a")).click();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("header img")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[text()='Logout']")).click();
//        xpath: //*[text()='Logout']

        Thread.sleep(5000);

        driver.quit();
    }
}
