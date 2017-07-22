package rotateit.data.model;

import org.junit.Test;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;
import static pl.pojo.tester.api.assertion.Method.*;

public class UserTest {

    @Test
    public void testGettersSettersAndToString() {
        assertPojoMethodsFor(User.class)
            .testing(GETTER)
            .testing(SETTER)
            .testing(TO_STRING)
            .areWellImplemented();
    }
}
