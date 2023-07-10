package app.identifier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Example of JUnit 5.0 test for Identifier Program,
 * considering basic functional testing criterion.
 */
public class IdentifierInitialTest {
    @Test
    public void validateIdentifier01() {
        Identifier id = new Identifier();
        boolean result = id.validateIdentifier("a1");
        assertEquals(true, result);
    }

    @Test
    public void validateIdentifier02() {
        Identifier id = new Identifier();
        boolean result = id.validateIdentifier("#");
        assertEquals(false, result);
    }
}