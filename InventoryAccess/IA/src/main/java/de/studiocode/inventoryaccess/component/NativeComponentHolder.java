package de.studiocode.inventoryaccess.component;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;

public class NativeComponentHolder extends ComponentHolder {

	private static final GsonComponentSerializer SERIALIZER = GsonComponentSerializer.gson();
	private final Component component;

	public static NativeComponentHolder of(Component component) {
		return new NativeComponentHolder(component);
	}

	NativeComponentHolder(Component component) {
		this.component = component;
	}

	@Override
	public String toJson() {
		return SERIALIZER.serialize(component);
	}
}
