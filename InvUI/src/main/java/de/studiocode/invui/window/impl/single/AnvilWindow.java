package de.studiocode.invui.window.impl.single;

import de.studiocode.inventoryaccess.abstraction.inventory.AnvilInventory;
import de.studiocode.inventoryaccess.component.ComponentHolder;
import de.studiocode.inventoryaccess.component.LegacyTextHolder;
import de.studiocode.inventoryaccess.version.InventoryAccess;
import de.studiocode.invui.gui.GUI;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class AnvilWindow extends SingleWindow {
    
    private final AnvilInventory anvilInventory;
    
    public AnvilWindow(Player player, ComponentHolder title, GUI gui, boolean closable, Consumer<String> renameHandler) {
        super(player.getUniqueId(), title, gui, null, false, closable, true);
        anvilInventory = InventoryAccess.createAnvilInventory(player, title, renameHandler);
        inventory = anvilInventory.getBukkitInventory();
        
        initItems();
    }
    
    public AnvilWindow(Player player, String title, GUI gui, boolean closeable, Consumer<String> renameHandler) {
        this(player, LegacyTextHolder.of(title), gui, closeable, renameHandler);
    }
    
    public AnvilWindow(Player player, String title, GUI gui, Consumer<String> renameHandler) {
        this(player, title, gui, true, renameHandler);
    }
    
    public AnvilWindow(Player player, ComponentHolder title, GUI gui, Consumer<String> renameHandler) {
        this(player, title, gui, true, renameHandler);
    }
    
    @Override
    protected void setInvItem(int slot, ItemStack itemStack) {
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
