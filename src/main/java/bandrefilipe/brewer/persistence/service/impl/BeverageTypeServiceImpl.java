package bandrefilipe.brewer.persistence.service.impl;

import bandrefilipe.brewer.persistence.core.model.BeverageType;
import bandrefilipe.brewer.persistence.repository.BeverageTypeRepository;
import bandrefilipe.brewer.persistence.service.BeverageTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
class BeverageTypeServiceImpl implements BeverageTypeService {

    private final BeverageTypeRepository beverageTypeRepository;

    @Autowired
    BeverageTypeServiceImpl(final BeverageTypeRepository beverageTypeRepository) {
        this.beverageTypeRepository = beverageTypeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BeverageType> listAll() {
        return beverageTypeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BeverageType> findTypeById(final Long id) {
        log.debug("M=findTypeById: id={}", id);
        final var type = beverageTypeRepository.findById(id);
        log.debug("M=findTypeById: return={}", type);
        return type;
    }
}
