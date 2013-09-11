Narrative: Customer buys soda
    As a Customer
    I want to buy soda

Scenario: Basic purchase
Given coke is in stock
When the Customer deposits 1.25
When the Customer presses the buy button
Then the machine should dispense coke

Scenario: Basic out of stock
Given coke is in stock
When the Customer deposits 1.25
When the Customer presses the buy button
Then the machine should dispense coke

Scenario: Customer has exact change
Given the <product> is in stock
When the Customer deposits <price>
When the Customer presses the buy button
Then the machine should dispense <product>

Examples:
| product | price |
| coke    | 1.25  |
| pepsi   | 0.25  |
| fanta   | 0.75  |

Scenario: Customer needs change back
Given the <product> is in stock
When the Customer deposits <amount>
When the Customer presses the buy button
Then the machine should dispense <product>
Then the machine should release <change>

Examples:
| product | price | amount | change |
| coke    |  1.25 |   1.50 |   0.25 |
| coke    |  1.25 |   2.00 |   0.75 |
| coke    |  1.25 |   2.50 |   1.25 |
| pepsi   |  0.25 |   1.00 |   0.75 |
| pepsi   |  0.25 |   0.30 |   0.05 |
| fanta   |  0.75 |   1.00 |   0.25 |

Scenario: Customer cancels the purchase
Given the <product> is in stock
When the Customer deposits <amount>
When the Customer presses the cancel button
Then the machine should not dispense <product>
Then the machine should release <amount>

Examples:
| product | amount |
| coke    |   1.50 |
| coke    |   2.00 |
| coke    |   2.50 |
| pepsi   |   1.00 |
| pepsi   |   0.30 |
| fanta   |   1.00 |

Scenario: Customer trys out of stock
Given the <product> is not in stock
When the Customer deposits <amount>
When the Customer presses the buy button
Then the machine should not dispense <product>
Then the machine should release <amount>
Then the machine should display out of stock

Examples:
| product | amount |
| coke    |   1.50 |
| coke    |   2.00 |
| coke    |   2.50 |
| pepsi   |   1.00 |
| pepsi   |   0.30 |
| fanta   |   1.00 |
