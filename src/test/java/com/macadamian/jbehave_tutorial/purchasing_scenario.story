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
Given coke is in stock of quantity 2
When the Customer deposits 2.00
When the Customer presses the buy coke button
Then the machine should dispense coke
Then the machine should return 0.75
When the Customer deposits 1.50
When the Customer presses the buy coke button
Then the machine should dispense coke
Then the machine should return 0.25

Scenario: Stock
Given coke is in stock of quantity 2
Given fanta is in stock of quantity 1
When the Customer deposits 1.25
When the Customer presses the buy coke button
Then the machine should dispense coke
When the Customer deposits 1.25
When the Customer presses the buy coke button
Then the machine should dispense coke
When the Customer deposits 1.25
When the Customer presses the buy coke button
Then the machine should not dispense
Then the machine should return 1.25

Scenario: Table of possibilities
Given coke is in stock
Given fanta is in stock
When the Customer deposits <amount>
When the Customer presses the buy <product> button
Then the machine should dispense <expected_product>
Then the machine should return <change>

Examples:
| product | amount | change | expected_product |
| coke    |   1.50 |   0.25 | coke             |
| fanta   |   1.00 |   0.25 | fanta            |
| coke    |   2.00 |   0.75 | coke             |
| fanta   |   2.00 |   1.25 | fanta            |


