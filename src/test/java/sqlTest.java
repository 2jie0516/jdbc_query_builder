import org.junit.jupiter.api.Test;
import sqlBuilder.builder.DmlBuilder.Delete;
import sqlBuilder.builder.DmlBuilder.Insert;
import sqlBuilder.builder.DmlBuilder.Select;
import sqlBuilder.builder.DmlBuilder.Update;
import sqlBuilder.builder.conditionBuilder.Order;
import sqlBuilder.builder.conditionBuilder.Where;
import sqlBuilder.builder.tableBuilder.Column;
import sqlBuilder.builder.tableBuilder.Values;
import sqlBuilder.builder.tableBuilder.Set;
import sqlBuilder.type.OrderType;
import sqlBuilder.type.TableType;

public class sqlTest {
    private Where where = Where.builder()
            .where("email", ":email")
            .and("name", ":name")
            .build();

    private Order order1 = Order.builder()
            .orderBy("name", OrderType.ASC)
            .and("email", OrderType.DESC)
            .build();

    private Column column = Column.builder()
            .columns("email", "name")
            .build();

    private Values values = Values.builder()
            .values(":email", ":name")
            .build();
    private Set set = Set.builder()
            .set("email", ":afterUpdateEmail")
            .build();

    @Test
    void insertSqlTest() {
        Insert insertSql = Insert.builder()
                .insert(TableType.customers)
                .into(column)
                .values(values)
                .build();

        System.out.println(insertSql.getQuery());
    }

    @Test
    void findAllTest() {
        Select findAllSql = Select.builder()
                .selectAll()
                .from(TableType.customers)
                .where(where)
                .order(order1)
                .build();

        System.out.println(findAllSql.getQuery());
    }

    @Test
    void findByEmailTest() {
        Select findByEmailSql = Select.builder()
                .select(column)
                .from(TableType.customers)
                .where(where)
                .build();

        System.out.println(findByEmailSql.getQuery());
    }

    @Test
    void updateInfoSqlTest() {
        Update updateInfoSql = Update.builder()
                .update(TableType.customers)
                .set(set)
                .where(where)
                .build();

        System.out.println(updateInfoSql.getQuery());
    }

    @Test
    void deleteByEmailSqlTest() {
        Delete deleteByEmailSql = Delete.builder()
                .from(TableType.customers)
                .where(where)
                .build();

        System.out.println(deleteByEmailSql.getQuery());
    }

    @Test
    void deleteAllSqlTest() {
        Delete deleteAllSql = Delete.builder()
                .from(TableType.customers)
                .build();

        System.out.println(deleteAllSql.getQuery());
    }
}
