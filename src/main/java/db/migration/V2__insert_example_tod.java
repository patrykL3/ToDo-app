package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;


/**
 * Create by Patryk Łubik on 18.04.2021.
 */
public class V2__insert_example_tod extends BaseJavaMigration {
    @Override
    public void migrate(final Context context) throws Exception {
        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute("INSERT INTO tasks " +
                "(description, done) VALUES ('descFromMigrationJava', true)");
    }
}
