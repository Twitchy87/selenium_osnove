package d26_09_2023;
//4. .Zadatak (Za vezbanje)
//Napisati program koji matematicku formulu koju korisnik unese izvrsaav na stranici:
//●	Ucitati stranicu https://www.calculatorsoup.com/calculators/math/basic.php
//●	Korisnik unosi formulu, samo osnovne matematicke operacija, npr:
//○	1243+329=
//○	21912-4=
//○	12913÷4=
//●	U programu se formula unosi kao jedan string i potrebno je razbiti formulu na karaktere. Za to imate metodu https://www.geeksforgeeks.org/convert-a-string-to-a-list-of-characters-in-java/
//●	Zatim u odnosu na karakter uradite odredjenu logiku

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Scanner;

public class Zadatak4 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.calculatorsoup.com/calculators/math/basic.php");

        Thread.sleep(2000);

        Scanner s = new Scanner(System.in);

        System.out.println("Unesite formulu:");
        String formula = s.next();

        ArrayList<Character> characters = new ArrayList<>();

        for (int i = 0; i < formula.length(); i++) {
            characters.add(formula.charAt(i));
        }

        ArrayList<String> newFormula = new ArrayList<>();

        for (int i = 0; i < characters.size(); i++) {
            newFormula.add(characters.get(i).toString());
        }

        for (String character : newFormula) {
            switch (character){
                case "/":
                    driver.findElement(By.cssSelector("[name='cs_divide']")).click();
                    break;
                case "*":
                    driver.findElement(By.cssSelector("[name='cs_multiply']")).click();
                    break;
                case "-":
                    driver.findElement(By.cssSelector("[name='cs_subtract']")).click();
                    break;
                case "+":
                    driver.findElement(By.cssSelector("[name='cs_add']")).click();
                    break;
                case "=":
                    driver.findElement(By.cssSelector("[name='cs_equal']")).click();
                    break;
                default:
                    driver.findElement(By.id("cs_display")).clear();
                    driver.findElement(By.id("cs_display")).sendKeys(character);
            }
        }

        System.out.println("Rezultat operacije: " + formula + driver.findElement(By.id("cs_display")).getAttribute("value"));

        Thread.sleep(2000);

        driver.quit();
    }
}
