package p26_09_2023;
//5. Zadatak
//probajte funkcionalnost checkbox-a na ovom sajtu https://demoqa.com/automation-practice-form
//Na kraju programa proverite da li je element cekiran.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5_1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("[for='hobbies-checkbox-2']")).click();

        Thread.sleep(2000);

        if (driver.findElement(By.id("hobbies-checkbox-2")).isSelected()){
            System.out.println("checked");
        } else {
            System.out.println("not checked");
        }

        driver.quit();
    }
}
