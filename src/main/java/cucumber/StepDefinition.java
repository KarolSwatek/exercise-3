package cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static data.ErrorMessage.NOT_ENOUGH_FUNDS;
import static org.junit.Assert.assertEquals;

public class StepDefinition {
    private int accountBalance;
    private int withdrawnAmount;
    private String errorMessage;

    @Given("^My initial account balance is (\\d+) PLN$")
    public void setInitialAccountBalance(int initialAccountBalance) {
        accountBalance = initialAccountBalance;
    }

    @When("^I try to withdraw (\\d+) PLN$")
    public void withdrawMoney(int requestedAmount) {
        try {
            withdraw(requestedAmount);
        } catch (RuntimeException e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("^The error message returned is correct$")
    public void verifyErrorMessage() {
        assertEquals(NOT_ENOUGH_FUNDS.getMessage(), errorMessage);
    }

    @Then("^The amount withdrawn is (\\d+) PLN$")
    public void checkWithdrawnAmount(int expectedAmount) {
        assertEquals(expectedAmount, withdrawnAmount);
    }

    @Then("^My account balance is (\\d+) PLN$")
    public void checkAccountBalance(int expectedBalance) {
        assertEquals(expectedBalance, accountBalance);
    }

    private void withdraw(int amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            withdrawnAmount = amount;
        } else {
            withdrawnAmount = 0;
            throw new RuntimeException(NOT_ENOUGH_FUNDS.getMessage());
        }
    }
}
