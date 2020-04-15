package bandrefilipe.brewer.persistence.service.impl;

import bandrefilipe.brewer.persistence.core.dto.BeverageRegistrationRequest;
import bandrefilipe.brewer.persistence.core.dto.BeverageRegistrationResponse;
import bandrefilipe.brewer.persistence.core.model.Beverage;
import bandrefilipe.brewer.persistence.repository.BeverageRepository;
import bandrefilipe.brewer.persistence.service.BeverageRegistrationConversionService;
import bandrefilipe.brewer.persistence.service.BeverageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Slf4j
@Service
class BeverageServiceImpl implements BeverageService {

    private final BeverageRepository beverageRepository;
    private final BeverageRegistrationConversionService conversionService;

    @Autowired
    BeverageServiceImpl(final BeverageRepository beverageRepository,
                        final BeverageRegistrationConversionService conversionService) {
        this.beverageRepository = beverageRepository;
        this.conversionService = conversionService;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Beverage> findBeverageById(final Long id) {
        log.debug("M=findBeverageById: id={}", id);
        final var result = beverageRepository.findById(id);
        log.debug("M=findBeverageById: return={}", result);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Beverage> findBeverageBySku(final String sku) {
        log.debug("M=findBeverageBySku: sku={}", sku);
        final var result = beverageRepository.findBySkuIgnoreCase(sku);
        log.debug("M=findBeverageBySku: return={}", result);
        return result;
    }

    @Override
    @Transactional
    public Optional<BeverageRegistrationResponse> registerNewBeverage(final BeverageRegistrationRequest requestDTO) {
        log.debug("M=registerNewBeverage: requestDTO={}", requestDTO);
        final var result = ofNullable(requestDTO)
                .map(conversionService::requestToModel)
                .map(beverageRepository::save)
                .map(conversionService::modelToResponse);
        log.debug("M=registerNewBeverage: return={}", result);
        return result;
    }
}
