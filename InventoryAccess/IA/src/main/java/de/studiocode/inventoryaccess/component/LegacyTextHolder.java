package de.studiocode.inventoryaccess.component;

import net.md_5.bungee.api.chat.TextComponent;

public class LegacyTextHolder extends BungeeComponentHolder {

	public static LegacyTextHolder of(String text)  {
		return new LegacyTextHolder(text);
	}

	LegacyTextHolder(String legacy) {
		super(TextComponent.fromLegacyText(legacy));
	}
}
