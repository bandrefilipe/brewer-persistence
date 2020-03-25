package bandrefilipe.brewer.persistence.service.impl;

import bandrefilipe.brewer.persistence.model.Beverage;
import bandrefilipe.brewer.persistence.repository.BeverageRepository;
import bandrefilipe.brewer.persistence.service.BeverageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.isNull;

@Slf4j
@Service
class BeverageServiceImpl implements BeverageService {

    private final BeverageRepository beverageRepository;

    @Autowired
    BeverageServiceImpl(final BeverageRepository beverageRepository) {
        super();
        this.beverageRepository = beverageRepository;
    }

    @Override
    public Optional<Beverage> findBySku(final String sku) {
        log.debug("M=findBySku: sku={}", sku);
        if (isNull(sku)) {
            final Optional<Beverage> result = Optional.empty();
            log.debug("M=findBySku: return={}", result);
            return result;
        }
        final var result = beverageRepository.findBySkuIgnoreCase(sku);
        log.debug("M=findBySku: return={}", result);
        return result;
    }
}
