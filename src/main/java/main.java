import sqlBuilder.Customer;
import sqlBuilder.actionBuilder.DeleteBuilder;
import sqlBuilder.actionBuilder.InsertBuilder;
import sqlBuilder.actionBuilder.SelectBuilder;
import sqlBuilder.actionBuilder.UpdateBuilder;
import sqlBuilder.dto.GetCustomerNameDto;
import sqlBuilder.type.OrderType;
import sqlBuilder.type.TableType;

public class main {
    public static void main(String[] args) {
        String insertSQL = new InsertBuilder()
                .insert(TableType.CUSTOMERS)
                .columns("email", "name")
                .values(":email", ":name")
                .build();

        System.out.println(insertSQL);

        String findAllSql = new SelectBuilder()
                .selectAll(new Customer("name","email"))
                .from(TableType.CUSTOMERS)
                .orderBy("name",OrderType.ASC)
                .orderBy("email",OrderType.DESC)
                .build();

        System.out.println(findAllSql);

        String findByEmailSql = new SelectBuilder()
                .select(new GetCustomerNameDto("name","email"))
                .from(TableType.CUSTOMERS)
                .where("email = :email")
                .build();

        System.out.println(findByEmailSql);

        String updateInfoSql = new UpdateBuilder()
                .update(TableType.CUSTOMERS)
                .set("email = :afterUpdateEmail")
                .where("email = :beforeUpdateEmail")
                .build();

        System.out.println(updateInfoSql);

        String deleteByEmailSql = new DeleteBuilder()
                .delete()
                .from(TableType.CUSTOMERS)
                .where("email = :email")
                .build();

        System.out.println(deleteByEmailSql);

        String deleteAllSql = new DeleteBuilder()
                .delete()
                .from(TableType.CUSTOMERS)
                .build();

        System.out.println(deleteAllSql);
    }
}
