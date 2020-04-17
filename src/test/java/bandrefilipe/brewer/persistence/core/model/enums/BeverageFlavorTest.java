package bandrefilipe.brewer.persistence.core.model.enums;

import org.junit.jupiter.api.Test;

import static bandrefilipe.brewer.persistence.core.model.enums.BeverageFlavor.BITTER;
import static bandrefilipe.brewer.persistence.core.model.enums.BeverageFlavor.FRUITY;
import static bandrefilipe.brewer.persistence.core.model.enums.BeverageFlavor.SOFT;
import static bandrefilipe.brewer.persistence.core.model.enums.BeverageFlavor.STRONG;
import static bandrefilipe.brewer.persistence.core.model.enums.BeverageFlavor.SWEET;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BeverageFlavorTest {

    @Test
    void testGetByCode() {
        final var args = asList("B", "F", "S", "T", "W", "b", "f", "s", "t", "w", null);

        final var expected = asList(BITTER, FRUITY, SOFT, STRONG, SWEET, null, null, null, null, null, null);
        final var actual = args.stream()
                .map(BeverageFlavor::getByCode)
                .collect(toList());

        assertEquals(expected, actual,
                "it should be a list of flavors and null for null and lower case inputs");
    }
}
