package com.zenika.decathlon.tp7;

import java.util.List;

public interface CompteDAO {
	Compte chargerCompte(int numero);
	List<Compte> chargerComptes();
}
