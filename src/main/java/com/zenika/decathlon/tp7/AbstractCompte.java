package com.zenika.decathlon.tp7;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

public abstract class AbstractCompte implements Compte {
	private Client titulaire;
	private int numeroCompte;
	private String libelle;
	public AbstractCompte(Client titulaire) {
		super();
		this.titulaire = titulaire;
	}
	public AbstractCompte(Client client, int numeroCompte, String libelle, BigDecimal solde) {
		this(client);
		this.numeroCompte = numeroCompte;
		this.libelle = libelle;
		this.solde = solde;
	}
	private BigDecimal solde;
	private final Currency currency = Currency.getInstance(Locale.FRANCE);
	@Override
	public Client getTitulaire() {
		return titulaire;
	}
	@Override
	public BigDecimal getSolde() {
		return solde;
	}
	@Override
	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}
	@Override
	public int hashCode() {
		return Objects.hash(numeroCompte, titulaire);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractCompte other = (AbstractCompte) obj;
		return Objects.equals(numeroCompte, other.numeroCompte) && Objects.equals(titulaire, other.titulaire) && Objects.equals(solde, other.solde);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName());
		builder.append(" [numero=");
		builder.append(numeroCompte);
		builder.append(", titulaire=");
		builder.append(titulaire);
		builder.append(", solde=");
		builder.append(solde);
		builder.append("]");
		return builder.toString();
	}
	
	public Currency getCurrency() {
		return currency;
	}
}
