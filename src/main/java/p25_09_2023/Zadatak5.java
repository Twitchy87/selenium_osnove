package p25_09_2023;
//5.Zadatak
//Napisati program koji ima:
//●	Niz stranica (niz stringova) koje treba da ucita. Niz je:
//○	https://google.com/
//○	https://youtube.com/
//○	https://www.ebay.com/
//○	https://www.kupujemprodajem.com/
//●	Program petljom prolazi kroz niz stranica i svaku stranicu ucitava preko get ili navigate i od svake stranice na ekranu ispisuje naslov stranice. Kako od stranice procitati naslov imate na ovom linku
//U prevodu u konzoli treba da se ispisu:
//Google
//YouTube
//Electronics, Cars, Fashion, Collectibles & More | eBay
//KupujemProdajem
//●	Zatvara pretrazivac

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak5 {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> urls = new ArrayList<>();
        urls.add("https://google.com/");
        urls.add("https://youtube.com/");
        urls.add("https://www.ebay.com/");
        urls.add("https://www.kupujemprodajem.com/");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        for (String url : urls) {
            driver.get(url);
            System.out.println(driver.getTitle());
            Thread.sleep(1000);
        }

        driver.quit();
    }
}
