package p26_09_2023;
//6.1. Zadatak (za vezbanje)
//●	Ucitati stranicu https://cms.demo.katalon.com/
//●	Maksimizovati prozor
//●	Proveriri da li je je crno MENU dugme vidljivo (Ispisati poruke u konzoli)
//●	Prostavite duzinu prozora na 700px i visinu na 700px
//●	Proverite da li je crno MENU dugme vidljivo (Ispisati poruke u konzoli)

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6_1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://cms.demo.katalon.com/");

        Thread.sleep(2000);

        if (driver.findElement(By.className("menu-toggle")).isDisplayed()){
            System.out.println("The button is displayed.");
        } else {
            System.out.println("The button is not displayed.");
        }

        Dimension windowDimension = new Dimension(700, 700);
        driver.manage().window().setSize(windowDimension);

        if (driver.findElement(By.className("menu-toggle")).isDisplayed()){
            System.out.println("The button is displayed.");
        } else {
            System.out.println("The button is not displayed.");
        }

        Thread.sleep(1500);

        driver.quit();
    }
}
