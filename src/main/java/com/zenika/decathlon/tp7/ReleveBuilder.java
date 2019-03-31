package com.zenika.decathlon.tp7;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReleveBuilder {
	
	static {
		Locale.setDefault(Locale.ROOT);
	}

	private Locale locale;

	public ReleveBuilder(Locale locale) {
		this.locale = locale;
	}

	public String releve(Client me) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
		MessageFormat header = new MessageFormat(bundle.getString("header"), locale);
		String returned = header.format(new Object[] {me.prenom, me.nom})+"\n";
		Collections.sort(me.getComptes(), (first, second) -> -1*first.getSolde().compareTo(second.getSolde()));
		returned +=
				me.getComptes().stream()
				.map(this.formatAccount(bundle, locale))
				.collect(Collectors.joining("\n"));
		return returned;
	}

	public Function<Compte, String> formatAccount(ResourceBundle bundle, Locale locale) {
		MessageFormat row = new MessageFormat(bundle.getString("row"), locale);
		return new Function<Compte, String>() {

			@Override
			public String apply(Compte c) {
				NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
				currency.setCurrency(c.getCurrency());
				return row.format(new Object[] {
						bundle.getString(c.getClass().getSimpleName()),
						currency.format(c.getSolde())
						});
			}
		};
	}
}
