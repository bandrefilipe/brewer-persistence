package bandrefilipe.brewer.persistence.service.impl;

import bandrefilipe.brewer.persistence.core.dto.BeverageRegistrationRequestBuilder;
import bandrefilipe.brewer.persistence.core.model.Beverage;
import bandrefilipe.brewer.persistence.core.model.BeverageType;
import bandrefilipe.brewer.persistence.core.model.BeverageTypeBuilder;
import bandrefilipe.brewer.persistence.service.BeverageTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static bandrefilipe.brewer.persistence.core.model.enums.BeverageFlavor.BITTER;
import static bandrefilipe.brewer.persistence.core.model.enums.Origin.INTERNATIONAL;
import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class BeverageRegistrationRequestConverterTest {

    private BeverageTypeService mockedBeverageTypeService;
    private BeverageRegistrationRequestConverter requestToModelConverter;

    @BeforeEach
    void beforeEach() {
        this.mockedBeverageTypeService = mock(BeverageTypeService.class);
        this.requestToModelConverter = new BeverageRegistrationRequestConverter(mockedBeverageTypeService);
    }

    @Test
    void testRequestToModelConversion() {
        when(mockedBeverageTypeService.findTypeById(any()))
                .thenReturn(ofNullable(new BeverageTypeBuilder()
                        .id(1L)
                        .name("Mocked Name")
                        .build()));
        final var arg = new BeverageRegistrationRequestBuilder()
                .sku("AA000")
                .name("Weihenstephaner Wheat Beer")
                .description("A veritable classic – and the star of our beer ensemble")
                .unitPrice(new BigDecimal("32.99"))
                .alcoholContent(new BigDecimal("5.40"))
                .commission(new BigDecimal("18.00"))
                .stock(300)
                .originCode("I")
                .flavorCode("B")
                .beverageTypeId(1L)
                .build();

        final var expected = BeverageRegistrationRequestConverterTestData.from(Beverage.builder()
                .id(null)
                .sku("AA000")
                .name("Weihenstephaner Wheat Beer")
                .description("A veritable classic – and the star of our beer ensemble")
                .unitPrice(new BigDecimal("32.99"))
                .alcoholContent(new BigDecimal("5.40"))
                .commission(new BigDecimal("18.00"))
                .stock(300)
                .origin(INTERNATIONAL)
                .flavor(BITTER)
                .type(new BeverageTypeBuilder()
                        .id(1L)
                        .name("Mocked Name")
                        .build())
                .build()
        );
        final var actual = BeverageRegistrationRequestConverterTestData.from(requestToModelConverter.convert(arg));

        assertEquals(expected, actual,
                "at least one attribute isn't equal between expected and actual");
    }

    @Test
    void testRequestToModelSkuToUppercase() {
        when(mockedBeverageTypeService.findTypeById(any()))
                .thenReturn(Optional.of(new BeverageType()));
        final var arg = new BeverageRegistrationRequestBuilder()
                .sku("abc123")
                .build();

        final var expected = "ABC123";
        final var actual = requestToModelConverter.convert(arg).getSku();

        assertEquals(expected, actual,
                "the converted sku wasn't transformed to upper case");
    }

    @Test
    void testRequestToModelException() {
        when(mockedBeverageTypeService.findTypeById(any()))
                .thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> requestToModelConverter.convert(null),
                "no RuntimeException was thrown when BeverageTypeService#findTypeById returned Optional#empty");
    }

    @Test
    void testRequestToModelNullSkuException() {
        when(mockedBeverageTypeService.findTypeById(any()))
                .thenReturn(Optional.of(new BeverageType()));
        final var arg = new BeverageRegistrationRequestBuilder()
                .sku(null)
                .build();

        assertThrows(NullPointerException.class, () -> requestToModelConverter.convert(arg),
                "no NullPointerException was thrown when the request's sku attribute was null");
    }
}
