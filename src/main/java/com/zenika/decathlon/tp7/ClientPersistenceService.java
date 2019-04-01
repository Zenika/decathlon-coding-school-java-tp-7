package com.zenika.decathlon.tp7;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.logging.Logger;

public class ClientPersistenceService {
	private static final Logger LOGGER = Logger.getLogger(ClientPersistenceService.class.getName());

	private Connection connection;
	private Properties statements;

	public ClientPersistenceService(Connection connection) {
		this.connection = connection;
	}

	public void start() throws IOException, SQLException {
		loadStatements();
		Statement init = connection.createStatement();
		init.executeUpdate(statements.getProperty("init"));
	}

	private void loadStatements() throws IOException {
		statements = new Properties();
		statements.loadFromXML(getClass().getResourceAsStream("statements.xml"));
	}
}
