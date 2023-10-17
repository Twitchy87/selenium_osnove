package p26_09_2023;
//2.Zadatak
//Napisti program koji:
//●	Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//●	Hvata sve elemente prve kolone i stampa tekst svakog elementa. Kako da od nekog elementa procitamo tekst imate na sledecem linku
//●	Ceka 1s
//●	Hvata sve elemente prvog reda i stampa tekst svakog elementa
//●	Ceka 5s
//●	Zatvara pretrazivac

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://s.bootsnipp.com/iframe/z80en");

        Thread.sleep(2000);

        List<WebElement> firstNames = driver.findElements(By.cssSelector("#lorem .table tr td:first-child"));

        for(WebElement firstName : firstNames){
            System.out.println(firstName.getText());
        }

        Thread.sleep(1000);

        List<WebElement> firstRowElements = driver.findElements(By.cssSelector("#lorem tbody > tr:first-child > td"));

        for(WebElement firstRowElement : firstRowElements){
            System.out.print(firstRowElement.getText() + " ");
        }

        Thread.sleep(5000);

        driver.quit();

    }
}
