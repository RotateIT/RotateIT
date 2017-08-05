package rotateit.data.model;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;
import static pl.pojo.tester.api.assertion.Method.GETTER;
import static pl.pojo.tester.api.assertion.Method.SETTER;
import static pl.pojo.tester.api.assertion.Method.TO_STRING;

import org.junit.Test;

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
