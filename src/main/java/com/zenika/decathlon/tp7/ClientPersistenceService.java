package com.zenika.decathlon.tp7;

import java.sql.Connection;

public class ClientPersistenceService {

	private Connection connection;

	public ClientPersistenceService(Connection connection) {
		this.connection = connection;
	}

}
