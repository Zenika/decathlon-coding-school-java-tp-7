package com.zenika.decathlon.tp7;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

public class JDBCCompteDAOImpl implements CompteDAO {

	private Connection connection;
	private Properties queries;

	public JDBCCompteDAOImpl(Connection connection) throws InvalidPropertiesFormatException, IOException {
		this.connection = connection;
		init();
	}

	private void init() throws InvalidPropertiesFormatException, IOException {
	    queries = new Properties();
	    queries.loadFromXML(JDBCCompteDAOImpl.class.getResourceAsStream("comptes.xml"));
	}

	@Override
	public Compte chargerCompte(int numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> chargerComptes() {
		List<Compte> allAccounts = new ArrayList<>();
		try(Statement selectAll = connection.createStatement()) {
			ResultSet result = selectAll.executeQuery(queries.getProperty("selectAll"));
			while (result.next()) {
				int numeroCompte = result.getInt(1);
				String libelle = result.getString(2);
				BigDecimal solde = result.getBigDecimal(3);
				String type = result.getString(4);
				allAccounts.add(createAccountFrom(numeroCompte, libelle, solde, type));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allAccounts;
	}

	private Compte createAccountFrom(int numeroCompte, String libelle, BigDecimal solde, String type) {
		switch(type) {
		case "C":
			return new CompteCourant(null, numeroCompte, libelle, solde);
		default:
			return new CompteEpargne(null, numeroCompte, libelle, solde);
		}
	}

}
