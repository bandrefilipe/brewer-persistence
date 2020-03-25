package bandrefilipe.brewer.persistence.service.impl;

import bandrefilipe.brewer.persistence.model.BeverageType;
import bandrefilipe.brewer.persistence.repository.BeverageTypeRepository;
import bandrefilipe.brewer.persistence.service.BeverageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class BeverageTypeServiceImpl implements BeverageTypeService {

    private final BeverageTypeRepository beverageTypeRepository;

    @Autowired
    BeverageTypeServiceImpl(final BeverageTypeRepository beverageTypeRepository) {
        super();
        this.beverageTypeRepository = beverageTypeRepository;
    }

    @Override
    public List<BeverageType> listAll() {
        return beverageTypeRepository.findAll();
    }
}
