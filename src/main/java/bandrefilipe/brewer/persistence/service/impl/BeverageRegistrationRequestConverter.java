package bandrefilipe.brewer.persistence.service.impl;

import bandrefilipe.brewer.persistence.core.dto.BeverageRegistrationRequest;
import bandrefilipe.brewer.persistence.core.model.Beverage;
import bandrefilipe.brewer.persistence.core.model.enums.BeverageFlavor;
import bandrefilipe.brewer.persistence.core.model.enums.Origin;
import bandrefilipe.brewer.persistence.service.BeverageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Responsible for dto-to-model conversion.
 */
@Component
class BeverageRegistrationRequestConverter implements Converter<BeverageRegistrationRequest, Beverage> {

    private BeverageTypeService beverageTypeService;

    @Autowired
    BeverageRegistrationRequestConverter(final BeverageTypeService beverageTypeService) {
        this.beverageTypeService = beverageTypeService;
    }

    @Override
    public Beverage convert(@NonNull final BeverageRegistrationRequest dto) {
        final var beverageType = beverageTypeService.findTypeById(dto.getBeverageTypeId())
                // TODO create and throw custom exception and adjust test
                .orElseThrow(RuntimeException::new);
        return Beverage.builder()
                .id(null)
                .sku(dto.getSku().toUpperCase(Locale.US))
                .name(dto.getName())
                .description(dto.getDescription())
                .unitPrice(dto.getUnitPrice())
                .alcoholContent(dto.getAlcoholContent())
                .commission(dto.getCommission())
                .stock(dto.getStock())
                .origin(Origin.getByCode(dto.getOriginCode()))
                .flavor(BeverageFlavor.getByCode(dto.getFlavorCode()))
                .type(beverageType)
                .build();
    }
}
