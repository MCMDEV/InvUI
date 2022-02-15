package de.studiocode.invui.window.impl.merged.split;

import de.studiocode.inventoryaccess.component.ComponentHolder;
import de.studiocode.inventoryaccess.component.LegacyTextHolder;
import de.studiocode.invui.gui.GUI;
import de.studiocode.invui.util.InventoryUtils;
import org.bukkit.entity.Player;

public class SimpleSplitWindow extends SplitWindow {
    
    public SimpleSplitWindow(Player player, ComponentHolder title, GUI upperGui, GUI lowerGui, boolean closeable, boolean closeOnEvent) {
        super(player, title, upperGui, lowerGui, InventoryUtils.createMatchingInventory(upperGui, ""), true, closeable, closeOnEvent);
    }
    
    public SimpleSplitWindow(Player player, ComponentHolder title, GUI upperGui, GUI lowerGui) {
        this(player, title, upperGui, lowerGui, true, true);
    }
    
    public SimpleSplitWindow(Player player, String title, GUI upperGui, GUI lowerGui, boolean closeable, boolean closeOnEvent) {
        this(player, LegacyTextHolder.of(title), upperGui, lowerGui, closeable, closeOnEvent);
    }
    
    public SimpleSplitWindow(Player player, String title, GUI upperGui, GUI lowerGui) {
        this(player, title, upperGui, lowerGui, true, true);
    }
    
}
