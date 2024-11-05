package com.browserstack.single.steps;

import com.browserstack.single.pages.BrowserStackPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class BrowserStackSteps {
    private BrowserStackPage browserStackPage;

    public BrowserStackSteps(WebDriver driver) {
        browserStackPage = new BrowserStackPage(driver);
    }

    @Given("I try to find Text Button in Sample App")
    public void findTextButton() {
        browserStackPage.findTextButton();
    }

    @When("I type in \"$textInput\" in the Text Input field")
    public void enterInputInTextInputField(String textInput) throws InterruptedException {
        browserStackPage.enterInputInTextInputField(textInput);
        Thread.sleep(5000);
    }

    @Then("I should get the entered text in the Text Output field")
    public void getTextInTextOutputField() throws Exception {
        String textOutput = browserStackPage.getTextInTextOutputField();
        Assert.assertEquals(textOutput, "hello@browserstack.com");
    }
}
