package bandrefilipe.brewer.persistence.core.model;

import bandrefilipe.brewer.persistence.core.model.enums.BeverageFlavor;
import bandrefilipe.brewer.persistence.core.model.enums.Origin;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "beverage")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Beverage implements PersistenceObject {

    static final String BEVERAGE_TYPE_MAPPER = "type";

    @Id
    @Column(name = "beverage")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Business Key */
    @Column(name = "sku", unique = true, nullable = false, updatable = false)
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price", precision = 8, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "alcohol_content", precision = 5, scale = 2)
    private BigDecimal alcoholContent;

    @Column(name = "commission", precision = 5, scale = 2)
    private BigDecimal commission;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "origin", length = 1)
    @Convert(converter = OriginConverter.class)
    private Origin origin;

    @Column(name = "flavor", length = 1)
    @Convert(converter = BeverageFlavorConverter.class)
    private BeverageFlavor flavor;

    @ManyToOne
    @JoinColumn(name = "beverage_type_id")
    private BeverageType type;

    @Override
    public int hashCode() {
        return Objects.hashCode(sku);
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) return true;
        if (other == null || other.getClass() != this.getClass()) return false;
        final var that = (Beverage) other;
        return Objects.equals(this.sku, that.sku);
    }
}
