package ExternalDependencyFacadeTests;

import ExternalDependencyFacade.Result;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ResultTests {

    @Test
    public void shouldResultFalseForNotSameType() {
        // arrange
        Result result = new Result("human");

        // assert
        assertThat(result.isOfType("car"), is(false));
    }

    @Test
    public void shouldResultTrueForSameType() {
        // arrange
        Result result = new Result("car");

        // assert
        assertThat(result.isOfType("car"), is(true));
    }
}
