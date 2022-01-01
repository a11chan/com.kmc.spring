package org.zerock.persistence;

import static org.junit.Assert.fail;
import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;
import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static {
		try { Class.forName("oracle.jdbc.driver.OracleDriver"); }
		//java build-path에서 로딩
		catch(Exception e) { e.printStackTrace(); }
	}
	
	@Test
	public void testConnection() {
		try(Connection con = DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:ORCL",
			"book_ex","book_ex")) { log.info(con); }
		catch(Exception e) { fail(e.getMessage()); }
	}
}