package bandrefilipe.brewer.persistence.core.model;

import bandrefilipe.brewer.persistence.core.model.enums.BeverageFlavor;

import javax.persistence.AttributeConverter;

import static java.util.Optional.ofNullable;

/**
 * A package-private {@link AttributeConverter} for JPA usage.<p>
 */
class BeverageFlavorConverter implements AttributeConverter<BeverageFlavor, String> {

    @Override
    public String convertToDatabaseColumn(final BeverageFlavor attribute) {
        return ofNullable(attribute)
                .map(BeverageFlavor::getCode)
                .orElse(null);
    }

    @Override
    public BeverageFlavor convertToEntityAttribute(final String dbData) {
        return ofNullable(dbData)
                .map(BeverageFlavor::getByCode)
                .orElse(null);
    }
}
