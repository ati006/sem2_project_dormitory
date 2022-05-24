package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

class TestDBConnection {


	@Test
	public void testGetConnection() {
				
		String urlString = String.format("jdbc:sqlserver://%s:%s;databaseName=%s;encrypt=true;trustServerCertificate=true", "localhost", "1433", "master");

		try {
			Connection connection = DriverManager.getConnection(urlString,"sa", "secret2022*");
			assertNotNull(connection);
		} catch (Exception e) {
			fail("issues with dbconnection");
		}
	}
}
