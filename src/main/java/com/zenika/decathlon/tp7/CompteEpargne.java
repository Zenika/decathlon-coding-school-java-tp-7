package com.zenika.decathlon.tp7;

import java.math.BigDecimal;

public class CompteEpargne extends AbstractCompte {

	public CompteEpargne(Client titulaire) {
		super(titulaire);
		// TODO Auto-generated constructor stub
	}

	public CompteEpargne(Client client, int numeroCompte, String libelle, BigDecimal solde) {
		super(client, numeroCompte, libelle, solde);
	}

}
