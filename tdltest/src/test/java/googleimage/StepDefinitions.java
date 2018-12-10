package googleimage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.sikuli.script.*;


public class StepDefinitions extends base.WebDriverBase {

    @Given("I navigate at {string}")
    public void i_navigate_at_https_www_google_com(String url) {
        System.out.println("Navigate to URL "+url);
        driver.navigate().to(url);
    }

    @Then("I verify main image matches with {string}")
    public void i_verify_image_matches_with(String image) throws FindFailed {
        String imagePath = this.getClass().getResource(image).getPath();
        System.out.println("Image path: "+imagePath);

        Screen screen = new Screen();
        double score = screen.find(imagePath).getScore();
        System.out.println("Proximity: "+score);
        Assert.assertTrue(String.format("Image found with score %s. Proximity must be higher than 80%%", score), score > 0.80);
    }

    @Before
    public void setup() {
        setupWebDriver();
    }

    @After
    public void teardown() {
       teardownWebDriver();
    }
}
