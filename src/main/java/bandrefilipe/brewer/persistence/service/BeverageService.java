package bandrefilipe.brewer.persistence.service;

import bandrefilipe.brewer.persistence.core.dto.BeverageRegistrationRequest;
import bandrefilipe.brewer.persistence.core.dto.BeverageRegistrationResponse;
import bandrefilipe.brewer.persistence.core.model.Beverage;

import java.util.Optional;

public interface BeverageService {

    Optional<Beverage> findBeverageById(Long id);
    Optional<Beverage> findBeverageBySku(String sku);
    Optional<BeverageRegistrationResponse> registerNewBeverage(BeverageRegistrationRequest beverage);
}
