package bandrefilipe.brewer.persistence.service;

import bandrefilipe.brewer.persistence.model.Beverage;

import java.util.Optional;

public interface BeverageService {

    Optional<Beverage> findBySku(String sku);
}
