package p26_09_2023;
//5. Zadatak
//Napisati program koji ucitava stranicu http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox.
//Na kraju programa proverite da li je element cekiran. Izguglajte kako mozemo da proverimo da li je element cekiran.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://cms.demo.katalon.com/my-account/");

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("form.login p:nth-child(3) > label")).click();

        if (driver.findElement(By.id("rememberme")).isSelected()){
            System.out.println("checked");
        } else {
            System.out.println("not checked");
        }

        Thread.sleep(2000);

        driver.quit();
    }
}
