package rotateit.domain.github.label;

import org.junit.Test;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;
import static pl.pojo.tester.api.assertion.Method.CONSTRUCTOR;
import static pl.pojo.tester.api.assertion.Method.GETTER;

public class UserTest {

    @Test
    public void testGetterAndConstructor() {
        assertPojoMethodsFor(User.class)
            .testing(GETTER)
            .testing(CONSTRUCTOR)
            .areWellImplemented();
    }
}
