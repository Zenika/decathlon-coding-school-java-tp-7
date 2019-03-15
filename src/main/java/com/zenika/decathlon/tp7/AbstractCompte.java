package com.zenika.decathlon.tp7;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public abstract class AbstractCompte implements Compte {
	private Client titulaire;
	private String identifiant;
	public AbstractCompte(Client titulaire) {
		super();
		identifiant = UUID.randomUUID().toString();
		this.titulaire = titulaire;
	}
	private BigDecimal solde;
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
		return Objects.hash(identifiant, titulaire);
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
		return Objects.equals(identifiant, other.identifiant) && Objects.equals(titulaire, other.titulaire);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName());
		builder.append(" [identifiant=");
		builder.append(identifiant);
		builder.append(", titulaire=");
		builder.append(titulaire);
		builder.append(", solde=");
		builder.append(solde);
		builder.append("]");
		return builder.toString();
	}
}
