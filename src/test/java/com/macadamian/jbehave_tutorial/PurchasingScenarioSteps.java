package com.macadamian.jbehave_tutorial;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import com.macadamian.jbehave_tutorial.Machine;
import com.macadamian.jbehave_tutorial.Product;

public class PurchasingScenarioSteps {
    private Machine _machine = new Machine();
    private Product _result;
    private double _amount;

    @Given("$product is in stock")
    public void setInStock(String product) {
        _machine.stock(product, true);
    }

    @Given("$product is not in stock")
    public void setNotInStock(String product) {
        _machine.stock(product, false);
    }

    @When("the Customer deposits $amount")
    public void deposit(double amount) {
        _amount = amount;
    }

    @When("the Customer presses the buy $product button")
    public void pressedBuy(String product) {
        _result = _machine.buy(product, _amount);
    }

    @Then("the machine should dispense $expectedProduct")
    public void verifyProduct(String expectedProduct) {
        assertThat(_result, is(notNullValue()));
        assertThat(_result.name(), is(equalTo(expectedProduct)));
    }

    @Then("the machine should not dispense")
    public void verifyNoProduct() {
        assertThat(_result, is(nullValue()));
    }        
}
