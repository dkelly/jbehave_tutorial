package com.macadamian.jbehave_tutorial;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class PurchasingScenarioSteps {
    @Given("$product is in stock")
    public void setInStock(String product) {
    }

    @When("the Customer deposits $amount")
    public void deposit(double amount) {
    }

    @When("the Customer presses the buy button")
    public void pressedBuy() {
    }

    @Then("the machine should dispense $expectedProduct")
    public void verifyProduct(String expectedProduct) {
    }
}
