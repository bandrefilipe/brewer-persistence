package bandrefilipe.brewer.persistence.core.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static bandrefilipe.brewer.persistence.core.model.enums.Origin.INTERNATIONAL;
import static bandrefilipe.brewer.persistence.core.model.enums.Origin.NATIONAL;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OriginConverterTest {

    private OriginConverter converter;

    @BeforeEach
    void beforeEach() {
        converter = new OriginConverter();
    }

    @Test
    void testConvertToDatabaseColumn() {
        final var args = asList(INTERNATIONAL, NATIONAL, null);

        final var expected = asList("I", "N", null);
        final var actual = args.stream()
                .map(converter::convertToDatabaseColumn)
                .collect(toList());

        assertEquals(expected, actual,
                "it should be a list of origin codes with null as last element");
    }

    @Test
    void testConvertToEntityAttribute() {
        final var args = asList("I", "N", null);

        final var expected = asList(INTERNATIONAL, NATIONAL, null);
        final var actual = args.stream()
                .map(converter::convertToEntityAttribute)
                .collect(toList());

        assertEquals(expected, actual,
                "it should be a list of origins with null as last element");
    }
}
