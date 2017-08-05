package rotateit.domain.github.label;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;
import static pl.pojo.tester.api.assertion.Method.CONSTRUCTOR;
import static pl.pojo.tester.api.assertion.Method.GETTER;

import org.junit.Test;

public class UserTest {

    @Test
    public void testGetterAndConstructor() {
        assertPojoMethodsFor(User.class)
            .testing(GETTER)
            .testing(CONSTRUCTOR)
            .areWellImplemented();
    }
}
