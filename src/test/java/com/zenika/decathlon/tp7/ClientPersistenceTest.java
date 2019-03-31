package com.zenika.decathlon.tp7;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClientPersistenceTest {
	private Connection connection;
	private ClientPersistenceService clientPersistence;

	@BeforeEach
	public void startDatabase() throws ClassNotFoundException, SQLException {
	    Class.forName("org.h2.Driver");
	    /*
	     * Initialisation de la connexion h2
	     * On peut créer une base sur disque avec une autre chaîne d'initialisation
	     * Voir par exemple http://www.h2database.com/html/cheatSheet.html
	     */
	    connection = DriverManager.getConnection("jdbc:h2:mem:mytestdb",
	            "sa", "");
	    clientPersistence = new ClientPersistenceService(connection);
	}
	
	@AfterEach
	public void stopDatabase() throws SQLException {
		connection.close();
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
