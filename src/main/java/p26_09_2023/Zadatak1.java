package p26_09_2023;
//1.Zadatak
//Napisti proram koji :
//●	Ucitava stranicu https://s.bootsnipp.com/iframe/oV91g
//●	Hvatamo sve page-eve iz paginacije tabele
//●	Zatim petljom prolazimo kroz paginaciju tako sto kliknemo na svaki broj
//●	Izmedju iteracija napravite pauzu od 1s
//●	Zatvorite pretrazivac

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://s.bootsnipp.com/iframe/oV91g");

        Thread.sleep(2000);

        List<WebElement> pages = driver.findElements(By.cssSelector("a.page_link"));

        for (WebElement page : pages){
            page.click();
            Thread.sleep(1000);
        }

        driver.quit();
    }
}
