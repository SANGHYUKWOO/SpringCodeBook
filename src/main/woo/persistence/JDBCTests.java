package woo.persistence;

//import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class JDBCTests {
	/*static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
//	@Inject
	@Setter(onMethod_= {@Autowired})
    private DataSource ds;
	
	@Test
	public void testConnection() {
		//try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","shatiel","shatiel")){
		try(Connection con = ds.getConnection()){
			//log.info(con);
			System.out.println(con);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}


