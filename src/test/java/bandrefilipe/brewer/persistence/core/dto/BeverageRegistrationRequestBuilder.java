package bandrefilipe.brewer.persistence.core.dto;

import java.math.BigDecimal;

public class BeverageRegistrationRequestBuilder {

    private String sku;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private BigDecimal alcoholContent;
    private BigDecimal commission;
    private Integer stock;
    private String originCode;
    private String flavorCode;
    private Long beverageTypeId;

    public BeverageRegistrationRequest build() {
        final var request = new BeverageRegistrationRequest();
        request.setSku(sku);
        request.setName(name);
        request.setDescription(description);
        request.setUnitPrice(unitPrice);
        request.setAlcoholContent(alcoholContent);
        request.setCommission(commission);
        request.setStock(stock);
        request.setOriginCode(originCode);
        request.setFlavorCode(flavorCode);
        request.setBeverageTypeId(beverageTypeId);
        return request;
    }

    public BeverageRegistrationRequestBuilder sku(final String sku) {
        this.sku = sku;
        return this;
    }

    public BeverageRegistrationRequestBuilder name(final String name) {
        this.name = name;
        return this;
    }

    public BeverageRegistrationRequestBuilder description(final String description) {
        this.description = description;
        return this;
    }

    public BeverageRegistrationRequestBuilder unitPrice(final BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public BeverageRegistrationRequestBuilder alcoholContent(final BigDecimal alcoholContent) {
        this.alcoholContent = alcoholContent;
        return this;
    }

    public BeverageRegistrationRequestBuilder commission(final BigDecimal commission) {
        this.commission = commission;
        return this;
    }

    public BeverageRegistrationRequestBuilder stock(final Integer stock) {
        this.stock = stock;
        return this;
    }

    public BeverageRegistrationRequestBuilder originCode(final String originCode) {
        this.originCode = originCode;
        return this;
    }

    public BeverageRegistrationRequestBuilder flavorCode(final String flavorCode) {
        this.flavorCode = flavorCode;
        return this;
    }

    public BeverageRegistrationRequestBuilder beverageTypeId(final Long beverageTypeId) {
        this.beverageTypeId = beverageTypeId;
        return this;
    }
}
