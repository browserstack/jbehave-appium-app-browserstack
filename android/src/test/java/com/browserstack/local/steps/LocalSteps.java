package com.browserstack.local.steps;

import com.browserstack.local.pages.LocalPage;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;

public class LocalSteps {
  private LocalPage page;

  public LocalSteps(WebDriver driver) {
    page = new LocalPage(driver);
  }

  @When("I start test on the Local Sample App")
  public void startLocalSampleApp() {
    page.startLocalSampleApp();
  }

  @Then("I should see \"$keyword\"")
  public void pageShouldContain(String keyword) throws Throwable {
    Assert.assertTrue(page.matchLocalText().contains(keyword));
  }
}
