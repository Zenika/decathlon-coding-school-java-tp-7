package com.zenika.decathlon.tp7;

import java.math.BigDecimal;

public class OperationCompte {
	public void virement(Compte source, Compte destination, BigDecimal montant) {
		if(source.equals(destination)) {
			throw new ConflitDeCompteException(String.format("Impossible de faire un virement de %s vers lui-même", source));
		} else if(source.getSolde().subtract(montant).longValue()<0) {
			throw new SoldeInsuffisantException(String.format("Le compte source %s n'a pas les moyens d'honorer un débit de %s", source, montant));
		} else {
			source.setSolde(source.getSolde().subtract(montant));
			destination.setSolde(destination.getSolde().add(montant));
		}
	}
}
