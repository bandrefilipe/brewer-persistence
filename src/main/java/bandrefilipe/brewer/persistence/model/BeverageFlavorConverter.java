package bandrefilipe.brewer.persistence.model;

import javax.persistence.AttributeConverter;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toUnmodifiableMap;

class BeverageFlavorConverter implements AttributeConverter<BeverageFlavor, String> {

    private final Map<String, BeverageFlavor> flavorMap;

    BeverageFlavorConverter() {
        super();
        flavorMap = Stream.of(BeverageFlavor.values())
                .collect(toUnmodifiableMap(BeverageFlavor::getCode, Function.identity()));
    }

    @Override
    public String convertToDatabaseColumn(final BeverageFlavor attribute) {
        return ofNullable(attribute)
                .map(BeverageFlavor::getCode)
                .orElse(null);
    }

    @Override
    public BeverageFlavor convertToEntityAttribute(final String dbData) {
        return ofNullable(dbData)
                .map(flavorMap::get)
                .orElse(null);
    }
}
