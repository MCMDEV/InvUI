package de.studiocode.invui.window.impl.merged.split;

import de.studiocode.inventoryaccess.abstraction.inventory.AnvilInventory;
import de.studiocode.inventoryaccess.component.ComponentHolder;
import de.studiocode.inventoryaccess.component.LegacyTextHolder;
import de.studiocode.inventoryaccess.version.InventoryAccess;
import de.studiocode.invui.gui.GUI;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class AnvilSplitWindow extends SplitWindow {
    
    private final AnvilInventory anvilInventory;
    
    public AnvilSplitWindow(Player player, ComponentHolder title, GUI upperGui, GUI lowerGui, boolean closeable, Consumer<String> renameHandler) {
        super(player, title, upperGui, lowerGui, null, false, closeable, true);
        
        anvilInventory = InventoryAccess.createAnvilInventory(player, title, renameHandler);
        upperInventory = anvilInventory.getBukkitInventory();
        
        initUpperItems();
    }
    
    public AnvilSplitWindow(Player player, ComponentHolder title, GUI upperGui, GUI lowerGui, Consumer<String> renameHandler) {
        this(player, title, upperGui, lowerGui, true, renameHandler);
    }
    
    public AnvilSplitWindow(Player player, String title, GUI upperGui, GUI lowerGui, boolean closeable, Consumer<String> renameHandler) {
        this(player, LegacyTextHolder.of(title), upperGui, lowerGui, closeable, renameHandler);
    }
    
    public AnvilSplitWindow(Player player, String title, GUI upperGui, GUI lowerGui, Consumer<String> renameHandler) {
        this(player, title, upperGui, lowerGui, true, renameHandler);
    }
    
    @Override
    protected void setUpperInvItem(int slot, ItemStack itemStack) {
        anvilInventory.setItem(slot, itemStack);
    }
    
    @Override
    public void show() {
        if (isClosed()) throw new IllegalStateException("The Window has already been closed.");
        
        Player viewer = getViewer();
        if (viewer == null) throw new IllegalStateException("The player is not online.");
        anvilInventory.open();
    }
    
    public String getRenameText() {
        return anvilInventory.getRenameText();
    }
    
}
