package bandrefilipe.brewer.persistence.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "beverage_type")
@Getter
@EqualsAndHashCode
@ToString
public class BeverageType implements PersistenceObject {

    @Id
    @Column(name = "beverage_type")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = Beverage.BEVERAGE_TYPE_MAPPER)
    private Set<Beverage> beverages;
}
