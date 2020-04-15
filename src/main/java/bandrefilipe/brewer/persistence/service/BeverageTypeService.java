package bandrefilipe.brewer.persistence.service;

import bandrefilipe.brewer.persistence.core.model.BeverageType;

import java.util.List;
import java.util.Optional;

public interface BeverageTypeService {

    List<BeverageType> listAll();
    Optional<BeverageType> findTypeById(Long id);
}
