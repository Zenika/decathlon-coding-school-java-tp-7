package com.zenika.decathlon.tp7;

import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Locale;
import java.util.Properties;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ReleveTest {
	private static Properties samples;
	@BeforeAll
	public static void loadProperties() throws InvalidPropertiesFormatException, IOException {
		samples = new Properties();
		samples.loadFromXML(ReleveTest.class.getClassLoader().getResourceAsStream("releve_values.xml"));
	}
	
	@Test
	public void je_peux_afficher_le_releve_avec_un_compte() {
		Client me = TestUtils.client();
		me.add(TestUtils.compte_courant(me));
		Assertions.assertThat(new ReleveBuilder(Locale.FRANCE).releve(me))
			.isEqualTo(samples.getProperty("releve_avec_un_compte_courant"));
	}
	
	@Test
	public void je_peux_afficher_le_releve_avec_deux_comptes() {
		Client me = TestUtils.client();
		me.add(TestUtils.compte_courant(me));
		me.add(TestUtils.compte_epargne(me));
		Assertions.assertThat(new ReleveBuilder(Locale.FRANCE).releve(me))
			.isEqualTo(samples.getProperty("releve_avec_compte_courant_et_compte_epargne"));
	}
	
	@Test
	public void je_peux_afficher_le_releve_en_anglais_avec_deux_comptes() {
		Client me = TestUtils.client();
		me.add(TestUtils.compte_courant(me));
		me.add(TestUtils.compte_epargne(me));
		Assertions.assertThat(new ReleveBuilder(Locale.ENGLISH).releve(me))
			.isEqualTo(samples.getProperty("releve_avec_compte_courant_et_compte_epargne_en_anglais"));
	}
}
