package d26_09_2023;
//2.	Zadatak
//Napisati program koji:
//●	Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//●	Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//●	POMOC: Brisite elemente odozdo.
//●	(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2_1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://s.bootsnipp.com/iframe/Dq2X");

        Thread.sleep(2000);

        List<WebElement> alerts = driver.findElements(By.cssSelector("body .alert"));

        for (int i = alerts.size() - 1; i >= 0; i--) {

            alerts.get(i).findElement(By.tagName("button")).click();

            List<WebElement> alerts2 = driver.findElements(By.cssSelector("body .alert"));

            if (alerts2.size() == i){
                System.out.println("The alert message is deleted.");
            }

            Thread.sleep(1000);
        }

        Thread.sleep(2000);

        driver.quit();
    }
}
