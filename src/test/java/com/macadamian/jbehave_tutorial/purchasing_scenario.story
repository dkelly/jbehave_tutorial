Narrative: Customer buys soda
    As a Customer
    I want to buy soda

Scenario: Basic purchase of coke
Given coke is in stock
When the Customer deposits 1.25
When the Customer presses the buy button
Then the machine should dispense coke

Scenario: Basic purchase of fanta
Given coke is in stock
When the Customer deposits .75
When the Customer presses the buy button
Then the machine should dispense fanta
