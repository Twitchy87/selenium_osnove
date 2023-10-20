package d26_09_2023;
//1.	Zadatak
//Napisati program koji:
//●	Ucitava stranicu https://demoqa.com/automation-practice-form
//●	Popunjava formu sta stranice. Korisnik unosi podatke sa tastature za popunu forme.
//●	(za vezbanje) Probajte da unese i datum. Sa datumom se radi isto kao i sa obicnim inputom sa sendKeys.
//●	Klik na submit

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class Zadatak1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");

        Thread.sleep(2000);

        Scanner s = new Scanner(System.in);

        System.out.println("Enter your first name:");
        String firstName = s.next();

        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys(firstName);

        System.out.println("Enter your last name:");
        String lastName = s.next();

        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys(lastName);

        System.out.println("Enter your email:");
        String email = s.next();

        driver.findElement(By.id("userEmail")).clear();
        driver.findElement(By.id("userEmail")).sendKeys(email);

        System.out.println("Choose gender (male/female/other):");
        String gender = s.next();

        switch (gender){
            case "male":
                driver.findElement(By.cssSelector("[for='gender-radio-1']")).click();
                break;
            case "female":
                driver.findElement(By.cssSelector("[for='gender-radio-2']")).click();
                break;
            case "other":
                driver.findElement(By.cssSelector("[for='gender-radio-3']")).click();
                break;
        }

        System.out.println("Enter your mobile number:");
        String mobileNumber = s.next();

        driver.findElement(By.id("userNumber")).clear();
        driver.findElement(By.id("userNumber")).sendKeys(mobileNumber);

        System.out.println("Pick your date of birth from the calendar");

        Thread.sleep(5000);

//        System.out.println("Enter your date of birth (format: 01 Jan 1999):");
//
//        System.out.println("Day:");
//        String day = s.next();
//
//        System.out.println("Month:");
//        String month = s.next();
//
//        System.out.println("Year:");
//        String year = s.next();
//
//        String dateOfBirth = day + " " + month + " " + year;
//
//        driver.findElement(By.id("dateOfBirthInput")).click();
//        driver.findElement(By.id("dateOfBirthInput")).clear();
//        Thread.sleep(1000);
//        driver.findElement(By.id("dateOfBirthInput")).sendKeys(dateOfBirth);
//
//        System.out.println("How many subjects do you want to enter?");
//        int numberOfSubjects = s.nextInt();
//
//        for (int i = 0; i < numberOfSubjects; i++) {
//            System.out.println("Enter your subject:");
//            String subject = s.next();
//
////            driver.findElement(By.className("subjects-auto-complete__input")).clear();
//            driver.findElement(By.className("subjects-auto-complete__input")).sendKeys(subject);
//        }

        System.out.println("Do you like sports?");
        boolean likesSports = s.nextBoolean();

        if (likesSports){
            driver.findElement(By.cssSelector("[for=hobbies-checkbox-1]")).click();
        }

        System.out.println("Do you like reading?");
        boolean likesReading = s.nextBoolean();

        if (likesReading){
            driver.findElement(By.cssSelector("[for=hobbies-checkbox-2]")).click();
        }

        System.out.println("Do you like listening to music?");
        boolean likesMusic = s.nextBoolean();

        if (likesMusic){
            driver.findElement(By.cssSelector("[for=hobbies-checkbox-3]")).click();
        }

        System.out.println("Enter your current address:");
        String currentAddress = s.next();

        driver.findElement(By.id("currentAddress")).clear();
        driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);

        Thread.sleep(1000);

        driver.findElement(By.id("submit")).click();

        Thread.sleep(2000);

        driver.quit();
    }
}
