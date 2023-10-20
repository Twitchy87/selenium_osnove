package p28_09_2023;
//1.Zadatak
//●	Ucitati stranicu https://demoqa.com/modal-dialogs
//●	Kliknuti na dugme Large modal
//●	Proverite da li se prikazao dijalog i ispisite u konzoli odgovarajuce poruke

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/modal-dialogs");

//        try{
//            driver.findElement(By.id("showLargeModal")).click();
//        } catch (Exception e){
//            System.out.println("The element doesn't exist.");
//        }
//
//        try{
//            driver.findElement(By.className("modal-content"));
//            System.out.println("The dialog box is displayed.");
//        } catch (Exception e){
//            System.out.println("The dialog box is not displayed.");
//        }

        driver.findElement(By.id("showLargeModal")).click();

        boolean isDialogOpen = true;

        try{
            driver.findElement(By.className("modal-content"));
        } catch (Exception e){
            isDialogOpen = false;
        }

        if (isDialogOpen){
            System.out.println("The dialog box is displayed.");
        } else {
            System.out.println("The dialog box is not displayed.");
        }

        Thread.sleep(2000);

        driver.quit();
    }
}
