package com.zenika.decathlon.tp7;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
	public final String nom;
	public final String prenom;
	private List<Compte> comptes = new ArrayList<>();
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
	public boolean contains(Object o) {
		return comptes.contains(o);
	}
	public boolean add(Compte e) {
		return comptes.add(e);
	}
	public boolean remove(Object o) {
		return comptes.remove(o);
	}
	
	public List<Compte> getComptes() {
		return comptes;
	}
}
