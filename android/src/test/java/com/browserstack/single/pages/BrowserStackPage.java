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

    public void searchWikipedia() {
        WebElement searchElement = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Search Wikipedia")));
        searchElement.click();
    }

    public void searchWithKeyWord(String keyWord) throws InterruptedException {
        WebElement insertTextElement = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys(keyWord);
    }

    public Integer searchResultsShouldBeListed() {
        List<WebElement> allProductsName = driver.findElements(AppiumBy.className("android.widget.TextView"));
        return allProductsName.size();
    }

}
