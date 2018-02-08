package resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by li on 1/22/18.
 */
public class TestJdbcTemplate {
    private static JdbcTemplate JDBCTEMPLATE;
    @BeforeClass
    public static void setUpClass(){
        String url = "jdbc:mysql://localhost:3306/mybookstore";
        String username = "root";
        String password= "root";
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url,username,password);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        JDBCTEMPLATE = new JdbcTemplate(dataSource);
    }

    @Test
    public void test(){
        //language=MySQL
        String sql = "select * from product";
        JDBCTEMPLATE.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                System.out.print(resultSet.getString("name")+"=");
                System.out.println(resultSet.getString("price"));
            }
        });
    }
}
