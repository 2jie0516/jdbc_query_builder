package sqlBuilder.builder.tableBuilder;

public class ValuesBuilder {
    private StringBuilder valuesBuilder;

    public ValuesBuilder(StringBuilder valuesBuilder) {
        this.valuesBuilder = valuesBuilder;
    }

    public String build() {
        return valuesBuilder.toString();
    }
}