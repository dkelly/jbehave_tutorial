Narrative: Customer buys soda
    As a Customer
    I want to buy soda

Scenario: Basic purchase of coke
Given coke is in stock
When the Customer deposits 1.25
When the Customer presses the buy coke button
Then the machine should dispense coke

Scenario: Basic purchase of fanta
Given fanta is in stock
When the Customer deposits .75
When the Customer presses the buy fanta button
Then the machine should dispense fanta

Scenario: Basic failed purchase of coke
Given coke is in stock
When the Customer deposits .75
When the Customer presses the buy coke button
Then the machine should not dispense

Scenario: Basic failed purchase of fanta
Given fanta is in stock
When the Customer deposits .25
When the Customer presses the buy fanta button
Then the machine should not dispense

Scenario: Basic out of stock of coke
Given coke is not in stock
When the Customer deposits 1.25
When the Customer presses the buy coke button
Then the machine should not dispense

Scenario: Get change
Given coke is in stock
When the Customer deposits 2.00
When the Customer presses the buy coke button
Then the machine should dispense coke
Then the machine should return 0.75
When the Customer deposits 1.50
When the Customer presses the buy coke button
Then the machine should dispense coke
Then the machine should return 0.25

