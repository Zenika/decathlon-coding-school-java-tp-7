package com.zenika.decathlon.tp7;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CompteTest {
	
	@Test
	void je_peux_recrediter_mon_compte_courant() {
		// given 
		Compte crédité = TestUtils.compte_courant(TestUtils.client());
		Compte débité = TestUtils.compte_epargne(TestUtils.client());
		// when
		OperationCompte opérateur = new OperationCompte();
		opérateur.virement(débité, crédité, new BigDecimal(1_000));
		// then
		Assertions.assertThat(débité.getSolde()).isEqualByComparingTo("1000");
		Assertions.assertThat(crédité.getSolde()).isEqualByComparingTo("1010");
	}

	@Test
	void je_ne_peux_pas_faire_de_virement_trop_gros() {
		// given 
		Compte crédité = TestUtils.compte_epargne(TestUtils.client());
		Compte débité = TestUtils.compte_courant(TestUtils.client());
		// when
		OperationCompte opérateur = new OperationCompte();
		org.junit.jupiter.api.Assertions.assertThrows(SoldeInsuffisantException.class, () -> opérateur.virement(débité, crédité, new BigDecimal(1_000)));
	}

	@Test
	void je_ne_peux_pas_faire_de_virement_vers_moi_meme() {
		// given 
		Compte account = TestUtils.compte_epargne(TestUtils.client());
		// when
		OperationCompte opérateur = new OperationCompte();
		org.junit.jupiter.api.Assertions.assertThrows(ConflitDeCompteException.class, () -> opérateur.virement(account, account, new BigDecimal(1_000)));
	}
}
