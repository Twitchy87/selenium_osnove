package d26_09_2023;
//3.	Zadatak (za vezbanje)
//●	Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//○	Visit Paris
//○	Visit Prague
//○	Visit London
//○	Visit New York
//○	Visit Belgrade
//●	Maksimizirati prozor
//●	Ucitati stranicu https://example.cypress.io/todo
//●	Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//○	Nakon svakog unosa todo-a, unosi se enter
//○	Validira da li je novi todo dodat na stranici  (ispisati poruku)
//●	Na kraju programa proci petljom i izbrisati svaki todo sa stranice (klikom na x dugme svakog todo-a)
//●	Validirati da je na kraju programa broj todo-a na stranici 0. (ispisati poruku)
//●	Cekanje od 5s
//●	Zatvorite pretrazivac

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Zadatak3 {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> todos = new ArrayList<>();

        todos.add("Visit Paris");
        todos.add("Visit Prague");
        todos.add("Visit London");
        todos.add("Visit New York");
        todos.add("Visit Belgrade");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://example.cypress.io/todo");

        Thread.sleep(2000);

        List<WebElement> todosList = driver.findElements(By.cssSelector(".todo-list li"));

        List<WebElement> todosList2 = null;

        for (int i = 0; i < todos.size(); i++) {
            driver.findElement(By.className("new-todo")).clear();
            driver.findElement(By.className("new-todo")).sendKeys(todos.get(i));
            driver.findElement(By.className("new-todo")).sendKeys(Keys.ENTER);

            todosList2 = driver.findElements(By.cssSelector(".todo-list li"));

            if (todosList2.size() == todosList.size() + i + 1){
                System.out.println("A new todo is added: " + todos.get(i));
            }

            Thread.sleep(1000);
        }

        for (WebElement todo : todosList2){
            driver.findElement(By.className("destroy")).click();
            Thread.sleep(1000);
        }

        if (!driver.findElement(By.id("toggle-all")).isDisplayed()){
            System.out.println("Every todo has been deleted.");
        }

        Thread.sleep(1500);

        driver.quit();

    }
}
