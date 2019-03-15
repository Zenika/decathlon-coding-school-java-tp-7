package com.zenika.decathlon.tp7;

import java.math.BigDecimal;

public interface Compte {
	public Client getTitulaire();
	public BigDecimal getSolde();
	public void setSolde(BigDecimal solde);
}
