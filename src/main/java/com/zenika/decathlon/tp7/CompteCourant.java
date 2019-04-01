package com.zenika.decathlon.tp7;

import java.math.BigDecimal;

public class CompteCourant extends AbstractCompte {

	public CompteCourant(Client titulaire) {
		super(titulaire);
	}

	public CompteCourant(Client client, int numeroCompte, String libelle, BigDecimal solde) {
		super(client, numeroCompte, libelle, solde);
	}

}
