package com.browserstack.local.pages;

import io.appium.java_client.AppiumBy;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class LocalPage {
    private WebDriver driver;

    public LocalPage(WebDriver driver) {
        this.driver = driver;
    }

    public String matchLocalText() throws Throwable {
        WebElement resultElement = (WebElement) driver.findElement(AppiumBy.accessibilityId("ResultBrowserStackLocal"));

        String resultString = resultElement.getText().toLowerCase();
        System.out.println(resultString);
        if (resultString.contains("not working")) {
            File scrFile = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/screenshot.png"));
            System.out.println("Screenshot stored at " + System.getProperty("user.dir") + "/screenshot.png");
            throw new Error("Unexpected BrowserStackLocal test result");
        }
        return resultString;
    }

    public void startLocalSampleApp() {
        WebElement testButton = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("TestBrowserStackLocal")));
        testButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                String result = d.findElement(AppiumBy.accessibilityId("ResultBrowserStackLocal")).getAttribute("value");
                return result != null && result.length() > 0;
            }
        });
    }
}
