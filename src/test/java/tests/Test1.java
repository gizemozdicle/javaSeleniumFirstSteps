package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class Test1 {
    public static void main(String[] args) {
        // Bunu bir kere kullaniyoruz, amaci chromedriverin yolunu sisteme tanimlamak
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        // Bir tane driver isimli obje olusturduk
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;


        //get fonkisyonu icine bir url alir. Bu url'i ziyret eder
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.click();

        fullName.sendKeys("Gizem Cengiz");

        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.click();
        email.sendKeys("gzm123@hotmail.com");

        jse.executeScript("scroll(0, 250);");
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        currentAddress.click();
        currentAddress.sendKeys("ankara");

        jse.executeScript("scroll(0, 250);");
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.click();
        permanentAddress.sendKeys("istanbul");

        jse.executeScript("scroll(0, 250);");
        WebElement submitButton = driver.findElement(new By.ByCssSelector("button.btn"));
        submitButton.click();

        WebElement textName = driver.findElement(By.xpath("//div/p[@id='name']"));
        String name = textName.getText();
        System.out.println(name);

        WebElement textEmail = driver.findElement(By.xpath("//div/p[@id='email']"));
        String Email = textEmail.getText();
        System.out.println(Email);

        driver.get("https://demoqa.com/checkbox");


        String homeCheckBoxCssValue = "label[for='tree-node-home'] span.rct-checkbox svg";

        WebElement homeCheckBox = driver.findElement(new By.ByCssSelector(homeCheckBoxCssValue));
        homeCheckBox.click();

        homeCheckBox = driver.findElement(new By.ByCssSelector(homeCheckBoxCssValue));


        String homeCheckBoxClassName = homeCheckBox.getAttribute("class");

        if (homeCheckBoxClassName.equals("rct-icon rct-icon-check")) {

            System.out.println("CheckBox is checked");
        } else {

            System.out.println("CheckBox is unchecked");
        }

        driver.get("https://demoqa.com/automation-practice-form");

        jse.executeScript("scroll(0, 250);");


        WebElement sportCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
        boolean isEnabled = sportCheckbox.isEnabled();
        System.out.println(isEnabled);

        WebElement sportCheckboxLabel = driver.findElement(new By.ByCssSelector("label[for='hobbies-checkbox-1']"));

        try {
            sportCheckbox.click();

        } catch (org.openqa.selenium.ElementClickInterceptedException e) {

            sportCheckboxLabel.click();

        }

        driver.get("https://demoqa.com/radio-button");


        WebElement yesRadioButton = driver.findElement(new By.ByCssSelector("label[for='yesRadio']"));
        boolean isEna = yesRadioButton.isEnabled();

        if (isEna) {
            yesRadioButton.click();
            System.out.println("clicked yesRadioButton");
        }
        WebElement noRadioButton = driver.findElement(By.id("noRadio"));
        System.out.println(noRadioButton.isEnabled());


        //ACTION CLASS
        //Cift tiklama
        //sayfadan text aldirma

        driver.get("https://demoqa.com/buttons");

        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        Actions action = new Actions(driver);
        action.doubleClick(doubleClick).perform();

        WebElement message = driver.findElement(By.id("doubleClickMessage"));
        String messageText = message.getText();
        System.out.println(messageText);

        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        action.contextClick(rightClick).perform();

        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        String messageText1 = rightClickMessage.getText();
        System.out.println(messageText1);

        //dinamik yakalama
        //xpatc ile yakaliyoruz

        WebElement dynamicClickButton = driver.findElement(By.xpath("//div[last()]/button"));
        dynamicClickButton.click();


        driver.get("https://demoqa.com/dynamic-properties");

        WebElement dynamicsButton = driver.findElement(By.xpath("//div/p"));
        String text = dynamicsButton.getText();
        System.out.println(text);

        WebElement firstButton = driver.findElement(By.id("enableAfter"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.elementToBeClickable(firstButton));
        firstButton.click();


    }


}


