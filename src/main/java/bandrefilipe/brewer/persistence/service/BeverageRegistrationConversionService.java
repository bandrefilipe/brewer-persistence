package bandrefilipe.brewer.persistence.service;

import bandrefilipe.brewer.persistence.core.dto.BeverageRegistrationRequest;
import bandrefilipe.brewer.persistence.core.dto.BeverageRegistrationResponse;
import bandrefilipe.brewer.persistence.core.model.Beverage;

public interface BeverageRegistrationConversionService {

    Beverage requestToModel(BeverageRegistrationRequest dto);
    BeverageRegistrationResponse modelToResponse(Beverage model);
}
