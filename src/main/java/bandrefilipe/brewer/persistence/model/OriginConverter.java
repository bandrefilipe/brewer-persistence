package bandrefilipe.brewer.persistence.model;

import javax.persistence.AttributeConverter;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toUnmodifiableMap;

class OriginConverter implements AttributeConverter<Origin, String> {

    private final Map<String, Origin> originMap;

    OriginConverter() {
        super();
        originMap = Stream.of(Origin.values())
                .collect(toUnmodifiableMap(Origin::getCode, Function.identity()));
    }

    @Override
    public String convertToDatabaseColumn(final Origin attribute) {
        return ofNullable(attribute)
                .map(Origin::getCode)
                .orElse(null);
    }

    @Override
    public Origin convertToEntityAttribute(final String dbData) {
        return ofNullable(dbData)
                .map(originMap::get)
                .orElse(null);
    }
}
