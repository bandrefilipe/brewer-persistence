package bandrefilipe.brewer.persistence;

public interface TestEqualsAndHashCodeContract {

    void testNonNullity();
    void shouldBeReflexive();
    void shouldBeTransitive();
    void shouldBeSymmetrical();
    void shouldBeConsistent();
    void shouldHaveSameHashes();
}
