package bandrefilipe.brewer.persistence.core.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "beverage_type")
@Getter
@Setter(AccessLevel.PACKAGE)
@ToString
public class BeverageType implements PersistenceObject {

    @Id
    @Column(name = "beverage_type")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Business Key */
    @Column(name = "name", unique = true, nullable = false, updatable = false)
    private String name;

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) return true;
        if (other == null || other.getClass() != this.getClass()) return false;
        final var that = (BeverageType) other;
        return Objects.equals(this.name, that.name);
    }
}
