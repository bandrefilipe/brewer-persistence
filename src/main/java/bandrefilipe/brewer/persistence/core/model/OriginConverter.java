package bandrefilipe.brewer.persistence.core.model;

import bandrefilipe.brewer.persistence.core.model.enums.Origin;

import javax.persistence.AttributeConverter;

import static java.util.Optional.ofNullable;

/**
 * A package-private {@link AttributeConverter} for JPA usage.
 */
class OriginConverter implements AttributeConverter<Origin, String> {

    @Override
    public String convertToDatabaseColumn(final Origin attribute) {
        return ofNullable(attribute)
                .map(Origin::getCode)
                .orElse(null);
    }

    @Override
    public Origin convertToEntityAttribute(final String dbData) {
        return ofNullable(dbData)
                .map(Origin::getByCode)
                .orElse(null);
    }
}
