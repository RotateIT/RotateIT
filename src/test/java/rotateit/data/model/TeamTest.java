package rotateit.data.model;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;
import static pl.pojo.tester.api.assertion.Method.CONSTRUCTOR;
import static pl.pojo.tester.api.assertion.Method.GETTER;
import static pl.pojo.tester.api.assertion.Method.SETTER;

import org.junit.Test;

public class TeamTest {

    @Test
    public void testGettersSettersAndConstructor() {
        assertPojoMethodsFor(Team.class)
            .testing(CONSTRUCTOR)
            .testing(GETTER)
            .testing(SETTER)
            .areWellImplemented();
    }
}
