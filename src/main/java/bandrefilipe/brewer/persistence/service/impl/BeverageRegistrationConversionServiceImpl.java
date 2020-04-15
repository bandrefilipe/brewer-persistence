package bandrefilipe.brewer.persistence.service.impl;

import bandrefilipe.brewer.persistence.core.dto.BeverageRegistrationRequest;
import bandrefilipe.brewer.persistence.core.dto.BeverageRegistrationResponse;
import bandrefilipe.brewer.persistence.core.model.Beverage;
import bandrefilipe.brewer.persistence.service.BeverageRegistrationConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A wrapper class for beverage registration objects conversion.<p>
 * It wraps both (request)dto-to-model and model-to-dto(response) converters and delegates the
 * conversion calls to its implementor.
 */
@Service
class BeverageRegistrationConversionServiceImpl implements BeverageRegistrationConversionService {

    private BeverageRegistrationRequestConverter requestToModelConverter;
    private BeverageRegistrationResponseConverter modelToResponseConverter;

    @Autowired
    BeverageRegistrationConversionServiceImpl(final BeverageRegistrationRequestConverter requestConverter,
                                              final BeverageRegistrationResponseConverter responseConverter) {
        this.requestToModelConverter = requestConverter;
        this.modelToResponseConverter = responseConverter;
    }

    @Override
    public Beverage requestToModel(final BeverageRegistrationRequest dto) {
        return requestToModelConverter.convert(dto);
    }

    @Override
    public BeverageRegistrationResponse modelToResponse(final Beverage model) {
        return modelToResponseConverter.convert(model);
    }
}
