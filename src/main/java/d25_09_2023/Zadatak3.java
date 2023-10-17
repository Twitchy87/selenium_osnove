package d25_09_2023;
//3.	Zadatak
//Napisati program koji vrsi dodavanje 5 redova
//●	Maksimizirati prozor
//●	Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
//●	Dodati 5 redova sa istim podacima.Jedan red u jednoj iteraciji
//●	Klik na dugme Add New
//●	Unesite name,departmant i phone (uvek iste vrednost)
//i.	Trazenje po name atributu
//ii.	Kliknite na zeleno Add dugme.
//PAZNJA: Pogledajte strukturu stranice i videcete da se u svakom redu poslednje kolone javljaju dugmici edit, add, delete ali zbog prirode reda neki dugmici se vide a neki ne.
//Morate da dohvatite uvek Add dugme iz poslednjeg reda tabele. Mozete koristeci index iz petlje, a mozete koristeci i last() fukncionalnost za xpath. Koristan link last mehnizma
//iii.	Cekanje od 0.5s
//●	Na kraju programa ugasite pretrazivac.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.className("btn")).click();

            driver.findElement(By.name("name")).clear();
            driver.findElement(By.name("name")).sendKeys("Jane Smith");

            driver.findElement(By.name("department")).clear();
            driver.findElement(By.name("department")).sendKeys("IT");

            driver.findElement(By.name("phone")).clear();
            driver.findElement(By.name("phone")).sendKeys("(381) 123-456");

            driver.findElement(By.cssSelector(".add[style='display: inline;']")).click();

            Thread.sleep(500);
        }

        driver.quit();
    }
}
