package com.example.demo;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.is;

public class AdduserSelenium {

    public String baseUrl = "http://localhost:3000/users";
    String driverPath = "C:\\Users\\shard\\Downloads\\selenium-java-3.141.59\\geckodriver-v0.26.0-win64\\geckodriver.exe";
    public WebDriver driver;

    @Test
    void Test() throws InterruptedException {
        System.out.println("launch firefox browser");
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Thread.sleep(2000);
        WebElement adduser = driver.findElement(By.tagName("button"));
        adduser.click();
        driver.findElement(By.name("user_id")).sendKeys("004");
        driver.findElement(By.name("first_name")).sendKeys("Jolly");
        driver.findElement(By.name("last_name")).sendKeys("Rama");
        driver.findElement(By.name("password")).sendKeys("testing5");
        driver.findElement(By.name("email")).sendKeys("Jollyram@gmail.com");
        driver.findElement(By.name("mobile_number")).sendKeys("1234567897");
        driver.findElement(By.name("middle_name")).sendKeys("best5");
        WebElement save = driver.findElement(By.tagName("button"));
        save.click();
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(1000);
        driver.close();
        get("http://localhost:9090/users/4")
                .then()
                .assertThat()
                .statusCode(200)
                .body("first_name", Matchers.equalTo("Jolly"))
                .body("last_name", Matchers.equalTo("Rama"))
                .body("password", Matchers.equalTo("testing5"))
                .body("email", Matchers.equalTo("Jollyram@gmail.com"))
                .body("mobile_number", Matchers.equalTo("1234567897"))
                .body("middle_name", Matchers.equalTo("best5"));
        get("http://localhost:9090/users")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size()", is(1));



    }


}
