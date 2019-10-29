package nl.marcenschede.tests.monorepo.it;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertThat;

public class FeatureHooks {

    private String firstname;
    private String response;

    @Given("name is {string}")
    public void name_is(String string) {

        firstname = string;
    }

    @When("the user is greeted")
    public void the_user_is_greeted() {

        response = new RestTemplate().getForObject("http://localhost:8082/welcome/" + firstname, String.class);
    }

    @Then("the welcome message is {string}")
    public void the_welcome_message_is(String string) {

        assertThat(response, CoreMatchers.equalTo(string));
    }



}
