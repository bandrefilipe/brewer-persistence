package bandrefilipe.brewer.persistence.core.model.enums;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static bandrefilipe.brewer.persistence.core.model.enums.Origin.INTERNATIONAL;
import static bandrefilipe.brewer.persistence.core.model.enums.Origin.NATIONAL;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OriginTest {

    @Test
    void testGetByCode() {
        final var args = asList("N", "I", "n", "i", null);

        final var expected = asList(NATIONAL, INTERNATIONAL, null, null, null);
        final var actual = args.stream()
                .map(Origin::getByCode)
                .collect(toList());

        assertEquals(expected, actual,
                "it should be a list of origins and null for null and lower case inputs");
    }
}
