package bandrefilipe.brewer.persistence.core.model;

import bandrefilipe.brewer.persistence.TestEqualsAndHashCodeContract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.TRUE;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class BeverageTest implements TestEqualsAndHashCodeContract {

    private Beverage X;
    private Beverage Y;
    private Beverage Z;

    @BeforeEach
    void beforeEach() {
        X = Beverage.builder().sku("AA000").build();
        Y = Beverage.builder().sku("AA000").build();
        Z = Beverage.builder().sku("AA000").build();
    }

    @Test
    @Override
    public void testNonNullity() {
        assertFalse(X.equals(null));
    }

    @Test
    @Override
    public void shouldBeReflexive() {
        assertTrue(X.equals(X));
    }

    @Test
    @Override
    public void shouldBeTransitive() {
        final var expected = asList(TRUE, TRUE);
        final var actual = asList(X.equals(Y), Y.equals(X));

        assertEquals(expected, actual);
    }

    @Test
    @Override
    public void shouldBeSymmetrical() {
        final var expected = asList(TRUE, TRUE, TRUE);
        final var actual = asList(X.equals(Y), Y.equals(Z), Z.equals(X));

        assertEquals(expected, actual);
    }

    @Test
    @Override
    public void shouldBeConsistent() {
        for (int i = 0; i < 100; i++)
            if (!X.equals(Y)) fail();
    }

    @Test
    @Override
    public void shouldHaveSameHashes() {
        assertTrue((X.hashCode() == Y.hashCode()) && (X.hashCode() == Z.hashCode()));
    }
}
