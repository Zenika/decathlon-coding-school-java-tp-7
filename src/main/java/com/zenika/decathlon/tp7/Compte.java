package com.zenika.decathlon.tp7;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public interface Compte {
	public Client getTitulaire();
	public BigDecimal getSolde();
	public void setSolde(BigDecimal solde);
	public Currency getCurrency();
}
