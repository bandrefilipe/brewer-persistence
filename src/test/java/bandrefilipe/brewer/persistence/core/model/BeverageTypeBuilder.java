package bandrefilipe.brewer.persistence.core.model;

public class BeverageTypeBuilder {

    private Long id;
    private String name;

    public BeverageType build() {
        final var beverageType = new BeverageType();
        beverageType.setId(id);
        beverageType.setName(name);
        return beverageType;
    }

    public BeverageTypeBuilder id(final Long id) {
        this.id = id;
        return this;
    }

    public BeverageTypeBuilder name(final String name) {
        this.name = name;
        return this;
    }
}
