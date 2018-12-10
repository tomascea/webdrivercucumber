package postmanecho;

import base.WebDriverBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import postmanecho.virtualkeyboard.VirtualKeyboard;

import java.awt.event.KeyEvent;


public class StepDefinitions extends WebDriverBase {

    @FindBy(xpath = "/html/body/pre")
    private WebElement jsonFormattedResponse;

    @Given("I authenticate at {string}")
    public void i_authenticate_at(String url) {
        System.out.println("Navigate to URL "+url);
        driver.navigate().to(url);
    }

    @When("username {string} and password {string}")
    public void username_and_password(String username, String pwd) throws InterruptedException {
        System.out.println(String.format("Enter username %s and password %s", username, pwd));
        Thread.sleep(3000);
        VirtualKeyboard vk = new VirtualKeyboard();
        vk.pressKeys(username);
        vk.enterKey(KeyEvent.VK_TAB);
        vk.pressKeys(pwd);
        vk.enterKey(KeyEvent.VK_TAB);
        vk.enterKey(KeyEvent.VK_ENTER);
    }

    @Then("I get {string} response")
    public void i_get_authenticated_true_response(String response){
        System.out.println("Response expected: "+response);
        Assert.assertTrue(driver.getPageSource().contains(response));
        Assert.assertEquals(response, jsonFormattedResponse.getText());
    }

    @Before
    public void setupTest() {
       setupWebDriver();
    }

    @After
    public void teardown() {
        teardownWebDriver();
    }

}
