package bandrefilipe.brewer.persistence.repository;

import bandrefilipe.brewer.persistence.core.model.Beverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeverageRepository extends JpaRepository<Beverage, Long> {

    Optional<Beverage> findBySkuIgnoreCase(String sku);
}
