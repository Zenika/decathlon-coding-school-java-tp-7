package com.zenika.decathlon.tp7;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ComptePersistenceTest {
	private static Connection connection;
	private static CompteDAO comptePersistence;

	@BeforeAll
	public static void startDatabase() throws ClassNotFoundException, SQLException, IOException {
	    Class.forName("org.h2.Driver");
	    /*
	     * Initialisation de la connexion h2
	     * On peut créer une base sur disque avec une autre chaîne d'initialisation
	     * Voir par exemple http://www.h2database.com/html/cheatSheet.html
	     */
	    connection = DriverManager.getConnection("jdbc:h2:./target/h2/ComptePersistenceTest",
	            "sa", "");
	    
	    Properties queries = new Properties();
	    queries.loadFromXML(ComptePersistenceTest.class.getResourceAsStream("comptes.xml"));
	    try(Statement creator = connection.createStatement()) {
	    	creator.execute(queries.getProperty("init"));
	    }
	    
	    comptePersistence = new JDBCCompteDAOImpl(connection);
	}
	
	@AfterAll public static void stopDatabase() throws SQLException {
		connection.close();
	}

	@Test public void I_can_get_accounts() throws SQLException {
		List<Compte> liste = comptePersistence.chargerComptes();
		Assertions.assertThat(liste)
			.containsExactly(
					new CompteCourant(null, 1, "Compte Courant", BigDecimal.valueOf(10000.75)));
	}
}
