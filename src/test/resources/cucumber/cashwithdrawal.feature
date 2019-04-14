Feature: Cash withdrawal
  Verify positive and negative cash withdrawal scenarios

  Scenario: Try to withdraw more than account balance
    Given My initial account balance is 200 PLN
    When I try to withdraw 500 PLN
    Then The error message returned is correct
    And The amount withdrawn is 0 PLN
    And My account balance is 200 PLN

  Scenario Outline: Withdraw desired amount
    Given My initial account balance is 200 PLN
    When I try to withdraw <desiredAmount> PLN
    Then The amount withdrawn is <amountWithdrawn> PLN
    And My account balance is <accountBalance> PLN

    Examples:
      | desiredAmount | amountWithdrawn | accountBalance |
      | 0             | 0               | 200            |
      | 50            | 50              | 150            |
      | 100           | 100             | 100            |
      | 150           | 150             | 50             |
      | 200           | 200             | 0              |