package bandrefilipe.brewer.persistence.repository;

import bandrefilipe.brewer.persistence.core.model.BeverageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeverageTypeRepository extends JpaRepository<BeverageType, Long> {}
