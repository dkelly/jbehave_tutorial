package com.macadamian.jbehave_tutorial;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Alias;

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
        _machine.stock(product, 1);
    }

    @Given("$product is in stock of quantity $quantity")
    public void setInStock(String product, int quantity) {
        _machine.stock(product, quantity);
    }

    @Given("$product is not in stock")
    public void setNotInStock(String product) {
        _machine.stock(product, 0);
    }

    @Given("<product> is in stock of quantity <quantity>")
    public void setQuantity(String product, int quantity) {
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
        if ("none".equals(expectedProduct)) {
            verifyNoProduct();
        } else {
            assertThat(_result, is(notNullValue()));
            assertThat(_result.name(), is(equalTo(expectedProduct)));
        }
    }

    @Then("the machine should not dispense")
    public void verifyNoProduct() {
        assertThat(_result, is(nullValue()));
    }        

    @Then("the machine should return $change")
    public void verifyChange(double change) {
        assertThat(_machine.current_change(), is(equalTo(change)));
    }
}
