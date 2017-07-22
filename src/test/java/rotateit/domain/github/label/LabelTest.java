package rotateit.domain.github.label;

import org.junit.Test;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;
import static pl.pojo.tester.api.assertion.Method.CONSTRUCTOR;
import static pl.pojo.tester.api.assertion.Method.GETTER;

public class LabelTest {

    @Test
    public void testGetterAndConstructor() {
        assertPojoMethodsFor(Label.class)
            .testing(GETTER)
            .testing(CONSTRUCTOR)
            .areWellImplemented();
    }
}
