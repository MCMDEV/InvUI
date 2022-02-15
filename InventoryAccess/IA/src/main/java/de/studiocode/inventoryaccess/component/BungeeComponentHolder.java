package de.studiocode.inventoryaccess.component;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.chat.ComponentSerializer;

public class BungeeComponentHolder extends ComponentHolder {

	private final BaseComponent[] components;

	public static BungeeComponentHolder of(BaseComponent[] baseComponents)  {
		return new BungeeComponentHolder(baseComponents);
	}

	BungeeComponentHolder(BaseComponent[] components) {
		this.components = components;
	}

	@Override
	public String toJson() {
		return ComponentSerializer.toString(components);
	}
}
