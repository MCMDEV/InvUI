package de.studiocode.invui.gui.impl;

import de.studiocode.invui.gui.GUI;
import de.studiocode.invui.gui.SlotElement;
import de.studiocode.invui.gui.builder.GUIBuilder;
import de.studiocode.invui.gui.structure.Structure;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A {@link PagedGUI} where every page is its own {@link GUI}.
 *
 * @see GUIBuilder
 * @see SimplePagedItemsGUI
 */
public class SimplePagedNestedGUI extends PagedGUI {
    
    private List<GUI> guis;
    
    public SimplePagedNestedGUI(int width, int height, @Nullable List<GUI> guis, int... itemListSlots) {
        super(width, height, false, itemListSlots);
        setGuis(guis);
    }
    
    public SimplePagedNestedGUI(int width, int height, @Nullable List<GUI> guis, @NotNull Structure structure) {
        super(width, height, false, structure);
        setGuis(guis);
    }
    
    @Override
    public int getPageAmount() {
        return guis.size();
    }
    
    @Override
    protected List<SlotElement> getPageElements(int page) {
        if (guis.size() <= page) return new ArrayList<>();
        
        GUI gui = guis.get(page);
        int size = gui.getSize();
        
        return IntStream.range(0, size)
            .mapToObj(i -> new SlotElement.LinkedSlotElement(gui, i))
            .collect(Collectors.toList());
    }
    
    public void setGuis(@Nullable List<GUI> guis) {
        this.guis = guis == null ? new ArrayList<>() : guis;
        update();
    }
    
}
