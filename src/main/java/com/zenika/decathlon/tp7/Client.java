package com.zenika.decathlon.tp7;

import java.util.Objects;

public class Client {
	public final String nom;
	public final String prenom;
	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nom, prenom);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(nom, other.nom) && Objects.equals(prenom, other.prenom);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [prenom=");
		builder.append(prenom);
		builder.append(", nom=");
		builder.append(nom);
		builder.append("]");
		return builder.toString();
	}
}
