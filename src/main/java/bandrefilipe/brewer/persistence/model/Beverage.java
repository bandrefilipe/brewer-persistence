package bandrefilipe.brewer.persistence.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
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

@Entity
@Table(name = "beverage")
@Getter
@EqualsAndHashCode
@ToString
public class Beverage implements PersistenceObject {

    protected static final String BEVERAGE_TYPE_MAPPER = "type";

    @Id
    @Column(name = "beverage")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sku")
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
    private BeverageFlavor beverageFlavor;

    @ManyToOne
    @JoinColumn(name = "beverage_type_id")
    private BeverageType type;
}
