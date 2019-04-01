package com.zenika.decathlon.tp7;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ClientPersistenceTest {
	private static Connection connection;
	private static ClientPersistenceService clientPersistence;

	@BeforeAll
	public static void startDatabase() throws ClassNotFoundException, SQLException, IOException {
	    Class.forName("org.h2.Driver");
	    /*
	     * Initialisation de la connexion h2
	     * On peut créer une base sur disque avec une autre chaîne d'initialisation
	     * Voir par exemple http://www.h2database.com/html/cheatSheet.html
	     */
	    connection = DriverManager.getConnection("jdbc:h2:./target/h2/ClientPersistenceTest",
	            "sa", "");
	    clientPersistence = new ClientPersistenceService(connection);
	    clientPersistence.start();
	}
	
	@AfterAll public static void stopDatabase() throws SQLException {
		connection.close();
	}

	@Test public void I_can_create_a_client() {
		Client toTest = new Client("Delsaux", "Nicolas");
		// TODO persist client in database and load it afterwards
	}
}
