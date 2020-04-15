package bandrefilipe.brewer.persistence.service.impl;

import bandrefilipe.brewer.persistence.core.model.Beverage;
import bandrefilipe.brewer.persistence.core.model.BeverageType;
import bandrefilipe.brewer.persistence.core.model.enums.BeverageFlavor;
import bandrefilipe.brewer.persistence.core.model.enums.Origin;

import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Since {@link Beverage} is a JPA entity, only its business key is part of the equals and hashCode
 * implementation. So this class wraps every single attribute and child attributes and implements
 * complete equals and hashCode methods for the purpose of testing object conversion.
 */
class BeverageRegistrationRequestConverterTestData {

    private Long id;
    private String sku;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private BigDecimal alcoholContent;
    private BigDecimal commission;
    private Integer stock;
    private Origin origin;
    private BeverageFlavor flavor;
    private Long typeId;
    private String typeName;

    static BeverageRegistrationRequestConverterTestData from(final Beverage model) {
        final var beverageType = ofNullable(model.getType());
        final var data = new BeverageRegistrationRequestConverterTestData();
        data.id = model.getId();
        data.sku = model.getSku();
        data.name = model.getName();
        data.description = model.getDescription();
        data.unitPrice = model.getUnitPrice();
        data.alcoholContent = model.getAlcoholContent();
        data.commission = model.getCommission();
        data.stock = model.getStock();
        data.origin = model.getOrigin();
        data.flavor = model.getFlavor();
        data.typeId = beverageType.map(BeverageType::getId).orElse(null);
        data.typeName = beverageType.map(BeverageType::getName).orElse(null);
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeverageRegistrationRequestConverterTestData that = (BeverageRegistrationRequestConverterTestData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(sku, that.sku) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(unitPrice, that.unitPrice) &&
                Objects.equals(alcoholContent, that.alcoholContent) &&
                Objects.equals(commission, that.commission) &&
                Objects.equals(stock, that.stock) &&
                origin == that.origin &&
                flavor == that.flavor &&
                Objects.equals(typeId, that.typeId) &&
                Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sku, name, description, unitPrice, alcoholContent, commission, stock, origin, flavor, typeId, typeName);
    }

    @Override
    public String toString() {
        return "BeverageRegistrationRequestConverterTestData{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", alcoholContent=" + alcoholContent +
                ", commission=" + commission +
                ", stock=" + stock +
                ", origin=" + origin +
                ", flavor=" + flavor +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
