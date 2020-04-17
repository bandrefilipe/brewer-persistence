package bandrefilipe.brewer.persistence.core.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static bandrefilipe.brewer.persistence.core.model.enums.BeverageFlavor.BITTER;
import static bandrefilipe.brewer.persistence.core.model.enums.BeverageFlavor.FRUITY;
import static bandrefilipe.brewer.persistence.core.model.enums.BeverageFlavor.SOFT;
import static bandrefilipe.brewer.persistence.core.model.enums.BeverageFlavor.STRONG;
import static bandrefilipe.brewer.persistence.core.model.enums.BeverageFlavor.SWEET;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BeverageFlavorConverterTest {

    private BeverageFlavorConverter converter;

    @BeforeEach
    void beforeEach() {
        converter = new BeverageFlavorConverter();
    }

    @Test
    void testConvertToDatabaseColumn() {
        final var args = asList(BITTER, FRUITY, SOFT, STRONG, SWEET, null);

        final var expected = asList("B", "F", "S", "T", "W", null);
        final var actual = args.stream()
                .map(converter::convertToDatabaseColumn)
                .collect(toList());

        assertEquals(expected, actual,
                "it should be a list of beverage flavor codes with null as last element");
    }

    @Test
    void testConvertToEntityAttribute() {
        final var args = asList("B", "F", "S", "T", "W", null);

        final var expected = asList(BITTER, FRUITY, SOFT, STRONG, SWEET, null);
        final var actual = args.stream()
                .map(converter::convertToEntityAttribute)
                .collect(toList());

        assertEquals(expected, actual,
                "it should be a list of beverage flavors with null as last element");
    }
}
