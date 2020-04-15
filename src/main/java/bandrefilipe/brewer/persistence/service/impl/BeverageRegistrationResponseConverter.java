package bandrefilipe.brewer.persistence.service.impl;

import bandrefilipe.brewer.persistence.core.dto.BeverageRegistrationResponse;
import bandrefilipe.brewer.persistence.core.dto.BeverageRegistrationResponse.BeverageTypeRegistrationResponse;
import bandrefilipe.brewer.persistence.core.model.Beverage;
import bandrefilipe.brewer.persistence.core.model.BeverageType;
import lombok.NoArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * Responsible for model-to-dto conversion.
 */
@Component
@NoArgsConstructor
class BeverageRegistrationResponseConverter implements Converter<Beverage, BeverageRegistrationResponse> {

    @Override
    public BeverageRegistrationResponse convert(@NonNull final Beverage model) {
        return BeverageRegistrationResponse.builder()
                .id(model.getId())
                .sku(model.getSku())
                .name(model.getName())
                .type(convertBeverageType(model.getType()))
                .build();
    }

    BeverageTypeRegistrationResponse convertBeverageType(final BeverageType beverageType) {
        return BeverageTypeRegistrationResponse.builder()
                .id(beverageType.getId())
                .name(beverageType.getName())
                .build();
    }
}
