package com.browserstack.single.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.browserstack.single.pages.BrowserStackPage;

public class BrowserStackSteps {
    private BrowserStackPage browserStackPage;

    public BrowserStackSteps(WebDriver driver) {
        browserStackPage = new BrowserStackPage(driver);
    }

    @Given("I try to search using Wikipedia App")
    public void searchWikipediaApp() throws InterruptedException {
        browserStackPage.searchWikipedia();
    }

    @Then("I search with keyword BrowserStack")
    public void searchWithKeywordBrowserStacks() throws InterruptedException {
      browserStackPage.searchWithKeyWord("BrowserStack");
      Thread.sleep(5000);
    }

    @Then("The search results should be listed")
    public void searchResultsShouldBeListed() throws Exception {
      Integer resultsSize  = browserStackPage.searchResultsShouldBeListed();
      Assert.assertTrue(resultsSize > 0);
    }
}
