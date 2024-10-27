package com.browserstack.single.pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BrowserStackPage {
    private WebDriver driver;

    public BrowserStackPage(WebDriver driver) {
        this.driver = driver;
    }

    public void findTextButton() {
        WebElement textButton = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Text Button")));
        textButton.click();
    }

    public Integer searchResultsShouldBeListed() {
        List<WebElement> allProductsName = driver.findElements(AppiumBy.className("android.widget.TextView"));
        return allProductsName.size();
    }

    public void enterInputInTextInputField(String textInput) {
        WebElement textInputField = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Text Input")));
        textInputField.sendKeys(textInput + "\n");
    }

    public String getTextInTextOutputField() {
        WebElement textOutput = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Text Output")));
        return textOutput.getText();
    }
}
