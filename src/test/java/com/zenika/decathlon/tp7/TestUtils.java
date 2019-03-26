package com.zenika.decathlon.tp7;

import java.math.BigDecimal;

public class TestUtils {

	public static Client client() {
		return new Client("Delsaux", "Nicolas");
	}

	public static Compte compte_courant(Client client) {
		Compte compte = new CompteCourant(client);
		compte.setSolde(new BigDecimal(10));
		return compte;
	}

	public static Compte compte_epargne(Client client) {
		Compte compte = new CompteEpargne(client);
		compte.setSolde(new BigDecimal(2_000));
		return compte;
	}

}
