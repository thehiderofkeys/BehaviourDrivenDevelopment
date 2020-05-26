package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hello.Calculator;
import org.junit.Assert;

public class CalculatorSteps {
    private int actualSum;
    private Calculator calculator= new Calculator();
    @Given("I have entered {int} into the calculator")
    public void i_have_entered_into_the_calculator(int number) {
        calculator.FirstNumber=number;
    }

    @Given("I have also entered {int} into the calculator")
    public void i_have_also_entered_into_the_calculator(int number) {
        calculator.SecondNumber=number;
    }

    @When("I press add")
    public void i_press_add() {
        actualSum=calculator.Add();
    }

    @Then("The Result should be {int}")
    public void the_Result_should_be(int expectedSum) {
        Assert.assertEquals(expectedSum, actualSum);
    }
}

