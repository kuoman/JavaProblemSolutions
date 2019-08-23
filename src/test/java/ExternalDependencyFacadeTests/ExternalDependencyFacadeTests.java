package ExternalDependencyFacadeTests;

import ExternalDependencyFacade.IExternalClassFacade;
import ExternalDependencyFacade.Result;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExternalDependencyFacadeTests {

    // fakes to return results to test behaviours in our system based off of responses
    // from the external dependency.
    private class FakeHumanResult implements IExternalClassFacade {
        public Result determineDataType(ArrayList<String> data) {
            return new Result("human");
        }
    }

    private class FakeCarResult implements IExternalClassFacade {
        public Result determineDataType(ArrayList<String> data) {
            return new Result("car");
        }
    }

    private class FakeAirplaneResult implements IExternalClassFacade {
        public Result determineDataType(ArrayList<String> data) {
            return new Result("airplane");
        }
    }


    // This test is really just showing how you can setup a fake to use the facade that will then
    // help you to test how you deal with results from your external dependency.
    // One would create the FakeHumanResult, not to test how an external dependency would handle "our" data
    // returning us a human, but rather to simulate that external dependency's response of just giving us a
    // resultHuman and now we can test drive how our system behaves to that response.
    @Test
    public void shouldResultHuman() {
        // arrange
        IExternalClassFacade externalClass = new FakeHumanResult();
        // irralavent data here, as we are only setting up this facade to return a human so we can test how our system
        // handles a human result...
        ArrayList<String> dataToTest = null;

        // act
        Result result = externalClass.determineDataType(dataToTest);

        // assert
        // used to drive the impl of the fake
        assertThat(result.isOfType("human"), is(true));

    }

    @Test
    public void shouldResultCar() {
        // arrange
        IExternalClassFacade externalClass = new FakeCarResult();
        ArrayList<String> dataToTest = null;

        // act
        Result result = externalClass.determineDataType(dataToTest);

        // assert
        assertThat(result.isOfType("car"), is(true));
    }

    @Test
    public void shouldResultAirplane() {
        // arrange
        IExternalClassFacade externalClass = new FakeAirplaneResult();
        ArrayList<String> dataToTest = null;

        // act
        Result result = externalClass.determineDataType(dataToTest);

        // assert
        assertThat(result.isOfType("airplane"), is(true));
    }
}






